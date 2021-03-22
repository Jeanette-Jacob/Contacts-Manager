package util;

import java.util.Scanner;

public class Input {

    private Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public String getString(){
        return scanner.nextLine();
    }

    public boolean yesNo(){
        String input = scanner.next();
        return input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes");
    }

    public int getInt() {
        try {
            return Integer.parseInt(getString());
        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
            System.out.println("Please enter a valid Integer");
        }
        return getInt();
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

    public int getInt(int min , int max){
        int userInt = getInt();
        if (userInt >= min && userInt <= max){
            return userInt;
        }else {
            System.out.println("Out of range. Please enter a number between " + min +" " + max);
            return getInt(min, max);
        }
    }

    public double getDouble() throws NumberFormatException {
        try {
            return Double.parseDouble(getString());
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
            System.out.println("Please enter a valid Double");

        }
        return getDouble();
    }

    public double getDouble(double min , double max){
        double userDouble = getDouble();
        if (userDouble >= min && userDouble <= max){
            return userDouble;
        }else {
            System.out.println("Out of range. Please enter a number between " + min +" " + max);
            return getDouble(min, max);
        }
    }


    public static void main(String[] args) {
        Input input = new Input();
        System.out.println("enter a number between 1.5 and 3.5");
        double userInt = input.getDouble(1.5,3.5);
        System.out.println("You entered: " + userInt);

    }


}