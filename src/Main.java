// Liste für die Command line
//Speichert alle Todos in eine Txt Datei. Aufgaben können im Programm gelöscht werden
//jedoch nicht aus der Txt Datei.


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Task> tasks = new ArrayList<Task>();
        Scanner navigator = new Scanner(System.in);
        int choice; //Menüvariable
        int counter = 0;

        BufferedReader reader = new BufferedReader(new FileReader("Tasks.txt"));
        System.out.println("\n\nWelcome to Task List\n\n");
        tasks.add(new Task(reader.readLine(),"test"));
        reader.close();

        FileWriter writer = new FileWriter("Tasks.txt");




        //Vorherige Tasks einlesen!!!!!

        System.out.println("Bisherige Tasks eingelesen.\n\n");

        //Menu
        while (true) {
        counter++;

            do {
                System.out.println("view current Tasks (1)");
                System.out.println("add new Task (2)");
                System.out.println("exit(3)");
                System.out.println("finish Tasks (4)\n");
                try {
                    choice = navigator.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Bitte gib eine Zahl ein.");
                    choice = 0;
                    navigator.nextLine();
                }
            }
            while (choice != 1 && choice != 2 && choice != 3 && choice != 4);

            //View Tasks
            if (choice == 1) {
                System.out.println("Tasks:\n");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i+1) + ") " + tasks.get(i).title); //Achtung: Das Array beginnt bei 0, die Liste aber bei 1.
                    System.out.println(tasks.get(i).description + "\n");
                }
            }


            //Enter new tasks and write them into a txt-Document
            if (choice == 2) {
                Scanner text = new Scanner(System.in);
                System.out.println("Enter title:");
                String title = text.nextLine();
                System.out.println("Enter description:");
                String description = text.nextLine();
                tasks.add(new Task(title, description));
                try {
                    writer.append(title);
                    writer.append(",");
                    writer.append(description);
                    writer.append("\n");
                } catch (IOException e) {
                    System.out.println("Fehler beim schreiben der Datei.");
                }
            }


            //exit
            if (choice == 3) {
                break;
            }


            //Tasks als erledigt markieren. Erledigte Tasks werden gelöscht.
            if (choice == 4) {
                System.out.println("Welche Task möchtest du als erledigt markieren? (1,2,3,...");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i+1) + ") " + tasks.get(i).title + "\n");
                    System.out.println(tasks.get(i).description);
                }

                Scanner choosetask = new Scanner(System.in);
                int numtask = choosetask.nextInt();
                tasks.remove((numtask-1));
                System.out.println("Task " + numtask + " wurde erfolgreich als erledigt.\n");
            }
        }
        writer.close();
    }
}
