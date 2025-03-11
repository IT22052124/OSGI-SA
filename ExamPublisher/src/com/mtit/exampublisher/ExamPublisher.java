package exampublisher;

import java.util.List;

public interface ExamPublisher {
    List<Exam> getExamsByCourseId(int courseId);
    Exam getExamById(int examId);
    void addExam(Exam exam);
}