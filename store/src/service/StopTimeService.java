package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.StopTimeDao;
import model.StopTime;
import model.Page;
import utils.DBUtil;
public class StopTimeService {
	 private StopTimeDao sDao = new StopTimeDao();
	 public void add(StopTime StopTime) {
	        Connection con = null;
	        try {
	            con = DBUtil.getConnection();
	            con.setAutoCommit(false);
	            sDao.insertStopTime(con,StopTime );
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
	    public Page getStopTimePage(int pageNumber) {
	        Page p = new Page();
	        p.setPageNumber(pageNumber);
	        int pageSize = 7;
	        int totalCount = 0;
	        try {
	            totalCount = sDao.selectStopTimeCount();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        p.SetPageSizeAndTotalCount(pageSize, totalCount);
	        List list=null;
	        try {
	            list = sDao.selectStopTimeList( pageNumber, pageSize);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        p.setList(list);
	        return p;
	    }
}