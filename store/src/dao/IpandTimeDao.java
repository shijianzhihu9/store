package dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import model.IpandTime;
import model.OpRecord;
import model.Salesperson;
import utils.DBUtil;
public class IpandTimeDao {
	public void insertIpandTime(Connection con,IpandTime i) throws SQLException {
        QueryRunner r = new QueryRunner();
        String sql = "insert into `ipandtime`(ip,time,name,type,op) values(?,?,?,?,?)";
        r.update(con,sql,
                i.getip(),i.gettime(),i.getname(),
                i.gettype(),i.getop());
    }
    
    
	public List selectIpandTimeList(int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from ipandtime limit ?,?";
        return r.query(sql, new BeanListHandler<IpandTime>(IpandTime.class), (pageNo-1)*pageSize,pageSize );
    }
	public int selectIpandTimeCount() throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from ipandtime";
        return r.query(sql, new ScalarHandler<Long>()).intValue();
    }
    
}
