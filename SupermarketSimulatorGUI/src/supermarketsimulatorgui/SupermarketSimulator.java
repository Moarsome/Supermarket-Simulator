/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.util.Scanner;

/**
 * Driver class for the SupermarketSimulator
 *
 * @author kyliec
 */
public class SupermarketSimulator {

    /**
     * Main Method for the SupemarketSimulator
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        FileManager fileManagement = new FileManager();

        User user = createUser(fileManagement);

        Scanner scan = new Scanner(System.in);
        IsleMarker isleManagement = new IsleMarker(user);
        SelectItem itemManagement = new SelectItem(user);

        System.out.println("WELCOME " + user.getName() + "\nYOUR BUDGET IS $" + user.getBudget());

        isleManagement.changeIsle(1);

        while (user.getIsShopping() == true) {

            parseUserCommand(fileManagement, user, scan, isleManagement, itemManagement);
        }

    }

    /**
     * Command parser for main method
     *
     * @author kyliec
     */
    static void parseUserCommand(FileManager fileManagement, User user, Scanner scan, IsleMarker isleManagement, SelectItem itemManagement) {
        String userCommand = scan.nextLine();

        if (userCommand.equalsIgnoreCase("left")) {
            isleManagement.changeIsle(-1);
        } else if (userCommand.equalsIgnoreCase("right")) {
            isleManagement.changeIsle(1);
        } else if (userCommand.equalsIgnoreCase("cart")) {
            System.out.println("Total cost: $" + user.getCart());
            itemManagement.printCartContent();
            pressEnter();
            isleManagement.changeIsle(0);
        } else {
            try {
                int itemSelection = Integer.parseInt(userCommand);
                if (itemSelection != 0) {
                    ItemDatabase item = isleManagement.getItem(itemSelection);

                    if (item != null) {
                        itemManagement.addToCart(isleManagement.getItem(itemSelection));
                    } else {
                        System.out.println("Item does not exist! Please try again.");
                    }

                    pressEnter();
                    isleManagement.changeIsle(0);
                } else {
                    System.out.println("Saving into new file '" + user.getName() + "Inventory'");
                    System.out.println("Previous money: $" + user.getBudget());
                    user.setBudget(user.getBudget() - itemManagement.getTotalCost());
                    System.out.println("Money after deduction: $" + user.getBudget() + "\n");

                    fileManagement.convertToMap(itemManagement.getCartContent(), user);
                    fileManagement.writeToFile(user);

                    if (user.getBudget() < 0.0f) {
                        System.out.println("\nNOTE: You are in overdraft!");
                    }

                    user.setIsShopping(false);

                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number associated with a desired item or use any of the commands above.");
                System.out.print("\n> ");
            }

        }
    }

    /**
     * Prints instructions and checks for user input
     */
    static void pressEnter() {
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    /**
     * Creates user
     *
     * @return user
     */
    static User createUser(FileManager fileManager) {
        User user;

        Scanner scan = new Scanner(System.in);

        System.out.println("Are you an existing user? (yes/no)");
        if (scan.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("What is your name? ");
            String userName = scan.nextLine();

            // Ensure that the file exists, otherwise ask if they want a new file.
            while (fileManager.checkFileExists(userName) == false) {
                System.out.println("File does not exist! Try again or type '0' to create a new user:");
                userName = scan.nextLine();
                if (userName.equals("0")) {
                    return createNewUser(scan);
                }
            }

            user = fileManager.readFromFile(userName);
            System.out.println("How much money would you like to add to your budget? ");
            System.out.print("\n> $");

            try {
                float budget = Float.valueOf(scan.nextLine());
                
                while ((budget + user.getBudget()) > 10000) {
                    System.out.println("Maximum limit reached please enter a lower number.");
                    budget = scan.nextFloat();
                    System.out.println();
                }

                user.addBudget(budget);

                System.out.println("Your new budget is now $" + user.getBudget());
            } catch (NumberFormatException e) {
                System.out.println("Invalid budget input!");

            }
        } else {
            user = createNewUser(scan);
        }
        return user;
    }

    /**
     * Creates a new user (excluding existing)
     *
     * @return user
     */
    
    public static User createNewUser(Scanner scan) {
        User user;

        System.out.println("Enter your name (only alphabetic characters):");
        String name = scan.nextLine();

        while (checkAlpha(name) == false) {
            System.out.println("Alphabetical characters only. Please enter your name again:");
            name = scan.nextLine();
        }

        System.out.print("\nEnter your budget (max $10000):\n$ ");
        float budget = scan.nextFloat();

        while (budget > 10000) {
            System.out.println("Please enter a number below 100000.");
            budget = scan.nextFloat();
            System.out.println();
        }

        System.out.println();
        user = new User(budget, name);
        return user;
    }

    /**
     * Checks if string contains only alphabetic characters
     *
     * @return boolean
     */
    
    public static boolean checkAlpha(String s) {
        s = s.toLowerCase();
        if (s == null) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!(c >= 'a' && c <= 'z')) {
                return false;
            }
        }

        return true;
    }
}
