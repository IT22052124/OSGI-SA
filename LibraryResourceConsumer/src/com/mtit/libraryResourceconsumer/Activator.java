package com.mtit.libraryResourceconsumer;

// import neccessary packages
import com.mtit.resourcepublisher.LibraryService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

// Activator class
public class Activator implements BundleActivator {

    // private variables
    private ServiceReference<?> serviceReference;

    // LibraryService variable
    private LibraryService libraryService;

    // LibraryConsumerInterface variable
    private LibraryConsumerInterface libraryConsumer;

    @Override // start method
    public void start(BundleContext context) throws Exception {
        System.out.println("Library Consumer Started");

        // Getting the service reference
        serviceReference = context.getServiceReference(LibraryService.class.getName());

        // Checking if the service reference is not null
        if (serviceReference != null) {
            libraryService = (LibraryService) context.getService(serviceReference);
            libraryConsumer = new LibraryConsumerImpl(libraryService);
            libraryConsumer.mainMenu();
        } else {
            System.out.println("⚠ Library Service Not Available.");
        }
    }

    @Override   // stop method
    public void stop(BundleContext context) throws Exception {
        System.out.println("Library Consumer Stopping");

        if (serviceReference != null) {
            context.ungetService(serviceReference); // Unregister the service
        }
    }
}
