package models;

public class TrainerDTO {
    private int trainer_id;
    private int course_id ;

    public TrainerDTO(int trainer_id, int course_id) {
        this.trainer_id = trainer_id;
        this.course_id = course_id;
    }

    public int getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(int trainer_id) {
        this.trainer_id = trainer_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TrainerDTO{");
        sb.append("trainer_id=").append(trainer_id);
        sb.append(", course_id=").append(course_id);
        sb.append('}');
        return sb.toString();
    }
}
