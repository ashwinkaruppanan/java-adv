import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/")
public class MySQLServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ashwin", "work", "work");
//            "jdbc:ucanaccess://D:/sample.accdb"

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
            out.println("<html><body style='font-family: monospace'><center><style>table, th, td { border: 1px solid black;border-collapse: collapse; text-align:center}</style><h2>Students Marks</h2><table><tr><th>Name</th><th>Python</th><th>Java</th><th>Golang</th><th>Total</th></tr>");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int python = resultSet.getInt("python");
                int java = resultSet.getInt("java");
                int golang = resultSet.getInt("golang");
                out.println("<tr><td>" + name + "</td><td>" + python + "</td><td>" + java + "</td><td>" + golang + "</td><td>" + (python + java + golang) + "</td></tr>");
            }
            out.println("</table></center></body></html>");
            
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
