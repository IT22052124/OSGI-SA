package exampublisher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExamPublisherImpl implements ExamPublisher {
    private List<Exam> exams = new ArrayList<>();

    public ExamPublisherImpl() {
        // Pre-populate with some exams
        exams.add(new Exam(1, 1, "OSGi Basics Exam", "Test your knowledge on OSGi Basics"));
        exams.add(new Exam(2, 1, "Bundle Lifecycle Exam", "Test your knowledge on Bundle Lifecycle"));
        exams.add(new Exam(3, 2, "Modular Design Exam", "Test your knowledge on Modular Design"));
    }

    @Override
    public List<Exam> getExamsByCourseId(int courseId) {
        return exams.stream()
                .filter(exam -> exam.getCourseId() == courseId)
                .collect(Collectors.toList());
    }

    @Override
    public Exam getExamById(int examId) {
        return exams.stream()
                .filter(exam -> exam.getExamId() == examId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addExam(Exam exam) {
        if (getExamById(exam.getExamId()) != null) {
            System.out.println("Error: Exam with ID " + exam.getExamId() + " already exists.");
            return;
        }
        exams.add(exam);
        System.out.println("Exam added: " + exam.getExamName());
    }
}