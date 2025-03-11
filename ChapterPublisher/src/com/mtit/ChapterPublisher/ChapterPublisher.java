package com.mtit.ChapterPublisher;


import java.util.HashMap;

public interface ChapterPublisher {
    void addChapter(int lectureId, int chapterId, String chapterName, String chapterSummary);
    Chapter getChapterById(int chapterId);
    HashMap<Integer, Chapter> getAllChapters();  // method to retrieve all chapters
}