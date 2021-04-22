package Private_school;

import models.*;

import java.util.ArrayList;

public class Printer {

    
    public static void printTrainersbyCourse(ArrayList<Trainer> trainers, Course course) {
        StringBuilder sb = new StringBuilder();
        sb.append("Course selected:");
        sb.append(course.toString());
        System.out.println(sb);
        
        if (trainers.isEmpty()) {
            System.out.println("Empty list of Trainers");
        }else {
            System.out.println("Trainer list:");
            for (int i = 0; i < trainers.size(); i++)  {
                System.out.println(trainers.get(i).printTrainer());
            }
        }


    }

    public static void printStudentsbyCourse(ArrayList<Student> Students, Course course) {
        StringBuilder sb = new StringBuilder();
        sb.append("Course selected:");
        sb.append(course.toString());
        System.out.println(sb);

        if (Students.size()==0) {
            System.out.println("Empty Student list");
        }else {
            System.out.println("Student list of the course:");
            for (int i = 0; i < Students.size(); i++) {
                System.out.println(Students.get(i).toString());
            }
        }

    }

    public static void printAssignmentbyCourse(ArrayList<Assignment> Assignments, Course course) {
        StringBuilder sb = new StringBuilder();
        sb.append("Course selected:");
        sb.append(course.toString());
        System.out.println(sb);
        if (Assignments.size()==0) {
            System.out.println("Empty assignment list");
        }else {
            System.out.println("Assigment list of the course:");
            for (int i = 0; i < Assignments.size(); i++) {
                System.out.println(Assignments.get(i).toString());
            }
        }

    }

    public static void printStudents(ArrayList<Student> Students) {

        if (Students.size()==0) {
            System.out.println("The school doesn t have any students");
        }else {
            System.out.println("Student list:");
            for (int i = 0; i < Students.size(); i++) {

                System.out.println(Students.get(i).toString());
            }
        }

    }
    public static void printAssignmentbyCoursebyStudent(ArrayList<AssignmentperCourseperStudent> assignments, Course course) {
        StringBuilder sb = new StringBuilder();
        sb.append("[Course ").append(course.getTitle());
        sb.append("]");
        //System.out.println(assignments.size());
        if (assignments.size()==0) {
            System.out.println("Empty list of Assignments");
        }else {
            for (int i = 0; i < assignments.size(); i++) {
                System.out.println(assignments.get(i).toString());
            }
        }

    }
    public static void printCourses(ArrayList<Course> Courses) {

        if (Courses.size()==0) {
            System.out.println("Empty list of courses");
        }else {
            System.out.println("Course list:");
            for (int i = 0; i < Courses.size(); i++) {

                System.out.println(Courses.get(i).toString());
            }
        }

    }
    public static void printTrainers(ArrayList<Trainer> Trainers) {

        if (Trainers.size()==0) {
            System.out.println("Empty list of trainers");
        }else {
            System.out.println("Trainer list:");
            for (int i = 0; i < Trainers.size(); i++) {

                System.out.println(Trainers.get(i).toString());
            }
        }

    }
    public static void printAssignments(ArrayList<Assignment> Assignments) {

        if (Assignments.size()==0) {
            System.out.println("Empty list of Assignments");
        }else {
            System.out.println("Assignment list:");
            for (int i = 0; i < Assignments.size(); i++) {

                System.out.println(Assignments.get(i).toString());
            }
        }

    }
    public static void printTrainersassignedtoCourse(Course course,Trainer trainer) {
       System.out.print("The trainer with the following details ");
       System.out.println(trainer.toString());
       System.out.print("was assigned to the course ");
       System.out.println(course.toString());


    }
    public static void printStudentsassignedtoCourse(Course course,Student student) {
        System.out.print("The student with the following details ");
        System.out.println(student.toString());
        System.out.print("was assigned to the course ");
        System.out.println(course.toString());


    }
    public static void printassignmentassignedtoCourse(Assignment assignment,Course course) {
        System.out.print("The assignment with the following details ");
        System.out.println(assignment.toString());
        System.out.print("was assigned to the course ");
        System.out.println(course.toString());


    }
    public static void printassignmentassignedtoStudent (models.AssignmentperCourseperStudent AssignmentperCourseperStudent, Student student) {
        
       
        
        
        System.out.println("The assignment with the description "
                +AssignmentperCourseperStudent.getAssignmment().getDescription()+" " + "submission date "+AssignmentperCourseperStudent.getAssignmment().getSubDateTime()+ " was marked with an oralmark "+
                AssignmentperCourseperStudent.getOralMark() +" and total mark "+AssignmentperCourseperStudent.getTotalMark());
        System.out.print("was assigned to the student with the followinng details:");
        System.out.print(student.toString());


    }

}
