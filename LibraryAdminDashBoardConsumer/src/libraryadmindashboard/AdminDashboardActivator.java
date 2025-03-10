package libraryadmindashboard;

// Import necessary packages
import com.mtit.resourcepublisher.LibraryService;
import com.mtit.resourcepublisher.Resource;

import java.util.List;
import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

// AdminDashboardActivator class
public class AdminDashboardActivator implements BundleActivator {

    private ServiceReference<?> serviceReference;   // Service reference
    private LibraryService libraryService;  // Library service
    private Scanner scn;    // Scanner object

    @Override // Start method
    public void start(BundleContext context) throws Exception {
        System.out.println("Admin Dashboard Started");

        serviceReference = context.getServiceReference(LibraryService.class.getName()); // Get service reference

        // If service reference is not null, get the library service and start the main menu
        if (serviceReference != null) {
            libraryService = (LibraryService) context.getService(serviceReference);
            scn = new Scanner(System.in);
            mainMenu();
        } else {
            System.out.println("\n[ERROR] Library Service Not Available.\n");
        }
    }

    // Main menu method
    private void mainMenu() {
        while (true) {
            System.out.println("\n=====================================");
            System.out.println("           Admin Dashboard           ");
            System.out.println("=====================================");
            System.out.println("1 - Manage Books");
            System.out.println("2 - Manage Articles");
            System.out.println("3 - Manage Research Papers");
            System.out.println("4 - Exit");
            System.out.println("=====================================");
            System.out.print("Enter your choice: ");

            int choice = scn.nextInt();
            scn.nextLine(); // Consume newline

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

    // Category menu method 
    private void categoryMenu(String category) {
        while (true) {
            System.out.println("\n------------------------------------");
            System.out.println("        " + category + " Management        ");
            System.out.println("-------------------------------------");
            System.out.println("1 - View All " + category + "s");
            System.out.println("2 - Edit a " + category);
            System.out.println("3 - Add a " + category);
            System.out.println("4 - Delete a " + category);
            System.out.println("5 - Back to Main Menu");
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
                    return; // Go back to main menu
                default:
                    System.out.println("\n Invalid choice. Try again.");
            }

            // Prompt user to press any key to go back to the category menu
            System.out.println("\nPress any key to go back to " + category + " management...");
            scn.nextLine();  // Wait for user input to continue
        }
    }

    // Edit resource method
    private void editResource(String category) {
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

            boolean success = libraryService.editResource(id, newTitle, newDescription, category);  // Edit resource
            System.out.println(success 
                ? "\n" + category + " updated successfully!" 
                : "\nUpdate failed. Check the ID."); // Print success message
        } else {
            System.out.println("\n " + category + " not found.");
        }

        // Prompt user to press any key to go back
        System.out.println("\nPress any key to go back to " + category + " management...");
        scn.next();  // Wait for user input to continue
    }

    // Add resource method
    private void addResource(String category) {
        System.out.println("\n------------------------------------");
        System.out.println("         Add New " + category + "         ");
        System.out.println("------------------------------------");
        System.out.print("Enter Title: ");
        String title = scn.nextLine();
        System.out.print("Enter Author Name: ");
        String author = scn.nextLine();
        System.out.print("Enter Description: ");
        String description = scn.nextLine();

        boolean success = libraryService.addResource(category, title, author, description);  // Add resource
        System.out.println(success 
            ? "\n" + category + " added successfully!" 
            : "\nFailed to add " + category + "."); // Print success message

        // Prompt user to press any key to go back
        System.out.println("\nPress any key to go back to " + category + " management...");
        scn.next();  // Wait for user input to continue
    }

    // Display resources method
    private void displayResources(List<Resource> resources, String category) {
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

        // Prompt user to press any key to go back
        System.out.println("\nPress any key to go back to " + category + " management...");
        scn.next();  // Wait for user input to continue
    }
    
 // Delete resource method
    private void deleteResource(String category) {
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
            System.out.println(success 
                ? "\n" + category + " deleted successfully!" 
                : "\n Deletion failed. Check the ID."); // Print success message
        } else {
            System.out.println("\n " + category + " not found.");
        }

        // Prompt user to press any key to go back
        System.out.println("\nPress any key to go back to " + category + " management...");
        scn.next();  // Wait for user input to continue
    }

    @Override   // Stop method
    public void stop(BundleContext context) throws Exception {
        System.out.println("Admin Dashboard Stopping...");

        if (serviceReference != null) {
            context.ungetService(serviceReference); // Release service
        }
    }
}
