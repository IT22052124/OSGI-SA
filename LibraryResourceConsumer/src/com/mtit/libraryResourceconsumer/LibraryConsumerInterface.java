package com.mtit.libraryResourceconsumer;

// import neccessary packages
import java.util.List;
import com.mtit.resourcepublisher.Resource;

// LibraryConsumerInterface interface
public interface LibraryConsumerInterface {

    // mainMenu method
    void mainMenu();

    // categoryMenu method
    void categoryMenu(String category);

    // displayResources method	
    void displayResources(List<Resource> resources);

	// searchById method
    void searchById(String category);

	// searchByName method
    void searchByName();

	// borrowResource method
    void borrowResource(String category);

	// returnResource method
	void returnResource();
}
