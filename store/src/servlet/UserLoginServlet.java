package servlet;

import model.User;
import service.UserService;
import model.IpandTime;
import service.IpandTimeService;
import utils.Ipandtime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "user_login",urlPatterns = "/user_login")
public class UserLoginServlet extends HttpServlet {
    private UserService uService = new UserService();
    private IpandTimeService iService = new IpandTimeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ue = request.getParameter("ue");
        String password = request.getParameter("password");
        User user = uService.login(ue, password);
        if(user==null) {
            request.setAttribute("failMsg", "用户名、邮箱或者密码错误，请重新登录！");
            request.getRequestDispatcher("/user_login.jsp").forward(request, response);
        }else {
        	Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateNowStr = sdf.format(d);
            Ipandtime i=new Ipandtime();
            IpandTime t=new IpandTime(i.getIp(request),dateNowStr,ue,"user","登录");
            iService.add(t);
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("/user_center.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
