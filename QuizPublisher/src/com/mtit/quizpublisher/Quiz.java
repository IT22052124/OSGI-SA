package quizpublisher;

public class Quiz {
    private int quizId;
    private int examId;
    private String quizName;
    private String quizQuestions;

    public Quiz(int quizId, int examId, String quizName, String quizQuestions) {
        this.quizId = quizId;
        this.examId = examId;
        this.quizName = quizName;
        this.quizQuestions = quizQuestions;
    }

    public int getQuizId() {
        return quizId;
    }

    public int getExamId() {
        return examId;
    }

    public String getQuizName() {
        return quizName;
    }

    public String getQuizQuestions() {
        return quizQuestions;
    }

    @Override
    public String toString() {
        return "Quiz ID: " + quizId + 
               "\nExam ID: " + examId + 
               "\nQuiz Name: " + quizName + 
               "\nQuestions: " + quizQuestions;
    }
}