package com.mtit.LecturePublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class LectureActivator implements BundleActivator {
    private ServiceRegistration<?> lectureServiceRegistration;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Lecture Publisher Started");
        LecturePublisher lecturePublisher = new LecturePublisherImpl();
        lectureServiceRegistration = context.registerService(LecturePublisher.class.getName(), lecturePublisher, null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Lecture Publisher Stopped");
        lectureServiceRegistration.unregister();
    }
}
