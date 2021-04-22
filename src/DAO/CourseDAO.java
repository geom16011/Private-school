package DAO;

import dbutils.Database;
import models.Assignment;
import models.AssignmentCourseDTO;
import models.Student;

import models.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourseDAO {
    private Connection con;
    private PreparedStatement prStatement=null;


    public void insertCourse(Course cr) {

        try {
            con=Database.getConnection();
            String sb = "";
            sb = "INSERT INTO " + "courses " + "( `title`, `stream`, `type`, `startdate`, `enddate`) VALUES (?,?,?,?,?)";
            //System.out.println(sb);
            prStatement = con.prepareStatement(sb);
            prStatement.setString(1, cr.getTitle());
            prStatement.setString(2, cr.getStream());
            prStatement.setString(3, cr.getType());
            prStatement.setString(4, cr.getStartDate().toString());
            prStatement.setString(5, cr.getEndDate().toString());
            prStatement.executeUpdate();
            prStatement.close();
            con.close();
        } catch (SQLException se) {
            se.printStackTrace();
            System.out.println("Connection is not established");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (prStatement != null)
                    prStatement.close();
            } catch (SQLException se2) {
            }
            try {
                if (con != null)
                    con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }
    public ArrayList<Course> getCourses(){



        String sql="SELECT * FROM courses ";
        ArrayList<Course> Courses=new ArrayList<>();
        try {
            con=Database.getConnection();

            prStatement= con.prepareStatement(sql);
            ResultSet rs = prStatement.executeQuery();

            while (rs.next()) {
                Courses.add(new Course(rs.getInt("id"),rs.getString("title"),rs.getString("stream"),
                        rs.getString("type"), LocalDate.parse(rs.getString("startdate"))
                        ,LocalDate.parse(rs.getString("enddate"))));

            }
        }
        catch (SQLException ex) {
            Logger.getLogger(TrainerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                prStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(TrainerDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Courses;

    }

    public List<Course> fetchcoursesperStudent(Student student) {
        ArrayList<Course> Courses=new ArrayList<>();
        String sql="SELECT courses.* FROM courses inner join students_courses on students_courses.Courses_id=courses.id and students_courses.student_id=?";

        try {
            con=Database.getConnection();

            prStatement= con.prepareStatement(sql);
            prStatement.setInt(1, student.getStudent_id());
            ResultSet rs = prStatement.executeQuery();


            while (rs.next()) {
                Courses.add(new Course(rs.getInt("id"),rs.getString("title"),rs.getString("stream"),
                        rs.getString("type")));

            }
        }
        catch (SQLException ex) {
            Logger.getLogger(TrainerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                prStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(TrainerDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Courses;

    }

    public  void insertStudenttoCourse(Course course1,Student student) {
        try {
            con=Database.getConnection();



            String sb = "";
            sb = "INSERT INTO " + "students_courses " + "(student_id, Course_id) VALUES (?,?)";
            //System.out.println(sb);
            prStatement = con.prepareStatement(sb);
            prStatement.setInt(1, student.getStudent_id());
            prStatement.setInt(2, course1.getCourse_id());



            int row = prStatement.executeUpdate();
            prStatement.close();
            con.close();
        } catch (SQLException se) {
            se.printStackTrace();
            System.out.println("Connection is not established");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (prStatement != null)
                    prStatement.close();
            } catch (SQLException se2) {
            }
            try {
                if (con != null)
                    con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }
    public ArrayList<AssignmentCourseDTO> fetchassignmentsCourses(Course Course) {
        String sql="SELECT assignments_courses.* FROM assignments_courses inner join assignments   " +
                "on assignments_courses.assignment_id=assignments.assignment_id and assignments_courses.Course_id=?";

        ArrayList<AssignmentCourseDTO> AssignmentCourseDTO=new ArrayList<>();
        try {
            con=Database.getConnection();

            prStatement= con.prepareStatement(sql);
            prStatement.setInt(1, Course.getCourse_id());
            ResultSet rs = prStatement.executeQuery();


            while (rs.next()) {
                AssignmentCourseDTO temp= (new AssignmentCourseDTO(rs.getInt("assignment_id"),rs.getInt("Course_id")));
                AssignmentCourseDTO.add(temp);

            }
            //System.out.println("sizw:"+AssignmentCourseDTO.size());
        }

        catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                prStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return AssignmentCourseDTO;

    }
}


