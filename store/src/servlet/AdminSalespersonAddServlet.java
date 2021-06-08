package servlet;

import model.Salesperson;
import org.apache.commons.beanutils.BeanUtils;
import service.SalespersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.OpRecord;
import service.OpRecordService;
import utils.Ipandtime;
import model.Admin;

@WebServlet(name = "admin_Salesperson_add",urlPatterns = "/admin/Salesperson_add")
public class AdminSalespersonAddServlet extends HttpServlet {
    private SalespersonService Salespersonvice = new SalespersonService();
    private OpRecordService oService=new OpRecordService();
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Salesperson Salesperson = new Salesperson();
        try {
            BeanUtils.copyProperties(Salesperson, request.getParameterMap());
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(Salespersonvice.add(Salesperson)) {
        	Date d = new Date();
            Admin admin=(Admin)request.getSession().getAttribute("Admin");
            String ue=admin.getadminname();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateNowStr = sdf.format(d);
            Ipandtime i=new Ipandtime();
            OpRecord o=new OpRecord(ue,i.getIp(request),"添加销售员",dateNowStr);
            oService.add(o);
            request.setAttribute("msg", "销售员添加成功！");
            request.getRequestDispatcher("/admin/Salesperson_list").forward(request, response);
        }else {
            request.setAttribute("failMsg", "用户名重复，请重新填写！");
            request.setAttribute("u",Salesperson);
            request.getRequestDispatcher("/admin/Salesperson_add.jsp").forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request,response);
    }
}
