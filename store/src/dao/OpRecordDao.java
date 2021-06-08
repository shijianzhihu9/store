package dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import model.Admin;
import model.OpRecord;
import utils.DBUtil;
public class OpRecordDao {
	public void insertOpRecord(Connection con,OpRecord i) throws SQLException {
        QueryRunner r = new QueryRunner();
        String sql = "insert into `oprecord`(name,ip,op,time) values(?,?,?,?)";
        r.update(con,sql,
                i.getname(),i.getip(),i.getop(),
                i.gettime());
    }
    
    
	public List selectOpRecordList(int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from oprecord limit ?,?";
        return r.query(sql, new BeanListHandler<OpRecord>(OpRecord.class), (pageNo-1)*pageSize,pageSize );
    }
	public int selectOpRecordCount() throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from oprecord";
        return r.query(sql, new ScalarHandler<Long>()).intValue();
    }
    
}