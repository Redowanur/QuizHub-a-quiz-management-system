/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mc;

/**
 *
 * @author ASUS
 */
public class Exams1 {
    private String title, id, name, code, time, marks, type, status;

        public Exams1(String title, String name, String id, String marks){
            this.title = title;
            this.name = name;
            this.id = id;
            this.marks = marks;
        }
        
        public Exams1(String title, String id, String marks, String time, String status){
            // 1 means finish
            this.title = title;
            this.id = id;
            this.marks = marks;
            this.time = time;
            this.status = status;
        }

        public Exams1(String title, String id, String name, String code, String time, String marks, String type){
            this.title = title;
            this.id = id;
            this.name = name;
            this.code = code;
            this.time = time;
            this.marks = marks;
            this.type = type;
        }
        
        public Exams1(String title, String id, String marks){
            this.title = title;
            this.id = id;
            this.marks = marks;
        }
        
    public String getStatus() {
        return status;
    }
    
    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getTime() {
        return time;
    }

    public String getMarks() {
        return marks;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }
    
    public String getTitle(){
        return title;
    }
}
