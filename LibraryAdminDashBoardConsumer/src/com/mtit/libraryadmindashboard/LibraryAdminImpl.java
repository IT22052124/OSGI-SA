package com.mtit.libraryadmindashboard;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.mtit.resourcepublisher.LibraryService;
import com.mtit.resourcepublisher.Resource;

public class LibraryAdminImpl implements LibraryAdmin {
	private LibraryService libraryService; // Library service
	private Scanner scn; // Scanner object
	boolean validChoice = false;

	public LibraryAdminImpl(LibraryService libraryService) {
		this.libraryService = libraryService;
		this.scn = new Scanner(System.in);
	}

	@Override
	public void start() {
		System.out.println("Admin Dashboard Started");
		mainMenu();
	}

	@Override
	public void stop() {
		System.out.println("Admin Dashboard Stopping...");
		scn.close();
	}

	@Override
	public void mainMenu() {
		while (true) {
			System.out.println("\n=====================================");
			System.out.println("           Admin Dashboard           ");
			System.out.println("=====================================");
			System.out.println("1 - Manage Books");
			System.out.println("2 - Manage Articles");
			System.out.println("3 - Manage Research Papers");
			System.out.println("4 - Exit");
			System.out.println("=====================================");

			int choice = getValidIntInput("Enter your choice: ");

			// Switch case for main menu choices
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
				System.out.println("\nExiting Admin Dashboard...");
				return;
			default:
				System.out.println("\nInvalid choice. Try again.");
			}
		}
	}

	@Override
	public void categoryMenu(String category) {
		while (true) {
			System.out.println("\n------------------------------------");
			System.out.println("        " + category + " Management        ");
			System.out.println("-------------------------------------");
			System.out.println("1 - View All " + category + "s");
			System.out.println("2 - Edit a " + category);
			System.out.println("3 - Add a " + category);
			System.out.println("4 - Delete a " + category);
			System.out.println("5 - Search by ID");
			System.out.println("6 - Search by Name");
			System.out.println("7 - Back to Main Menu");
			System.out.println("=====================================");
			System.out.print("Enter your choice: ");

			int choice = scn.nextInt();
			scn.nextLine(); // Consume newline

			// Switch case for category menu choices
			switch (choice) {
			case 1:
				displayResources(libraryService.getResourceByType(category), category);
				break;
			case 2:
				editResource(category);
				break;
			case 3:
				addResource(category);
				break;
			case 4:
				deleteResource(category);
				break;
			case 5:
				searchById(category);
				break;
			case 6:
				searchByName();
				break;
			case 7:
				return; // Go back to main menu
			default:
				System.out.println("\n Invalid choice. Try again.");
			}

			// Prompt user to press any key to go back
			System.out.println("\nPress Enter to go back");
			scn.nextLine(); // Wait for user input to continue
		}
	}

	@Override
	public void editResource(String category) {
		System.out.println("\n------------------------------------");
		System.out.println("        Edit " + category + " Details        ");
		System.out.println("------------------------------------");
		System.out.print("Enter ID of the " + category + " to edit: ");
		int id = scn.nextInt();
		scn.nextLine(); // Consume newline

		Resource resource = libraryService.getResourceById(id); // Get resource by ID

		// If resource is not null, get new title and description and edit the resource
		if (resource != null) {
			System.out.print("Enter New Title: ");
			String newTitle = scn.nextLine();
			System.out.print("Enter New Description: ");
			String newDescription = scn.nextLine();

			boolean success = libraryService.editResource(id, newTitle, newDescription, category); // Edit resource
			System.out.println(success ? "\n" + category + " updated successfully!" : "\nUpdate failed. Check the ID."); // Print
																															// success
																															// message
		} else {
			System.out.println("\n " + category + " not found.");
		}

		
	}

	@Override
	public void addResource(String category) {
		System.out.println("\n------------------------------------");
		System.out.println("         Add New " + category + "         ");
		System.out.println("------------------------------------");
		System.out.print("Enter Title: ");
		String title = scn.nextLine();
		System.out.print("Enter Author Name: ");
		String author = scn.nextLine();
		System.out.print("Enter Description: ");
		String description = scn.nextLine();

		boolean success = libraryService.addResource(category, title, author, description); // Add resource
		System.out.println(success ? "\n" + category + " added successfully!" : "\nFailed to add " + category + "."); // Print
																														// success
																														// message

		
	}

	@Override
	public void displayResources(List<Resource> resources, String category) {
		System.out.println("\n------------------------------------");
		System.out.println("       Available " + category + "s        ");
		System.out.println("------------------------------------\n");

		if (resources.isEmpty()) {
			System.out.println("\n No " + category.toLowerCase() + "s found.\n");
		} else {
			for (Resource resource : resources) {
				System.out.println(resource);
			}
		}
		System.out.println("=====================================");

		
	}

	@Override
	public void deleteResource(String category) {
		System.out.println("\n------------------------------------");
		System.out.println("        Delete " + category + "        ");
		System.out.println("------------------------------------");
		System.out.print("Enter ID of the " + category + " to delete: ");
		int id = scn.nextInt();
		scn.nextLine(); // Consume newline

		Resource resource = libraryService.getResourceById(id); // Get resource by ID

		// If resource is found, proceed with deletion
		if (resource != null) {
			boolean success = libraryService.deleteResource(id); // Call delete method on service
			System.out.println(
					success ? "\n" + category + " deleted successfully!" : "\n Deletion failed. Check the ID."); // Print
																													// success
																													// message
		} else {
			System.out.println("\n " + category + " not found.");
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

	}

	@Override
	public void searchByName() {
		System.out.print("Enter Name: ");
		String name = scn.nextLine();

		displayResources(libraryService.searchResourceByName(name));

	}

	private int getValidIntInput(String prompt) {
		while (true) {
			System.out.print(prompt);
			if (scn.hasNextInt()) {
				int input = scn.nextInt();
				scn.nextLine(); // Consume newline
				return input;
			} else {
				System.out.println("\nInvalid input. Please enter a number.");
				scn.next(); // Clear invalid input
			}
		}
	}
}