package CookieServe;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CookieServlet", urlPatterns = {"/CookieServlet"})
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        String name = request.getParameter("name");
        
        Cookie[] cookies = request.getCookies();
        int count = 1;
        if(cookies != null){
            for(Cookie cookie:cookies){
                if(name.equals(cookie.getName())){
                    count = Integer.parseInt(cookie.getValue()) + 1;
                }
            }
        }
        
        Cookie c = new Cookie(name, String.valueOf(count));
        c.setMaxAge(24 * 60 * 60);
        response.addCookie(c);
        response.getWriter().append(String.valueOf(count));       
    }
}
