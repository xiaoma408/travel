import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ContactServlet",urlPatterns = "/contact.html")
public class ContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //构建sql语句
        String sql="select id,title,content,author,create_datetime from article ";

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
            ResultSet resultSet = statement.executeQuery(sql);

            //JavaBean
            List<Article> articles=new ArrayList<>();

            //通过resultSet 对象获取数据库中查询得到的各个字段的数据值
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String title=resultSet.getString("title");
//                 或者： title=resultSet.getString(2"); 2号位
                String content=resultSet.getString("content");
                String author=resultSet.getString("author");
                String createDateTime=resultSet.getString("create_datetime");

                Article article=new Article();
                article.setId(id);
                article.setTitle(title);
                article.setContent(content);
                article.setAuthor(author);
                article.setCreateDateTime(createDateTime);

                articles.add(article);
            }

            //设置当前request对象的属性并赋值
            request.setAttribute("articles",articles);

            //将当前已经设置属性值的请求对象发给article.jsp
            request.getRequestDispatcher("contact.jsp").forward(request,response);


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
