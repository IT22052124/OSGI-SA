package com.mtit.libraryadmindashboard;

// Import necessary packages
import java.util.List;
import com.mtit.resourcepublisher.Resource;

// LibraryAdmin interface
public interface LibraryAdmin {

    void mainMenu(); // Main menu

    void categoryMenu(String category); // Category menu

    void displayResources(List<Resource> resources, String category); // Display resources

    void editResource(String category); // Edit resource

    void addResource(String category); // Add resource

    void deleteResource(String category); // Delete resource

    void searchByName(); // Search by name

    void searchById(String category); // Search by ID

    void displayResources(List<Resource> resources); // Display resources

}
