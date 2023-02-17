/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mc;

/**
 *
 * @author ASUS
 */
class Students {
    private String name, reg, dept, address, phone;
    
    public Students(String name, String reg, String dept, String address, String phone){
        this.name = name;
        this.reg = reg;
        this.dept = dept;
        this.address = address;
        this.phone = phone;
    }
    
    public String getName() {
        return name;
    }

    public String getReg() {
        return reg;
    }

    public String getDept() {
        return dept;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
    
}