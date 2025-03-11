package com.mtit.StudentCourseConsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.LecturePublisher.LecturePublisher;
import com.mtit.ChapterPublisher.ChapterPublisher;

public class StudentDashboardActivator implements BundleActivator {
    private ServiceReference<?> lectureServiceRef;
    private ServiceReference<?> chapterServiceRef;

    public void start(BundleContext context) throws Exception {
        System.out.println("Student Dashboard Started");

        // Get service references from producer bundles
        lectureServiceRef = context.getServiceReference(LecturePublisher.class.getName());
        chapterServiceRef = context.getServiceReference(ChapterPublisher.class.getName());

        LecturePublisher lecturePublisher = (LecturePublisher) context.getService(lectureServiceRef);
        ChapterPublisher chapterPublisher = (ChapterPublisher) context.getService(chapterServiceRef);

        // Initialize Student Dashboard
        StudentDashboard studentDashboard = new StudentDashboardImpl();
        studentDashboard.getServices(lecturePublisher, chapterPublisher);
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Student Dashboard Stopped");
        context.ungetService(lectureServiceRef);
        context.ungetService(chapterServiceRef);
    }
}