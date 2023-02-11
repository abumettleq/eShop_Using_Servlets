package com.example.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class cartRemoveServlet extends HttpServlet {
    private HttpSession session;
    private PrintWriter out;
    private ArrayList<itemCreator> cart;
    private int item_id;
    private RequestDispatcher rd;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        out = response.getWriter();
        session = request.getSession();
        cart = (ArrayList<itemCreator>) session.getAttribute("Cart");
        item_id = Integer.parseInt(request.getParameter("item_id")) - 1;
        cart.remove(item_id);
        session.setAttribute("Cart", cart);
        rd = request.getRequestDispatcher("cartShow-servlet");
        rd.include(request,response);
        out.println("<p style=\"color:green; font-size:20px;\">Item Successfully Removed From Cart!</p>");
    }
}
