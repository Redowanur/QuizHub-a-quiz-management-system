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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MyTextField extends JTextField {
	private boolean mouseOver = false;

    MyTextField(){
        JLabel label = new JLabel();
        label.setBounds(0, 10, 20, 20);
        ImageIcon icon2 = new ImageIcon("src/mc/assests/user1.png");
        Image img1 = icon2.getImage();
        Image imgScale = img1.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        label.setIcon(scaledIcon);
        
        this.setBounds(100, 335, 200, 40);
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.white);
        this.setCaretColor(Color.white);
        this.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        this.setBorder(new EmptyBorder(10, 30, 8, 10));
        this.add(label);

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
