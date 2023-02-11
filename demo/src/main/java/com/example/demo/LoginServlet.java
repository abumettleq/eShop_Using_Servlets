package com.example.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    private HttpSession session;
    private RequestDispatcher rd;
    private String db_email = "user@test.com";
    private String db_password = "1234";
    private String login_email, login_password;
    private PrintWriter out;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        out = response.getWriter();

        login_email = request.getParameter("email-field");
        login_password = request.getParameter("password-field");

        if(login_email.equals(db_email) && login_password.equals(db_password))
        {
            session = request.getSession();
            session.setAttribute("eUser", login_email);
            rd = request.getRequestDispatcher("shopping.jsp");
            rd.include(request,response);
        }
        else
        {
            rd = request.getRequestDispatcher("login.jsp");
            rd.include(request,response);
            out.print("<p style=\"font-size: 20px; color: red;\">Email or Password is incorrect!</p>");
        }
    }
}
