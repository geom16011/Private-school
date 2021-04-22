package DAO;


import dbutils.Database;
import models.*;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;

public class TrainerDAO {

    private  Connection con;
    private PreparedStatement prStatement=null;


    public ArrayList<Trainer> fetachallTrainers(){



        String sql="SELECT * FROM trainers";
        ArrayList<Trainer> Trainers=new ArrayList<>();



        try {

            con=Database.getConnection();
            prStatement= con.prepareStatement(sql);
            ResultSet rs = prStatement.executeQuery();
            while (rs.next()) {
                Trainer trainer=new Trainer();
                trainer.setTrainer_id(rs.getInt("trainer_id"));
                trainer.setFirstName(rs.getString("firstName"));
                trainer.setLastName(rs.getString("lastName"));
                trainer.setSubject(rs.getString("Subject"));
                Trainers.add(trainer);

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

        return Trainers;

    }
    public void insertTrainer(Trainer tr) {

        try {
            con=Database.getConnection();

            String sb = "";
            sb = "INSERT INTO " + "trainers " + "(firstName,LastName,Subject) VALUES (?,?,?)";
            //System.out.println(sb);
            prStatement = con.prepareStatement(sb);
            prStatement.setString(1, tr.getFirstName());
            prStatement.setString(2, tr.getLastName());
            prStatement.setString(3, tr.getSubject());

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
    public Trainer getlastinsert(){

      
        String sql="SELECT * FROM trainers where trainer_id=(Select MAX(trainer_id) from trainers)";

        Trainer trainer=new Trainer();

        try {

            con=Database.getConnection();
            prStatement= con.prepareStatement(sql);
            ResultSet rs = prStatement.executeQuery();
            if(rs.next()) {
                trainer.setTrainer_id(rs.getInt("trainer_id"));
                trainer.setFirstName(rs.getString("firstName"));
                trainer.setLastName(rs.getString("lastName"));
                trainer.setSubject(rs.getString("Subject"));

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

        return trainer;

    }
    public ArrayList<Trainer> fetchallTrainersbyCourse(Course course) {

       

        String sql="select * from trainers inner join " +
                "trainers_courses on " +
                "trainers_courses.course_id=? and trainers_courses.trainer_id=trainers.trainer_id";
        //System.out.println(sql);
        //System.out.println(course.getCourse_id());

        ArrayList<Trainer> TrainersperCourse=new ArrayList<>();
        try {
            con=Database.getConnection();
            prStatement= con.prepareStatement(sql);
            prStatement.setInt(1,course.getCourse_id());
            ResultSet rs = prStatement.executeQuery();

            while (rs.next()) {


                TrainersperCourse.add(new Trainer(rs.getInt("trainer_id"),rs.getString("firstname"),
                        rs.getString("lastname"),rs.getString("Subject")));


            }
            //TrainersperCourse.get(0).printTrainer();
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
        return TrainersperCourse;

    }
    public ArrayList<TrainerCourseDTO> fetchTrainerCourses() {
        ArrayList<TrainerCourseDTO> TrainerCourseDTO=new ArrayList<>();
        try {

            con = Database.getConnection();

            String sb = "";
            sb = "SELECT *" +
                    " FROM trainers_courses" ;
            //System.out.println(sb);
            prStatement = con.prepareStatement(sb);

            ResultSet rs = prStatement.executeQuery();

            while (rs.next()) {
                //System.out.print(rs.getString(" firstName"));
                TrainerCourseDTO temp=new TrainerCourseDTO (rs.getInt("trainer_id"), rs.getInt("course_id"));

                TrainerCourseDTO.add(temp);


            }
            //System.out.println(TrainerCourseDTO.toString());

            prStatement.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(TrainerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
                prStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(TrainerDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return TrainerCourseDTO;

    }
    public  void insertTrainertoCourse(Course course, Trainer trainer) {
        try {
            con=Database.getConnection();
            String sb ;
            sb = "INSERT INTO " + "trainers_courses " + "(trainer_id, course_id) VALUES (?,?)";
            //System.out.println(sb);
            prStatement = con.prepareStatement(sb);
            prStatement.setInt(1, trainer.getTrainer_id());
            prStatement.setInt(2, course.getCourse_id());
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
}

