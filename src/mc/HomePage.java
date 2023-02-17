package mc;

import com.k33ptoo.components.KButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import org.netbeans.lib.awtextra.AbsoluteLayout;

import keeptoo.KGradientPanel;

public class HomePage extends JFrame implements MouseInputListener{
    KGradientPanel pan;
    JLabel label5, a, label6, label7, b;
    KButton adPan;
    int x, y, xx, yy;

    public HomePage() {
        initComponents();
    }
                         
    private void initComponents() {
        BackgroundImage = new JLabel();
        homePageBG = new JPanel();
        //jButton1 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setLayout(new AbsoluteLayout());

        homePageBG.setPreferredSize(new java.awt.Dimension(1000, 650));
        homePageBG.setLayout(null);

        pan = new KGradientPanel();
        pan.setkEndColor(new Color(0x34495E));
        pan.setkStartColor(new Color(0x17202A));
        pan.setkGradientFocus(0);
        pan.setSize(1000, 27);
        pan.setLayout(null);
        
        pan.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panMouseDragged(evt);
            }
        });

        pan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panMousePressed(evt);
            }
        });

        label5 = new JLabel();
        label5.setBounds(5, 6, 15, 15);
        ImageIcon icon5 = new ImageIcon("src/mc/assests/cross.png");
        Image img5 = icon5.getImage();
        Image imgScale5 = img5.getScaledInstance(label5.getWidth(), label5.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon5 = new ImageIcon(imgScale5);
        label5.setIcon(scaledIcon5);
        label5.addMouseListener(this);
        pan.add(label5);
        
        a = new JLabel();
        a.setBounds(5, 6, 15, 15);
        ImageIcon icon9 = new ImageIcon("src/mc/assests/cross1.png");
        Image img9 = icon9.getImage();
        Image imgScale9 = img9.getScaledInstance(a.getWidth(), a.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon9 = new ImageIcon(imgScale9);
        a.setIcon(scaledIcon9);
        a.addMouseListener(this);
        pan.add(a);
        
        label6 = new JLabel();
        label6.setBounds(25, 6, 15, 15);
        label6.addMouseListener(this);
        ImageIcon icon6 = new ImageIcon("src/mc/assests/expand.png");
        Image img6 = icon6.getImage();
        Image imgScale6 = img6.getScaledInstance(label6.getWidth(), label6.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon6 = new ImageIcon(imgScale6);
        label6.setIcon(scaledIcon6);
        pan.add(label6);
        
        label7 = new JLabel();
        label7.setBounds(45, 6, 15, 15);
        label7.addMouseListener(this);
        ImageIcon icon7 = new ImageIcon("src/mc/assests/minus.png");
        Image img7 = icon7.getImage();
        Image imgScale7 = img7.getScaledInstance(label7.getWidth(), label7.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon7 = new ImageIcon(imgScale7);
        label7.setIcon(scaledIcon7);
        pan.add(label7);
        
        b = new JLabel();
        b.setBounds(45, 6, 15, 15);
        b.addMouseListener(this);
        ImageIcon icon8 = new ImageIcon("src/mc/assests/minus1.png");
        Image img8 = icon8.getImage();
        Image imgScale8 = img8.getScaledInstance(b.getWidth(), b.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon8 = new ImageIcon(imgScale8);
        b.setIcon(scaledIcon8);
        pan.add(b);
        homePageBG.add(pan);

        logo = new JLabel();
        logo.setBounds(50, 59, 156, 80);
        logo.setIcon(new ImageIcon("src/mc/assests/logo.png"));
        homePageBG.add(logo);

        hi = new JLabel();
        hi.setText("Hi,");
        hi.setFont(new Font("Open Sans", Font.BOLD, 35));
        hi.setBounds(370, 240, 50, 40);
        hi.setForeground(Color.white);
        homePageBG.add(hi);

        youare = new JLabel();
        youare.setText("you are???");
        youare.setFont(new Font("Open Sans", Font.PLAIN, 35));
        youare.setBounds(415, 280, 170, 50);
        youare.setForeground(Color.white);
        homePageBG.add(youare);

        ImageIcon student = new ImageIcon("src/mc/assests/studentButton.png");
        studentLabel = new JLabel();
        studentLabel.setBounds(308, 350, 154, 49);
        studentLabel.setIcon(student);
        studentLabel.addMouseListener(this);
        homePageBG.add(studentLabel);

        ImageIcon teacher = new ImageIcon("src/mc/assests/teacherButton.png");
        teacherLabel = new JLabel();
        teacherLabel.setBounds(538, 350, 154, 49);
        teacherLabel.setIcon(teacher);
        teacherLabel.addMouseListener(this);
        homePageBG.add(teacherLabel);
        
        adPan = new KButton();
        adPan.setkHoverForeGround(Color.white);
        adPan.setText("Admin Panel");
        adPan.setBorder(null);
        adPan.setFocusable(false);
        adPan.setFont(new java.awt.Font("Segoe UI", 0, 12));
        adPan.setBounds(875, 605, 108, 23);
        adPan.setkStartColor(new Color(15, 32, 39));
        adPan.setkEndColor(new Color(32, 58, 67));
        adPan.setkBorderRadius(12);
        adPan.setkHoverStartColor(new Color(32, 58, 67));
        adPan.setkHoverEndColor(new Color(15, 32, 39));
        adPan.setkIndicatorThickness(5);
        adPan.addMouseListener(this);
        homePageBG.add(adPan);
        
        BackgroundImage.setIcon(new ImageIcon("src/mc/assests/homepagebg.jpg")); // NOI18N
        BackgroundImage.setPreferredSize(new java.awt.Dimension(1000, 623));
        BackgroundImage.setBounds(0, 27, 1000, 623);
        homePageBG.add(BackgroundImage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homePageBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homePageBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>                        
    
    private void panMousePressed(java.awt.event.MouseEvent evt) {                                      
        xx = evt.getX();
        yy = evt.getY();
    }   

    private void panMouseDragged(java.awt.event.MouseEvent evt) {                                      
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - yy);
    }  

    public static void main(String[] args) {
        new HomePage().setVisible(true);
    }                                      
                    
    private javax.swing.JLabel BackgroundImage;
    private javax.swing.JPanel homePageBG;
    private javax.swing.JLabel studentLabel;
    private javax.swing.JLabel teacherLabel;
    private javax.swing.JLabel hi;
    private javax.swing.JLabel youare;
    private javax.swing.JLabel logo;

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == studentLabel){
            studentLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            StudentLogIn s = new StudentLogIn();
            s.setLocation(this.getX(), this.getY());
            dispose();
        }
        if(e.getSource() == teacherLabel){
            teacherLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            TeacherLogIn t = new TeacherLogIn();
            t.setLocation(this.getX(), this.getY());
            dispose();
        }
        if(e.getSource() == adPan){
            AdminLogIn ad = new AdminLogIn();
            ad.setVisible(true);
            ad.setLocation(this.getX(), this.getY());
            dispose();
        }
        if(e.getSource() == a) {
			System.exit(0);
		}
		if(e.getSource() == b) {
			this.setState(this.ICONIFIED);
		}
    }

    @Override
    public void mousePressed(MouseEvent e) {  
    }

    @Override
    public void mouseReleased(MouseEvent e) {  
    }

    @Override
    public void mouseEntered(MouseEvent e) {  
        if(e.getSource() == studentLabel){
            studentLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        if(e.getSource() == teacherLabel){
            teacherLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        if(e.getSource() == label5) {
			label5.setVisible(false);
			a.setVisible(true);
			a.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		if(e.getSource() == label7) {
			label7.setVisible(false);
			b.setVisible(true);
			b.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == a) {
			a.setVisible(false);
			label5.setVisible(true);
			label5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		if(e.getSource() == b) {
			b.setVisible(false);
			label7.setVisible(true);
			label7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}  
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
