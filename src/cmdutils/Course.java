package cmdutils;

import Private_school.Printer;

import java.text.ParseException;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Scanner;

public class Course extends Datahandling{

    private static Scanner sc;

    public Course(Scanner sc) {
        this.sc=sc;
    }

    public models.Course askData() throws ParseException {
        models.Course course=new models.Course();
        Command cmd = new Command();


        String title=cmd.getField(sc,"Enter title of the course");
        while (!Datahandling.checknotnull(title)){
            System.out.println("title name was not provided correctly");
            title=cmd.getField(sc, "Enter title of the course");

        }
        course.setTitle(title);


        String Stream=cmd.getField(sc,"Enter stream of the course");
        while (!Datahandling.checknotnull(Stream)){
            System.out.println("Stream was not provided correctly");
            Stream=cmd.getField(sc, "Enter stream of the course");

        }
        course.setStream(Stream);

        String type=cmd.getField(sc,"Enter type  of the course");
        while (!Datahandling.checknotnull(type)){
            System.out.println("Type was not provided correctly");
            type=cmd.getField(sc, "Enter type  of the course");

        }

        course.setType(type);


        
        LocalDate startdate=cmd.getDateField(sc,"Enter start date of the course in the format yyyy-mm-dd");
        LocalDate enddate=cmd.getDateField(sc,"Enter end date of the course in the format yyyy-mm-dd");
            
  
        
        while (!Datahandling.checkstartenddate(startdate,enddate)){
            enddate=cmd.getDateField(sc,"Type a valid end date of the course in the format yyyy-mm-dd");
            

        }
        
        //System.out.println(startdate);
        //System.out.println(enddate);
        course.setStartDate(startdate);

        course.setEndDate(enddate);
        
        

        return course;
    }
    public static models.Course getValidCoursefromUser (ArrayList<models.Course> Courses){
        Scanner sc=new Scanner(System.in);
        models.Course Course=null;
        Printer.printCourses(Courses);
        boolean valid=false;
        //System.out.println("Please select a course from the list by typing an id:");

        Command cmd = new Command();


        int id=cmd.getIntField(sc,"Please select a course from the list by typing an id:");
        //System.out.println(id);
        while (valid==false) {
            for (int i = 0; i < Courses.size(); i++) {
                if (Courses.get(i).getCourse_id() == id) {
                    Course = Courses.get(i);
                    valid=true;
                    //System.out.println(Courses.get(i).getCourse_id());
                    break;
                } else if (!valid && i==Courses.size()-1) {
                    System.out.println("invalid ID");
                    //System.out.println("Please select a a valid id from the list by typing an id");
                    id=cmd.getIntField(sc,"Please select a course from the list by typing an id:");

                }
            }
        }
        return Course;

    }

}
