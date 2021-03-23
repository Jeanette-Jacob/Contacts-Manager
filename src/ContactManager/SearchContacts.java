package ContactManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class SearchContacts {

    static void searchContacts() {

    }

    public static void main(String[] args) throws FileNotFoundException {
        searchContacts();

        Scanner userInput = new Scanner(System.in);
            System.out.print("Enter a name to search for:");
            String name = userInput.next();

            File file = new File("/Users/jacob.k.valeriano/IdeaProjects/Contacts-Manager/src/contacts.txt");
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
    }


