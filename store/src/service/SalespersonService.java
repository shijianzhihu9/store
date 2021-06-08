package service;

import dao.SalespersonDao;
import model.Page;
import model.Salesperson;

import java.sql.SQLException;
import java.util.List;

public class SalespersonService {
    private SalespersonDao uDao = new SalespersonDao();
    public boolean add(Salesperson Salesperson) {
        try {
            if(uDao.issalespersonnameExist(Salesperson.getsalespersonname())) {
                return false;
            }
            uDao.addSalesperson(Salesperson);
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public Salesperson login(String ue,String password) {
        Salesperson Salesperson=null;
        try {
            Salesperson = uDao.selectBysalespersonnamePassword(ue, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(Salesperson!=null) {
            return Salesperson;
        }
        return null;
    }
    public Salesperson selectById(int id) {
        Salesperson u=null;
        try {
            u = uDao.selectById(id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return u;
    }
    public void updateSalespersonAddress(Salesperson Salesperson) {
        try {
            uDao.updateSalespersonAddress(Salesperson);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void updatePwd(Salesperson Salesperson) {
        try {
            uDao.updatePwd(Salesperson);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Page getSalespersonPage(int pageNumber) {
        Page p = new Page();
        p.setPageNumber(pageNumber);
        int pageSize = 7;
        int totalCount = 0;
        try {
            totalCount = uDao.selectSalespersonCount();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.SetPageSizeAndTotalCount(pageSize, totalCount);
        List list=null;
        try {
            list = uDao.selectSalespersonList( pageNumber, pageSize);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }
    public boolean delete(int id ) {
        try {
            uDao.delete(id);
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
}
