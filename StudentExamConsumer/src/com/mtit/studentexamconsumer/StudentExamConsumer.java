package studentexamconsumer;

import exampublisher.*;
import quizpublisher.*;

public interface StudentExamConsumer {
    void takeExamAndQuiz(Exam exam, Quiz quiz);
}