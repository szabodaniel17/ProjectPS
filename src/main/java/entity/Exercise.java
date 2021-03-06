package entity;

import javax.persistence.*;
import java.util.*;

@Entity(name = "exercise")
public class Exercise {

    @Id
    private final String id;
    @Column
    private String name;
    @Column
    private String reps;
    @Column
    private Integer sets;
    @Column
    private String restTime;

    Exercise(){
        id = UUID.randomUUID().toString();
    }

    public Exercise(String name,String reps,Integer sets,String restTime){
        this.name = name;
        this.reps = reps;
        this.sets = sets;
        this.restTime = restTime;
        id = UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return Objects.equals(name, exercise.name) &&
                Objects.equals(reps, exercise.reps) &&
                Objects.equals(sets, exercise.sets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, reps, sets);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public String getRestTime() {
        return restTime;
    }

    public void setRestTime(String restTime) {
        this.restTime = restTime;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", reps='" + reps + '\'' +
                ", sets=" + sets +
                ", restTime='" + restTime + '\'' +
                '}';
    }
}
