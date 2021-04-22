/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmdutils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 *
 */
public class Command extends Datahandling{
     private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/YYYY");
    public String getField(Scanner sc, String message) {
        System.out.println(message);
        return(sc.nextLine());
    }
    
    public double getDoubleField(Scanner sc, String message) {
        System.out.println(message);
        //return(Double.parseDouble(sc.nextLine()));
        return(sc.nextDouble());
    }
    
    public int getIntField(Scanner sc, String message) {
        System.out.println(message);
        //return(Double.parseDouble(sc.nextLine()));
        return(sc.nextInt());
    }

    public LocalDate  getDateField(Scanner sc, String message) throws ParseException  {
        System.out.println(message);
        LocalDate date = null;
        boolean valid=false;
        while (!valid){
            String string= sc.nextLine().trim();
            while (!Datahandling.checkDatefieldfornullvalues(string)) {
                string= sc.nextLine().trim();
            } 
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try {
                date=LocalDate.parse(string,format);
                valid=true;
            }catch (DateTimeParseException e) {
                System.out.println("Not valid date was provided");
                
            }
        }
        return date;
    }
    public String getDateTimeField(Scanner sc, String message) {
        System.out.println(message);
        String date;
        String foramttedString = null;
        LocalDateTime dateTime;
        boolean valid=false;
        while (!valid){
            date= sc.nextLine().trim();
            while (!Datahandling.checkDatefieldfornullvalues(date)) {
                date= sc.nextLine().trim();
            } 
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            try {
                dateTime = LocalDateTime.parse(date, format);
                LocalDateTime localDateTime = LocalDateTime.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth(), dateTime.getHour(), dateTime.getMinute());
                foramttedString = localDateTime.toString();
                valid=true;
            }catch (DateTimeParseException e) {
                System.out.println("Not valid date was provided");
        
            }
        }
        
        return foramttedString ;
    }
    
}
