package models;
import java.text.ParseException;
import java.time.LocalDate;

/**
 *
 * @author  
 */
public final class Student {

    private int student_id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private double tuitionFees;





    public Student() {

    }
    public Student(int student_id,String firstName, String lastName, LocalDate dateOfBirth, double fees)throws ParseException{
        setStudent_id(student_id);
        setFirstName(firstName);
        setLastName(lastName);
        if(dateOfBirth != null){
            setDateOfBirth(dateOfBirth);
        }
        setFees(fees);

    }

    public Student(String firstName, String lastName, LocalDate dateOfBirth, double fees)throws ParseException{
        setFirstName(firstName);
        setLastName(lastName);
        if(dateOfBirth != null){
            setDateOfBirth(dateOfBirth);
        }
        setFees(fees);

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return getFirstName().concat(" ").concat(getLastName());
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public double getFees() {
        return tuitionFees;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) throws ParseException{
        if(dateOfBirth!=null){
            this.dateOfBirth = dateOfBirth;
        }        
    }

    public void setFees(double tuitionFees) {
        if (tuitionFees < 0) {
            System.err.println("Wrong fees. No changes.");
        } else {
            this.tuitionFees = tuitionFees;
        }

    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }


    public int getStudent_id() {
        return student_id;
    }

    public String printStudent() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", tuitionFees=").append(tuitionFees);
        sb.append('}');
        return sb.toString();
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("student_id=").append(student_id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", tuitionFees=").append(tuitionFees);
        sb.append('}');
        return sb.toString();
    }

}
