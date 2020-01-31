package myServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "myServlet.calculatorServlet")
public class calculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* SOLUTION TO PROBLEM 1 in the comment section
        PrintWriter out = response.getWriter();

        if(request.getParameter("numOne")!=null&&request.getParameter("numTwo")!=null){
            float num1 = Float.parseFloat(request.getParameter("numOne"));
            float num2 = Float.parseFloat(request.getParameter("numTwo"));
            out.println("Add : "+ num1 + " +"+ num2 +" = "+(numOne+numTwo));
        }

        if(request.getParameter("numThree")!=null&&request.getParameter("numFour")!=null){
            float num3 = Float.parseFloat(request.getParameter("mul1"));
            float num4 = Float.parseFloat(request.getParameter("mul2"));


            out.println("Mul : "+ mul1+ " +"+ mul2+" = "+(mul1* mul2));
        }*/


        // Improved version of calculator
        try{

            // Get the text as string initially
            String s1 = request.getParameter("numOne");
            String s2 = request.getParameter("numTwo");

            // Variables to store all inputs and results
            float num1 = 0,num2 = 0, num3 = 0, num4 = 0, sum=0,product = 0;

            // If the fields are not empty, add two numbers
            if(s1.length()>0 && s2.length()>0){

                // Using float to accept decimals
                num1 = Float.parseFloat(s1);
                num2 = Float.parseFloat(s2);
                sum = num1 + num2;
                request.setAttribute("sumResult",sum);
                request.setAttribute("num1",num1);
                request.setAttribute("num2",num2);

                // else if the fields are empty, display nothing
            }else{
                request.setAttribute("sumResult","");
                request.setAttribute("num1","");
                request.setAttribute("num2","");
            }

            // Same process for the product
            s1 = request.getParameter("numThree");
            s2 = request.getParameter("numFour");
            num3 = Float.parseFloat(s1);
            num4 = Float.parseFloat(s2);
            product = num4 * num3;
            request.setAttribute("productResult",product);
            request.setAttribute("num3",num3);
            request.setAttribute("num4",num4);

        }catch(NumberFormatException e){

            // Print error on output if there is number format exception
            System.out.println("Invalid Number");

        }

        RequestDispatcher dispatch = request.getRequestDispatcher("index.jsp");
        dispatch.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}

