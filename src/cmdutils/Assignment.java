package cmdutils;

import Private_school.Printer;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Assignment extends Datahandling{
    private Scanner sc;

    public Assignment (Scanner sc) {
        this.sc = sc;
    }


    public models.Assignment askData() throws ParseException {
        Command cmd = new Command();
        models.Assignment ass = new models.Assignment();
        String des=cmd.getField(sc, "Type description of the assignment");
        while (!Datahandling.checknotnull(des)){
            System.out.println("Description  was not provided correctly");
            des=cmd.getField(sc, "Type description of the assignment");

        }

        ass.setDescription(des);
        ass.setSubDateTime(cmd.getDateTimeField(sc, "Type submission date of the assignment yyyy-mm-dd HH:ss"));


        return(ass);
    }
    public static models.Assignment getValidAssignmentfromUser(ArrayList<models.Assignment> Assignments) {
        Scanner sc = new Scanner(System.in);
        models.Assignment Assignment = null;
         Collections.sort(Assignments, (o1, o2) -> Integer.valueOf(o1.getAssignment_id()).compareTo(o1.getAssignment_id()));
        Printer.printAssignments(Assignments);
        boolean valid = false;
        //System.out.println("Please select a course from the list by typing an id:");

        Command cmd = new Command();


        int id = cmd.getIntField(sc, "Please select a assignment from the list by typing an id:");
        //System.out.println(id);
        while (valid == false) {
            for (int i = 0; i < Assignments.size(); i++) {
                if (Assignments.get(i).getAssignment_id()== id) {
                    Assignment = Assignments.get(i);
                    valid = true;
                    //System.out.println(Assignment);
                    break;
                } else if (!valid && i == Assignments.size() - 1) {
                    System.out.println("invalid ID");
                    //System.out.println("Please select a a valid id from the list by typing an id");
                    id = cmd.getIntField(sc, "Please select a assignment from the list by typing an id:");

                }
            }
        }
        return Assignment;
    }


}
