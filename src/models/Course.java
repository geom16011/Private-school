package  models;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author  
 */
public final class Course {

    private int course_id;
    private String title;
    private String stream;
    private String type;
    private LocalDate startDate;
    private LocalDate endDate;

    public Course () {

    }
    public Course(int id,String title, String stream, String type, LocalDate startDate, LocalDate endDate) {
        this.course_id = id;
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.endDate=endDate;
        this.startDate = startDate;
        
    }
    public Course(int id, String title, String stream, String type) {
        this.course_id = id;
        this.title = title;
        this.stream = stream;
        this.type = type;
    }
    public Course(String title, String stream, String type, LocalDate startDate, LocalDate endDate) {

        this.title = title;
        this.stream = stream;
        this.type = type;

        if (startDate != null) {
            this.startDate = startDate;
        }

        if (endDate != null) {
            this.endDate = endDate;
        }

    }

    public void setTitle(String title) {
        if (title != null) {
            this.title = title;
        } else {
            System.err.println("Null input title. No changes.");
        }
    }

    public void setStream(String stream) {
        if (stream != null) {
            this.stream = stream;
        } else {
            System.err.println("Null input stream. No changes");
        }

    }

    public void setType(String type) {
        if (type != null) {
            this.type = type;
        } else {
            System.err.println("Null input type. No changes.");
        }
    }

    public void setStartDate(LocalDate startDate) throws ParseException {
        if (startDate != null) {
            this.startDate = startDate;
        } else {
            System.out.println("Wrong date. Setting date. No changes.");
        }
    }

    public void setEndDate(LocalDate endDate) throws ParseException {
        this.endDate = endDate;

      
    }

    public String getTitle() {
        return title;
    }

    public String getStream() {
        return stream;
    }

    public String getType() {
        return type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getCourse_id() {
        return course_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course_id);
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Course{");
        sb.append("course_id=").append(course_id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", stream='").append(stream).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append('}');
        return sb.toString();
    }

    public String printCourse() {

        final StringBuilder sb = new StringBuilder("Course{");
        sb.append(" title='").append(title).append('\'');
        sb.append(", stream='").append(stream).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(title, course.title) &&
                stream.equals(course.stream) &&
                type.equals(course.type) &&
                startDate.equals(course.startDate) &&
                endDate.equals(course.endDate);
    }
}
