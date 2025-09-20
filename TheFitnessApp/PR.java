package TheFitnessApp;

import java.time.LocalDateTime;

public class PR {
    private String exerciseName;
    private double weight;
    private int repetitions;
    private LocalDateTime dateAchieved;  

    public PR(String exerciseName, double weight, int repetitions, LocalDateTime dateAchieved) {
        this.exerciseName = exerciseName;
        this.weight = weight;
        this.repetitions = repetitions;
        this.dateAchieved = dateAchieved;
    }

    // Getters and setters
    public String getExerciseName() { return exerciseName; }
    public double getWeight() { return weight; }
    public int getRepetitions() { return repetitions; }
    public LocalDateTime getDateAchieved() { return dateAchieved; }

    @Override
    public String toString() {
        return "PR{" +
                "exerciseName='" + exerciseName + '\'' +
                ", weight=" + weight +
                ", repetitions=" + repetitions +
                ", dateAchieved=" + dateAchieved +
                '}';
    }
} // End of PR class