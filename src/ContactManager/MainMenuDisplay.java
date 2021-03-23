package ContactManager;

import util.Input;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainMenuDisplay {


    private static String menuDisplay() {
        return "\nWhat would you like to do?\n"
                + "1 - View Contacts\n"
                + "2 - Add a new contact \n"
                + "3 - Search a contact by name.\n"
                + "4 - Delete an existing contact.\n"
                + "5 - Exit\n";
    }

    private static int promptUserForChoice() {
        Input input = new Input();
        System.out.print("Enter an option: (1, 2, 3, 4, or 5) ");
        return input.getInt(0, 5);
    }

    private static boolean executeMenuChoice(int option) {
        boolean continueRunning = true;
        switch (option) {
            case 1:
                ContactUtils.showContacts();
                break;
            case 2:
                ContactUtils.addToContacts();
                break;
            case 3:
                try {
                    ContactUtils.searchContacts();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    ContactUtils.deleteContact();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 5:
                System.out.println("exit");
                continueRunning = false;
                break;

        }
             return continueRunning;
    }

    public static void printMainMenu() {
        boolean running = true;
        while (running) {
            System.out.println(menuDisplay());

            int response = promptUserForChoice();
            running = executeMenuChoice(response);
        }
    }




}
