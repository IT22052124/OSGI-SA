package com.mtit.resourcepublisher;

// Importing required libraries
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

// LibraryProducerActivator class to register
public class LibraryProducerActivator implements BundleActivator {

    // Service registration
    private ServiceRegistration<?> serviceRegistration;

    // Start the bundle
    public void start(BundleContext Context) throws Exception {

        System.out.println("Library Resource Publisher Started"); // Print a message
        LibraryService service = new LibraryServiceImpl();	// Create a new LibraryServiceImpl object
        serviceRegistration = Context.registerService(LibraryService.class.getName(), service, null);	// Register the service
    }

    // Stop the bundle
    public void stop(BundleContext Context) throws Exception {

        System.out.println("Library Resource Publisher Stopping");	// Print a message
        serviceRegistration.unregister();	// Unregister the service

    }

}
