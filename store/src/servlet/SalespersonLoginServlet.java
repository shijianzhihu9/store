package servlet;

import model.Salesperson;
import service.SalespersonService;
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

@WebServlet(name = "Salesperson_login",urlPatterns = "/Salesperson_login")
public class SalespersonLoginServlet extends HttpServlet {
    private SalespersonService Salespersonvice = new SalespersonService();
    private IpandTimeService iService = new IpandTimeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ue = request.getParameter("ue");
        String password = request.getParameter("password");
        Salesperson Salesperson = Salespersonvice.login(ue, password);
        if(Salesperson==null) {
            request.setAttribute("failMsg", "用户名、邮箱或者密码错误，请重新登录！");
            request.getRequestDispatcher("/Salesperson_login.jsp").forward(request, response);
        }else {
        	Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateNowStr = sdf.format(d);
            Ipandtime i=new Ipandtime();
            IpandTime t=new IpandTime(i.getIp(request),dateNowStr,ue,"salesperson","登录");
            iService.add(t);
            request.getSession().setAttribute("Salesperson", Salesperson);
            request.getRequestDispatcher("/Salesperson/index.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
