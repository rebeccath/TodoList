//Experiment zum testen von

import java.util.InputMismatchException;
import java.util.Scanner;

public class exp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;

        while(true) {
            System.out.println("1. Bitte geben SSie eine zahl ein.");
            try {
                System.out.println("2. Bitte geben Sie eine Zahl ein.");
                num = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("FEHLER");
                scanner.nextLine();
            }
        }
    }
}
