package ContactManager;

import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class AddContacts extends Contact {


    public AddContacts(String firstName, String lastName, Integer phoneNumber) {
        super(firstName, lastName, phoneNumber);
    }

public static List<String> addToContacts() {
    Input input = new Input();
    System.out.print("Pleas enter your first name: ");
    var firstName = input.getString();
    System.out.print("Please Enter your last name: ");
    var lastName = input.getString();
    System.out.print("Please Enter Phone Number: ");
    var phoneNumber = input.getString();
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


    public static void main(String[] args) {
        System.out.println(addToContacts());
    }




}
