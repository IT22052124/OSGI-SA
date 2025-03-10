package com.mtit.libraryResourceconsumer;

import java.util.List;
import java.util.Scanner;

import com.mtit.resourcepublisher.LibraryService;
import com.mtit.resourcepublisher.Resource;

public class LibraryConsumerImpl implements LibraryConsumerInterface{
	private LibraryService libraryService;
    private Scanner scn;

    public LibraryConsumerImpl(LibraryService libraryService) {
        this.libraryService = libraryService;
        this.scn = new Scanner(System.in);
    }

    @Override
    public void mainMenu() {
        while (true) {
            System.out.println("\n====================================");
            System.out.println("       Welcome To Library           ");
            System.out.println("====================================");
            System.out.println("What are you looking for?");
            System.out.println("1 - Books");
            System.out.println("2 - Articles");
            System.out.println("3 - Research Papers");
            System.out.println("4 - Exit");
            System.out.println("------------------------------------");
            System.out.print("Enter your choice: ");

            int choice = scn.nextInt();
            scn.nextLine(); // Consume newline

            // Switch case for the user choice
            switch (choice) {
                case 1:
                    categoryMenu("Book");
                    break;
                case 2:
                    categoryMenu("Article");
                    break;
                case 3:
                    categoryMenu("Research Paper");
                    break;
                case 4:
                    System.out.println("Exiting Library System...");
                    return;
                default:
                    System.out.println("⚠ Invalid choice. Try again.");
            }
        }
    }

    @Override
    public void categoryMenu(String category) {
        while (true) {
            System.out.println("\n-----------------------------------");
            System.out.println("        " + category + " Section");
            System.out.println("------------------------------------");
            System.out.println("1 - View All " + category);
            System.out.println("2 - Search by ID");
            System.out.println("3 - Search by Name");
            System.out.println("4 - Borrow " + category);
            System.out.println("5 - Return " + category);
            System.out.println("6 - Back to Main Menu");
            System.out.println("------------------------------------");
            System.out.print("Enter your choice: ");

            int choice = scn.nextInt();
            scn.nextLine(); // Consume newline

            // Switch case for the user choice
            switch (choice) {
                case 1:
                    displayResources(libraryService.getResourceByType(category));
                    break;
                case 2:
                    searchById(category);
                    break;
                case 3:
                    searchByName();
                    break;
                case 4:
                    borrowResource(category);
                    break;
                case 5:
                    returnResource();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("⚠ Invalid choice. Try again.");
            }
        }
    }

    @Override
    public void displayResources(List<Resource> resources) {
        System.out.println("");
        System.out.println("Available Resources        ");
        System.out.println("___________________________________");

        if (resources.isEmpty()) {
            System.out.println("⚠ No resources found.");
        } else {
            for (Resource resource : resources) {
                System.out.println(resource);
                System.out.println("------------------------------------");
            }
        }
    }

    @Override
    public void searchById(String category) {
        System.out.print("Enter ID: ");
        int id = scn.nextInt();
        scn.nextLine();

        // Getting the resource by ID
        Resource resourceById = libraryService.getResourceById(id);

        System.out.println("\n------------------------------------");
        if (resourceById == null || !resourceById.getType().equalsIgnoreCase(category)) {
            System.out.println("⚠ Resource not found in " + category + " section.");
        } else {
            System.out.println(resourceById);
        }
        System.out.println("------------------------------------");
        System.out.println("Press Enter to go back.");
        scn.nextLine();
    }

    @Override
    public void searchByName() {
        System.out.print("Enter Name: ");
        String name = scn.nextLine();

        displayResources(libraryService.searchResourceByName(name));

        System.out.println("\nPress Enter to go back.");
        scn.nextLine();
    }

    @Override
    public void borrowResource(String category) {
        System.out.print("Enter Resource ID to borrow: ");
        int borrowId = scn.nextInt();
        scn.nextLine();

        Resource resourceToBorrow = libraryService.getResourceById(borrowId);

        System.out.println("\n------------------------------------");
        if (resourceToBorrow == null || !resourceToBorrow.getType().equalsIgnoreCase(category)) {
            System.out.println("⚠ Resource not found in " + category + " section.");
        } else {
            System.out.print("Enter Your Name: ");
            String user = scn.nextLine();
            System.out.print("Enter Borrow Days: ");
            int days = scn.nextInt();
            scn.nextLine();

            boolean success = libraryService.borrowResource(borrowId, user, days);
            System.out.println(
                    success ? "✅ Successfully Borrowed!" : "❌ Borrowing Failed. Resource may not be available.");
        }
        System.out.println("------------------------------------");
        System.out.println("Press Enter to go back.");
        scn.nextLine();
    }

    @Override
    public void returnResource() {
        System.out.print("Enter Resource ID to return: ");
        int returnId = scn.nextInt();
        scn.nextLine();

        System.out.println("\n------------------------------------");
        boolean success = libraryService.returnResource(returnId);
        System.out.println(success ? "✅ Successfully Returned!" : "❌ Return Failed. Check the ID.");
        System.out.println("------------------------------------");
        System.out.println("Press Enter to go back.");
        scn.nextLine();
    }

	

}
