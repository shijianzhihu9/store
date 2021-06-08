package service;

import dao.AdminDao;
import model.Admin;

import java.sql.SQLException;


public class AdminService {
    private AdminDao uDao = new AdminDao();
    public Admin login(String ue,String password) {
        Admin Admin=null;
        try {
            Admin = uDao.selectByadminnamePassword(ue, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(Admin!=null) {
            return Admin;
        }
        return null;
    }
    public Admin selectById(int id) {
        Admin u=null;
        try {
            u = uDao.selectById(id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return u;
    }

 
   
}
