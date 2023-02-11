package com.example.demo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthFilter implements Filter {
    FilterConfig filterConfig = null;
    public void init(FilterConfig config) throws ServletException {
        filterConfig = config;
    }

    public void destroy() {
        filterConfig = null;
    }

    private HttpServletResponse res;
    private HttpServletRequest req;
    private HttpSession session;
    private PrintWriter out;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException
    {
        req = (HttpServletRequest) request;
        res = (HttpServletResponse) response;
        out = res.getWriter();
        session = req.getSession(false);

        if (session == null)
        {
            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.include(req, res);
            out.println("<p style=\"font-size: 20px; color: red;\">You haven't logged in yet.</p>");
        }
        else if (session.getAttribute("eUser") == null)
        {
            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.include(req, res);
            out.println("<p style=\"font-size: 20px; color: red;\">Session Invalid or Expired.</p>");
        }
        else chain.doFilter(request, response);
    }

}
