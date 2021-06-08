package dao;

import model.Admin;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DBUtil;

import java.sql.SQLException;


public class AdminDao {
    public boolean isadminnameExist(String adminname) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from admin where adminname = ?";
        Admin u = r.query(sql, new BeanHandler<Admin>(Admin.class),adminname);
        if(u==null) {
            return false;
        }else {
            return true;
        }
    }
    public Admin selectByadminnamePassword(String adminname,String password) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from admin where adminname=? and password=?";
        return r.query(sql, new BeanHandler<Admin>(Admin.class),adminname,password);
    }
    
    public Admin selectById(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from admin where id=?";
        return r.query(sql, new BeanHandler<Admin>(Admin.class),id);
    }

  
}

