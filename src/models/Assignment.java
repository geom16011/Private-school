package models;



import java.text.ParseException;
import java.time.LocalDate;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author  
 */
public final class Assignment {

    private int assignment_id;

  
    private String description;
    private String subDateTime;

    public Assignment() {
    }

    public Assignment(int assignment_id, String description, String subDateTime) {
        this.assignment_id = assignment_id;
        this.description = description;
        this.subDateTime = subDateTime;
    }

    public Assignment(String description, String subDateTime) {
        this.description = description;
        this.subDateTime = subDateTime;
    }

    public int getAssignment_id() {
        return assignment_id;
    }

    public void setAssignment_id(int assignment_id) {
        this.assignment_id = assignment_id;
    }


 
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(String subDateTime) {
        this.subDateTime = subDateTime;
    }

    public String printAssignment() {
        final StringBuilder sb = new StringBuilder("Assignment{");
        sb.append(", description='").append(description).append('\'');
        sb.append(", subDateTime='").append(subDateTime).append('\'');
        sb.append('}');
        return sb.toString();
    }
    public String toString() {
        final StringBuilder sb = new StringBuilder("Assignment{");
        sb.append("assignment_id=").append(assignment_id);
        sb.append(", description='").append(description).append('\'');
        sb.append(", subDateTime='").append(subDateTime).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
