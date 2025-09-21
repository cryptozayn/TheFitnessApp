package TheFitnessApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("WelcomeToTheFitnessApp");

        List<User> users = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Voer je naam in: ");
        String naam = scanner.nextLine();
        System.out.print("Voer je e-mail in: ");
        String email = scanner.nextLine();

        User user = new User(naam, email);
        users.add(user);

        List<Exercise> oefeningen = new ArrayList<>();
        oefeningen.add(new Exercise("Squat", "Ga door je knieën en kom weer omhoog."));
        oefeningen.add(new Exercise("Push-up", "Duw jezelf op vanaf de grond."));
        oefeningen.add(new Exercise("Deadlift", "Til het gewicht van de grond naar je heupen."));
        oefeningen.add(new Exercise("Bench Press", "Duw het gewicht omhoog vanaf je borst."));
        oefeningen.add(new Exercise("Pull-up", "Trek jezelf omhoog aan een stang."));
        oefeningen.add(new Exercise("Plank", "Houd je lichaam recht en stevig."));      
        oefeningen.add(new Exercise("Lunges", "Stap naar voren en buig beide knieën."));
        oefeningen.add(new Exercise("Bicep Curl", "Buig je armen met gewichten."));
        oefeningen.add(new Exercise("Tricep Dip", "Daal af met je armen achter je."));
        oefeningen.add(new Exercise("Shoulder Press", "Duw gewichten boven je hoofd."));    
        oefeningen.add(new Exercise("Leg Press", "Duw met je benen tegen een platform."));  
        // Voeg meer oefeningen toe

        System.out.println("Beschikbare oefeningen:");
        for (Exercise ex : oefeningen) {
            System.out.println("- " + ex.getName() + ": " + ex.getDescription());
        }

        boolean doorgaan = true;
        while (doorgaan) {
            System.out.print("Voer oefening in: ");
            String oefening = scanner.nextLine();

            System.out.print("Voer gewicht in (kg): ");
            double gewicht = Double.parseDouble(scanner.nextLine());
            System.out.print("Voer je lengte in (meter): ");
            double lengte = Double.parseDouble(scanner.nextLine());
            double bmi = calculateBMI(gewicht, lengte);
            System.out.println("Jouw BMI is: " + bmi);

            System.out.print("Voer aantal herhalingen in: ");
            int herhalingen = Integer.parseInt(scanner.nextLine());

            PR pr = new PR(oefening, gewicht, herhalingen, LocalDateTime.now());
            user.GetPrs(pr);

            System.out.print("Wil je nog een PR toevoegen? (ja/nee): ");
            String antwoord = scanner.nextLine();
            if (!antwoord.equalsIgnoreCase("ja")) {
                doorgaan = false;
            }
        }

        System.out.print("Voor welke dag wil je een schema maken? ");
        String dag = scanner.nextLine();

        System.out.println("Kies oefeningen voor " + dag + " (typ 'klaar' om te stoppen):");
        List<Exercise> dagOefeningen = new ArrayList<>();
        while (true) {
            System.out.print("Oefening naam: ");
            String oefNaam = scanner.nextLine();
            if (oefNaam.equalsIgnoreCase("klaar")) break;
            // Zoek oefening in de library
            Exercise gekozen = null;
            for (Exercise ex : oefeningen) {
                if (ex.getName().equalsIgnoreCase(oefNaam)) {
                    gekozen = ex;
                    break;
                }
            }
            if (gekozen != null) {
                dagOefeningen.add(gekozen);
                System.out.println("Toegevoegd!");
            } else {
                System.out.println("Oefening niet gevonden.");
            }
        }
        System.out.println("Jouw schema voor " + dag + ":");
        for (Exercise ex : dagOefeningen) {
            System.out.println("- " + ex.getName());
        }

        scanner.close();

        System.out.println("Alle PR's van " + user.getName() + ":");
        for (PR pr : user.getPrs()) {
            System.out.println(pr);
        }

        System.out.println("Vandaag is: " + LocalDate.now());
    }

    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }
}

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
# TheFitnessApp
A fitness app where you can track your data

package TheFitnessApp;

import java.util.ArrayList;
import java.util.List;


public class User {
    private String name;
    private String email;
    private List<PR> prs;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.prs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<PR> getPrs() {
        return prs;
    }

    public void GetPrs(PR pr) {
        prs.add(pr);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", prs=" + prs +
                '}';
    }
}// End of User class  
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
package TheFitnessApp;

public class Exercise {
    private String name;
    private String description;

    public Exercise(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
