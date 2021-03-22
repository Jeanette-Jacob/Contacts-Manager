package util;

import java.util.Scanner;

public class Input {

    private final Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public String getString(){
        return scanner.nextLine();
    }

    public boolean yesNo(){
        String input = scanner.next();
        return input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes");
    }


    public int getInt(int min, int max) {
        int userInput = getInt();
        if(userInput > max || userInput < min) {
            System.out.println("Please Enter number from " + min + " and " + max);
            return getInt(min, max);
        }
        else
            return userInput;
    }

    public int getInt() {
        String input = this.getString();
        try{
            return Integer.valueOf(input);
        } catch (Exception e) {
            return getInt();
        }
    }

    public int getBinary(){
        try {
            return Integer.valueOf(getString());
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
            System.out.println("enter a valid number");
        }
        return getBinary();
    }

}