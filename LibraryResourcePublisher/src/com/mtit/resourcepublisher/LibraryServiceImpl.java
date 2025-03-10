package com.mtit.resourcepublisher;

// Importing required libraries
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// LibraryServiceImpl class to implement the LibraryService interface
public class LibraryServiceImpl implements LibraryService {

    // List of resources
    private List<Resource> resources = new ArrayList<>();

    // Track the next available ID for new resources
    private int nextId = 6;

    // LibraryServiceImpl constructor
    public LibraryServiceImpl() {

        // Adding some resources to the list
        resources.add(new Resource(1, "Book", "Clean Code", "Dr Smith", "A Handbook of Agile Software Craftsmanship."));
        resources.add(new Resource(2, "Book", "Design Patterns", "K Tracy", "Elements of Reusable Object-Oriented Software."));
        resources.add(new Resource(3, "Article", "Microservices Architecture", "Dr Abdul", "Introduction to Microservices."));
        resources.add(new Resource(4, "Article", "Cloud Computing", "Mr Geaorge", "Basics of Cloud and Distributed Systems."));
        resources.add(new Resource(5, "Research Paper", "Machine Learning in Healthcare", "KK Waren", "AI applications in medicine."));
    }

    // Get resources by type
    @Override
    public List<Resource> getResourceByType(String type) {

        return resources.stream()
                .filter(resource -> resource.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    // Get resource by ID
    @Override
    public Resource getResourceById(int id) {

        return resources.stream()
                .filter(resource -> resource.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Search resource by name
    @Override
    public List<Resource> searchResourceByName(String name) {

        return resources.stream()
                .filter(resource -> resource.getTitle().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Borrow resource
    @Override
    public boolean borrowResource(int id, String user, int days) {
        Resource resource = getResourceById(id);
        if (resource != null && !resource.isBorrowed()) {
            resource.borrowResource(user, LocalDate.now().plusDays(days));
            return true;
        }
        return false;
    }

    // Return resource
    @Override
    public boolean returnResource(int id) {
        Resource resource = getResourceById(id);
        if (resource != null && resource.isBorrowed()) {
            resource.returnResource();
            return true;
        }
        return false;
    }

    // Admin Functions
    // Add resource
    @Override
    public boolean addResource(String type, String title, String author, String description) {
        resources.add(new Resource(nextId++, type, title, author, description));
        return true;
    }

    // Edit resource
    @Override
    public boolean editResource(int id, String title, String description, String type) {
        Resource resource = getResourceById(id);
        if (resource != null) {
            resource.setTitle(title);
            resource.setDescription(description);
            resource.setType(type);
            return true;
        }
        return false;
    }

    // Delete resource
    @Override
    public boolean deleteResource(int id) {
        return resources.removeIf(resource -> resource.getId() == id);
    }

}
