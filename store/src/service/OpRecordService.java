package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.OpRecordDao;
import model.OpRecord;
import model.Page;
import utils.DBUtil;
public class OpRecordService {
	 private OpRecordDao oDao = new OpRecordDao();
	 public void add(OpRecord OpRecord) {
	        Connection con = null;
	        try {
	            con = DBUtil.getConnection();
	            con.setAutoCommit(false);
	            oDao.insertOpRecord(con,OpRecord );
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
	    public Page getOpRecordPage(int pageNumber) {
	        Page p = new Page();
	        p.setPageNumber(pageNumber);
	        int pageSize = 7;
	        int totalCount = 0;
	        try {
	            totalCount = oDao.selectOpRecordCount();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        p.SetPageSizeAndTotalCount(pageSize, totalCount);
	        List list=null;
	        try {
	            list = oDao.selectOpRecordList( pageNumber, pageSize);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        p.setList(list);
	        return p;
	    }
}
