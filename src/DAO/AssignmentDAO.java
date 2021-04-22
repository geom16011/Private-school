package DAO;

import dbutils.Database;
import models.Assignment;
import models.AssignmentperCourseperStudent;
import models.Course;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Student;

public class AssignmentDAO {
    private Connection con;
    private PreparedStatement prStatement=null;
    public ArrayList<Assignment> fetachallAssignments(){
        String sql="SELECT * FROM assignments";
        ArrayList<Assignment> Assignments=new ArrayList<>();
        try {

            con=Database.getConnection();
            prStatement= con.prepareStatement(sql);
            ResultSet rs = prStatement.executeQuery();
            while (rs.next()) {
                Assignment ass=new Assignment();
                ass.setAssignment_id((rs.getInt("assignment_id")));
                ass.setDescription((rs.getString("description")));
                ass.setSubDateTime((rs.getString("subDateTime")));
               
                Assignments.add(ass);



            }
        }
        catch (SQLException ex) {
            Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                prStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return Assignments;

    }
    public void insertAssignment(Assignment ass) {

        try {

            con= Database.getConnection();
            String sb = "";
            sb = "INSERT INTO " + " assignments " +  "(`description`, `subDateTime`) VALUES (?,?)";
            //System.out.println(sb);
            prStatement = con.prepareStatement(sb);

            prStatement.setString(1, ass.getDescription());

            prStatement.setString(2, ass.getSubDateTime());


            prStatement.executeUpdate();
            prStatement.close();
            con.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                prStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    public ArrayList<Assignment> fetchallAssignmentsbyCourse(Course course) {


        String sql="select * from assignments inner join " +
                "assignments_courses on " +
                "assignments_courses.course_id=? and  assignments_courses.assignment_id=assignments.assignment_id";


        ArrayList<Assignment> AssignmentsperCourse=new ArrayList<>();
        try {
            con=Database.getConnection();

            prStatement= con.prepareStatement(sql);
            prStatement.setInt(1,course.getCourse_id());
            ResultSet rs = prStatement.executeQuery();

            while (rs.next()) {


                AssignmentsperCourse.add(new Assignment(rs.getInt("assignment_id"),rs.getString("description"),
                        rs.getString("subDateTime")));


            }

        }
        catch (SQLException ex) {
            Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                prStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return AssignmentsperCourse;

    }
    public ArrayList<AssignmentperCourseperStudent> fetchallAssignmentspercourseperstudent(int id) {

        ArrayList<AssignmentperCourseperStudent> Assignments=new ArrayList<>();

        String sql="select assignmentpercourseperstudent.enrollment_id, assignmentpercourseperstudent.oralMark, assignmentpercourseperstudent.totalMark , " +
                "assignments.description, assignments.subDateTime, assignments.assignment_id " +
                "from assignments inner join   assignmentpercourseperstudent on assignmentpercourseperstudent.enrollment_id=? " +
                "and assignmentpercourseperstudent.assignment_id=assignments.assignment_id";

        //System.out.println(sql);


        try {
            con = Database.getConnection();


            prStatement = con.prepareStatement(sql);
            prStatement.setInt(1, id);
            ResultSet rs = prStatement.executeQuery();

            while (rs.next()) {


                AssignmentperCourseperStudent assignmentpercourseperstudent = new AssignmentperCourseperStudent();
                assignmentpercourseperstudent.setEnrollment_id(id);
                assignmentpercourseperstudent.setOralMark(rs.getInt("oralMark"));
                assignmentpercourseperstudent.setTotalMark(rs.getInt("totalMark"));

                Assignment assignment=new Assignment();
                assignment.setAssignment_id(rs.getInt("assignment_id"));
                assignment.setDescription(rs.getString("description"));

                assignment.setSubDateTime((rs.getString("SubDateTime")));
                assignmentpercourseperstudent.setAssignmment(assignment);
                Assignments.add(assignmentpercourseperstudent);

            }

        }
        catch (SQLException ex) {
            Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                prStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Assignments;

    }
    public void insertAssignmentstoCourse(Assignment ass, Course course) {

        try {

            con= Database.getConnection();


            String sb = "";
            sb = "INSERT INTO " + " assignments_courses " +  "(`Course_id`, `assignment_id`) VALUES (?,?)";
            //System.out.println(sb);
            prStatement = con.prepareStatement(sb);

            prStatement.setInt(1, course.getCourse_id());

            prStatement.setInt(2, ass.getAssignment_id());


            prStatement.executeUpdate();
            prStatement.close();
            con.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                prStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
      public Assignment getlastinsert() throws ParseException{

      
        String sql="SELECT * FROM assignments where assignment_id=(Select MAX(assignment_id) from assignments)";

        Assignment Assignment=new Assignment();

        try {

            con=Database.getConnection();
            prStatement= con.prepareStatement(sql);
            ResultSet rs = prStatement.executeQuery();
            if(rs.next()) {
                Assignment.setAssignment_id(rs.getInt("assignment_id"));
                Assignment.setDescription(rs.getString("description"));
                Assignment.setSubDateTime((rs.getString("SubDateTime")));


            }
        }
        catch (SQLException ex) {
            Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                prStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

        return Assignment;

    }
}
