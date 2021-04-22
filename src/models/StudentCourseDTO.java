package models;

import java.util.ArrayList;

public class StudentCourseDTO {

    private int student_id;
    private String firstname;
    private int course_id;
    private String course_title;

    public StudentCourseDTO(int student_id, String firstname, int course_id, String course_title) {
        this.student_id = student_id;
        this.firstname = firstname;
        this.course_id = course_id;
        this.course_title = course_title;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }
}
