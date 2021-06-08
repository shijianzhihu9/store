package servlet;

import service.OrderService;

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

@WebServlet(name = "Salesperson_order_delete",urlPatterns = "/Salesperson/order_delete")
public class SalespersonOrderDeleteServlet extends HttpServlet {
    private OrderService oService = new OrderService();
    private OpRecordService oservice=new OpRecordService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        oService.delete(id);
        Date d = new Date();
        Salesperson salesperson=(Salesperson)request.getSession().getAttribute("Salesperson");
        String ue=salesperson.getsalespersonname();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(d);
        Ipandtime i=new Ipandtime();
        OpRecord o=new OpRecord(ue,i.getIp(request),"删除订单",dateNowStr);
        oservice.add(o);
        request.getRequestDispatcher("/Salesperson/order_list").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
