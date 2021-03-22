package ContactManager;

import util.Input;

import java.util.Scanner;

public class MoviesApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println(returnMenuDisplay());
            int response = promptUserForChoice();
            running = executeUserChoice(response);
        }
    }

    private static String returnMenuDisplay() {
        System.out.println("What would you like to do?");
        String choices =
                "1 - View Contacts\n" +
                "2 - Add a new contact \n" +
                "3 - Search a contact by name.\n" +
                "4 -Delete an existing contact.\n" +
                "5 - Exit";
        return choices;
    }

    private static int promptUserForChoice() {
        Input input = new Input();
        System.out.print("Enter your choice: ");
        int response = input.getInt(0, 5);
        return response;
    }

}