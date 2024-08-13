package edu.sdccd.cisc191.springjpa.exercises;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Exercise {
    @Id
    private String dateOfWorkout;
    private int pushUps;
    private int pullUps;
    private int sitUps;
    private int planks;
    private int diveBombers;
    private int sets;
    private int reps;
    private int weight;
    private int duration;
    private int distance;


    @OneToMany(fetch = FetchType.EAGER)
    // TODO: think about the Option class and if i should change the name to reflect sets and reps or something similar.
    public List<Option> options;

    public Exercise(String upperBodyPart, int pushUps, int pullUps, int sitUps, int planks, int diveBombers, int sets, int reps, int weight, int duration, int distance,  int options) {
        this.dateOfWorkout = upperBodyPart;
        this.pushUps = pushUps;
        this.pullUps = pullUps;
        this.sitUps = sitUps;
        this.planks = planks;
        this.diveBombers = diveBombers;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.duration = duration;
        this.distance = distance;


    }

    public Exercise() {
    }

    public Exercise(String newExercise) {
    }

//    public Exercise(String dateOfWorkout, int pushUps, int pullUps, int sitUps, int planks, int diveBombers, int sets, int reps, int weight, int duration, int distance, List<Option> options) {
//    }

    public Exercise(String date, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, List<Option> options) {
    }

    public String getDateOfWorkout() {
        return dateOfWorkout;
    }

    public void setDateOfWorkout(String upperBodyPart) {
        this.dateOfWorkout = upperBodyPart;
    }

    public int getPushUps() {
        return pushUps;
    }

    public void setPushUps(int pushUps) {
        this.pushUps = pushUps;
    }

    public int getPullUps() {
        return pullUps;
    }

    public void setPullUps(int pullUps) {
        this.pullUps = pullUps;
    }

    public int getSitUps() {
        return sitUps;
    }

    public void setSitUps(int sitUps) {
        this.sitUps = sitUps;
    }

    public int getPlanks() {
        return planks;
    }

    public void setPlanks(int planks) {
        this.planks = planks;
    }

    public int getDiveBombers() {
        return diveBombers;
    }

    public void setDiveBombers(int diveBombers) {
        this.diveBombers = diveBombers;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }


    public String getOptionsAsString() {
        return options.stream().map(option -> option.getDetails()).collect(Collectors.joining(","));

    }


    @Override
    public String toString() {
        return "Exercise{" +
                "upperBodyPart='" + dateOfWorkout + '\'' +
                ", pushUps=" + pushUps +
                ", pullUps=" + pullUps +
                ", sitUps=" + sitUps +
                ", planks=" + planks +
                ", diveBombers=" + diveBombers +
                ", sets=" + sets +
                ", reps=" + reps +
                ", weight=" + weight +
                ", duration=" + duration +
                ", distance=" + distance +
                '}';
    }
}
