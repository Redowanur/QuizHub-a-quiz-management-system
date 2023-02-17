package mc;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends JLabel{
	MyLabel(){
        this.setSize(180, 20);
        this.setBackground(Color.black);
        this.setForeground(new Color(10, 190, 179));
        this.setFont(new Font("Ginto Nord", Font.PLAIN, 15));
    }
}
