package model;

public class StopTime {
	private String ip;
	private String stoptime;
	private String goodsname;
	
	public String getip() {
		return ip;
	}
	public String getstoptime() {
		return stoptime;
	}
	public String getgoodsname() {
		return goodsname;
	}
	public void setip(String ip) {
		this.ip=ip;
	}
	public void setstoptime(String stoptime) {
		this.stoptime=stoptime;
	}
	public void setgoodsname(String goodsname) {
		this.goodsname=goodsname;
	}
	public StopTime(String ip,String goodsname,String stoptime) {
		super();
		this.ip=ip;
		this.goodsname=goodsname;
		this.stoptime=stoptime;
	}
	public StopTime() {
		super();
	}

}
