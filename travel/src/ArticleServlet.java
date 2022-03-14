import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "ArticleServlet",urlPatterns = "/article")
public class ArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String sql="SELECT id,title,content,author,create_datetime FROM article WHERE id="+id;
        String url="jdbc:mysql://localhost:3306/travel_db?serverTimezone=UTC";
        String username="root";
        String pwd="123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn= DriverManager.getConnection(url,username,pwd);
            Statement statement= conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            String title="";
            String content="";
            String author="";
            String createDateTime="";

            while(resultSet.next()){
                title = resultSet.getString(2);
                content = resultSet.getString(3);
                author = resultSet.getString(4);
                createDateTime = resultSet.getString(5);
            }

            request.setAttribute("title",title);
            request.setAttribute("content",content);
            request.setAttribute("author",author);
            request.setAttribute("createDateTime",createDateTime);

            request.getRequestDispatcher("article.jsp").forward(request,response);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return;
    }
}
