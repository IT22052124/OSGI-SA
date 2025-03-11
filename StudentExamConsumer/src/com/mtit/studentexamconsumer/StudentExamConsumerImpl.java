package studentexamconsumer;

import exampublisher.Exam;
import quizpublisher.Quiz;

public class StudentExamConsumerImpl implements StudentExamConsumer {

    @Override
    public void takeExamAndQuiz(Exam exam, Quiz quiz) {
        System.out.println("\n=== Student Taking Exam and Quiz ===");
        System.out.println("Exam ID: " + exam.getExamId());
        System.out.println("Exam Name: " + exam.getExamName());
        System.out.println("Exam Description: " + exam.getExamDescription());
        System.out.println("Quiz ID: " + quiz.getQuizId());
        System.out.println("Quiz Name: " + quiz.getQuizName());
        System.out.println("Quiz Questions: " + quiz.getQuizQuestions());
        System.out.println("Status: Student is taking Exam " + exam.getExamId() + 
                           " and Quiz " + quiz.getQuizId());
    }
}