package com.mtit.libraryResourceconsumer;

import com.mtit.resourcepublisher.LibraryService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

    private ServiceReference<?> serviceReference;
    private LibraryService libraryService;
    private LibraryConsumerInterface libraryConsumer;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Library Consumer Started");

        // Getting the service reference
        serviceReference = context.getServiceReference(LibraryService.class.getName());

        if (serviceReference != null) {
            libraryService = (LibraryService) context.getService(serviceReference);
            libraryConsumer = new LibraryConsumerImpl(libraryService);
            libraryConsumer.mainMenu();
        } else {
            System.out.println("⚠ Library Service Not Available.");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Library Consumer Stopping");

        if (serviceReference != null) {
            context.ungetService(serviceReference);
        }
    }
}
