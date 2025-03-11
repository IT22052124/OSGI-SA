package exampublisher;

public class Exam {
    private int examId;
    private int courseId;
    private String examName;
    private String examDescription;

    public Exam(int examId, int courseId, String examName, String examDescription) {
        this.examId = examId;
        this.courseId = courseId;
        this.examName = examName;
        this.examDescription = examDescription;
    }

    public int getExamId() {
        return examId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getExamName() {
        return examName;
    }

    public String getExamDescription() {
        return examDescription;
    }

    @Override
    public String toString() {
        return "Exam ID: " + examId + 
               "\nCourse ID: " + courseId + 
               "\nExam Name: " + examName + 
               "\nDescription: " + examDescription;
    }
}