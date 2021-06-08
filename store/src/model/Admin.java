package model;

public class Admin {
    private int id;
    private String adminname;
    private String password;
    private boolean isvalidate=false;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getadminname() {
        return adminname;
    }
    public void setadminname(String adminname) {
        this.adminname = adminname;
    }
 
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Admin [id=" + id + ", adminname=" + adminname + ", password=" + password + ", isvalidate="
                + isvalidate + "]";
    }
    
    public boolean isIsvalidate() {
        return isvalidate;
    }
    public void setIsvalidate(boolean isvalidate) {
        this.isvalidate = isvalidate;
    }
    public Admin(int id, String adminname, String password, boolean isvalidate) {
        super();
        this.id = id;
        this.adminname = adminname;
        this.password = password;
        this.isvalidate = isvalidate;
    }
    public Admin( String adminname, String password) {
        this.adminname = adminname;
        this.password = password;
        this.isvalidate = false;
    }
    public Admin() {
        super();
    }


}