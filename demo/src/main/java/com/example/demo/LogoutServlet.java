package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LogoutServlet extends HttpServlet {
    private HttpSession session;
    private PrintWriter out;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        out = response.getWriter();

        request.getRequestDispatcher("index.jsp").include(request, response);

        session = request.getSession();
        session.invalidate();

        out.print("<p style=\"color: green\">You are successfully logged out!</p>");

        out.close();
    }
}