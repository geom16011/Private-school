
package models;

import java.text.ParseException;
import models.*;


public final class Trainer {
    private int trainer_id;
    private String firstName;
    private String lastName;
    private String subject;

    public Trainer() {
    }

    public Trainer(String firstName, String lastName) throws ParseException {
        setFirstName(firstName);
        setLastName(lastName);
    }
    public Trainer(int trainer_id,String firstName, String lastName, String Subject) {
        this.trainer_id=trainer_id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.subject=Subject;
    }
    Trainer(String firstName, String lastName, String Subject)  {
        this.firstName=firstName;
        this.lastName=lastName;
        this.subject=Subject;
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

    public String getSubject() {
        return subject;
    }

    public void setFirstName(String firstName) {
        //System.out.println(firstName);
        if (firstName != null) {
            this.firstName = firstName;
        } else {
            System.err.println("Null name. No changes.");
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        } else {
            System.err.println("Null name. No changes.");
        }
    }

    public int getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(int trainer_id) {
        this.trainer_id = trainer_id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String printTrainer() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trainer[fullname: ").append(getFirstName());
        sb.append(" ").append(getLastName());
        if(getSubject()!=null){
            sb.append(", ").append("subject: ").append(getSubject());
        }else{
            sb.append(", ").append("subject: ").append(" null");
        }
       sb.append("]");

        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Trainer{");
        sb.append("trainer_id=").append(trainer_id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", subject='").append(subject).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
