package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.IpandTime;
import service.IpandTimeService;
import utils.Ipandtime;
import model.Admin;
@WebServlet(name = "Admin_logout",urlPatterns = "/Admin_logout")
public class AdminLogoutServlet extends HttpServlet {
	private IpandTimeService iService = new IpandTimeService();
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	Admin admin=(Admin)request.getSession().getAttribute("Admin");
	    	String ue=admin.getadminname();
	    	Date d = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String dateNowStr = sdf.format(d);
	        Ipandtime i=new Ipandtime();
	        IpandTime t=new IpandTime(i.getIp(request),dateNowStr,ue,"admin","登出");
	        iService.add(t);
	        request.getSession().removeAttribute("Admin");
	        response.sendRedirect("index");
	    }
}
