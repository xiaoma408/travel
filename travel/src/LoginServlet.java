import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "LoginServlet", urlPatterns = "/login1")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2.1 构建SQL语句
        String sql = "SELECT id,username,password,email,mobile FROM user WHERE username='"+username+"'";

        //2.2 执行SQL语句
        String url="jdbc:mysql://localhost:3306/travel_db?serverTimezone=UTC";
        String name="root";
        String pwd="123456";
        try {
            //注册MySQL驱动程序类
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            // 2.2.1 构建与数据库服务器的通信通道——构建Connection对象
            Connection conn = DriverManager.getConnection(url,name,pwd);
            //2.2.2 通过Connection对象，构建Statement对象（负责发送SQL指令给数据库服务器）
            Statement statement = conn.createStatement();
            //2.2.3 通过Statement对象，发送SQL指令给数据库服务器执行
            ResultSet resultSet = statement.executeQuery(sql);
            User user = new User();
            while(resultSet.next()){
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setMobile(resultSet.getString(5));
            }

            if(password.equals(user.getPassword())){
                //用户名和密码是正确的
                request.getSession().setAttribute("user",user);
            }else{
                request.getRequestDispatcher("login1.html").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("index.html").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
