package servlet;

import service.TypeService;

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
import model.Salesperson;
@WebServlet(name = "Salesperson_type_delete",urlPatterns = "/Salesperson/type_delete")
public class SalespersonTypeDeleteServlet extends HttpServlet {
    private TypeService tService = new TypeService();
    private OpRecordService Oservice=new OpRecordService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isSuccess = tService.delete(id);
        if(isSuccess) {
        	Date d = new Date();
            Salesperson salesperson=(Salesperson)request.getSession().getAttribute("Salesperson");
            String ue=salesperson.getsalespersonname();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateNowStr = sdf.format(d);
            Ipandtime i=new Ipandtime();
            OpRecord o=new OpRecord(ue,i.getIp(request),"删除类目",dateNowStr);
            Oservice.add(o);
            request.setAttribute("msg", "删除成功");
            TypeService tsService=new TypeService();
            request.getSession().setAttribute("typeList",tsService.GetAllType());
        }else {
            request.setAttribute("failMsg", "类目下包含商品，无法直接删除类目！");
        }
        
        request.getRequestDispatcher("/Salesperson/type_list").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
