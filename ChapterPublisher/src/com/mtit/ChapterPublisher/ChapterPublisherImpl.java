package com.mtit.ChapterPublisher;

import java.util.HashMap;

public class ChapterPublisherImpl implements ChapterPublisher {

    private HashMap<Integer, Chapter> chapters = new HashMap<>();

    public ChapterPublisherImpl() {
        // Adding some sample chapters for testing purposes
        addChapter(1, 1, "OSGi Basics", "Understanding the basics of OSGi Framework.");
        addChapter(1, 2, "OSGi Bundles", "Learning about OSGi Bundles and their lifecycle.");
        addChapter(2, 1, "Service Architecture", "Overview of OSGi Service Architecture.");
        addChapter(2, 2, "Service Registration", "Implementing and registering OSGi services.");
    }

    @Override
    public void addChapter(int lectureId, int chapterId, String chapterName, String chapterSummary) {
        Chapter chapter = new Chapter(lectureId, chapterId, chapterName, chapterSummary);
        chapters.put(chapterId, chapter);
        System.out.println("Chapter added successfully: " + chapterName);
    }

    @Override
    public Chapter getChapterById(int chapterId) {
        return chapters.get(chapterId);
    }

    @Override
    public HashMap<Integer, Chapter> getAllChapters() {
        return chapters;
    }
}