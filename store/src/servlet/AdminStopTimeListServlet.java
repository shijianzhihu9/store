package servlet;

import model.Page;
import service.StopTimeService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "admin_StopTime_list",urlPatterns = "/admin/StopTime_list")
public class AdminStopTimeListServlet extends HttpServlet {
    private StopTimeService StopTimevice = new StopTimeService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNumber = 1;
        if(request.getParameter("pageNumber") != null) {
            try {
                pageNumber=Integer.parseInt(request.getParameter("pageNumber") ) ;
            }
            catch (Exception e)
            {

            }

        }
        if(pageNumber<=0)
            pageNumber=1;
        Page p = StopTimevice.getStopTimePage(pageNumber);
        if(p.getTotalPage()==0)
        {
            p.setTotalPage(1);
            p.setPageNumber(1);
        }
        else {
            if(pageNumber>=p.getTotalPage()+1)
            {
                p = StopTimevice.getStopTimePage(pageNumber);
            }
        }
        request.setAttribute("p", p);
        request.getRequestDispatcher("/admin/StopTime_list.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request,response);
    }
}