package dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import model.StopTime;
import utils.DBUtil;
public class StopTimeDao {
	public void insertStopTime(Connection con,StopTime s) throws SQLException {
        QueryRunner r = new QueryRunner();
        String sql = "insert into `stoptime`(ip,stoptime,goodsname) values(?,?,?)";
        r.update(con,sql,
                s.getip(),s.getstoptime(),s.getgoodsname());
    }
    
    
	public List selectStopTimeList(int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from stoptime limit ?,?";
        return r.query(sql, new BeanListHandler<StopTime>(StopTime.class), (pageNo-1)*pageSize,pageSize );
    }
	public int selectStopTimeCount() throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from stoptime";
        return r.query(sql, new ScalarHandler<Long>()).intValue();
    }
    
}

