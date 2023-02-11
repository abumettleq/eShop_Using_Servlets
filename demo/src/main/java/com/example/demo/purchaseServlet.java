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
import java.util.Random;

public class purchaseServlet extends HttpServlet {
    private ArrayList<itemCreator> cart;
    private HttpSession session;
    private PrintWriter out;
    int min = 800000000;
    int max = 900000000;
    RequestDispatcher rd;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        out = resp.getWriter();
        session = req.getSession();
        cart = (ArrayList<itemCreator>) session.getAttribute("Cart");
        rd = req.getRequestDispatcher("checkout.jsp");
        rd.include(req,resp);
        int totalPrice = 0;
        for(itemCreator i : cart)
        {
            totalPrice = totalPrice + i.getItem_price();
        }

        out.print("<p>Order ID: "+ (int)(Math.random()*(max-min+1)+min) +"</p>");
        out.print("<p>Total: $"+totalPrice+"</p>");
        out.print("<form method=\"get\" action=\"cartEmpty-servlet\"> <input type=\"submit\" value=\"Proceed\"> </form>");
    }
}
