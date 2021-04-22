package cmdutils;
import Private_school.Printer;

import java.util.Arrays;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Student extends Datahandling {
    private Scanner sc;

    public Student (Scanner sc) {
        this.sc = sc;
    }


    public models.Student askData() throws ParseException {
        Command cmd = new Command();
        models.Student Student = new models.Student();


        String firstname=cmd.getField(sc, "Type your First Name");
        while (!Datahandling.checknotnull(firstname)){
            System.out.println("First name was not provided correctly");
            firstname=cmd.getField(sc, "Type your First Name");

        }

        Student.setFirstName(firstname);
        String lastname=cmd.getField(sc, "Type your Last Name");
        //System.out.println(lastname);
        while (!Datahandling.checknotnull(lastname)){
            System.out.println("last name was not provided correctly");
            lastname=cmd.getField(sc, "Type your First Name");

        }
        Student.setDateOfBirth(cmd.getDateField(sc, "Type your date of birth in the format yyyy-mm-dd"));
        Student.setLastName(lastname);
        double tutitionfees=cmd.getDoubleField(sc,"tuition fees");
        while (!Datahandling.checknegative(tutitionfees)){
            System.out.println("Fees were not provided correctly");
            tutitionfees=cmd.getDoubleField(sc, "Provide tuition fees for the student");

        }
        Student.setFees(tutitionfees);
        return(Student);
    }

    public static models.Student getValidStudentfromUser (ArrayList<models.Student> Students){
        Scanner sc=new Scanner(System.in);
        models.Student Student=null;
        Collections.sort(Students, (o1, o2) -> Integer.valueOf(o1.getStudent_id()).compareTo(o1.getStudent_id()));
        Printer.printStudents(Students);
        boolean valid=false;
        //System.out.println("Please select a course from the list by typing an id:");

        Command cmd = new Command();


        int id=cmd.getIntField(sc,"Please select a student from the list by typing an id:");
        //System.out.println(id);
        while (valid==false) {
            for (int i = 0; i < Students.size(); i++) {
                if (Students.get(i).getStudent_id() == id) {
                    Student =Students.get(i);
                    valid=true;
                    //System.out.println(Student);
                    break;
                } else if (!valid && i==Students.size()-1) {
                    System.out.println("invalid ID");
                    //System.out.println("Please select a a valid id from the list by typing an id");
                    id=cmd.getIntField(sc,"Please select a student from the list by typing an id:");

                }
            }
        }
        return Student;

    }

}

