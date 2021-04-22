package models;

public class AssignmentperCourseperStudent {
    private int enrollment_id;
    private Assignment assignment;
    private int oralMark;
    private int totalMark;

    public AssignmentperCourseperStudent() {
    }

    public AssignmentperCourseperStudent(int enrollment_id, Assignment assignmment, int oralMark, int totalMark) {
        this.assignment= assignmment;
        this.enrollment_id = enrollment_id;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
    }

    public AssignmentperCourseperStudent(int enrollment_id, Assignment assignmment) {
        this.assignment= assignmment;
        this.enrollment_id = enrollment_id;
    }

    public int getEnrollment_id() {
        return enrollment_id;
    }

    public void setEnrollment_id(int enrollment_id) {
        this.enrollment_id = enrollment_id;
    }

    public Assignment getAssignmment() {
        return assignment;
    }

    public void setAssignmment(Assignment assignmment) {
        this.assignment = assignmment;
    }

    public int getOralMark() {
        return oralMark;
    }

    public void setOralMark(int oralMark) {
        this.oralMark = oralMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Assignment details{");
        sb.append(assignment.toString());
        sb.append(", oralMark=").append(oralMark);
        sb.append(", totalMark=").append(totalMark);
        sb.append('}');
        return sb.toString();
    }
    
    public void printAssignmentperCourseperStudent (){
        System.out.println("The assignment with the description "+assignment.getDescription()+" "
                + "submission date "+assignment.getSubDateTime()+ " was marked with an oralmark "+
                oralMark +" and total mark "+totalMark+".");
    }
}
