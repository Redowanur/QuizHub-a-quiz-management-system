package mc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Cursor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.k33ptoo.components.KButton;
import java.sql.*;
import javax.swing.JOptionPane;

public class StudentLogIn extends JFrame implements FocusListener, MouseListener, MouseMotionListener {

    MyTextField tField;
    MyPasswordField pField;
    JLabel label3, label4, label5, label6, label7, a, b, enterID, enterPass;
    KButton but1, kButton4;
    JPanel pan;
    Cursor cur;
    int x, y, xx, yy;

    StudentLogIn() {
        cur = new Cursor(Cursor.HAND_CURSOR);

        tField = new MyTextField();
        tField.addFocusListener(this);
        pField = new MyPasswordField();
        pField.addFocusListener(this);
        //button = new MyButton();
        //but = new Button();

        ImageIcon icon1 = new ImageIcon("src/mc/assests/studentSignInBackground.png");
        JLabel label1 = new JLabel();
        label1.setSize(1000, 720);
        label1.setIcon(icon1);

        MyLabel label2 = new MyLabel();
        label2.setText("Welcome to QuizHub");
        label2.setLocation(100, 260);
        label2.setFont(new Font("Provicali", Font.PLAIN, 35));
        label2.setSize(380, 30);

        label3 = new JLabel();
        label3.setBounds(184, 15, 15, 15);
        ImageIcon icon2 = new ImageIcon("src/mc/assests/invisible.png");
        Image img2 = icon2.getImage();
        Image imgScale2 = img2.getScaledInstance(label3.getWidth(), label3.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(imgScale2);
        label3.setIcon(scaledIcon2);
        label3.addMouseListener(this);
        label3.setCursor(cur);
        label3.setVisible(false);

        label4 = new JLabel();
        label4.setBounds(184, 15, 15, 15);
        ImageIcon icon3 = new ImageIcon("src/mc/assests/visible.png");
        Image img3 = icon3.getImage();
        Image imgScale3 = img3.getScaledInstance(label4.getWidth(), label4.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(imgScale3);
        label4.setIcon(scaledIcon3);
        label4.addMouseListener(this);
        label4.setCursor(cur);

        but1 = new KButton();
        but1.setBorder(null);
        but1.setkBorderRadius(30);
        but1.setBounds(100, 490, 100, 35);
        but1.setText("Sign In");
        but1.setkHoverStartColor(new Color(109, 213, 237));
        but1.setkHoverEndColor(new Color(33, 147, 176));
        but1.setkHoverForeGround(Color.white);
        but1.setFont(new Font("Open Sans", Font.BOLD, 13));
        but1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but1ActionPerformed(evt);
            }
        });

        but1.setCursor(cur);

        pan = new JPanel();
        pan.setSize(1000, 27);
        pan.setBackground(new Color(0x17202A));
        pan.setForeground(Color.white);
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

        pField.add(label3);
        pField.add(label4);
        
        enterID = new JLabel();
        enterID.setText("Enter Your ID");
        enterID.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
        enterID.setBounds(100, 300, 200, 40);
        enterID.setForeground(Color.white);
        enterID.setForeground(new Color(10, 190, 179));
        
        enterPass = new JLabel();
        enterPass.setText("Password");
        enterPass.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
        enterPass.setBounds(100, 385, 200, 40);
        enterPass.setForeground(Color.white);
        enterPass.setForeground(new Color(10, 190, 179));
        
        kButton4 = new KButton();
        kButton4.setBorder(null);
        kButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mc/assests/go_back.png"))); // NOI18N
        kButton4.setText("Go Back");
        kButton4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        kButton4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        kButton4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        kButton4.setkBorderRadius(20);
        kButton4.setkEndColor(new java.awt.Color(33, 47, 61));
        kButton4.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton4.setkHoverEndColor(new java.awt.Color(23, 32, 42));
        kButton4.setkHoverForeGround(new java.awt.Color(207, 207, 207));
        kButton4.setkHoverStartColor(new java.awt.Color(33, 47, 61));
        kButton4.setkStartColor(new java.awt.Color(23, 32, 42));
        kButton4.setBounds(25, 598, 120, 30);
        kButton4.setkForeGround(new java.awt.Color(207, 207, 207));
        kButton4.setkSelectedColor(new java.awt.Color(0, 123, 224));
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });
        
        ImageIcon img = new ImageIcon("src/mc/assests/titleBarIcon.png");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 650);
        this.setUndecorated(true);
        this.setLayout(null);
        this.setResizable(false);
        this.setIconImage(img.getImage());
        HomePage h = new HomePage();
        this.setLocation(h.getX(), h.getY());
        this.setVisible(true);
        this.add(pan);
        this.add(tField);
        this.add(pField);
        this.add(enterID);
        this.add(enterPass);
        this.add(but1);
        this.add(kButton4);
        this.add(label2);
        this.add(label1);
    }

    public static void main(String[] args) {
        new StudentLogIn();
    }
    
    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        HomePage hm = new HomePage();
        hm.setVisible(true);
        hm.setLocation(this.getX(), this.getY());
        dispose();
    }
    
    private void panMousePressed(java.awt.event.MouseEvent evt) {
        xx = evt.getX();
        yy = evt.getY();
    }

    private void panMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - yy);
    }

    private void but1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
            Statement st = con.createStatement();
            String query = "select * from student where reg_no='" + tField.getText() + "' and password='" + pField.getText().toString() + "'";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                String id = rs.getNString("reg_no");
                String[] name = rs.getNString("name").split(" ");
                String fullName = rs.getNString("name");
                String dep = rs.getNString("department");
                String session = rs.getNString("session");
                StudentPage t = new StudentPage(id, name[0], fullName, dep, session);
                t.setLocation(this.getX(), this.getY());
                t.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect username and password...");
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == a) {
            System.exit(0);
        }
        if (e.getSource() == b) {
            this.setState(JFrame.ICONIFIED);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == label4) { // visible.png
            label4.setVisible(false);
            label3.setVisible(true);
            pField.setEchoChar((char) 0);
        }
        if (e.getSource() == label3) { // invisible.png
            label3.setVisible(false);
            label4.setVisible(true);
            pField.setEchoChar('\u25CF');
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == label5) {
            label5.setVisible(false);
            a.setVisible(true);
            a.setCursor(cur);
        }
        if (e.getSource() == label7) {
            label7.setVisible(false);
            b.setVisible(true);
            b.setCursor(cur);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == a) {
            a.setVisible(false);
            label5.setVisible(true);
            label5.setCursor(cur);
        }
        if (e.getSource() == b) {
            b.setVisible(false);
            label7.setVisible(true);
            label7.setCursor(cur);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
