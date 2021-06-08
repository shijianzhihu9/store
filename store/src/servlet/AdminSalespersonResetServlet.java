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

@WebServlet(name = "admin_Salesperson_reset",urlPatterns = "/admin/Salesperson_reset")
public class AdminSalespersonResetServlet extends HttpServlet {
    private SalespersonService Salespersonvice = new SalespersonService();
    private OpRecordService oService=new OpRecordService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Salesperson u = new Salesperson();
        try {
            BeanUtils.copyProperties(u, request.getParameterMap());
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Salespersonvice.updatePwd(u);
        Date d = new Date();
        Admin admin=(Admin)request.getSession().getAttribute("Admin");
        String ue=admin.getadminname();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(d);
        Ipandtime i=new Ipandtime();
        OpRecord o=new OpRecord(ue,i.getIp(request),"重置销售员密码",dateNowStr);
        oService.add(o);
        request.getRequestDispatcher("/admin/Salesperson_list").forward(request, response);
    }
}
