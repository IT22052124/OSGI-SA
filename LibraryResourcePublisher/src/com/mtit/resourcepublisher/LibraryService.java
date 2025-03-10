package com.mtit.resourcepublisher;

import java.util.List;

// LibraryService interface to define the library functionalities
public interface LibraryService {

	// User functionalities
    List<Resource> getResourceByType(String type);

	// List all resources by Id
    Resource getResourceById(int id);

	// List all resources by name
    List<Resource> searchResourceByName(String name);

	// List all resources borrowed
    boolean borrowResource(int id, String user, int days); // NEW - Borrow

	// List all resources returned
    boolean returnResource(int id); // NEW - Return

    // Admin functionalities
    boolean addResource(String type, String title, String author, String description);

	// Edit resource
    boolean editResource(int id, String title, String description, String type);

	// Delete resource
    boolean deleteResource(int id);

}
