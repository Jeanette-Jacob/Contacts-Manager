package ContactManager;

import util.Input;

import java.io.*;

import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ContactUtils extends Contact{
    private static final Path pathToTxt = Paths.get("src", "contacts.txt");
    private static final File file = new File("src", "contacts.txt");
    private static Input userInput = new Input();

    public ContactUtils(String firstName, String lastName, Integer phoneNumber) {
        super(firstName, lastName, phoneNumber);
    }


    public static void searchContacts() throws FileNotFoundException {
        System.out.print("Enter a name to search for: ");
        String name = userInput.getString();
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();

            Scanner lineScanner = new Scanner(line);
            while (lineScanner.hasNext()) {
                String word = lineScanner.next();
                if (name.equalsIgnoreCase(word)) {
                    System.out.println(line);
                    break;
                }
            }
        }
    }

    public static List<String> showContacts() {
        List<String> contactList = new ArrayList<>();
        try {
            contactList = Files.readAllLines(pathToTxt);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String name : contactList)
            System.out.println(name);
        return contactList;
    }

    public static List<String> addToContacts() {
        System.out.print("Pleas enter your first name: ");
        var firstName = userInput.getString();
        System.out.print("Please Enter your last name: ");
        var lastName = userInput.getString();
        System.out.print("Please Enter Phone Number: ");
        var phoneNumber = userInput.getString();
        List<String> addToList = new ArrayList<>();
        addToList.add(firstName + " " + lastName + ", " + phoneNumber);
        Path path = Paths.get("src",  "contacts.txt");
        try{
            Files.write(
                    path,
                    addToList,
                    StandardOpenOption.APPEND
            );
        } catch(IOException e) {
            e.printStackTrace();
        }
        return addToList;

    }

    public static void deleteContact() throws IOException{
        File inputFile = new File(String.valueOf(pathToTxt));
        File tempFile = new File("myTempFile.txt");


        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        String currentLine;
        String lineToRemove;

        System.out.print("Enter the name of the contact you wish to delete: ");
        lineToRemove = userInput.getString();


        while((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if(trimmedLine.startsWith(lineToRemove)) continue;
            System.out.println(trimmedLine);

            writer.write((currentLine) + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        Files.move(tempFile.toPath(), inputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Contact was deleted");
    }




    public static void main(String[] args) {
        try {
            deleteContact();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
