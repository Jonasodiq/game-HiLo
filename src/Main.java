// 9 sep 2024 Jonas N Uppgift-5 Game-HiLo

import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {  // continue as long as playAgain is true
            System.out.println("Välkommen till spelet HiLo!");
            System.out.println("Välj svårighetsgrad:\n 1 = Lätt   (1-10)\n 2 = Medel (1-100)\n 3 = Svår (1-1000)");

            int degree;
            while (true) { // Check valid input for severity
                if (scanner.hasNextInt()) {
                    degree = scanner.nextInt();
                    if (degree >= 1 && degree <= 3) { // digit (1, 2 or 3)
                        break; // If the input is valid, the loop breaks.
                    } else {
                        System.out.println("Vänligen välj en giltig svårighetsgrad (1, 2 eller 3).");
                    }
                } else {
                    System.out.println("Felaktig inmatning. Vänligen ange en siffra.");
                    scanner.next(); // Clear incorrect input
                }
            }
            // Set maximum guess limit based on difficulty
            int maxNumber;
            switch (degree) {
                case 1:
                    maxNumber = 10;
                    break;
                case 2:
                    maxNumber = 100;
                    break;
                case 3:
                    maxNumber = 1000;
                    break;
                default:
                    return;
            }
            // Generate a random number
            int correctNumber = random.nextInt(maxNumber) + 1; // is generated as a random number between 1 and maxNumber.
            int attempts = 0;  // count how many attempts the user has made.
            int guess = 0;  // user's current guess.

            // Guess loop
            while (guess != correctNumber) { // while loop runs until the user guesses the correct number.
                System.out.println("Gissa ett tal mellan 1 och " + maxNumber + ":");

                while (!scanner.hasNextInt()) { // input until an integer
                    System.out.println("Felaktig inmatning. Vänligen ange ett giltigt tal.");
                    scanner.next(); // Clear incorrect input
                }
                guess = scanner.nextInt();
                attempts++;

                if (guess > correctNumber) {
                    System.out.println("För högt!");
                } else if (guess < correctNumber) {
                    System.out.println("För lågt!");
                }
            }
            // Congratulations message when the correct number is guessed
            System.out.println("Grattis! Du gissade rätt tal " + correctNumber + " på " + attempts + " försök.");
            System.out.println("Vill du spela igen? (j/n)");
            // Ask if the player wants to play again
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("j");
        }
        // End the program
        System.out.println("Tack för att du spelade med HiLo!");
        scanner.close();
    }
}