package mc;

import com.k33ptoo.components.KButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.event.MouseInputListener;

import keeptoo.KGradientPanel;

import javax.swing.*;

public class TeacherLogIn extends JFrame implements MouseInputListener {

    javax.swing.JPanel Background;
    javax.swing.JPanel LeftPanel;
    javax.swing.JPanel RightPanel;
    KGradientPanel TitleBar;
    javax.swing.JLabel Welcome;
    KButton jButton1, kButton4;
    javax.swing.JCheckBox jCheckBox2;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel5;
    javax.swing.JLabel jLabel6;
    javax.swing.JLabel jLabel7;
    javax.swing.JPasswordField jPasswordField1;
    javax.swing.JTextField jTextField1;
    JLabel rightLabel;
    JLabel label5, a, label6, label7, b;
    int x, y, xx, yy;

    TeacherLogIn() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 650);
        this.setUndecorated(true);

        Background = new JPanel();
        Background.setSize(1000, 650);
        Background.setLayout(null);

        TitleBar = new KGradientPanel();
        TitleBar.setkEndColor(new Color(0x34495E));
        TitleBar.setkStartColor(new Color(0x17202A));
        TitleBar.setkGradientFocus(0);
        TitleBar.setLayout(null);
        TitleBar.setBounds(0, 0, 1000, 27);
        TitleBar.setBackground(new java.awt.Color(51, 51, 51));
        TitleBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                TitleBarMouseDragged(evt);
            }
        });
        TitleBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TitleBarMousePressed(evt);
            }
        });

        // start
        label5 = new JLabel();
        label5.setBounds(5, 6, 15, 15);
        ImageIcon icon5 = new ImageIcon("src/mc/assests/cross.png");
        Image img5 = icon5.getImage();
        Image imgScale5 = img5.getScaledInstance(label5.getWidth(), label5.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon5 = new ImageIcon(imgScale5);
        label5.setIcon(scaledIcon5);
        label5.addMouseListener(this);
        TitleBar.add(label5);

        a = new JLabel();
        a.setBounds(5, 6, 15, 15);
        ImageIcon icon9 = new ImageIcon("src/mc/assests/cross1.png");
        Image img9 = icon9.getImage();
        Image imgScale9 = img9.getScaledInstance(a.getWidth(), a.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon9 = new ImageIcon(imgScale9);
        a.setIcon(scaledIcon9);
        a.addMouseListener(this);
        TitleBar.add(a);

        label6 = new JLabel();
        label6.setBounds(25, 6, 15, 15);
        label6.addMouseListener(this);
        ImageIcon icon6 = new ImageIcon("src/mc/assests/expand.png");
        Image img6 = icon6.getImage();
        Image imgScale6 = img6.getScaledInstance(label6.getWidth(), label6.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon6 = new ImageIcon(imgScale6);
        label6.setIcon(scaledIcon6);
        TitleBar.add(label6);

        label7 = new JLabel();
        label7.setBounds(45, 6, 15, 15);
        label7.addMouseListener(this);
        ImageIcon icon7 = new ImageIcon("src/mc/assests/minus.png");
        Image img7 = icon7.getImage();
        Image imgScale7 = img7.getScaledInstance(label7.getWidth(), label7.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon7 = new ImageIcon(imgScale7);
        label7.setIcon(scaledIcon7);
        TitleBar.add(label7);

        b = new JLabel();
        b.setBounds(45, 6, 15, 15);
        b.addMouseListener(this);
        ImageIcon icon8 = new ImageIcon("src/mc/assests/minus1.png");
        Image img8 = icon8.getImage();
        Image imgScale8 = img8.getScaledInstance(b.getWidth(), b.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon8 = new ImageIcon(imgScale8);
        b.setIcon(scaledIcon8);
        TitleBar.add(b);
        // end

        Background.add(TitleBar);

        RightPanel = new JPanel();
        //RightPanel.setBackground(new java.awt.Color(23, 32, 42));
        rightLabel = new JLabel();
        rightLabel.setSize(500, 623);
        rightLabel.setIcon(new ImageIcon("src/mc/assests/rightpanel.png"));
        RightPanel.setSize(500, 623);
        RightPanel.setLayout(null);

        jLabel2 = new JLabel();
        jLabel2.setIcon(new javax.swing.ImageIcon("src/mc/assests/user.png")); // NOI18N
        jLabel2.setBounds(127, 257, 30, 30);

        jTextField1 = new JTextField();
        jTextField1.setBackground(new java.awt.Color(33, 47, 61));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jTextField1.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField1.setBounds(162, 252, 195, 41);
        //jTextField1.add(jLabel2);

        jLabel1 = new JLabel();
        jLabel1.setIcon(new javax.swing.ImageIcon("src/mc/assests/lock.png")); // NOI18N
        jLabel1.setBounds(127, 352, 30, 30);

        jPasswordField1 = new JPasswordField();
        jPasswordField1.setBackground(new java.awt.Color(33, 47, 61));
        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jPasswordField1.setCaretColor(new java.awt.Color(255, 255, 255));
        jPasswordField1.setBounds(162, 347, 195, 41);
        jPasswordField1.setEchoChar('\u25CF');
        //jPasswordField1.add(jLabel1);

        jButton1 = new KButton();
        jButton1.setBorder(null);
        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16));
        jButton1.setkBorderRadius(40);
        jButton1.setText("Sign In");
        jButton1.setAlignmentX(0.5F);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.setBounds(120, 440, 260, 45);
        jButton1.setkEndColor(new java.awt.Color(57, 187, 12));
        jButton1.setkHoverEndColor(new java.awt.Color(105, 247, 39));
        jButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        jButton1.setkHoverStartColor(new java.awt.Color(57, 187, 12));
        jButton1.setkStartColor(new java.awt.Color(105, 247, 39));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setFocusable(false);

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
        kButton4.setBounds(25, 573, 120, 30);
        kButton4.setkForeGround(new java.awt.Color(207, 207, 207));
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });

        jLabel3 = new JLabel();
        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(105, 247, 39));
        jLabel3.setText("User ID");
        jLabel3.setBounds(222, 221, 73, 22);

        jLabel4 = new JLabel();
        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(105, 247, 39));
        jLabel4.setText("Password");
        jLabel4.setBounds(215, 316, 69, 22);

        jLabel5 = new JLabel();
        jLabel5.setIcon(new javax.swing.ImageIcon("src/mc/assests/verified.png")); // NOI18N
        jLabel5.setBounds(213, 121, 70, 70);

        jCheckBox2 = new JCheckBox();
        jCheckBox2.setBackground(new java.awt.Color(23, 32, 42));
        jCheckBox2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(105, 247, 39));
        jCheckBox2.setText("Show Password");
        jCheckBox2.setBorder(null);
        jCheckBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox2.setBounds(190, 406, 130, 21);
        jCheckBox2.setFocusable(false);
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        RightPanel.add(jTextField1);
        RightPanel.add(jPasswordField1);
        RightPanel.add(jButton1);
        RightPanel.add(jLabel2);
        RightPanel.add(jLabel1);
        RightPanel.add(jLabel3);
        RightPanel.add(jLabel4);
        RightPanel.add(jLabel5);
        RightPanel.add(jCheckBox2);
        RightPanel.add(rightLabel);
        RightPanel.setLocation(500, 27);

        Background.add(RightPanel);

        LeftPanel = new JPanel();
        LeftPanel.setBackground(new java.awt.Color(33, 47, 61));
        LeftPanel.setSize(500, 623);
        LeftPanel.setLayout(null);

        jLabel6 = new JLabel();
        jLabel6.setIcon(new javax.swing.ImageIcon("src/mc/assests/logo1.png")); // NOI18N
        jLabel6.setBounds(50, 32, 156, 80);

        Welcome = new JLabel();
        Welcome.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        Welcome.setForeground(new java.awt.Color(105, 247, 39));
        Welcome.setText("welcome to QuizHub.");
        Welcome.setBounds(50, 335, 410, 50);

        jLabel7 = new JLabel();
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(105, 247, 39));
        jLabel7.setText("Hello there,");
        jLabel7.setBounds(50, 282, 205, 54);

        LeftPanel.add(jLabel6);
        LeftPanel.add(Welcome);
        LeftPanel.add(jLabel7);
        LeftPanel.add(kButton4);
        LeftPanel.setLocation(0, 27);

        Background.add(LeftPanel);

        this.add(Background);
        //this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void TitleBarMousePressed(java.awt.event.MouseEvent evt) {
        xx = evt.getX();
        yy = evt.getY();
    }

    private void TitleBarMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - yy);
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TeacherDashBoard2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherDashBoard2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherDashBoard2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherDashBoard2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        new TeacherLogIn().setVisible(true);
    }
    
    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt){
        if(jCheckBox2.isSelected()) jPasswordField1.setEchoChar((char)0);
        else jPasswordField1.setEchoChar('\u25CF');
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
            Statement st = con.createStatement();
            String query = "select * from teacher where id='" + jTextField1.getText() + "' and password='" + jPasswordField1.getText().toString() + "'";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                String id = rs.getNString("id");
                String name = rs.getNString("name");
                String dept = rs.getString("department");
                String email = rs.getNString("email");
                TeacherDashBoard2 t = new TeacherDashBoard2(id, name, dept, email);
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

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        HomePage hm = new HomePage();
        hm.setVisible(true);
        hm.setLocation(this.getX(), this.getY());
        dispose();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == a) {
            System.exit(0);
        }
        if (e.getSource() == b) {
            this.setState(this.ICONIFIED);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == label5) {
            label5.setVisible(false);
            a.setVisible(true);
            a.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() == label7) {
            label7.setVisible(false);
            b.setVisible(true);
            b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == a) {
            a.setVisible(false);
            label5.setVisible(true);
            label5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() == b) {
            b.setVisible(false);
            label7.setVisible(true);
            label7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
