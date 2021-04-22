package cmdutils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Datahandling {
   
    public static boolean checkDatefieldfornullvalues(String string) {
        boolean valid=false;
           if (string.isEmpty()) {
                System.err.println("Null value for date type valid date");
            
            }else {
                valid=true;
            }
        return valid;

    }

    public static boolean checknotnull(String str) {
        boolean valid=false;
        if (str.isEmpty()) {
            System.err.println("A null value was entered");
        } else if (str.contains("@") || str.contains("!")  || str.contains("?")  ) {
            System.err.println("Characters such as @!?; can not be contained in the input values");

        }  else if (str.length()==1){
            System.err.println("Value can not have a length of 1");
        }
        else
        {
            valid=true;
        }
        return valid;

    }
    
    public static boolean checknegative(double number) {
        boolean valid=false;
        
        if (number<0) {
            System.err.println("Negative values are not allowed");

        }  else {
            valid=true;
        }
        return valid;

    }
    public static boolean checkstartenddate(LocalDate startdate,LocalDate enddate) {
        boolean valid=false;
        if (startdate.compareTo(enddate)==0) {
            System.err.println("Start date and end date can not be the same");
        } else if (enddate.compareTo(startdate)<0  ) {
            System.err.println("End date of the course " +enddate +" can not be earlier than the start date "+
                    startdate);
        } else {
            valid=true;
        }
        return valid;

    }
}
