package listener;

import java.util.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import utils.Stoptime;
import model.StopTime;
import service.StopTimeService;
public class StoptimeListener implements javax.servlet.http.HttpSessionBindingListener {
	private Stoptime stoptime=new Stoptime();
	private String name;
	private String ip;
	public void setip(String ip) {
		this.ip=ip;
	}
	public void setgoodsname(String name) {
		this.name=name;
	}
	public void valueBound(HttpSessionBindingEvent arg0)
	{
		stoptime.setStart(new Date());
	}
	
	public void valueUnbound(HttpSessionBindingEvent arg0)
	{
		stoptime.conuttime(new Date());
		writetime();
	}
	public void writetime()//写入操作
	{
		String times=stoptime.getTimes();
		StopTime t=new StopTime(ip,name,times);
		StopTimeService sService=new StopTimeService();
		sService.add(t);
	}

	
	
}

