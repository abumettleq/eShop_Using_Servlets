package com.example.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class cartEmptyServlet extends HttpServlet {
    private HttpSession session;
    private PrintWriter out;
    private RequestDispatcher rd;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        out = response.getWriter();
        session = request.getSession();
        session.setAttribute("Cart", null);
        rd = request.getRequestDispatcher("cartShow-servlet");
        rd.include(request,response);
        out.println("<p style=\"color:green; font-size:20px;\">Successfully Emptied Cart!</p>");
    }
}
