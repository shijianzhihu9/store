package servlet;

import model.Type;
import org.apache.commons.beanutils.BeanUtils;
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

@WebServlet(name = "Salesperson_type_edit",urlPatterns = "/Salesperson/type_edit")
public class SalespersonTypeEditServlet extends HttpServlet {
    private TypeService tService = new TypeService();
    private OpRecordService Oservice=new OpRecordService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Type t = new Type();
        try {
            BeanUtils.copyProperties(t, request.getParameterMap());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        tService.update(t);
        TypeService tsService=new TypeService();
        Date d = new Date();
        Salesperson salesperson=(Salesperson)request.getSession().getAttribute("Salesperson");
        String ue=salesperson.getsalespersonname();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(d);
        Ipandtime i=new Ipandtime();
        OpRecord o=new OpRecord(ue,i.getIp(request),"修改类目",dateNowStr);
        Oservice.add(o);
        request.getSession().setAttribute("typeList",tsService.GetAllType());
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
