// Liste für die Command line
//Speichert alle Todos in eine Txt Datei. Aufgaben können im Programm gelöscht werden
//jedoch nicht aus der Txt Datei.


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        String[] singletask;
        ArrayList<String[]> tasks = new ArrayList<String[]>();
        Scanner navigator = new Scanner(System.in);
        int choice; //Menüvariable
        int counter = 0;

        System.out.println("\n\nWelcome to Task List\n\n");
        //Menu



        FileWriter writer = new FileWriter("Tasks.txt");
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
                    System.out.println((i+1) + ") " + tasks.get(i)[0]); //Achtung: Das Array beginnt bei 0, die Liste aber bei 1.
                    System.out.println(tasks.get(i)[1] + "\n");
                }
            }


            //Enter new tasks and write them into a txt-Document
            if (choice == 2) {
                Scanner text = new Scanner(System.in);
                System.out.println("Enter title:");
                String title = text.nextLine();
                System.out.println("Enter description:");
                String description = text.nextLine();
                tasks.add(new String[]{title, description});
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
                    System.out.println((i+1) + ") " + tasks.get(i)[0]); //Achtung: Das Array beginnt bei 0, die Liste aber bei 1.
                    System.out.println(tasks.get(i)[1] + "\n");
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
