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

@WebServlet(name = "admin_Salesperson_edit",urlPatterns = "/admin/Salesperson_edit")
public class AdminSalespersonEditServlet extends HttpServlet {
    private SalespersonService Salespersonvice = new SalespersonService();
    private OpRecordService oService=new OpRecordService();
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Salesperson u = new Salesperson();
        try {
            BeanUtils.copyProperties(u, request.getParameterMap());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Salespersonvice.updateSalespersonAddress(u);
        Date d = new Date();
        Admin admin=(Admin)request.getSession().getAttribute("Admin");
        String ue=admin.getadminname();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(d);
        Ipandtime i=new Ipandtime();
        OpRecord o=new OpRecord(ue,i.getIp(request),"修改销售员信息",dateNowStr);
        oService.add(o);
        request.getRequestDispatcher("/admin/Salesperson_list").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }
}
