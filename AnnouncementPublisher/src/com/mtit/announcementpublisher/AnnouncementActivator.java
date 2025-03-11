package announcementpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class AnnouncementActivator implements BundleActivator {

	private ServiceRegistration<?> announcementServiceRegistration;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Announcement Publisher Started");
        AnnouncementPublisher announcementPublisher = new AnnouncementPublisherImpl();
        announcementServiceRegistration = context.registerService(AnnouncementPublisher.class.getName(), announcementPublisher, null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Announcement Publisher Stopped");
        announcementServiceRegistration.unregister();
    }

}
