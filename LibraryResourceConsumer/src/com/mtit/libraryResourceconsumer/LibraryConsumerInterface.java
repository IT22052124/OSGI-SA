package com.mtit.libraryResourceconsumer;

import java.util.List;

import com.mtit.resourcepublisher.Resource;

public interface LibraryConsumerInterface {
	void mainMenu();

	void categoryMenu(String category);

	void displayResources(List<Resource> resources);

	void searchById(String category);

	void searchByName();

	void borrowResource(String category);

	void returnResource();
}
