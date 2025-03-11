package com.mtit.ChapterPublisher;

public class Chapter {
    private int chapterId;
    private int lectureId;
    private String chapterName;
    private String chapterSummary;

    public Chapter(int chapterId, int lectureId, String chapterName, String chapterSummary) {
        this.chapterId = chapterId;
        this.lectureId = lectureId;
        this.chapterName = chapterName;
        this.chapterSummary = chapterSummary;
    }

    public int getChapterId() {
        return chapterId;
    }

    public int getLectureId() {
        return lectureId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public String getChapterSummary() {
        return chapterSummary;
    }

    @Override
    public String toString() {
        return "Chapter ID: " + chapterId + 
               "\nLecture ID: " + lectureId + 
               "\nChapter Name: " + chapterName + 
               "\nSummary: " + chapterSummary;
    }
}