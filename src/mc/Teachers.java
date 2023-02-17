/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mc;

/**
 *
 * @author ASUS
 */
class Teachers {
    private String name, id, dept, address, phone;
    
    public Teachers(String name, String id, String dept, String address, String phone){
        this.name = name;
        this.id = id;
        this.dept = dept;
        this.address = address;
        this.phone = phone;
    }
    
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
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