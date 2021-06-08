package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Stoptime {
	private int h=0;
	private int m=0;
	private int s=0;
	private Date start=null;
	private Date end=null;
	private SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	public void setStart(Date start)
	{
		this.start=start;
	
	}
	public void conuttime(Date end)
	{
		this.end=end;
		long howmuch=end.getTime()-start.getTime();//将它和开始时间做差
		h=(int)(howmuch/1000/60/60);//计算小时
		howmuch=howmuch-h*60*60*1000;
		m=(int)(howmuch/1000/60);//计算分钟
		howmuch=howmuch-m*60*1000;
		s=(int)(howmuch/1000);//计算秒
	}
	public int getH()
	{
		return h;
	}
    public int getM()
    {
    	return m;
    }
    public int getS()
    {
    	return s;
    }
    public String getTimes()
	{
		String times=this.h+"小时"+this.m+"分"+this.s+"秒";
		return times;
	}
	
    public String getStart()
	{
		return format.format(start);
	}
	public String getEnd()
	{
		return format.format(end);
	}
}
