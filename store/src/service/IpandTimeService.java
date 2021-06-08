package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.IpandTimeDao;
import model.IpandTime;
import model.IpandTime;
import model.Page;
import utils.DBUtil;
public class IpandTimeService {
	 private IpandTimeDao iDao = new IpandTimeDao();
	 public void add(IpandTime IpandTime) {
	        Connection con = null;
	        try {
	            con = DBUtil.getConnection();
	            con.setAutoCommit(false);
	            iDao.insertIpandTime(con,IpandTime );
	            con.commit();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            if(con!=null)
	                try {
	                    con.rollback();
	                } catch (SQLException e1) {
	                    // TODO Auto-generated catch block
	                    e1.printStackTrace();
	                }
	        }
	    }
	    public Page getIpandTimePage(int pageNumber) {
	        Page p = new Page();
	        p.setPageNumber(pageNumber);
	        int pageSize = 7;
	        int totalCount = 0;
	        try {
	            totalCount = iDao.selectIpandTimeCount();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        p.SetPageSizeAndTotalCount(pageSize, totalCount);
	        List list=null;
	        try {
	            list = iDao.selectIpandTimeList( pageNumber, pageSize);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        p.setList(list);
	        return p;
	    }
}
