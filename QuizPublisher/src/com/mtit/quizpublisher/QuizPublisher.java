package quizpublisher;

import java.util.List;

public interface QuizPublisher {
    List<Quiz> getQuizzesByExamId(int examId);
    Quiz getQuizById(int quizId);
    void addQuiz(Quiz quiz);
}