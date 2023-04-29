package Rand;

import Rand.DSBean;
import java.util.*;
import java.io.*;
import java.net.*;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/")
public class DSServlett extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            double x = Math.random();
            double y = Math.random();
            DSBean myb = new DSBean(x, y);
            request.setAttribute("rndno", myb);
            String add = "/DSjsp.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(add);
            rd.forward(request, response);
            System.out.println(x + " " + y);
        } catch (ServletException | IOException e) {
            System.err.println(e);
        }
    }
}
