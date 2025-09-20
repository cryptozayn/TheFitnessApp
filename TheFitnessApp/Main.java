package TheFitnessApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;

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

        boolean doorgaan = true;
        while (doorgaan) {
            System.out.print("Voer oefening in: ");
            String oefening = scanner.nextLine();

            System.out.print("Voer gewicht in (kg): ");
            double gewicht = Double.parseDouble(scanner.nextLine());

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

        scanner.close();

        System.out.println("Alle PR's van " + user.getName() + ":");
        for (PR pr : user.getPrs()) {
            System.out.println(pr);
        }
    }
}