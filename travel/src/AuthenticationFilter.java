import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        // 检查请求是否由已登录
        HttpServletRequest request = (HttpServletRequest)req;
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        if(user == null){
            request.getRequestDispatcher("login1.html").forward(request,resp);
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
