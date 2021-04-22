/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Private_school;

import DAO.AssignmentDAO;
import DAO.CourseDAO;
import DAO.StudentDAO;
import DAO.TrainerDAO;

import dbutils.Database;
import models.*;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;


public class Private_school {



    private static String input;

  


    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Provide name of the database");
        String database=sc.next();

        System.out.println("Provide username for the database");
        String username=sc.next();

        System.out.println("Provide password for the database");
        String password=sc.next();

        Database.setUsername(username);
        Database.setPassword(password);
        Database.setDatabase(database);




        int choice = chooseValuesInput();

        switch (choice) {
            case 0:
                System.out.println("Thank you! Exiting program.");
                System.exit(0);
            case 1:

                chooseOperation();
                break;
        }

    }
    public static int chooseValuesInput()  {
        System.out.println("");
        System.out.println("Choose operation:");
        System.out.println("Insert 0 to exit program");
        System.out.println("Insert 1 to proceed to the menu");
        System.out.println("--------------------");
        Scanner scanner= new Scanner(System.in);
        input = scanner.nextLine();

        if (input.equals("0")) {
            return 0;
        } else  {
            return 1;
        }
    }

    public static void chooseOperation() throws ParseException {



        while (true) {
            System.out.println("Choose an operation");
            System.out.println("Insert 0 to exit the program");
            System.out.println("Insert 1 see information for the school");
            System.out.println("Insert 2 Create an entity (Course, Trainer, Student, Assignment)");
            System.out.println("Insert 3 Associate  entities (Trainer or Student or Assignment or Assignment to a Student to course)");
            System.out.println("---------");


            Scanner scanner=new Scanner(System.in);
            input = scanner.nextLine().trim();

            switch (input) {
                case "0":
                    System.exit(0);
                case "1":
                    choosePrintMenu();
                    break;
                case "2":
                    chooseCreateMenu();
                    break;
                case "3":
                    chooseAssociateMenu();
                    break;
                default:
                        System.out.println("Wrong input. Please try again");
                    break;
            }
        }
    }



    public  static void chooseCreateMenu() throws ParseException {

        System.out.println("What would you like to create?");
        System.out.println("Insert 0 to exit the program");
        System.out.println("Insert 1 to create a course");
        System.out.println("Insert 2 to create a trainer");
        System.out.println("Insert 3 to create a student");
        System.out.println("Insert 4 to create an assignment");
        
        

        System.out.println("-----------");

        Scanner scanner=new Scanner(System.in);
        input = scanner.nextLine().trim();
        CourseDAO CourseDAO1=new CourseDAO();
        
        cmdutils.Course cmdcourse=new cmdutils.Course(scanner);
        Course course1;
        ArrayList<Course> courses;
        Trainer trainer;
       
        switch (input) {
            case "0":
                System.out.println("Thank you! Exiting program");
                System.exit(0);
                break;
            case "1":
                System.out.println("Creating a course");       
                models.Course course=cmdcourse.askData();
                CourseDAO1.insertCourse(course);
                System.out.println("Course with the following details was added to the database: "+
                        course.printCourse());

                break;
            case "2":
                System.out.println("Creating a trainer");
                cmdutils.Trainer cmdtrainer=new cmdutils.Trainer(scanner);
                TrainerDAO trainerDAO1=new TrainerDAO();
                trainer=cmdtrainer.askData();
                trainerDAO1.insertTrainer(trainer);
                System.out.println("Trainer with the following details was added to the database: "+
                        trainer.printTrainer());
                
                courses=CourseDAO1.getCourses();
                if (!courses.isEmpty()) {
                    System.out.println("Would you like to assign the added trainer to a course?");
                    System.out.println("Type 1 to assign to a course otherwise type any other number");
                    int choice=scanner.nextInt();
                    if (choice==1) {
                        course1=cmdutils.Course.getValidCoursefromUser(courses);
                        trainer=trainerDAO1.getlastinsert();
                        trainerDAO1.insertTrainertoCourse(course1, trainer);
                        Printer.printTrainersassignedtoCourse(course1,trainer);
                    }
                
                }

                break;
            case "3":
                System.out.println("Creating a student");
                cmdutils.Student cmdst=new cmdutils.Student(scanner);
                StudentDAO StudentDAO1= new StudentDAO();
                models.Student Student= cmdst.askData();
                StudentDAO1.insertStudent(Student);
                System.out.println("Student with the following details was added to the database: "+
                        Student.printStudent());
                courses=CourseDAO1.getCourses();
                if (!courses.isEmpty()) {
                    System.out.println("Would you like to assign the added student to a course?");
                    System.out.println("Type 1 to assign to a course otherwise type any other number");
                    int choice=scanner.nextInt();
                    if (choice==1) {
                        course1=cmdutils.Course.getValidCoursefromUser(courses);
                        Student=StudentDAO1.getlastinsert();
                        CourseDAO1.insertStudenttoCourse(course1,Student);
                        Printer.printStudentsassignedtoCourse(course1,Student);
                        
 
                    }
                
                }

                break;
            case "4":
                System.out.println("Creating an assignment");
                cmdutils.Assignment cmdassignment=new cmdutils.Assignment(scanner);
                AssignmentDAO AssignmentDAO1= new AssignmentDAO();
                models.Assignment Assignment=cmdassignment.askData();
                AssignmentDAO1.insertAssignment(Assignment);
                System.out.println("Assignment with the following details was added to the database: "+
                Assignment.printAssignment());
                courses=CourseDAO1.getCourses();
                if (!courses.isEmpty()) {
                    System.out.println("Would you like to assign the added assignment to a course?");
                    System.out.println("Type 1 to assign to a course otherwise type any other number");
                    int choice=scanner.nextInt();
                    if (choice==1) {
                        course1=cmdutils.Course.getValidCoursefromUser(courses);
                        Assignment=AssignmentDAO1.getlastinsert();
                        AssignmentDAO1.insertAssignmentstoCourse(Assignment, course1);
                        Printer.printassignmentassignedtoCourse(Assignment,course1);
                     
 
                    }
                }
                break; 
            default:

                System.err.println("Wrong input. Please try again");

                break;
        }


    }
    public static void chooseAssociateMenu() throws  ParseException {


        System.out.println("What would you like to associate?");
        System.out.println("Insert 0 to exit the program");
        System.out.println("Insert 1 assign a trainer to a course");
        System.out.println("Insert 2 assign a student to a course");
        System.out.println("Insert 3 assign a assignment to a course");
        System.out.println("Insert 4 assign an assignment to a student to a course");
        //System.out.println("Insert 5 create a new student and a assign to a course");
        System.out.println("-----------");


        Scanner scanner=new Scanner(System.in);
        input = scanner.nextLine().trim();
        //System.out.println(input);
        CourseDAO courseDAO=new CourseDAO();
        StudentDAO studentDAO=new StudentDAO();
        TrainerDAO trainerDAO=new TrainerDAO();
        AssignmentDAO assignmentDAO=new AssignmentDAO();

        Course course;
        Student Student;
        Assignment Assignment;

        ArrayList<Student> Students;
        ArrayList<Assignment> Assignments;
        ArrayList<Course> courses;

        switch (input) {
            case "0":
                System.out.println("Thank you! Exiting program");
                System.exit(0);
                break;
            case "1":
                courses=courseDAO.getCourses();
                if (!courses.isEmpty()) {
                        course = cmdutils.Course.getValidCoursefromUser(courses);
                        ArrayList<Trainer> trainers = trainerDAO.fetachallTrainers();
                        if (!trainers.isEmpty()) {
                            Trainer trainer = cmdutils.Trainer.getValidTrainerfromUser(trainers);
                            ArrayList<TrainerCourseDTO> TrainerCourseDTO = trainerDAO.fetchTrainerCourses();
                            if (!chcecktraineralreadytocourse(course, trainer, TrainerCourseDTO)) {
                                trainerDAO.insertTrainertoCourse(course, trainer);
                                Printer.printTrainersassignedtoCourse(course,trainer);
                            }
                        } else {
                            System.out.println("Empty list of trainers please add a trainer");
                        }
                }
                else{
                        System.out.println("Empty list of courses please add a course");
                    }

                break;
            case "2":
                courses=courseDAO.getCourses();
                if (!courses.isEmpty()) {
                    course=cmdutils.Course.getValidCoursefromUser(courses);
                    Students=studentDAO.fetchStudents();
                    
                    if (!Students.isEmpty()) {
                        Student=cmdutils.Student.getValidStudentfromUser(Students);
                        ArrayList<StudentCourseDTO> StudentCourseDTO=studentDAO.fetchStudentCourses();
                        if (!chceckstudentalreadytocourse(course,Student,StudentCourseDTO)){
                            courseDAO.insertStudenttoCourse(course,Student);
                            Printer.printStudentsassignedtoCourse(course,Student);
                        }
                    }else {
                        System.out.println("Student list for the course is empty");

                    }
                }else {
                    System.out.println("Course list is empty");

                }

                break;
            case "3":
                courses=courseDAO.getCourses();
                if (!courses.isEmpty()) {
                    course=cmdutils.Course.getValidCoursefromUser(courses);
                    Assignments=assignmentDAO.fetachallAssignments();
                    if (!Assignments.isEmpty()) {
                        Assignment = cmdutils.Assignment.getValidAssignmentfromUser(Assignments);
                        if (!chceckassignmentalreadyassignedtocourse(course, Assignment, courseDAO.fetchassignmentsCourses(course))) {
                            assignmentDAO.insertAssignmentstoCourse(Assignment, course);
                            Printer.printassignmentassignedtoCourse(Assignment,course);
                        }
                    }else {
                        System.out.println("Assignments list for the course is empty");
                    }

                } else {
                    System.out.println("Course list is empty");
                }


                break;
            case "4":
                courses=courseDAO.getCourses();
                if (!courses.isEmpty()) {
                    course=cmdutils.Course.getValidCoursefromUser((courses));
                    Students=studentDAO.fetchalStudentsbyCourse(course);
                    if (!Students.isEmpty()) {
                        Student=cmdutils.Student.getValidStudentfromUser(Students);
                        int id= studentDAO.fetchenrollmentid(course,Student);
                        Assignments=assignmentDAO.fetchallAssignmentsbyCourse(course);
                        if (!Assignments.isEmpty()) {
                            Assignment = cmdutils.Assignment.getValidAssignmentfromUser(Assignments);
   
                            
                            if (!checkassignmentalreadyassignedtostudent(id, Assignment,assignmentDAO.fetchallAssignmentspercourseperstudent(id))) {
                                cmdutils.AssignmentperCourseperStudent cmdAssignmentperCourseperStudent = new cmdutils.AssignmentperCourseperStudent(scanner);
                                AssignmentperCourseperStudent AssignmentperCourseperStudent = cmdAssignmentperCourseperStudent.askData();
                                AssignmentperCourseperStudent.setAssignmment(Assignment);
                                studentDAO.insertStudentAssignment(id, Assignment, AssignmentperCourseperStudent);
                                Printer.printassignmentassignedtoStudent(AssignmentperCourseperStudent, Student);

                            }
                        }
                        else {
                            System.out.println("Assignments list for the course is empty");
                        }
                    } else {
                        System.out.println("Student list for the course is empty");
                    }
                }else {
                    System.out.println("Course list is empty");
                }
                break;
            default:
                System.err.println("Wrong input. Please try again");

                break;
        }
    }
    public static void choosePrintMenu() {
        //System.out.println("What would you like to print? Remaining attempts " + attempts);
        System.out.println("Insert 0 to exit the program");
        System.out.println("Insert 1 print courses of school");
        System.out.println("Insert 2 print trainers of school");
        System.out.println("Insert 3 print students of school");
        System.out.println("Insert 4 print assignments of school");
        System.out.println("Insert 5 print students by course");
        System.out.println("Insert 6 print trainers by course");
        System.out.println("Insert 7 print assignments  by course");
        System.out.println("Insert 8 print assignments by course per student");
        System.out.println("Insert 9 print students enrolled to more than one course");
        System.out.println("-----------");
        Scanner scanner=new Scanner(System.in);
        input = scanner.nextLine().trim();

        CourseDAO courseDAO=new CourseDAO();
        TrainerDAO trainerDAO=new TrainerDAO();
        StudentDAO studentDAO=new StudentDAO();
        AssignmentDAO assignmentDAO=new AssignmentDAO();
        switch (input) {
            case "0":
                System.out.println("Thank you! Exiting program");
                System.exit(0);
                break;
            case "1":
                Printer.printCourses(courseDAO.getCourses());

                break;
            case "2":
                Printer.printTrainers(trainerDAO.fetachallTrainers());
                break;
            case "3":
                Printer.printStudents(studentDAO.fetchStudents());
                break;
            case "4":
                Printer.printAssignments(assignmentDAO.fetachallAssignments());
                break;
            case "5":
                ArrayList<Course> courses=courseDAO.getCourses();
                Course course=cmdutils.Course.getValidCoursefromUser(courses);
                ArrayList<Student> Students=studentDAO.fetchalStudentsbyCourse(course);
                Printer.printStudentsbyCourse(Students,course);
                break;
            case "6":
                ArrayList<Course> courses1=courseDAO.getCourses();
                Course course1=cmdutils.Course.getValidCoursefromUser(courses1);
                ArrayList<Trainer> Trainers=trainerDAO.fetchallTrainersbyCourse(course1);
                Printer.printTrainersbyCourse(Trainers,course1);

                break;
            case "7":
                ArrayList<Course> courses2=courseDAO.getCourses();
                Course course2=cmdutils.Course.getValidCoursefromUser(courses2);

                Printer.printAssignmentbyCourse(assignmentDAO.fetchallAssignmentsbyCourse(course2),course2);

                break;
            case "8":

                Course course3=cmdutils.Course.getValidCoursefromUser(courseDAO.getCourses());
                ArrayList<Student> students=studentDAO.fetchStudents();
                Student student=cmdutils.Student.getValidStudentfromUser(students);
                Printer.printAssignmentbyCoursebyStudent(
                        assignmentDAO.fetchallAssignmentspercourseperstudent(studentDAO.fetchenrollmentid(course3,student)),course3);
                break;
            case "9":

                System.out.println("Students list enrolled to more than one course");
                Printer.printStudents(studentDAO.fetchStudentenrolledmorethanoneCourse());

                break;


            default:

                System.err.println("Wrong input. Please try again");

                break;
        }

    }
    public static  boolean chceckstudentalreadytocourse(Course course, Student student, ArrayList<StudentCourseDTO> StudentCourseDTO)
             {
        boolean enrolled=false;
        for (int i=0;i<StudentCourseDTO.size();i++) {
            if (StudentCourseDTO.get(i).getCourse_id()==(course.getCourse_id()) &&
            StudentCourseDTO.get(i).getStudent_id()==(student.getStudent_id()) ) {
            System.out.println("The student with the name "+student.getFullName()+" was already assigned to the course with the title "
                        +course.getTitle()+".");
                enrolled=true;
            }

        }
        return enrolled;

    }
    public static  boolean chcecktraineralreadytocourse(Course course, Trainer trainer, ArrayList<TrainerCourseDTO> TrainerCourseDTO) {
        boolean enrolled=false;
        for (int i=0;i<TrainerCourseDTO.size();i++) {
            if (TrainerCourseDTO.get(i).getCourse_id()==(course.getCourse_id()) &&
                    TrainerCourseDTO.get(i).getTrainer_id()==(trainer.getTrainer_id()) ) {
                      System.out.println("The trainer with the name "+trainer.getFullName()+" was already assigned to the course with the title "
                        +course.getTitle()+".");
                enrolled=true;
            }

        }
        return enrolled;

    }
    public static  boolean chceckassignmentalreadyassignedtocourse(Course course, Assignment Assignment, ArrayList<AssignmentCourseDTO> AssignmentCourseDTO)
             {
        boolean assigned=false;
        

//        System.out.println(course.getCourse_id());
//        System.out.println(AssignmentCourseDTO.get(1).getCourse_id());
//        System.out.println(AssignmentCourseDTO.get(1).getAssignment_id());

        for (int i=0;i<AssignmentCourseDTO.size();i++) {
            if (AssignmentCourseDTO.get(i).getCourse_id()==(course.getCourse_id()) &&
                    AssignmentCourseDTO.get(i).getAssignment_id()==(Assignment.getAssignment_id()) ) {
                System.out.println("The assignment with the description "+Assignment.getDescription()+" was already assigned to the course with the title "
                        +course.getTitle()+".");
                assigned=true;
            }

        }
        return assigned;

    }
    public static  boolean checkassignmentalreadyassignedtostudent(int id, Assignment Assignment,ArrayList<AssignmentperCourseperStudent> AssignmentperCourseperStudent)
             {
        boolean assigned=false;
        //System.out.println(Assignment.getAssignment_id());

        for (int i=0;i<AssignmentperCourseperStudent.size();i++) {



        if (AssignmentperCourseperStudent.get(i).getEnrollment_id()==(id) &&

                AssignmentperCourseperStudent.get(i).getAssignmment().getAssignment_id()==(Assignment.getAssignment_id()) ) {
                System.out.println("The assignment with the description "+Assignment.getDescription()+" was already assigned to the student.");
                assigned=true;
            }
        }
        return assigned;

    }

}

