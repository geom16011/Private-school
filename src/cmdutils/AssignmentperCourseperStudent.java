package cmdutils;



import java.text.ParseException;
import java.util.Scanner;


public class AssignmentperCourseperStudent {

        private static Scanner sc;

        public AssignmentperCourseperStudent(Scanner sc) {
            this.sc=sc;
        }

        public models.AssignmentperCourseperStudent askData() throws ParseException {
            models.AssignmentperCourseperStudent  ass=new models.AssignmentperCourseperStudent();
            Command cmd = new Command();
            int Oralmark=cmd.getIntField(sc, "Type oral mark of the assignment");
            while (!Datahandling.checknegative(Oralmark)){
                System.out.println("Oral mark was not provided correctly");
                Oralmark=cmd.getIntField(sc, "Type oral mark of the assignment");
            }
            
            ass.setOralMark(Oralmark);
            
            int Totalmark=cmd.getIntField(sc, "Type total mark of the assignment");
            while (!Datahandling.checknegative(Totalmark)){
                System.out.println("Totalmark was not provided correctly");
                Totalmark=cmd.getIntField(sc, "Type total of thel assignment");
            }
            
            ass.setTotalMark(Totalmark);

            return ass;
        }
}


