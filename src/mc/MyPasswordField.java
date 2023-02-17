package mc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class MyPasswordField extends JPasswordField {
	private boolean mouseOver = false;
	
    MyPasswordField() {
        JLabel label1 = new JLabel();
        label1.setBounds(0, 10, 20, 20);
        ImageIcon icon1 = new ImageIcon("src/mc/assests/lock1.png");
        Image img1 = icon1.getImage();
        Image imgScale1 = img1.getScaledInstance(label1.getWidth(), label1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(imgScale1);
        label1.setIcon(scaledIcon1);
        
        this.setBounds(100, 420, 200, 40);
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.white);
        this.setCaretColor(Color.white);
        this.setEchoChar('\u25CF');
        this.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        this.setBorder(new EmptyBorder(10, 30, 8, 20));
        this.add(label1);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                mouseOver = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseOver = false;
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        int height = getHeight();
        int width = getWidth();

        if(mouseOver) g2.setColor(new Color(10, 190, 179));
        else g2.setColor(Color.white);
        g2.fillRect(2, height-1, width-4, 1);
        g2.dispose();
    }
    
    
}
