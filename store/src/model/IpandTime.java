package model;

public class IpandTime {
	private String ip;
	private String time;
	private String name;
	private String type;
	private String op;
	
	public String getip() {
		return ip;
	}
	public String getop() {
		return op;
	}
	public String gettime() {
		return time;
	}
	public String getname() {
		return name;
	}
	public String gettype() {
		return type;
	}
	public void setip(String ip) {
		this.ip=ip;
	}
	public void settime(String time) {
		this.time=time;
	}
	public void setname(String name) {
		this.name=name;
	}
	public void settype(String type) {
		this.type=type;
	}
	public void setop(String op) {
		this.op=op;
	}
	public IpandTime(String ip,String time,String name,String type,String op) {
		super();
		this.ip=ip;
		this.time=time;
		this.name=name;
		this.type=type;
		this.op=op;
	}
	public IpandTime() {
		super();
	}
	

}
