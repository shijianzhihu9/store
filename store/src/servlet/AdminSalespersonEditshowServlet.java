package servlet;

import model.Salesperson;
import service.SalespersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "admin_Salesperson_editshow",urlPatterns = "/admin/Salesperson_editshow")
public class AdminSalespersonEditshowServlet extends HttpServlet {
    private SalespersonService Salespersonvice = new SalespersonService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Salesperson Salesperson = Salespersonvice.selectById(id);
        request.setAttribute("u", Salesperson);
        request.getRequestDispatcher("/admin/Salesperson_edit.jsp").forward(request, response);
    }
}
