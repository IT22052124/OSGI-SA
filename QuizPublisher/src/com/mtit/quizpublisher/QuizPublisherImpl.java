package quizpublisher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import exampublisher.ExamPublisher;

public class QuizPublisherImpl implements QuizPublisher {
    private List<Quiz> quizzes = new ArrayList<>();
    private ExamPublisher examPublisher;

    public QuizPublisherImpl(ExamPublisher examPublisher) {
        this.examPublisher = examPublisher;

        // Pre-populate with some quizzes
        quizzes.add(new Quiz(1, 1, "OSGi Basics Quiz", "What is OSGi?"));
        quizzes.add(new Quiz(2, 1, "Bundle Lifecycle Quiz", "Explain Bundle Lifecycle in OSGi"));
        quizzes.add(new Quiz(3, 2, "Modular Design Quiz", "What is modular programming?"));
    }

    @Override
    public List<Quiz> getQuizzesByExamId(int examId) {
        return quizzes.stream()
                .filter(quiz -> quiz.getExamId() == examId)
                .collect(Collectors.toList());
    }

    @Override
    public Quiz getQuizById(int quizId) {
        return quizzes.stream()
                .filter(quiz -> quiz.getQuizId() == quizId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addQuiz(Quiz quiz) {
        // Check if the exam ID exists
        if (examPublisher.getExamById(quiz.getExamId()) == null) {
            System.out.println("Error: Exam with ID " + quiz.getExamId() + " does not exist.");
            return;
        }

        // Check if a quiz with the same ID already exists for this exam
        boolean quizExists = quizzes.stream()
                .anyMatch(q -> q.getExamId() == quiz.getExamId() && q.getQuizId() == quiz.getQuizId());

        if (quizExists) {
            System.out.println("Error: Quiz with ID " + quiz.getQuizId() + " already exists for Exam ID " + quiz.getExamId() + ".");
            return;
        }

        quizzes.add(quiz);
        System.out.println("Quiz added: " + quiz.getQuizName());
    }
}