/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmdutils;

import Private_school.Printer;
import models.Student;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author George.Pasparakis
 */
public class Trainer extends Datahandling {
    private Scanner sc;

    public Trainer(Scanner sc) {
        this.sc = sc;
    }


    public models.Trainer askData() throws ParseException {
        Command cmd = new Command();
        models.Trainer trainer = new models.Trainer();

        String firstname = cmd.getField(sc, "Type your First Name");
        while (!Datahandling.checknotnull(firstname)) {
            System.out.println("First name was not provided correctly");
            firstname = cmd.getField(sc, "Type your First Name");
        }
        trainer.setFirstName(firstname);
        ///System.out.println(trainer.getFirstName());
        String lastname = cmd.getField(sc, "Type your Last Name");
        while (!Datahandling.checknotnull(lastname)) {
            System.out.println("last name was not provided correctly");
            lastname = cmd.getField(sc, "Please type correctly your Last Name");
        }
        trainer.setLastName(lastname);
        String Subject = cmd.getField(sc, "Type your Subject");
        while (!Datahandling.checknotnull(Subject)) {
            System.out.println("Subject was not provided correctly");
            Subject = cmd.getField(sc, "Type your Subject");
        }
        trainer.setSubject(Subject);

        return (trainer);
    }

    public static models.Trainer getValidTrainerfromUser(ArrayList<models.Trainer> trainers) {
        Scanner sc = new Scanner(System.in);
        models.Trainer Trainer = null;
        Collections.sort(trainers, (o1, o2) -> Integer.valueOf(o1.getTrainer_id()).compareTo(o1.getTrainer_id()));
        Printer.printTrainers(trainers);
        boolean valid = false;
        //System.out.println("Please select a course from the list by typing an id:");

        Command cmd = new Command();


        int id = cmd.getIntField(sc, "Please select a trainer from the list by typing an id:");
        //System.out.println(id);
        while (valid == false) {
            for (int i = 0; i < trainers.size(); i++) {
                if (trainers.get(i).getTrainer_id() == id) {
                    Trainer = trainers.get(i);
                    valid = true;
                    //System.out.println(Trainer);
                    break;
                } else if (!valid && i == trainers.size() - 1) {
                    System.out.println("invalid ID");
                    //System.out.println("Please select a a valid id from the list by typing an id");
                    id = cmd.getIntField(sc, "Please select a trainer from the list by typing an id:");

                }
            }
        }
        return Trainer;
    }
}
