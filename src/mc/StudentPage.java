/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author ASUS
 */
class timeDisplay extends Thread {

}

public class StudentPage extends javax.swing.JFrame implements MouseInputListener {

    Timer stopwatch;
    int count = 0;
    int delay = 1000;
    int x, y, xx, yy, q_no, num;
    JLabel label5, a, label6, label7, b;
    int[] arr;

    /**
     * Creates new form StudentPage
     */
    public StudentPage(String p, String q, String fn, String r, String s) {
        initComponents();

        ID.setText(p);
        Name.setText(q);
        FN.setText(fn);
        Department.setText(r);
        Session.setText(s);
        show_chart();
        show_exams();
        show_result();

//        SimpleDateFormat sd = new SimpleDateFormat("dd-mm-yyyy");
//        Date d = new Date();
//        date.setText(sd.format(d));
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
    }

    public ArrayList<Exams1> Examlist() {
        ArrayList<Exams1> examlist = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
            String query = "select * from exam_list where dept = '" + Department.getText() + "' and session = '" + Session.getText() + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            Exams1 exams;
            while (rs.next()) {
                String type;
                if (rs.getInt("question_type") == 0) {
                    type = "MCQ";
                } 
                else if (rs.getInt("question_type") == 1) {
                    type = "T/F";
                } else {
                    type = "Mixed";
                }
                exams = new Exams1(rs.getString("title"), rs.getString("exam_id"), rs.getString("course_teacher"), rs.getString("course_code"), rs.getString("time") + " minutes", rs.getString("marks"), type);
                examlist.add(exams);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return examlist;
    }

    public void show_exams() {
        ArrayList<Exams1> list = Examlist();
        DefaultTableModel model = (DefaultTableModel) UpcomingQuizes.getModel();
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getTitle();
            row[1] = list.get(i).getId();
            row[2] = list.get(i).getName();
            row[3] = list.get(i).getCode();
            row[4] = list.get(i).getTime();
            row[5] = list.get(i).getMarks();
            row[6] = list.get(i).getType();
            model.addRow(row);
        }
    }

    public ArrayList<Exams1> ResultList() {
        ArrayList<Exams1> resultlist = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
            String query = "select * from result where id = '" + ID.getText() + "' and dept = '" + Department.getText() + "' and session = '" + Session.getText() + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            Exams1 exams;
            while (rs.next()) {
                exams = new Exams1(rs.getString("exam_name"), rs.getString("exam_id"), rs.getString("marks"));
                resultlist.add(exams);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return resultlist;
    }

    public void show_result() {
        ArrayList<Exams1> list = ResultList();
        DefaultTableModel model = (DefaultTableModel) ResultTable.getModel();
        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getTitle();
            row[1] = list.get(i).getId();
            row[2] = list.get(i).getMarks();
            model.addRow(row);
        }
    }
    
    public void show_chart(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
            String query = "select exam_id,marks from result where name = '"+FN.getText()+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            
            while(rs.next()){
                dataset.setValue(new Double(rs.getString("marks")), "Marks", rs.getString("exam_id"));
            }
            
            JFreeChart chrt = ChartFactory.createLineChart("Progress Graph", "Exam ID", "Marks", dataset);
            chrt.getTitle().setPaint(Color.red);
            CategoryPlot p = chrt.getCategoryPlot();
            p.setRangeGridlinePaint(Color.blue);
            ChartPanel pan = new ChartPanel(chrt);
            //pan.setSize(600, 300);
            chart.add(pan, BorderLayout.CENTER);
            chart.validate();
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kButton2 = new com.k33ptoo.components.KButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        TitleBar = new keeptoo.KGradientPanel();
        NavigationMenu = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DashBoardButton = new com.k33ptoo.components.KButton();
        QuizesButton = new com.k33ptoo.components.KButton();
        ResultButton = new com.k33ptoo.components.KButton();
        jLabel9 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        DashboardPanel = new keeptoo.KGradientPanel();
        panelRound1 = new roundpanel.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        panelRound3 = new roundpanel.PanelRound();
        IDLabel = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        Department = new javax.swing.JLabel();
        Session = new javax.swing.JLabel();
        SessionLabel = new javax.swing.JLabel();
        DepartmentLabel = new javax.swing.JLabel();
        FN = new javax.swing.JLabel();
        chart = new javax.swing.JPanel();
        QuizPanel = new keeptoo.KGradientPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        UpcomingQuizes = new rojerusan.RSTableMetro();
        StartQuiz = new com.k33ptoo.components.KButton();
        ResultPanel = new keeptoo.KGradientPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ResultTable = new rojerusan.RSTableMetro();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        panelRound2 = new roundpanel.PanelRound();
        jScrollPane2 = new javax.swing.JScrollPane();
        question = new javax.swing.JTextArea();
        op1 = new radio_button.RadioButtonCustom();
        op4 = new radio_button.RadioButtonCustom();
        op3 = new radio_button.RadioButtonCustom();
        op2 = new radio_button.RadioButtonCustom();
        op5 = new radio_button.RadioButtonCustom();
        but1 = new com.k33ptoo.components.KButton();
        but2 = new com.k33ptoo.components.KButton();
        but3 = new com.k33ptoo.components.KButton();
        qNo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        min = new javax.swing.JLabel();
        sec = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        mrk = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Ok = new com.k33ptoo.components.KButton();
        message = new javax.swing.JLabel();

        kButton2.setText("kButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(null);

        TitleBar.setkEndColor(new java.awt.Color(52, 73, 94));
        TitleBar.setkGradientFocus(0);
        TitleBar.setkStartColor(new java.awt.Color(23, 32, 42));
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

        javax.swing.GroupLayout TitleBarLayout = new javax.swing.GroupLayout(TitleBar);
        TitleBar.setLayout(TitleBarLayout);
        TitleBarLayout.setHorizontalGroup(
            TitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        TitleBarLayout.setVerticalGroup(
            TitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jPanel1.add(TitleBar);
        TitleBar.setBounds(0, 0, 1000, 27);

        NavigationMenu.setkEndColor(new java.awt.Color(31, 28, 59));
        NavigationMenu.setkGradientFocus(0);
        NavigationMenu.setkStartColor(new java.awt.Color(31, 28, 59));
        NavigationMenu.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mc/assests/home.png"))); // NOI18N
        jLabel2.setText("  Dashboard");
        NavigationMenu.add(jLabel2);
        jLabel2.setBounds(31, 170, 110, 20);

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mc/assests/test.png"))); // NOI18N
        jLabel4.setText("     Quizes");
        NavigationMenu.add(jLabel4);
        jLabel4.setBounds(30, 220, 110, 20);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mc/assests/result.png"))); // NOI18N
        jLabel5.setText("     Result");
        NavigationMenu.add(jLabel5);
        jLabel5.setBounds(30, 270, 110, 20);

        DashBoardButton.setBorder(null);
        DashBoardButton.setForeground(new java.awt.Color(254, 159, 86));
        DashBoardButton.setToolTipText("");
        DashBoardButton.setFocusable(false);
        DashBoardButton.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        DashBoardButton.setkBorderRadius(38);
        DashBoardButton.setkEndColor(new java.awt.Color(31, 28, 59));
        DashBoardButton.setkHoverEndColor(new java.awt.Color(60, 50, 88));
        DashBoardButton.setkHoverForeGround(new java.awt.Color(254, 159, 86));
        DashBoardButton.setkHoverStartColor(new java.awt.Color(60, 50, 88));
        DashBoardButton.setkIndicatorThickness(5);
        DashBoardButton.setkPressedColor(new java.awt.Color(229, 231, 233));
        DashBoardButton.setkSelectedColor(new java.awt.Color(50, 255, 0));
        DashBoardButton.setkStartColor(new java.awt.Color(31, 28, 59));
        DashBoardButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashBoardButtonMouseEntered(evt);
            }
        });
        DashBoardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashBoardButtonActionPerformed(evt);
            }
        });
        NavigationMenu.add(DashBoardButton);
        DashBoardButton.setBounds(10, 160, 180, 40);

        QuizesButton.setBorder(null);
        QuizesButton.setToolTipText("");
        QuizesButton.setFocusable(false);
        QuizesButton.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        QuizesButton.setkBorderRadius(38);
        QuizesButton.setkEndColor(new java.awt.Color(31, 28, 59));
        QuizesButton.setkHoverEndColor(new java.awt.Color(60, 50, 88));
        QuizesButton.setkHoverForeGround(new java.awt.Color(254, 159, 86));
        QuizesButton.setkHoverStartColor(new java.awt.Color(60, 50, 88));
        QuizesButton.setkIndicatorThickness(5);
        QuizesButton.setkPressedColor(new java.awt.Color(102, 102, 102));
        QuizesButton.setkSelectedColor(new java.awt.Color(50, 255, 0));
        QuizesButton.setkStartColor(new java.awt.Color(31, 28, 59));
        QuizesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                QuizesButtonMouseEntered(evt);
            }
        });
        QuizesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuizesButtonActionPerformed(evt);
            }
        });
        NavigationMenu.add(QuizesButton);
        QuizesButton.setBounds(10, 210, 180, 40);

        ResultButton.setBorder(null);
        ResultButton.setToolTipText("");
        ResultButton.setFocusable(false);
        ResultButton.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        ResultButton.setkBorderRadius(38);
        ResultButton.setkEndColor(new java.awt.Color(31, 28, 59));
        ResultButton.setkHoverEndColor(new java.awt.Color(60, 50, 88));
        ResultButton.setkHoverForeGround(new java.awt.Color(254, 159, 86));
        ResultButton.setkHoverStartColor(new java.awt.Color(60, 50, 88));
        ResultButton.setkIndicatorThickness(5);
        ResultButton.setkPressedColor(new java.awt.Color(102, 102, 102));
        ResultButton.setkSelectedColor(new java.awt.Color(50, 255, 0));
        ResultButton.setkStartColor(new java.awt.Color(31, 28, 59));
        ResultButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ResultButtonMouseEntered(evt);
            }
        });
        ResultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResultButtonActionPerformed(evt);
            }
        });
        NavigationMenu.add(ResultButton);
        ResultButton.setBounds(10, 260, 180, 40);

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mc/assests/log-out2.png"))); // NOI18N
        jLabel9.setText("Log out");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        NavigationMenu.add(jLabel9);
        jLabel9.setBounds(40, 580, 90, 30);

        jPanel1.add(NavigationMenu);
        NavigationMenu.setBounds(0, 27, 170, 623);

        DashboardPanel.setkEndColor(new java.awt.Color(60, 50, 88));
        DashboardPanel.setkGradientFocus(800);
        DashboardPanel.setkStartColor(new java.awt.Color(60, 50, 88));

        panelRound1.setBackground(new java.awt.Color(237, 137, 62));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundTopRight(30);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome back,");

        Name.setFont(new java.awt.Font("Segoe UI Black", 0, 30)); // NOI18N
        Name.setForeground(new java.awt.Color(255, 255, 255));

        panelRound3.setBackground(new java.awt.Color(254, 159, 86));
        panelRound3.setRoundBottomLeft(30);
        panelRound3.setRoundTopRight(30);

        IDLabel.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        IDLabel.setForeground(new java.awt.Color(255, 255, 255));
        IDLabel.setText("ID:");

        ID.setBackground(new java.awt.Color(255, 255, 255));
        ID.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        ID.setForeground(new java.awt.Color(255, 255, 255));

        Department.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        Department.setForeground(new java.awt.Color(255, 255, 255));

        Session.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        Session.setForeground(new java.awt.Color(255, 255, 255));

        SessionLabel.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        SessionLabel.setForeground(new java.awt.Color(255, 255, 255));
        SessionLabel.setText("Session:");

        DepartmentLabel.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        DepartmentLabel.setForeground(new java.awt.Color(255, 255, 255));
        DepartmentLabel.setText("Department:");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DepartmentLabel)
                    .addComponent(IDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SessionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Department, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Session, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DepartmentLabel)
                    .addComponent(Department, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SessionLabel)
                    .addComponent(Session, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        FN.setVisible(false);
        FN.setText("jLabel12");

        chart.setBackground(new java.awt.Color(255, 255, 255));
        chart.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout DashboardPanelLayout = new javax.swing.GroupLayout(DashboardPanel);
        DashboardPanel.setLayout(DashboardPanelLayout);
        DashboardPanelLayout.setHorizontalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashboardPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(DashboardPanelLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        DashboardPanelLayout.setVerticalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FN)
                .addGap(33, 33, 33)
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", DashboardPanel);

        QuizPanel.setkEndColor(new java.awt.Color(60, 50, 88));
        QuizPanel.setkStartColor(new java.awt.Color(60, 50, 88));

        UpcomingQuizes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Quiz Name", "Exam ID", "Teacher", "Course Code", "Time", "Marks", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        UpcomingQuizes.setColorBackgoundHead(new java.awt.Color(56, 145, 201));
        UpcomingQuizes.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        UpcomingQuizes.setColorBordeHead(new java.awt.Color(255, 255, 255));
        UpcomingQuizes.setColorFilasBackgound2(new java.awt.Color(230, 230, 230));
        UpcomingQuizes.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        UpcomingQuizes.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        UpcomingQuizes.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        UpcomingQuizes.setColorSelBackgound(new java.awt.Color(232, 57, 95));
        UpcomingQuizes.setFocusable(false);
        UpcomingQuizes.setFuenteFilas(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        UpcomingQuizes.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        UpcomingQuizes.setFuenteHead(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        UpcomingQuizes.setGridColor(new java.awt.Color(0, 0, 0));
        UpcomingQuizes.setGrosorBordeFilas(0);
        UpcomingQuizes.setGrosorBordeHead(0);
        UpcomingQuizes.setMultipleSeleccion(false);
        UpcomingQuizes.setName(""); // NOI18N
        UpcomingQuizes.setRowHeight(26);
        UpcomingQuizes.setRowMargin(0);
        UpcomingQuizes.setSelectionBackground(new java.awt.Color(232, 57, 95));
        UpcomingQuizes.setShowGrid(false);
        UpcomingQuizes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpcomingQuizesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(UpcomingQuizes);

        StartQuiz.setBorder(null);
        StartQuiz.setText("Start Quiz");
        StartQuiz.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        StartQuiz.setkBorderRadius(30);
        StartQuiz.setkEndColor(new java.awt.Color(0, 180, 219));
        StartQuiz.setkHoverEndColor(new java.awt.Color(0, 131, 176));
        StartQuiz.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        StartQuiz.setkHoverStartColor(new java.awt.Color(0, 180, 219));
        StartQuiz.setkStartColor(new java.awt.Color(0, 131, 176));
        StartQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartQuizActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout QuizPanelLayout = new javax.swing.GroupLayout(QuizPanel);
        QuizPanel.setLayout(QuizPanelLayout);
        QuizPanelLayout.setHorizontalGroup(
            QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuizPanelLayout.createSequentialGroup()
                .addGroup(QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QuizPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QuizPanelLayout.createSequentialGroup()
                        .addGap(347, 347, 347)
                        .addComponent(StartQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        QuizPanelLayout.setVerticalGroup(
            QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuizPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(StartQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", QuizPanel);

        ResultPanel.setkEndColor(new java.awt.Color(60, 50, 88));
        ResultPanel.setkStartColor(new java.awt.Color(60, 50, 88));

        ResultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Exam Name", "Exam ID", "Marks"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ResultTable.setColorBackgoundHead(new java.awt.Color(32, 136, 203));
        ResultTable.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        ResultTable.setColorBordeHead(new java.awt.Color(255, 255, 255));
        ResultTable.setColorFilasBackgound2(new java.awt.Color(230, 230, 230));
        ResultTable.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        ResultTable.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        ResultTable.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        ResultTable.setColorSelBackgound(new java.awt.Color(232, 57, 95));
        ResultTable.setFocusable(false);
        ResultTable.setFuenteFilas(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        ResultTable.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        ResultTable.setFuenteHead(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ResultTable.setGridColor(new java.awt.Color(0, 0, 0));
        ResultTable.setGrosorBordeFilas(0);
        ResultTable.setGrosorBordeHead(0);
        ResultTable.setMultipleSeleccion(false);
        ResultTable.setName(""); // NOI18N
        ResultTable.setRowHeight(26);
        ResultTable.setRowMargin(0);
        ResultTable.setSelectionBackground(new java.awt.Color(232, 57, 95));
        ResultTable.setShowGrid(false);
        jScrollPane4.setViewportView(ResultTable);

        javax.swing.GroupLayout ResultPanelLayout = new javax.swing.GroupLayout(ResultPanel);
        ResultPanel.setLayout(ResultPanelLayout);
        ResultPanelLayout.setHorizontalGroup(
            ResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ResultPanelLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        ResultPanelLayout.setVerticalGroup(
            ResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ResultPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(229, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", ResultPanel);

        kGradientPanel1.setkEndColor(new java.awt.Color(60, 50, 88));
        kGradientPanel1.setkStartColor(new java.awt.Color(60, 50, 88));

        panelRound2.setBackground(new java.awt.Color(77, 66, 109));
        panelRound2.setRoundBottomLeft(30);
        panelRound2.setRoundBottomRight(30);
        panelRound2.setRoundTopLeft(30);
        panelRound2.setRoundTopRight(30);
        panelRound2.setLayout(null);

        jScrollPane2.setBackground(new java.awt.Color(77, 66, 109));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));

        question.setEditable(false);
        question.setBackground(new java.awt.Color(77, 66, 109));
        question.setColumns(20);
        question.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        question.setForeground(new java.awt.Color(255, 255, 255));
        question.setLineWrap(true);
        question.setRows(5);
        question.setSelectionColor(new java.awt.Color(255, 51, 153));
        jScrollPane2.setViewportView(question);

        panelRound2.add(jScrollPane2);
        jScrollPane2.setBounds(20, 23, 577, 118);

        op1.setBackground(new java.awt.Color(237, 137, 62));
        buttonGroup1.add(op1);
        op1.setForeground(new java.awt.Color(255, 255, 255));
        op1.setText("Option1");
        op1.setFocusable(false);
        op1.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        op1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op1ActionPerformed(evt);
            }
        });
        panelRound2.add(op1);
        op1.setBounds(20, 160, 577, 29);

        op4.setBackground(new java.awt.Color(237, 137, 62));
        buttonGroup1.add(op4);
        op4.setForeground(new java.awt.Color(255, 255, 255));
        op4.setText("Option4");
        op4.setFocusable(false);
        op4.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        op4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op4ActionPerformed(evt);
            }
        });
        panelRound2.add(op4);
        op4.setBounds(20, 353, 577, 29);

        op3.setBackground(new java.awt.Color(237, 137, 62));
        buttonGroup1.add(op3);
        op3.setForeground(new java.awt.Color(255, 255, 255));
        op3.setText("Option3");
        op3.setFocusable(false);
        op3.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        op3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op3ActionPerformed(evt);
            }
        });
        panelRound2.add(op3);
        op3.setBounds(20, 289, 577, 29);

        op2.setBackground(new java.awt.Color(237, 137, 62));
        buttonGroup1.add(op2);
        op2.setForeground(new java.awt.Color(255, 255, 255));
        op2.setText("Option2");
        op2.setFocusable(false);
        op2.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        op2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op2ActionPerformed(evt);
            }
        });
        panelRound2.add(op2);
        op2.setBounds(20, 224, 577, 29);

        op5.setVisible(false);
        buttonGroup1.add(op5);
        panelRound2.add(op5);
        op5.setBounds(20, 320, 30, 21);

        but1.setBorder(null);
        but1.setText("Previous");
        but1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        but1.setkBorderRadius(30);
        but1.setkEndColor(new java.awt.Color(77, 66, 109));
        but1.setkHoverEndColor(new java.awt.Color(45, 41, 92));
        but1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        but1.setkHoverStartColor(new java.awt.Color(45, 41, 92));
        but1.setkStartColor(new java.awt.Color(77, 66, 109));
        but1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but1ActionPerformed(evt);
            }
        });

        but2.setBorder(null);
        but2.setText("Next");
        but2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        but2.setkBorderRadius(30);
        but2.setkEndColor(new java.awt.Color(77, 66, 109));
        but2.setkHoverEndColor(new java.awt.Color(45, 41, 92));
        but2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        but2.setkHoverStartColor(new java.awt.Color(45, 41, 92));
        but2.setkStartColor(new java.awt.Color(77, 66, 109));
        but2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but2ActionPerformed(evt);
            }
        });

        but3.setBorder(null);
        but3.setText("Submit");
        but3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        but3.setkBorderRadius(30);
        but3.setkEndColor(new java.awt.Color(77, 66, 109));
        but3.setkHoverEndColor(new java.awt.Color(45, 41, 92));
        but3.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        but3.setkHoverStartColor(new java.awt.Color(45, 41, 92));
        but3.setkStartColor(new java.awt.Color(77, 66, 109));
        but3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but3ActionPerformed(evt);
            }
        });

        qNo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        qNo.setForeground(new java.awt.Color(255, 255, 255));
        qNo.setText("10");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Question:");

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("minutes");

        min.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        min.setForeground(new java.awt.Color(255, 255, 255));
        min.setText("10");

        sec.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        sec.setForeground(new java.awt.Color(255, 255, 255));
        sec.setText("10");

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("seconds");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(but1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(but2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(307, 307, 307)
                        .addComponent(but3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qNo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(min)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(sec)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)))
                .addGap(43, 43, 43))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(min, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(qNo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sec, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(but1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("tab6", kGradientPanel1);

        jPanel3.setBackground(new java.awt.Color(60, 50, 88));

        mrk.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        mrk.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("You have got ");

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("marks.");

        Ok.setBorder(null);
        Ok.setText("Ok");
        Ok.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Ok.setkBorderRadius(30);
        Ok.setkEndColor(new java.awt.Color(77, 66, 109));
        Ok.setkHoverEndColor(new java.awt.Color(45, 41, 92));
        Ok.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        Ok.setkHoverStartColor(new java.awt.Color(45, 41, 92));
        Ok.setkStartColor(new java.awt.Color(77, 66, 109));
        Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkActionPerformed(evt);
            }
        });

        message.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        message.setForeground(new java.awt.Color(255, 255, 255));
        message.setText("You have got ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mrk, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)))
                .addContainerGap(235, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mrk, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
                .addComponent(Ok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        jTabbedPane1.addTab("tab8", jPanel3);

        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(170, -2, 830, 650);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TitleBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TitleBarMouseDragged
        x = evt.getXOnScreen();
        y = evt.getYOnScreen();
        this.setLocation(x - xx, y - yy);
    }//GEN-LAST:event_TitleBarMouseDragged

    private void TitleBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TitleBarMousePressed
        xx = evt.getX();
        yy = evt.getY();
    }//GEN-LAST:event_TitleBarMousePressed

    private void DashBoardButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashBoardButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DashBoardButtonMouseEntered

    private void DashBoardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashBoardButtonActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_DashBoardButtonActionPerformed

    private void QuizesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QuizesButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_QuizesButtonMouseEntered

    private void QuizesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuizesButtonActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_QuizesButtonActionPerformed

    private void ResultButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ResultButtonMouseEntered

    private void ResultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResultButtonActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_ResultButtonActionPerformed

    public void initAnswer(int n) {
        num = n;
        arr = new int[num];
        for (int i = 1; i < num; i++) {
            arr[i] = 9;
        }
    }

    public void startTimer(int countPassed) {
        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (count == 0) {
                    stopwatch.stop();
                    try {
                        int row = UpcomingQuizes.getSelectedRow();
                        String xmid = UpcomingQuizes.getModel().getValueAt(row, 1).toString();
                        String xname = UpcomingQuizes.getModel().getValueAt(row, 0).toString();
                        String marks = UpcomingQuizes.getModel().getValueAt(row, 5).toString();
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
                        Statement st = con.createStatement();
                        String query = "select correct_ans from quiz_questions where exam_id='" + xmid + "'";
                        ResultSet rs = st.executeQuery(query);
                        int i = 1, m = 0;
                        while (rs.next()) {
                            String str = rs.getString("correct_ans");
                            if (str.equals("A") && arr[i] == 1) {
                                m++;
                            } else if (str.equals("B") && arr[i] == 2) {
                                m++;
                            } else if (str.equals("C") && arr[i] == 3) {
                                m++;
                            } else if (str.equals("D") && arr[i] == 4) {
                                m++;
                            }
                            i++;
                        }
                        mrk.setText(Integer.toString(m));
                        jTabbedPane1.setSelectedIndex(4);
                        double a = (double) Integer.parseInt(marks);
                        double b = (m / a) * 100.0;
                        if (b >= 80) {
                            message.setText("Excellent!!");
                        } else if (b >= 60) {
                            message.setText("Great!!");
                        } else if (b >= 40) {
                            message.setText("Study regularly");
                        } else {
                            message.setText("Study harder");
                        }

                        String query2 = "insert into result values('" + xmid + "', '" + xname + "', '" + FN.getText() + "', '" + ID.getText() + "', '" + Department.getText() + "', '" + Session.getText() + "', '" + Integer.toString(m) + "')";
                        st.executeUpdate(query2);
                        DefaultTableModel model = (DefaultTableModel) ResultTable.getModel();
                        Vector<String> vec = new Vector<String>();
                        vec.add(xname);
                        vec.add(xmid);
                        vec.add(Integer.toString(m));
                        model.addRow(vec);
                        con.close();
                    } catch (ClassNotFoundException | SQLException ex) {
                        ex.printStackTrace();
                    }

                } else {
                    sec.setText(Integer.toString(count % 60));
                    min.setText(Integer.toString(count / 60));
                    count--;
                }
            }
        };
        stopwatch = new Timer(delay, action);
        stopwatch.setInitialDelay(0);
        stopwatch.start();
        count = countPassed;
    }

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        int val = JOptionPane.showConfirmDialog(null, "Do you want to Log out?");
        if (val == 0) {
            HomePage hp = new HomePage();
            hp.setVisible(true);
            hp.setLocation(this.getX(), this.getY());
            dispose();
        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_OkActionPerformed

    private void but3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but3ActionPerformed
        int n = JOptionPane.showConfirmDialog(null, "Do you want to submit?");
        if (n == 0) {
            try {
                int row = UpcomingQuizes.getSelectedRow();
                String xmid = UpcomingQuizes.getModel().getValueAt(row, 1).toString();
                String xname = UpcomingQuizes.getModel().getValueAt(row, 0).toString();
                String marks = UpcomingQuizes.getModel().getValueAt(row, 5).toString();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
                Statement st = con.createStatement();
                String query = "select correct_ans from quiz_questions where exam_id='" + xmid + "'";
                ResultSet rs = st.executeQuery(query);
                int i = 1, m = 0;
                while (rs.next()) {
                    String str = rs.getString("correct_ans");
                    if (str.equals("A") && arr[i] == 1) {
                        m++;
                    } else if (str.equals("B") && arr[i] == 2) {
                        m++;
                    } else if (str.equals("C") && arr[i] == 3) {
                        m++;
                    } else if (str.equals("D") && arr[i] == 4) {
                        m++;
                    }
                    i++;
                }
                mrk.setText(" " + Integer.toString(m));
                jTabbedPane1.setSelectedIndex(4);
                double a = (double) Integer.parseInt(marks);
                double b = (m / a) * 100.0;
                if (b >= 80) {
                    message.setText("Excellent!!");
                } else if (b >= 60) {
                    message.setText("Great!!");
                } else if (b >= 40) {
                    message.setText("Study regularly");
                } else {
                    message.setText("Study harder");
                }

                String query2 = "insert into result values('" + xmid + "', '" + xname + "', '" + FN.getText() + "', '" + ID.getText() + "', '" + Department.getText() + "', '" + Session.getText() + "', '" + Integer.toString(m) + "')";
                st.executeUpdate(query2);
                DefaultTableModel model = (DefaultTableModel) ResultTable.getModel();
                Vector<String> vec = new Vector<String>();
                vec.add(xname);
                vec.add(xmid);
                vec.add(Integer.toString(m));
                model.addRow(vec);
                con.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_but3ActionPerformed

    private void but2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but2ActionPerformed
        try {
            int row = UpcomingQuizes.getSelectedRow();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
            Statement st = con.createStatement();
            String query = "select * from quiz_questions where exam_id = '" + UpcomingQuizes.getModel().getValueAt(row, 1).toString() + "' and question_no = '" + Integer.toString(++q_no) + "'";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                if (arr[q_no] == 9 && (op1.isSelected() || op2.isSelected() || op3.isSelected() || op4.isSelected())) {
                    // unanswered
                    op5.setSelected(true);
                } else if (arr[q_no] == 1) {
                    op1.setSelected(true);
                } else if (arr[q_no] == 2) {
                    op2.setSelected(true);
                } else if (arr[q_no] == 3) {
                    op3.setSelected(true);
                } else if (arr[q_no] == 4) {
                    op4.setSelected(true);
                }
                but1.setEnabled(true);

                if (rs.getString("correct_ans").equals("0") || rs.getString("correct_ans").equals("1")) {
                    // true false
                    //System.out.println("I am inside tf and next button.");
                    
                    qNo.setText(Integer.toString(q_no));
                    question.setText(rs.getString("question"));
                    op1.setText("True");
                    op2.setText("False");
                    op3.setVisible(false);
                    op4.setVisible(false);
                } else {
                    // mcq
                    //System.out.println("I am inside mcq and next button.");
                    
                    qNo.setText(Integer.toString(q_no));
                    op3.setVisible(true);
                    op4.setVisible(true);
                    question.setText(rs.getNString("question"));
                    op1.setText(rs.getString("option1"));
                    op2.setText(rs.getNString("option2"));
                    op3.setText(rs.getNString("option3"));
                    op4.setText(rs.getNString("option4"));
                }
            } else {
                but2.setEnabled(false);
                but3.setVisible(true);
                --q_no;
            }
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_but2ActionPerformed

    private void but1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but1ActionPerformed
        if (q_no == 1) {
            but1.setEnabled(false);
            return;
        }
        but2.setEnabled(true);
        but3.setVisible(false);
        try {
            int row = UpcomingQuizes.getSelectedRow();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
            Statement st = con.createStatement();
            String query = "select * from quiz_questions where exam_id = '" + UpcomingQuizes.getModel().getValueAt(row, 1).toString() + "' and question_no = '" + Integer.toString(--q_no) + "'";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                if (arr[q_no] == 9 && (op1.isSelected() || op2.isSelected() || op3.isSelected() || op4.isSelected())) {
                    // unanswered
                    op5.setSelected(true);
                } else if (arr[q_no] == 1) {
                    op1.setSelected(true);
                } else if (arr[q_no] == 2) {
                    op2.setSelected(true);
                } else if (arr[q_no] == 3) {
                    op3.setSelected(true);
                } else if (arr[q_no] == 4) {
                    op4.setSelected(true);
                }
                if (rs.getString("correct_ans").equals("0") || rs.getString("correct_ans").equals("1")) {
                    // true false
                    //System.out.println("I am inside tf and prev button.");
                    //jTabbedPane1.setSelectedIndex(5);
                    qNo.setText(Integer.toString(q_no));
                    question.setText(rs.getString("question"));
                    op1.setText("True");
                    op2.setText("False");
                    op3.setVisible(false);
                    op4.setVisible(false);
                } else {
                    // mcq
                    //System.out.println("I am inside mcq and prev button.");
                    //jTabbedPane1.setSelectedIndex(5);
                    qNo.setText(Integer.toString(q_no));
                    op3.setVisible(true);
                    op4.setVisible(true);
                    question.setText(rs.getNString("question"));
                    op1.setText(rs.getString("option1"));
                    op2.setText(rs.getNString("option2"));
                    op3.setText(rs.getNString("option3"));
                    op4.setText(rs.getNString("option4"));
                }
            }
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_but1ActionPerformed

    private void op2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op2ActionPerformed
        arr[q_no] = 2;
    }//GEN-LAST:event_op2ActionPerformed

    private void op3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op3ActionPerformed
        arr[q_no] = 3;
    }//GEN-LAST:event_op3ActionPerformed

    private void op4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op4ActionPerformed
        arr[q_no] = 4;
    }//GEN-LAST:event_op4ActionPerformed

    private void op1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op1ActionPerformed
        arr[q_no] = 1;
    }//GEN-LAST:event_op1ActionPerformed

    private void StartQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartQuizActionPerformed
        int row = UpcomingQuizes.getSelectedRow();
        String xmid = UpcomingQuizes.getModel().getValueAt(row, 1).toString();
        String tm = UpcomingQuizes.getModel().getValueAt(row, 4).toString();
        String tim[] = tm.split(" ");
        if (row == -1)
        JOptionPane.showMessageDialog(null, "Select a quiz to participate");
        else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
                Statement st = con.createStatement();
                String query = "select * from result where exam_id='" + xmid + "' and id = '" + ID.getText() + "' and dept = '" + Department.getText() + "' and session = '" + Session.getText() + "'";
                String query1 = "select * from exam_list where exam_id = '" + xmid + "' and isOver = '" + 1 + "'";
                ResultSet rs1 = st.executeQuery(query1);
                if (rs1.next()) {
                    JOptionPane.showMessageDialog(null, "The quiz is finished.");
                    return;
                }
                ResultSet rs = st.executeQuery(query);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "You have already participated in this quiz.");
                    return;
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

            op5.setSelected(true);

            try {
                startTimer(Integer.parseInt(tim[0]) * 60);
                //startTimer(2*60);
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
                Statement st = con.createStatement();
                String query = "select * from quiz_questions where exam_id='" + xmid + "' and question_no = '" + 1 + "'";
                ResultSet rs = st.executeQuery(query);
                but3.setVisible(false);
                if (rs.next()) {
                    initAnswer(Integer.parseInt(UpcomingQuizes.getModel().getValueAt(row, 5).toString()) + 1);
                    q_no = 1;
                    but2.setEnabled(true);
                    but1.setEnabled(true);
                    if (rs.getString("correct_ans").equals("0") || rs.getString("correct_ans").equals("1")) {
                        // true false
                        jTabbedPane1.setSelectedIndex(3);
                        qNo.setText("1");
                        question.setText(rs.getString("question"));
                        op1.setText("True");
                        op2.setText("False");
                        op3.setVisible(false);
                        op4.setVisible(false);
                    } else {
                        // mcq
                        jTabbedPane1.setSelectedIndex(3);
                        qNo.setText("1");
                        op3.setVisible(true);
                        op4.setVisible(true);
                        question.setText(rs.getNString("question"));
                        op1.setText(rs.getString("option1"));
                        op2.setText(rs.getNString("option2"));
                        op3.setText(rs.getNString("option3"));
                        op4.setText(rs.getNString("option4"));
                    }
                }
                con.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_StartQuizActionPerformed

    private void UpcomingQuizesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpcomingQuizesMouseClicked

    }//GEN-LAST:event_UpcomingQuizesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentPage(null, null, null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton DashBoardButton;
    private keeptoo.KGradientPanel DashboardPanel;
    private javax.swing.JLabel Department;
    private javax.swing.JLabel DepartmentLabel;
    private javax.swing.JLabel FN;
    private javax.swing.JLabel ID;
    private javax.swing.JLabel IDLabel;
    private javax.swing.JLabel Name;
    private keeptoo.KGradientPanel NavigationMenu;
    private com.k33ptoo.components.KButton Ok;
    private keeptoo.KGradientPanel QuizPanel;
    private com.k33ptoo.components.KButton QuizesButton;
    private com.k33ptoo.components.KButton ResultButton;
    private keeptoo.KGradientPanel ResultPanel;
    private rojerusan.RSTableMetro ResultTable;
    private javax.swing.JLabel Session;
    private javax.swing.JLabel SessionLabel;
    private com.k33ptoo.components.KButton StartQuiz;
    private keeptoo.KGradientPanel TitleBar;
    private rojerusan.RSTableMetro UpcomingQuizes;
    private com.k33ptoo.components.KButton but1;
    private com.k33ptoo.components.KButton but2;
    private com.k33ptoo.components.KButton but3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel chart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.k33ptoo.components.KButton kButton2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel message;
    private javax.swing.JLabel min;
    private javax.swing.JLabel mrk;
    private radio_button.RadioButtonCustom op1;
    private radio_button.RadioButtonCustom op2;
    private radio_button.RadioButtonCustom op3;
    private radio_button.RadioButtonCustom op4;
    private radio_button.RadioButtonCustom op5;
    private roundpanel.PanelRound panelRound1;
    private roundpanel.PanelRound panelRound2;
    private roundpanel.PanelRound panelRound3;
    private javax.swing.JLabel qNo;
    private javax.swing.JTextArea question;
    private javax.swing.JLabel sec;
    // End of variables declaration//GEN-END:variables

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
    }

    @Override
    public void mouseReleased(MouseEvent e) {
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
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
