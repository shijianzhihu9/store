package servlet;

import service.GoodsService;

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

@WebServlet(name = "admin_goods_delete",urlPatterns = "/admin/goods_delete")
public class AdminGoodsDeleteServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();
    private OpRecordService oService=new OpRecordService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        gService.delete(id);
        Date d = new Date();
        Admin admin=(Admin)request.getSession().getAttribute("Admin");
        String ue=admin.getadminname();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(d);
        Ipandtime i=new Ipandtime();
        OpRecord o=new OpRecord(ue,i.getIp(request),"删除商品",dateNowStr);
        oService.add(o);
        request.getRequestDispatcher("/admin/goods_list").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
