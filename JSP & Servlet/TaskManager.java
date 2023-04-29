import java.io.IOException;
import java.util.HashSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/manage")
public class TaskManager extends HttpServlet {

    private HashSet<String> tasks = new HashSet<String>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String task = request.getParameter("task");
        if("add".equals(request.getParameter("action"))) {
                tasks.add(task);
        } else tasks.remove(task);
        request.setAttribute("tasks", tasks);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}