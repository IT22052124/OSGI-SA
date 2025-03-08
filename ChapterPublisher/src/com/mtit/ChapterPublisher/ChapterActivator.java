package com.mtit.ChapterPublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ChapterActivator implements BundleActivator {
    private ServiceRegistration<?> chapterServiceRegistration;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Chapter Publisher Started");
        ChapterPublisher chapterPublisher = new ChapterPublisherImpl();
        chapterServiceRegistration = context.registerService(ChapterPublisher.class.getName(), chapterPublisher, null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Chapter Publisher Stopped");
        chapterServiceRegistration.unregister();
    }
}