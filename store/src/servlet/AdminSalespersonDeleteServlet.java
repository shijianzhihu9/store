package servlet;

import service.SalespersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.OpRecord;
import service.OpRecordService;
import utils.Ipandtime;
import model.Admin;

@WebServlet(name = "admin_Salesperson_delete",urlPatterns = "/admin/Salesperson_delete")
public class AdminSalespersonDeleteServlet extends HttpServlet {
    private SalespersonService Salespersonvice = new SalespersonService();
    private OpRecordService oService=new OpRecordService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isSuccess = Salespersonvice.delete(id);
        if(isSuccess) {
        	Date d = new Date();
            Admin admin=(Admin)request.getSession().getAttribute("Admin");
            String ue=admin.getadminname();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateNowStr = sdf.format(d);
            Ipandtime i=new Ipandtime();
            OpRecord o=new OpRecord(ue,i.getIp(request),"删除销售员",dateNowStr);
            oService.add(o);
            request.setAttribute("msg", "销售员删除成功");
        }else {
            request.setAttribute("failMsg", "删除失败！");
        }
        request.getRequestDispatcher("/admin/Salesperson_list").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
