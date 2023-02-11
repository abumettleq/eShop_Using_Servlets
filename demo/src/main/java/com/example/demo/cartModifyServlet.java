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

public class cartModifyServlet extends HttpServlet {
    private itemCreator item;
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

        // get the item to be modified, from cart
        item = cart.get(item_id);

        // modify the amount & the price
        int new_amount = Integer.parseInt(request.getParameter("new_amount-field"));
        int oldPrice = item.getItem_price()/item.getItem_amount();
        item.setItem_amount(new_amount);
        item.setItem_price(oldPrice);

        // overwrite it with the new changes
        cart.set(item_id, item);

        // save cart to session
        session.setAttribute("Cart", cart);
        rd = request.getRequestDispatcher("cartShow-servlet");
        rd.include(request,response);
        out.println("<p style=\"color:green; font-size:20px;\">Item Successfully Removed From Cart!</p>");
    }
}
