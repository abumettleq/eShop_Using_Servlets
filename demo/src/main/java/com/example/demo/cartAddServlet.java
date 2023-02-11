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

public class cartAddServlet extends HttpServlet {
    private itemCreator item;
    private ArrayList<itemCreator> cart;
    private HttpSession session;
    private RequestDispatcher rd;
    private PrintWriter out;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        out = response.getWriter();
        item = new itemCreator();

        session = request.getSession();

        // fetch cart from session
        cart = (ArrayList<itemCreator>) session.getAttribute("Cart");

        if(cart == null) // if the cart object has never been built.
        {
            cart = new ArrayList<itemCreator>();
        }

        // create new item
        item.setItem_name(request.getParameter("product-name"));
        item.setItem_amount(Integer.parseInt(request.getParameter("product-amount")));
        item.setItem_price(Integer.parseInt(request.getParameter("product-price")));

        // add the new item to cart
        cart.add(item);

        // overwrite cart in session
        session.setAttribute("Cart", cart);

        rd = request.getRequestDispatcher("shopping.jsp");
        rd.include(request,response);
        out.println("<p style=\"color:green; font-size:20px;\">Item Successfully Added To Cart!</p>");
    }
}
