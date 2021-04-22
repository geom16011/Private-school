package DAO;

import dbutils.Database;
import models.*;

import java.sql.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDAO {
    private Connection con;
    private PreparedStatement prStatement = null;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void insertStudent(Student st) {

        try {

            con = Database.getConnection();


            String sb = "";
            sb = "INSERT INTO " + " students " + "(firstName, lastName,dob,tuitionFees) VALUES (?,?,?,?)";
            //System.out.println(sb);
            prStatement = con.prepareStatement(sb);
            prStatement.setString(1, st.getFirstName());
            //System.out.println(st.getFirstName());
            prStatement.setString(2, st.getLastName());
            //System.out.println(st.getLastName());
            prStatement.setDate(3, Date.valueOf(st.getDateOfBirth()));
            prStatement.setDouble(4, st.getFees());


            prStatement.executeUpdate();
            prStatement.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                prStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public ArrayList<Student> fetchStudents() {
        ArrayList<Student> Students = new ArrayList<>();

        try {

            con = Database.getConnection();


            String sb ;
            sb = "select * from students ";
            //System.out.println(sb);
            prStatement = con.prepareStatement(sb);

            ResultSet rs = prStatement.executeQuery();

            while (rs.next()) {
                //System.out.print(rs.getString(" firstName"));
                Students.add(new Student(rs.getInt("student_id"),rs.getString("firstName"), rs.getString("lastName")
                        , LocalDate.parse(rs.getString("dob")), rs.getDouble("tuitionFees")));


            }
            //System.out.println(Students.size());
            prStatement.close();
            con.close();
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                prStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Students;
    }

    public ArrayList<Student> fetchStudentenrolledmorethanoneCourse() {
        ArrayList<Student> Students = new ArrayList<>();

        try {

            con = Database.getConnection();

            String sb ;
            sb = "SELECT  students.* FROM students  INNER JOIN students_courses  " +
                    "ON students.student_id = students_courses.student_id GROUP BY students.student_id  " +
                    "HAVING COUNT(students_courses.Course_id) > 1";
            //System.out.println(sb);
            prStatement = con.prepareStatement(sb);

            ResultSet rs = prStatement.executeQuery();

            while (rs.next()) {
                //System.out.print(rs.getString(" firstName"));
                Students.add(new Student(rs.getInt("student_id"),rs.getString("firstName"), rs.getString("lastName")
                        , LocalDate.parse(rs.getString("dob")), rs.getDouble("tuitionFees")));


            }
            //System.out.println(Students.size());
            prStatement.close();
            con.close();
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                prStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Students;

    }

    public ArrayList<StudentCourseDTO> fetchStudentCourses() {
        ArrayList<StudentCourseDTO> StudentCourseDTO=new ArrayList<>();
        try {

            con = Database.getConnection();

            String sb = "";
            sb = "SELECT Students.`student_id`, students. `firstName`, courses.id, courses.title" +
                    " FROM students_courses" +
                    " INNER JOIN students on students.student_id = students_courses.student_id" +
                    " INNER JOIN courses ON courses.id = students_courses.Course_id;";
            //System.out.println(sb);
            prStatement = con.prepareStatement(sb);

            ResultSet rs = prStatement.executeQuery();

            while (rs.next()) {
                //System.out.print(rs.getString(" firstName"));
                StudentCourseDTO temp=new StudentCourseDTO (rs.getInt(1), rs.getString(2),rs.getInt(3),
                        rs.getString(4));
                StudentCourseDTO.add(temp);


            }

            prStatement.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                prStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return StudentCourseDTO;

    }
    public ArrayList<Student> fetchalStudentsbyCourse(Course course) {


        String sql="select * from students inner join " +
                "students_courses on " +
                "students_courses.course_id=? and  students_courses.student_id=students.student_id";
        //System.out.println(sql);
        //System.out.println(course.getCourse_id());

        ArrayList<Student> StudentsperCourse=new ArrayList<>();
        try {
            con=Database.getConnection();


            prStatement= con.prepareStatement(sql);
            prStatement.setInt(1,course.getCourse_id());
            ResultSet rs = prStatement.executeQuery();

            while (rs.next()) {


                StudentsperCourse.add(new Student(rs.getInt("student_id"),rs.getString("firstname"),
                        rs.getString("lastname"),LocalDate.parse(rs.getString("dob")), rs.getDouble("tuitionFees")));

            }

        }
        catch (SQLException | ParseException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                prStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return StudentsperCourse;

    }

    public int fetchenrollmentid(Course course, Student student) {

        int result = 0;

        try {

            con = Database.getConnection();

            String sb;
            sb = "select enrollment_id from students_courses inner join students "
                    + " where students.student_id=students_courses.student_id and" +
                    " students_courses.student_id=? and students_courses.course_id=?";
            //System.out.println(sb);
            prStatement = con.prepareStatement(sb);
            prStatement.setInt(1, student.getStudent_id());
            prStatement.setInt(2, course.getCourse_id());
            ResultSet rs = prStatement.executeQuery();

            if (rs.next()) {
                result=rs.getInt("enrollment_id");

            }


            prStatement.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                prStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    public void insertStudentAssignment(int id, Assignment assignment,AssignmentperCourseperStudent AssignmentperCourseperStudent ) {

        try {

            con = Database.getConnection();



            String sb = "";
            sb = "INSERT INTO " + " AssignmentperCourseperStudent " + 
                    "(enrollment_id, assignment_id,oralMark,totalMark) VALUES (?,?,?,?)";
            //System.out.println(sb);
            prStatement = con.prepareStatement(sb);
            prStatement.setInt(1, id);

            prStatement.setInt(2,assignment.getAssignment_id());

            prStatement.setInt(3, AssignmentperCourseperStudent.getOralMark());
            prStatement.setInt(4, AssignmentperCourseperStudent.getTotalMark());


            prStatement.executeUpdate();
            prStatement.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                prStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    public Student getlastinsert() throws ParseException{

      
        String sql="SELECT * FROM Students where student_id=(Select MAX(Student_id) from Students)";

        Student Student=new Student();

        try {

            con=Database.getConnection();
            prStatement= con.prepareStatement(sql);
            ResultSet rs = prStatement.executeQuery();
            if(rs.next()) {
                Student.setStudent_id(rs.getInt("student_id"));
                Student.setFirstName(rs.getString("firstName"));
                Student.setLastName(rs.getString("lastName"));
                Student.setDateOfBirth(LocalDate.parse(rs.getString("dob")));
                Student.setFees(rs.getDouble("tuitionFees"));

            }
        }
        catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                prStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

        return Student;

    }
}
