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

public class cartShowServlet extends HttpServlet {
    private ArrayList<itemCreator> cart;
    private HttpSession session;
    private PrintWriter out;
    private RequestDispatcher rd;
    private int id;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        out = response.getWriter();

        String prompt = request.getParameter("prompt"); // parameter to specify whether user choose to modify or not
        if(prompt != null)
        {
            String item_id = request.getParameter("item_id");
            if(prompt.equals("1"))
            {
                response.setContentType("text/html");
                out.print("<dialog id=\"my-dialog\" open>\n" +
                        "  <form method=\"get\" action=\"cartModify-servlet\">\n" +
                        "    <p>Insert your new amount:</p>\n" +
                        "    <input min=\"1\" max=\"10\" name=\"new_amount-field\" type=\"number\" required>" +
                        "    <input name=\"item_id\" value=\""+item_id+"\" hidden=\"hidden\">" +
                        "    <input type=\"submit\" value=\"Ok\">" +
                        "  </form>\n" +
                        "</dialog>");
            }
        }

        id = 1;
        session = request.getSession();
        cart = (ArrayList<itemCreator>) (session.getAttribute("Cart"));

        if (cart != null) {
            if(!cart.isEmpty())
            {
                rd = request.getRequestDispatcher("cart.jsp");
                rd.include(request, response);

                out.println("<style>\n" +
                        "table, th, td {\n" +
                        "  border:1px solid black;\n" +
                        "}\n" +
                        "</style>");
                out.println("<table>");
                out.println("<tr><th>ID</th><th>Name</th><th>Amount</th><th>Price</th><th>Action-1</th><th>Action-2</th></tr>");
                for (itemCreator i : cart) {
                    out.println("<tr><td>" + id + "</td><td>" + i.getItem_name() + "</td><td>" + i.getItem_amount() + "</td><td>" + i.getItem_price() + "</td><td><a href=\"cartShow-servlet?prompt=1&item_id=" + id + "\" style=\"color:green;\">Modify</a>" + "</td><td><a href=\"cartRemove-servlet?item_id=" + id + "\" style=\"color:red;\">Remove</a></td></tr>");
                    id++;
                }
                out.println("</table>");
                out.println("<a href=\"cartEmpty-servlet\" style=\"color: red;\">Empty Cart</a>");
                out.print("<br>");
                out.print("<center><form method=\"get\" action=\"purchase-servlet\"> <input type=\"submit\" value=\"CheckOut\"> </form></center>");
                out.print("<br>");
                out.println("<a href=\"shopping.jsp\">Go back to main</a>");
            }
            else
            {
                rd = request.getRequestDispatcher("cart.jsp");
                rd.include(request, response);
                out.println("<p>Cart is Empty.</p>");
                out.println("<a href=\"shopping.jsp\">Go back to main</a>");
            }
        }
        else
        {
            rd = request.getRequestDispatcher("cart.jsp");
            rd.include(request, response);
            out.println("<p>Cart is Empty.</p>");
            out.println("<a href=\"shopping.jsp\">Go back to main</a>");
        }
    }
}
