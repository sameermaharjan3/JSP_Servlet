package app;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Quiz {

    private static int correctAnswersCount = 0;
    private static int currentQuestion = 0;
    private static int numOfQuestion = 5;
    public final String[] questions = {"[3, 1, 4, 1, 5, ? ]","[1, 2, 3, 4, 5, ?]","[1, 3, 5, 7, 9, ?]","[1, 1, 2, 3, 5, ?]","[2, 7, 1, 8, 2, ?]"};
    public final String[] answers = {"9","6","11","8","8"};

    // Getter and setter for number of correct answers variable
    public int getNumCorrect(){return correctAnswersCount;}
    public void setNumCorrect(int num){correctAnswersCount = num;}

    // Getter and setter for number of question
    public int getNumQuestions(){return numOfQuestion;}
    public void setNumQuestions(int num){numOfQuestion = num;}

    //ScoreAnswer function score the currect answers and increase current question index
    public void scoreAnswer(){
        correctAnswersCount++;
        currentQuestion++;
    }

    //Getter and setter for current question index
    public int getCurrentQuestionIndex(){return currentQuestion;}
    public void setCurrentQuestionIndex(int index){currentQuestion = index;}

    //Function to check if the given answer is correct
    public boolean isCorrect(String ans){

        // Compare the current question index with answers' index
        if(this.getCurrentQuestionIndex() == 0 && ans.equals(answers[0])){return true;}
        else if(this.getCurrentQuestionIndex() == 1 && ans.equals(answers[1])){return true;}
        else if(this.getCurrentQuestionIndex() == 2 && ans.equals(answers[2])){return true;}
        else if(this.getCurrentQuestionIndex() == 3 && ans.equals(answers[3])){return true;}
        else if(this.getCurrentQuestionIndex() == 4 && ans.equals(answers[4])){return true;}
        else{return false;}
    }

    //Getter and setter for questions
    public String getCurrentQuestion() { return questions[this.getCurrentQuestionIndex()]; }
    public void setCurrentQuestion(String question){questions[this.getCurrentQuestionIndex()] = question;}

}
