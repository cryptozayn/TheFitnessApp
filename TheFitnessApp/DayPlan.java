package TheFitnessApp;

import java.util.List;

public class DayPlan {
    private String day;
    private List<Exercise> exercises;

    public DayPlan(String day, List<Exercise> exercises) {
        this.day = day;
        this.exercises = exercises;
    }

    public String getDay() {
        return day;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }
}
