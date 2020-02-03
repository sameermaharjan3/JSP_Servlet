package app;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QuizServlet")
public class QuizServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Maintain session
        HttpSession session = request.getSession();

        // Restore previous instance of quiz using session
        Quiz quiz = (Quiz) session.getAttribute("q");

        try{
            if(!request.getParameter("answer").equals(null)){
                String ans = request.getParameter("answer");
                if(quiz.isCorrect(ans)){
                    quiz.scoreAnswer();
                }
            }

            // If there are no more question, display the quiz over page
            if(quiz.getCurrentQuestionIndex() >= quiz.getNumQuestions()){
                request.getRequestDispatcher("/quizOverPage.jsp").forward(request,response);
            }else {
                /*Redirect to the same page until the quiz is over*/
                RequestDispatcher dispatcher = request.getRequestDispatcher("/myQuiz.jsp");

                /*Set the corresponding question in jsp page*/
                request.setAttribute("question", quiz.getCurrentQuestion());
                dispatcher.forward(request, response);
            }

        }catch(Exception e){
            System.out.println("ERROR");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create a quiz instance
        Quiz quiz = new Quiz();

        // Create a session as soon as user begins quiz
        HttpSession session = request.getSession();

        // Store the quiz object in the session
        session.setAttribute("q",quiz);

        // Set the dispatcher to myQuiz.jsp page and set the first quiz question to begin with
        RequestDispatcher dispatch = request.getRequestDispatcher("/myQuiz.jsp");
        request.setAttribute("question",quiz.getCurrentQuestion());
        dispatch.forward(request, response);

    }


    // Optional method to generate the quiz page using printWriter, but without creating jsp page
    private void genQuizPage(Quiz sessQuiz, PrintWriter out, String currQuest, boolean error, String answer) {

        out.print("<html>");
        out.print("<head>");
        out.print("	<title>NumberQuiz</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("	<form method='post'>");
        out.print("		<h3>Have fun with NumberQuiz!</h3>");
        out.print("<p>Your current score is: ");
        out.print(sessQuiz.getNumCorrect() + "</br></br>");
        out.print("<p>Guess the next number in the sequence! ");
        out.print(currQuest + "</p>");

        out.print("<p>Your answer:<input type='text' name='txtAnswer' value='' /></p> ");

        /* if incorrect, then print out error message */
        if (error && (answer != null)) {  //REFACTOR?-- assumes answer null only when first open page
            out.print("<p style='color:red'>Your last answer was not correct! Please try again</p> ");
        }
        out.print("<p><input type='submit' name='btnNext' value='Next' /></p> ");

        out.print("</form>");
        out.print("</body></html>");
    }

    // Optional method to generate quiz over page without using jsp page
    private void genQuizOverPage(PrintWriter out) {
        out.print("<html> ");
        out.print("<head >");
        out.print("<title>NumberQuiz is over</title> ");
        out.print("</head> ");
        out.print("<body> ");
        out.print("<p style='color:red'>The number quiz is over!</p>	</body> ");
        out.print("</html> ");
    }

}
