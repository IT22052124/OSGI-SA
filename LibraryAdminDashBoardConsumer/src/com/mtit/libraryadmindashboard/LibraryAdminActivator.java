package com.mtit.libraryadmindashboard;

// Import necessary packages
import com.mtit.resourcepublisher.LibraryService;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

// AdminDashboardActivator class
public class LibraryAdminActivator implements BundleActivator {

    private ServiceReference<?> serviceReference;   // Service reference
    private LibraryAdmin adminDashboard;  // Admin dashboard
    private LibraryService libraryService;

    @Override // Start method
    public void start(BundleContext context) throws Exception {

        System.out.println("Admin Dashboard Started"); // Print message

        serviceReference = context.getServiceReference(LibraryService.class.getName()); // Get service reference

        // If service reference is not null, get the library service and start the admin dashboard
        if (serviceReference != null) {
            libraryService = (LibraryService) context.getService(serviceReference); // Get library service
            adminDashboard = new LibraryAdminImpl(libraryService); // Create admin dashboard
            adminDashboard.mainMenu(); // Start admin dashboard
        } else {
            System.out.println("\n ⚠ Library Service Not Available.\n"); // Print message
        }
    }

    @Override // Stop method
    public void stop(BundleContext context) throws Exception {

        System.out.println("Admin Dashboard Stopped."); // Print message

        // If service reference is not null, release the service
        if (serviceReference != null) {
            context.ungetService(serviceReference);    
        }

    }
}
