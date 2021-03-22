package ContactManager;

import util.Input;

public class MainMenuDisplay {
    public static String menuDisplay() {
        return "What would you like to do?\n"
                + "1 - View Contacts\n"
                + "2 - Add a new contact \n"
                + "3 - Search a contact by name.\n"
                + "4 - Delete an existing contact.\n"
                + "5 - Exit";
    }

    public static int promptUserForChoice() {
        Input input = new Input();
        System.out.print("Enter an option: (1, 2, 3, 4, or 5) ");
        return input.getInt(0, 5);
    }

    public static void printMainMenu() {
//        boolean running = true;
//        while (running) {
//            System.out.println(menuDisplay());
//
//            int response = promptUserForChoice();
//            showContacts();
 //       }
    }




}
