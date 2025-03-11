package eventpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class EventActivator implements BundleActivator {

	private ServiceRegistration<?> eventServiceRegistration;

	    public void start(BundleContext context) throws Exception {
	        System.out.println("Event Publisher Started");
	        EventPublisher eventPublisher = new EventPublisherImpl();
	        eventServiceRegistration = context.registerService(EventPublisher.class.getName(), eventPublisher, null);
	    }
	 
	    public void stop(BundleContext context) throws Exception {
	        System.out.println("Event Publisher Stopped");
	        eventServiceRegistration.unregister();
	    }

}
