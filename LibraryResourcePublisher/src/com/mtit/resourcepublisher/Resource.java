package com.mtit.resourcepublisher;

import java.time.LocalDate;

// Resource class to represent a resource
public class Resource {

    // Resource attributes

    private int id; // Resource ID
    private String type; // Resource type
    private String title; // Resource title
    private String author; // Resource author
    private String description; // Resource description
    private boolean isBorrowed; //Track borrowing status
    private String borrowedBy; // User who borrowed
    private LocalDate dueDate; // Due date for return

	// Resource constructor
    public Resource(int id, String type, String title, String author, String Description) {

        this.id = id;
        this.type = type;
        this.title = title;
        this.description = Description;
        this.isBorrowed = false;
        this.borrowedBy = null;
        this.dueDate = null;
        this.author = author;
    }
	

	// Getters and Setters

    public int getId() {
        return id;
    }
    public String getType() {
        return type;
    } 

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public String getBorrowedBy() {
        return borrowedBy;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

	// NEW - Update resource details
    public void setTitle(String title2) {

        title = title2;

    }

    public void setAuthor(String autor) {

        author = autor;

    }

    public void setDescription(String description2) {
        description = description2;
    }

    public void setType(String type2) {
        type = type2;
    }

	// Borrow and return resource methods
    public void borrowResource(String user, LocalDate dueDate) {
        this.isBorrowed = true;
        this.borrowedBy = user;
        this.dueDate = dueDate;
    }

	// NEW - Return resource method
    public void returnResource() {
        this.isBorrowed = false;
        this.borrowedBy = null;
        this.dueDate = null;
    }

	
    @Override // toString method to display resource details
    public String toString() {

        return "\nID: " + id + "\nType: " + type + "\nTitle: " + title + "\nAuthor: " + author + "\nDescription: " + description + "\nStatus: "
                + (isBorrowed ? "Not Available:Borrowed by " + borrowedBy + ", Due: " + dueDate : "Available")
                ;
    }


}
