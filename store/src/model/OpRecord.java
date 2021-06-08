package model;

public class OpRecord {
	private String name;
	private String ip;
	private String op;
	private String time;
	
	public String getname() {
		return name;
	}
	public String getip() {
		return ip;
	}
	public String getop() {
		return op;
	}
	public String gettime() {
		return time;
	}
	public void setname(String name) {
		this.name=name;
	}
	public void setip(String ip) {
		this.ip=ip;
	}
	public void setop(String op) {
		this.op=op;
	}
	public void settime(String time) {
		this.time=time;
	}
	public OpRecord(String name,String ip,String op,String time) {
		super();
		this.name=name;
		this.ip=ip;
		this.op=op;
		this.time=time;
	}
	public OpRecord() {
		super();
	}

}
