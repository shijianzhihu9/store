package dao;

import model.Salesperson;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class SalespersonDao {
    public void addSalesperson(Salesperson Salesperson) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "insert into salesperson(salespersonname,password,phone,address,isvalidate) values(?,?,?,?,?)";
        r.update(sql,Salesperson.getsalespersonname(),Salesperson.getPassword(),Salesperson.getPhone(),Salesperson.getAddress(),Salesperson.isIsvalidate());
    }
    public boolean issalespersonnameExist(String salespersonname) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from salesperson where salespersonname = ?";
        Salesperson u = r.query(sql, new BeanHandler<Salesperson>(Salesperson.class),salespersonname);
        if(u==null) {
            return false;
        }else {
            return true;
        }
    }
    public Salesperson selectBysalespersonnamePassword(String salespersonname,String password) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from salesperson where salespersonname=? and password=?";
        return r.query(sql, new BeanHandler<Salesperson>(Salesperson.class),salespersonname,password);
    }
    public Salesperson selectById(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from salesperson where id=?";
        return r.query(sql, new BeanHandler<Salesperson>(Salesperson.class),id);
    }

    public void updateSalespersonAddress(Salesperson Salesperson) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql ="update salesperson set salespersonname = ?,phone=?,address=? where id = ?";
        r.update(sql,Salesperson.getsalespersonname(),Salesperson.getPhone(),Salesperson.getAddress(),Salesperson.getId());
    }
    public void updatePwd(Salesperson Salesperson) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql ="update salesperson set password = ? where id = ?";
        r.update(sql,Salesperson.getPassword(),Salesperson.getId());
    }
    public int selectSalespersonCount() throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from salesperson";
        return r.query(sql, new ScalarHandler<Long>()).intValue();
    }
    public List selectSalespersonList(int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from salesperson limit ?,?";
        return r.query(sql, new BeanListHandler<Salesperson>(Salesperson.class), (pageNo-1)*pageSize,pageSize );
    }
    public void delete(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "delete from salesperson where id = ?";
        r.update(sql,id);
    }
}
