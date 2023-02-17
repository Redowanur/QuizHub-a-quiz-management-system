/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mc;

/**
 *
 * @author ASUS
 */
public class Questions {
    private String q_no, ques, op1, op2, op3, op4, correct;
    
    public Questions(String q_no, String ques, String op1, String op2, String op3, String op4, String correct){
        this.q_no = q_no;
        this.ques = ques;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
        this.correct = correct;
    }
    
    public String getQ_no() {
        return q_no;
    }

    public String getQues() {
        return ques;
    }

    public String getOp1() {
        return op1;
    }

    public String getOp2() {
        return op2;
    }

    public String getOp3() {
        return op3;
    }

    public String getOp4() {
        return op4;
    }

    public String getCorrect() {
        return correct;
    }
    
}
