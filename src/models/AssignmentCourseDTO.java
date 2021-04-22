package models;

public class AssignmentCourseDTO {
    private int assignment_id;
    private int course_id;

    public AssignmentCourseDTO(int assignment_id, int course_id) {
        this.assignment_id = assignment_id;
        this.course_id = course_id;
    }

    public int getAssignment_id() {
        return assignment_id;
    }

    public void setAssignment_id(int assignment_id) {
        this.assignment_id = assignment_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
}
