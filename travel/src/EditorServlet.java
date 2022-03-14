import javafx.scene.control.Alert;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

@WebServlet(name = "EditorServlet",urlPatterns = {"/editor"})
public class EditorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1、获取用户提交信息
        request.setCharacterEncoding("UTF-8");
        String title = request.getParameter("title");
        String author=request.getParameter("author");
        String place=request.getParameter("place");
        String price=request.getParameter("price");
        String content = request.getParameter("content").replaceAll("'","\\\\");

        String now = LocalDateTime.now().toString();
        //2、把信息存到数据库
        //2.1构建SQL语句
        String sql = "INSERT INTO article(title,author,place,price,content,time) VALUES ('" +title+ "','"+author+"','"+place+"','"+price+"','" +content+ "','" + now +"')";

        //2.2执行SQL语句

        String url="jdbc:mysql://localhost:3306/travel_db?serverTimezone=UTC";
        String username="root";
        String pwd="123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //2.2.1构建与数据库服务器的通信通道——构建Connection对象
            Connection conn= DriverManager.getConnection(url,username,pwd);
            //2.2.2通过Connection对象，构建Statement对象（负责发送SQL指令给数据库服务器）
            Statement statement= conn.createStatement();
            //2.2.3通过Statement对象，发送SQL指令给数据库服务器
            statement.executeLargeUpdate(sql);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        try {
            PrintWriter out =response.getWriter();

            out.print("<script>alert('Success！')</script>");
            out.print("<script>location.href='index.html'</script>");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        request.getRequestDispatcher("index.jsp").forward(request,response);

        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        response.getWriter().write("Hello!"+name);
        response.getWriter().flush();
        return;
    }
}
