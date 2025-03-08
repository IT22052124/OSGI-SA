package com.mtit.ChapterPublisher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChapterPublisherImpl implements ChapterPublisher {
    private List<Chapter> chapters = new ArrayList<>();

    public ChapterPublisherImpl() {
        chapters.add(new Chapter(1, 1, "OSGi Basics", "Introduction to OSGi framework."));
        chapters.add(new Chapter(2, 1, "Bundle Lifecycle", "Understanding OSGi bundle lifecycle."));
        chapters.add(new Chapter(3, 2, "Modular Design", "How to design modular applications."));
        chapters.add(new Chapter(4, 3, "Service Components", "Creating and using OSGi services."));
    }

    @Override
    public List<Chapter> getChaptersByLectureId(int lectureId) {
        return chapters.stream()
                .filter(chapter -> chapter.getLectureId() == lectureId)
                .collect(Collectors.toList());
    }

    @Override
    public Chapter getChapterById(int chapterId) {
        return chapters.stream()
                .filter(chapter -> chapter.getChapterId() == chapterId)
                .findFirst()
                .orElse(null);
    }
}