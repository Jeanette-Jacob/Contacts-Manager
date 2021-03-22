package ContactManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ShowContacts {
    public static List<String> showContacts() {
        Path txtPath = Paths.get("src", "contacts.txt");
        List<String> contactList = new ArrayList<>();
        try {
            contactList = Files.readAllLines(txtPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String name : contactList)
            System.out.println(name);
        return contactList;
    }





}
