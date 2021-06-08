package model;

public class Salesperson {
    private int id;
    private String salespersonname;
    private String password;
    private String phone;
    private String address;
    private boolean isvalidate=false;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getsalespersonname() {
        return salespersonname;
    }
    public void setsalespersonname(String salespersonname) {
        this.salespersonname = salespersonname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Salesperson [id=" + id + ", salespersonname=" + salespersonname + ", password=" + password + ", phone=" + phone + ", address=" + address + ", isvalidate=" + isvalidate + "]";
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
  
    public boolean isIsvalidate() {
        return isvalidate;
    }
    public void setIsvalidate(boolean isvalidate) {
        this.isvalidate = isvalidate;
    }
    public Salesperson(int id, String salespersonname, String password, String phone, String address,
                boolean isvalidate) {
        super();
        this.id = id;
        this.salespersonname = salespersonname;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.isvalidate = isvalidate;
    }
    public Salesperson( String salespersonname, String password, String phone, String address) {
        this.salespersonname = salespersonname;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.isvalidate = false;
    }
    public Salesperson() {
        super();
    }


}
