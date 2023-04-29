package core.bean;

import java.io.*;
import java.net.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/Hit")
public class SessServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name1 = request.getParameter("t1");
        String name2 = request.getParameter("t2");
        HttpSession hsess = request.getSession();
        SessBean sbeen = (SessBean) hsess.getAttribute("NB");
        if (sbeen == null) {
            sbeen = new SessBean();
            hsess.setAttribute("NB", sbeen);
        }
        if ((name1 != null) && (!name1.trim().equals(""))) {
            sbeen.setName1(name1);
        }
        if ((name2 != null) && (!name2.trim().equals(""))) {
            sbeen.setName2(name2);
        }
        String myurl = "/index.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(myurl);
        rd.forward(request, response);
    }
}
