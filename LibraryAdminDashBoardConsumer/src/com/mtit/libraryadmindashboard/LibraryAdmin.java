package com.mtit.libraryadmindashboard;

import java.util.List;

import com.mtit.resourcepublisher.Resource;

public interface LibraryAdmin {

	

	void mainMenu();

	void categoryMenu(String category);

	void displayResources(List<Resource> resources, String category);

	void editResource(String category);

	void addResource(String category);

	void deleteResource(String category);


	void searchByName();

	void searchById(String category);

	void displayResources(List<Resource> resources);

}
