package ContactManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;



class DeleteContacts {
    public static void main(String[] args) throws IOException {

        Scanner removeThis = new Scanner(System.in);

        Path txtPath = Paths.get("src", "contacts.txt");
        File inputFile = new File(String.valueOf(txtPath));
        File tempFile = new File("myTempFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;
        String lineToRemove;

        System.out.println("Enter the name of the contact you wish to delete :");
        lineToRemove = removeThis.next();


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
}
