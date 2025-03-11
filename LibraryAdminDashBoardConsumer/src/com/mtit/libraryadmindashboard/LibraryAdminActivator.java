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


    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Admin Dashboard Started");

        serviceReference = context.getServiceReference(LibraryService.class.getName()); // Get service reference

        // If service reference is not null, get the library service and start the admin dashboard
        if (serviceReference != null) {
            libraryService = (LibraryService) context.getService(serviceReference);
            adminDashboard = new LibraryAdminImpl(libraryService);
            adminDashboard.mainMenu();
        } else {
            System.out.println("\n ⚠ Library Service Not Available.\n");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Admin Dashboard Stopped.");


        if (serviceReference != null) {
            context.ungetService(serviceReference); // Release service
        }

    }
}