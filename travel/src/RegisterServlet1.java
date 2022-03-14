import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "RegisterServlet1",urlPatterns = {"/register1"})

public class RegisterServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1、获取用户提交信息
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        //2、把信息存到数据库
        //2.1构建SQL语句
        String sql = "INSERT INTO user(username,password,email,mobile) VALUES ('" +name+ "','" +password+ "','" +email +"','" +mobile +"')";

        //2.2执行SQL语句

        String url="jdbc:mysql://localhost:3306/travel_db?serverTimezone=UTC";
        String username="root";
        String pwd="123456";
        try{
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
        request.getRequestDispatcher("login1.html").forward(request,response);//页面跳转
        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        response.getWriter().write("Hello!"+name);
        response.getWriter().flush();
        return;
    }

}
