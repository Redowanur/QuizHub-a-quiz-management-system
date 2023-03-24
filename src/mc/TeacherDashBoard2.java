package mc;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.Document;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class TeacherDashBoard2 extends javax.swing.JFrame implements MouseInputListener {
    int x, xx, y, yy, q_no = 0;
    JLabel label5, a, label6, label7, b;

    public TeacherDashBoard2(String p, String q, String r, String s) {
        initComponents();
        //show_piechart(20, 20, 40, 10);
        
        id.setText(p);
        name.setText(q);
        dept.setText(r);
        email.setText(s);
        show_exams();
        
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
    
    public ArrayList<Exams1> ExamList() {
        ArrayList<Exams1> examList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
            String query = "select * from exam_list where teacher_id = '"+id.getText()+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            Exams1 exams;
            while (rs.next()) {
                String status = null;
                if(rs.getInt("isOver") == 0) status = "Running";
                else status = "Finished";
                exams = new Exams1(rs.getString("title"), rs.getString("exam_id"), rs.getString("marks"), rs.getString("time"), status);
                examList.add(exams);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return examList;
    }

    public void show_exams() {
        ArrayList<Exams1> list = ExamList();
        DefaultTableModel model = (DefaultTableModel) exam_list.getModel();
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getTitle();
            row[1] = list.get(i).getId();
            row[2] = list.get(i).getMarks();
            row[3] = list.get(i).getTime();
            row[4] = list.get(i).getStatus();
            model.addRow(row);
        }
    }
    
//    public void show_piechart(int p, int q, int r, int s){
//        PieDataset dataset = createDataset(p, q, r, s);
//        JFreeChart chart = ChartFactory.createPieChart("Mobile sales", dataset, true, true, false);
//        ChartPanel cp = new ChartPanel(chart);
//        pieChartContainer.add(cp, BorderLayout.CENTER);
//        pieChartContainer.validate();
//    }
//    
//    public PieDataset createDataset(int p, int q, int r, int s){
//        DefaultPieDataset dataset = new DefaultPieDataset( );
//        dataset.setValue( "IPhone 5s" , p);  
//        dataset.setValue( "SamSung Grand" , q);   
//        dataset.setValue( "MotoG" , r);    
//        dataset.setValue( "Nokia Lumia" , s); 
//        return dataset;
//    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPanel = new javax.swing.JPanel();
        TitleBar = new keeptoo.KGradientPanel();
        NavigationMenu = new keeptoo.KGradientPanel();
        CreateQuizButton = new com.k33ptoo.components.KButton();
        DashBoardButton = new com.k33ptoo.components.KButton();
        UpdateButton = new com.k33ptoo.components.KButton();
        ResultButton = new com.k33ptoo.components.KButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        DashBoardPanel = new keeptoo.KGradientPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        exam_list = new rojerusan.RSTableMetro();
        panelRound4 = new roundpanel.PanelRound();
        jLabel5 = new javax.swing.JLabel();
        panelRound3 = new roundpanel.PanelRound();
        DeptLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        dept = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        kButton2 = new com.k33ptoo.components.KButton();
        jCheckBoxCustom1 = new checkbox.JCheckBoxCustom();
        CreateQuiz = new keeptoo.KGradientPanel();
        combobox1 = new combobox.Combobox();
        textField1 = new textfield.TextField();
        kButton1 = new com.k33ptoo.components.KButton();
        examTitle = new textfield.TextField();
        sessionChooser = new combobox.Combobox();
        deptChooser = new combobox.Combobox();
        combobox2 = new combobox.Combobox();
        timeSetter = new textfield.TextField();
        marksSetter = new textfield.TextField();
        CreateQuizPanel = new keeptoo.KGradientPanel();
        QuestionArea = new textarea.TextAreaScroll();
        textArea0 = new textarea.TextArea();
        Option1 = new textarea.TextAreaScroll();
        textArea1 = new textarea.TextArea();
        Option2 = new textarea.TextAreaScroll();
        textArea2 = new textarea.TextArea();
        Option3 = new textarea.TextAreaScroll();
        textArea3 = new textarea.TextArea();
        Option4 = new textarea.TextAreaScroll();
        textArea4 = new textarea.TextArea();
        FinishButton = new com.k33ptoo.components.KButton();
        CorrectAnswerChooser = new combobox.Combobox();
        AddButton = new com.k33ptoo.components.KButton();
        QuestionTypeChooser1 = new combobox.Combobox();
        jLabel1 = new javax.swing.JLabel();
        Q_no = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        examChooser = new textfield.TextField();
        editButton = new com.k33ptoo.components.KButton();
        jPanel2 = new javax.swing.JPanel();
        Option5 = new textarea.TextAreaScroll();
        textArea5 = new textarea.TextArea();
        Option6 = new textarea.TextAreaScroll();
        textArea6 = new textarea.TextArea();
        FinishButton1 = new com.k33ptoo.components.KButton();
        QuestionArea1 = new textarea.TextAreaScroll();
        textArea7 = new textarea.TextArea();
        CorrectAnswerChooser1 = new combobox.Combobox();
        NextButton = new com.k33ptoo.components.KButton();
        Option7 = new textarea.TextAreaScroll();
        textArea8 = new textarea.TextArea();
        Option8 = new textarea.TextAreaScroll();
        textArea9 = new textarea.TextArea();
        jLabel2 = new javax.swing.JLabel();
        Q_no1 = new javax.swing.JLabel();
        PreviousButton = new com.k33ptoo.components.KButton();
        Update = new com.k33ptoo.components.KButton();
        ResultPanel = new javax.swing.JPanel();
        textField2 = new textfield.TextField();
        GetResult = new com.k33ptoo.components.KButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Results = new rojerusan.RSTableMetro();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BackgroundPanel.setLayout(null);

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

        BackgroundPanel.add(TitleBar);
        TitleBar.setBounds(0, 0, 1000, 27);

        NavigationMenu.setkEndColor(new java.awt.Color(81, 82, 84));
        NavigationMenu.setkGradientFocus(0);
        NavigationMenu.setkStartColor(new java.awt.Color(35, 37, 38));
        NavigationMenu.setLayout(null);

        CreateQuizButton.setBorder(null);
        CreateQuizButton.setText("Create Question");
        CreateQuizButton.setToolTipText("");
        CreateQuizButton.setFocusable(false);
        CreateQuizButton.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        CreateQuizButton.setkBorderRadius(0);
        CreateQuizButton.setkEndColor(new java.awt.Color(50, 50, 50));
        CreateQuizButton.setkHoverEndColor(new java.awt.Color(9, 144, 30));
        CreateQuizButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        CreateQuizButton.setkHoverStartColor(new java.awt.Color(76, 241, 101));
        CreateQuizButton.setkIndicatorThickness(5);
        CreateQuizButton.setkPressedColor(new java.awt.Color(229, 231, 233));
        CreateQuizButton.setkSelectedColor(new java.awt.Color(50, 255, 0));
        CreateQuizButton.setkStartColor(new java.awt.Color(26, 27, 28));
        CreateQuizButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CreateQuizButtonMouseEntered(evt);
            }
        });
        CreateQuizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateQuizButtonActionPerformed(evt);
            }
        });
        NavigationMenu.add(CreateQuizButton);
        CreateQuizButton.setBounds(0, 210, 170, 40);

        DashBoardButton.setBorder(null);
        DashBoardButton.setText("Dashboard");
        DashBoardButton.setToolTipText("");
        DashBoardButton.setFocusable(false);
        DashBoardButton.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        DashBoardButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        DashBoardButton.setkBorderRadius(0);
        DashBoardButton.setkEndColor(new java.awt.Color(50, 50, 50));
        DashBoardButton.setkHoverEndColor(new java.awt.Color(9, 144, 30));
        DashBoardButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        DashBoardButton.setkHoverStartColor(new java.awt.Color(76, 241, 101));
        DashBoardButton.setkIndicatorColor(new java.awt.Color(255, 0, 51));
        DashBoardButton.setkIndicatorThickness(5);
        DashBoardButton.setkPressedColor(new java.awt.Color(229, 231, 233));
        DashBoardButton.setkSelectedColor(new java.awt.Color(50, 255, 0));
        DashBoardButton.setkStartColor(new java.awt.Color(26, 27, 28));
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
        DashBoardButton.setBounds(0, 160, 170, 40);

        UpdateButton.setBorder(null);
        UpdateButton.setText("Edit Question");
        UpdateButton.setToolTipText("");
        UpdateButton.setFocusable(false);
        UpdateButton.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        UpdateButton.setkBorderRadius(0);
        UpdateButton.setkEndColor(new java.awt.Color(50, 50, 50));
        UpdateButton.setkHoverEndColor(new java.awt.Color(9, 144, 30));
        UpdateButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        UpdateButton.setkHoverStartColor(new java.awt.Color(76, 241, 101));
        UpdateButton.setkIndicatorThickness(5);
        UpdateButton.setkPressedColor(new java.awt.Color(229, 231, 233));
        UpdateButton.setkSelectedColor(new java.awt.Color(50, 255, 0));
        UpdateButton.setkStartColor(new java.awt.Color(26, 27, 28));
        UpdateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UpdateButtonMouseEntered(evt);
            }
        });
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        NavigationMenu.add(UpdateButton);
        UpdateButton.setBounds(0, 260, 170, 40);

        ResultButton.setBorder(null);
        ResultButton.setText("Results");
        ResultButton.setToolTipText("");
        ResultButton.setFocusable(false);
        ResultButton.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        ResultButton.setkBorderRadius(0);
        ResultButton.setkEndColor(new java.awt.Color(50, 50, 50));
        ResultButton.setkHoverEndColor(new java.awt.Color(9, 144, 30));
        ResultButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        ResultButton.setkHoverStartColor(new java.awt.Color(76, 241, 101));
        ResultButton.setkIndicatorThickness(5);
        ResultButton.setkPressedColor(new java.awt.Color(229, 231, 233));
        ResultButton.setkSelectedColor(new java.awt.Color(50, 255, 0));
        ResultButton.setkStartColor(new java.awt.Color(26, 27, 28));
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
        ResultButton.setBounds(0, 310, 170, 40);

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mc/assests/log-out2.png"))); // NOI18N
        jLabel7.setText("Log out");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        NavigationMenu.add(jLabel7);
        jLabel7.setBounds(40, 580, 90, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mc/assests/user2.png"))); // NOI18N
        NavigationMenu.add(jLabel3);
        jLabel3.setBounds(60, 50, 50, 50);

        BackgroundPanel.add(NavigationMenu);
        NavigationMenu.setBounds(0, 27, 170, 623);

        DashBoardPanel.setkEndColor(new java.awt.Color(255, 255, 255));
        DashBoardPanel.setkGradientFocus(800);
        DashBoardPanel.setkStartColor(new java.awt.Color(255, 255, 255));
        DashBoardPanel.setVisible(true);
        DashBoardPanel.setLayout(null);

        exam_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Exam Name", "Exam ID", "Marks", "Time", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        exam_list.setColorBackgoundHead(new java.awt.Color(56, 145, 201));
        exam_list.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        exam_list.setColorBordeHead(new java.awt.Color(255, 255, 255));
        exam_list.setColorFilasBackgound2(new java.awt.Color(230, 230, 230));
        exam_list.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        exam_list.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        exam_list.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        exam_list.setColorSelBackgound(new java.awt.Color(232, 57, 95));
        exam_list.setFocusable(false);
        exam_list.setFuenteFilas(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        exam_list.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        exam_list.setFuenteHead(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        exam_list.setGridColor(new java.awt.Color(0, 0, 0));
        exam_list.setGrosorBordeFilas(0);
        exam_list.setGrosorBordeHead(0);
        exam_list.setMultipleSeleccion(false);
        exam_list.setName(""); // NOI18N
        exam_list.setRowHeight(26);
        exam_list.setSelectionBackground(new java.awt.Color(232, 57, 95));
        exam_list.setShowGrid(false);
        exam_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exam_listMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(exam_list);

        DashBoardPanel.add(jScrollPane2);
        jScrollPane2.setBounds(22, 181, 780, 348);

        panelRound4.setBackground(new java.awt.Color(237, 137, 62));
        panelRound4.setRoundBottomLeft(30);
        panelRound4.setRoundBottomRight(30);
        panelRound4.setRoundTopLeft(30);
        panelRound4.setRoundTopRight(30);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Welcome back,");

        panelRound3.setBackground(new java.awt.Color(254, 159, 86));
        panelRound3.setRoundBottomLeft(30);
        panelRound3.setRoundBottomRight(30);
        panelRound3.setRoundTopLeft(30);
        panelRound3.setRoundTopRight(30);

        DeptLabel.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        DeptLabel.setForeground(new java.awt.Color(255, 255, 255));
        DeptLabel.setText("Dept:");

        emailLabel.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel.setText("Email:");

        dept.setFont(new java.awt.Font("JetBrains Mono", 0, 13)); // NOI18N
        dept.setForeground(new java.awt.Color(255, 255, 255));

        email.setFont(new java.awt.Font("JetBrains Mono", 0, 13)); // NOI18N
        email.setForeground(new java.awt.Color(255, 255, 255));

        idLabel.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        idLabel.setForeground(new java.awt.Color(255, 255, 255));
        idLabel.setText("ID:");

        id.setFont(new java.awt.Font("JetBrains Mono", 0, 13)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DeptLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dept, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(192, 192, 192))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(idLabel)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeptLabel)
                    .addComponent(dept, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        name.setFont(new java.awt.Font("Segoe UI Black", 0, 30)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5))
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DashBoardPanel.add(panelRound4);
        panelRound4.setBounds(22, 21, 768, 104);

        kButton2.setVisible(false);
        kButton2.setBorder(null);
        kButton2.setText("Copy Exam ID");
        kButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        kButton2.setkBorderRadius(30);
        kButton2.setkHoverEndColor(new java.awt.Color(0, 153, 153));
        kButton2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton2.setkHoverStartColor(new java.awt.Color(0, 255, 0));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });
        DashBoardPanel.add(kButton2);
        kButton2.setBounds(22, 554, 120, 45);

        jCheckBoxCustom1.setVisible(false);
        jCheckBoxCustom1.setBorder(null);
        jCheckBoxCustom1.setText("  Mark this quiz as Finished");
        jCheckBoxCustom1.setFocusable(false);
        jCheckBoxCustom1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxCustom1MouseClicked(evt);
            }
        });
        jCheckBoxCustom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCustom1ActionPerformed(evt);
            }
        });
        DashBoardPanel.add(jCheckBoxCustom1);
        jCheckBoxCustom1.setBounds(622, 555, 180, 45);

        jTabbedPane1.addTab("tab1", DashBoardPanel);

        CreateQuiz.setkEndColor(new java.awt.Color(255, 255, 255));
        CreateQuiz.setkGradientFocus(800);
        CreateQuiz.setkStartColor(new java.awt.Color(255, 255, 255));
        CreateQuiz.setVisible(false);

        combobox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CSE 133", "CSE 134", "CSE 143", "CSE 137", "CSE 138", "CSE 147", "CSE 150", "CSE 233", "CSE 234", "CSE 237", "CSE 238" }));
        combobox1.setSelectedIndex(-1);
        combobox1.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        combobox1.setLabeText("Course Code");

        textField1.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        textField1.setLabelText("Exam ID");

        kButton1.setBorder(null);
        kButton1.setText("Start");
        kButton1.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        kButton1.setkBorderRadius(35);
        kButton1.setkHoverEndColor(new java.awt.Color(51, 255, 51));
        kButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton1.setkHoverStartColor(new java.awt.Color(51, 255, 204));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        examTitle.setLabelText("Exam Title");

        sessionChooser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2020-21", "2019-20", "2018-19", "2017-18" }));
        sessionChooser.setSelectedIndex(-1);
        sessionChooser.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        sessionChooser.setLabeText("Session");

        deptChooser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CSE", "SWE" }));
        deptChooser.setSelectedIndex(-1);
        deptChooser.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        deptChooser.setLabeText("Department");

        combobox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MCQ", "T/F", "Mixed" }));
        combobox2.setSelectedIndex(-1);
        combobox2.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        combobox2.setLabeText("Exam Type");

        timeSetter.setLabelText("Time (Minutes)");

        marksSetter.setLabelText("Marks");

        javax.swing.GroupLayout CreateQuizLayout = new javax.swing.GroupLayout(CreateQuiz);
        CreateQuiz.setLayout(CreateQuizLayout);
        CreateQuizLayout.setHorizontalGroup(
            CreateQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreateQuizLayout.createSequentialGroup()
                .addContainerGap(170, Short.MAX_VALUE)
                .addGroup(CreateQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(timeSetter, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(examTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(455, 455, 455))
            .addGroup(CreateQuizLayout.createSequentialGroup()
                .addGroup(CreateQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CreateQuizLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(deptChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addGroup(CreateQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combobox2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sessionChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(marksSetter, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CreateQuizLayout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CreateQuizLayout.setVerticalGroup(
            CreateQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateQuizLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addGroup(CreateQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deptChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sessionChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CreateQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CreateQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(combobox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(examTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CreateQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeSetter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marksSetter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", CreateQuiz);

        CreateQuizPanel.setkEndColor(new java.awt.Color(255, 255, 255));
        CreateQuizPanel.setkGradientFocus(800);
        CreateQuizPanel.setkStartColor(new java.awt.Color(255, 255, 255));
        CreateQuizPanel.setVisible(false);

        QuestionArea.setLabelText("Enter Your Question Here");
        QuestionArea.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N

        textArea0.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 15));
        textArea0.setColumns(20);
        textArea0.setRows(5);
        textArea0.setTabSize(4);
        textArea0.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        QuestionArea.setViewportView(textArea0);

        Option1.setLabelText("Enter 1st Option");
        Option1.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N

        textArea1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textArea1.setColumns(20);
        textArea1.setRows(5);
        textArea1.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        Option1.setViewportView(textArea1);

        Option2.setLabelText("Enter 2nd option");
        Option2.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N

        textArea2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textArea2.setColumns(20);
        textArea2.setRows(5);
        textArea2.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        Option2.setViewportView(textArea2);

        Option3.setLabelText("Enter 3rd Option");
        Option3.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N

        textArea3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textArea3.setColumns(20);
        textArea3.setRows(5);
        textArea3.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        Option3.setViewportView(textArea3);

        Option4.setLabelText("Enter 4th Option");
        Option4.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N

        textArea4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textArea4.setColumns(20);
        textArea4.setRows(5);
        textArea4.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        Option4.setViewportView(textArea4);

        FinishButton.setBorder(null);
        FinishButton.setText("Finish");
        FinishButton.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        FinishButton.setkBorderRadius(30);
        FinishButton.setkHoverEndColor(new java.awt.Color(51, 255, 51));
        FinishButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        FinishButton.setkHoverStartColor(new java.awt.Color(51, 255, 204));
        FinishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinishButtonActionPerformed(evt);
            }
        });

        CorrectAnswerChooser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        CorrectAnswerChooser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));
        CorrectAnswerChooser.setSelectedIndex(-1);
        CorrectAnswerChooser.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        CorrectAnswerChooser.setLabeText("Correct Answer");
        CorrectAnswerChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorrectAnswerChooserActionPerformed(evt);
            }
        });

        AddButton.setBorder(null);
        AddButton.setForeground(new java.awt.Color(255, 0, 255));
        AddButton.setText("Add");
        AddButton.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        AddButton.setkBorderRadius(30);
        AddButton.setkHoverEndColor(new java.awt.Color(51, 255, 51));
        AddButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        AddButton.setkHoverStartColor(new java.awt.Color(51, 255, 204));
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        QuestionTypeChooser1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        QuestionTypeChooser1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MCQ", "T/F" }));
        QuestionTypeChooser1.setSelectedIndex(-1);
        QuestionTypeChooser1.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        QuestionTypeChooser1.setLabeText("Question Type");
        QuestionTypeChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuestionTypeChooser1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jLabel1.setText("Question:");

        Q_no.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Q_no.setText("Q");

        javax.swing.GroupLayout CreateQuizPanelLayout = new javax.swing.GroupLayout(CreateQuizPanel);
        CreateQuizPanel.setLayout(CreateQuizPanelLayout);
        CreateQuizPanelLayout.setHorizontalGroup(
            CreateQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateQuizPanelLayout.createSequentialGroup()
                .addGroup(CreateQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CreateQuizPanelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(Option1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CreateQuizPanelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(Option2, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CreateQuizPanelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(Option3, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CreateQuizPanelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(Option4, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CreateQuizPanelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(554, 554, 554)
                        .addComponent(FinishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CreateQuizPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(CreateQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(CreateQuizPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Q_no)
                                .addGap(185, 185, 185)
                                .addComponent(QuestionTypeChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CorrectAnswerChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(QuestionArea, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(51, 51, 51))
        );
        CreateQuizPanelLayout.setVerticalGroup(
            CreateQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateQuizPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(CreateQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CorrectAnswerChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QuestionTypeChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q_no)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(QuestionArea, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Option1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Option2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Option3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Option4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CreateQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FinishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("tab3", CreateQuizPanel);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        examChooser.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        examChooser.setLabelText("Exam ID (4 digit number)");

        editButton.setBorder(null);
        editButton.setText("Edit");
        editButton.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        editButton.setkBorderRadius(35);
        editButton.setkHoverEndColor(new java.awt.Color(51, 255, 51));
        editButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        editButton.setkHoverStartColor(new java.awt.Color(51, 255, 204));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(examChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(349, 349, 349)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(313, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(examChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(259, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        Option3.setLabelText("Enter 3rd Option");
        Option5.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        Option5.setLabelText("Enter 3rd option");

        textArea5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textArea5.setColumns(20);
        textArea5.setRows(5);
        textArea5.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        Option5.setViewportView(textArea5);

        Option4.setLabelText("Enter 4th Option");
        Option6.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        Option6.setLabelText("Enter 4th option");

        textArea6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textArea6.setColumns(20);
        textArea6.setRows(5);
        textArea6.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        Option6.setViewportView(textArea6);

        FinishButton1.setBorder(null);
        FinishButton1.setText("Finish");
        FinishButton1.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        FinishButton1.setkBorderRadius(30);
        FinishButton1.setkHoverEndColor(new java.awt.Color(51, 255, 51));
        FinishButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        FinishButton1.setkHoverStartColor(new java.awt.Color(51, 255, 204));
        FinishButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinishButton1ActionPerformed(evt);
            }
        });

        QuestionArea.setLabelText("Enter Your Question Here");
        QuestionArea1.setBackground(new java.awt.Color(255, 255, 255));
        QuestionArea1.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N

        textArea7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 15));
        textArea7.setColumns(20);
        textArea7.setRows(5);
        textArea7.setTabSize(4);
        textArea7.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        QuestionArea1.setViewportView(textArea7);

        CorrectAnswerChooser1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        CorrectAnswerChooser1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));
        CorrectAnswerChooser1.setSelectedIndex(-1);
        CorrectAnswerChooser1.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        CorrectAnswerChooser1.setLabeText("Correct Answer");

        NextButton.setBorder(null);
        NextButton.setForeground(new java.awt.Color(255, 0, 255));
        NextButton.setText("Next");
        NextButton.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        NextButton.setkBorderRadius(30);
        NextButton.setkHoverEndColor(new java.awt.Color(51, 255, 51));
        NextButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        NextButton.setkHoverStartColor(new java.awt.Color(51, 255, 204));
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        Option1.setLabelText("Enter 1st Option");
        Option7.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        Option7.setLabelText("Enter 1st option");

        textArea8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textArea8.setColumns(20);
        textArea8.setRows(5);
        textArea8.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        Option7.setViewportView(textArea8);

        Option2.setLabelText("Enter 2nd option");
        Option8.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        Option8.setLabelText("Enter 2nd option");

        textArea9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textArea9.setColumns(20);
        textArea9.setRows(5);
        textArea9.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        Option8.setViewportView(textArea9);

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jLabel2.setText("Question:");

        Q_no1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Q_no1.setText("Q");

        PreviousButton.setBorder(null);
        PreviousButton.setForeground(new java.awt.Color(255, 0, 255));
        PreviousButton.setText("Previous");
        PreviousButton.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        PreviousButton.setkBorderRadius(30);
        PreviousButton.setkHoverEndColor(new java.awt.Color(51, 255, 51));
        PreviousButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        PreviousButton.setkHoverStartColor(new java.awt.Color(51, 255, 204));
        PreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousButtonActionPerformed(evt);
            }
        });

        Update.setBorder(null);
        Update.setForeground(new java.awt.Color(255, 0, 255));
        Update.setText("Update");
        Update.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        Update.setkBorderRadius(30);
        Update.setkHoverEndColor(new java.awt.Color(51, 255, 51));
        Update.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        Update.setkHoverStartColor(new java.awt.Color(51, 255, 204));
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(Option7, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(Option8, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(Option5, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Q_no1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CorrectAnswerChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(QuestionArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(331, 331, 331)
                                .addComponent(FinishButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Option6, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CorrectAnswerChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(Q_no1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(QuestionArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Option7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Option8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Option5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Option6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FinishButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("tab5", jPanel2);

        ResultPanel.setBackground(new java.awt.Color(255, 255, 255));

        textField2.setLabelText("Exam ID");

        GetResult.setBorder(null);
        GetResult.setText("Get Result");
        GetResult.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        GetResult.setkBorderRadius(30);
        GetResult.setkHoverEndColor(new java.awt.Color(0, 153, 153));
        GetResult.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        GetResult.setkHoverStartColor(new java.awt.Color(0, 255, 0));
        GetResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetResultActionPerformed(evt);
            }
        });

        Results.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Quiz", "Name", "ID", "Marks"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Results.setColorBackgoundHead(new java.awt.Color(56, 145, 201));
        Results.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        Results.setColorBordeHead(new java.awt.Color(255, 255, 255));
        Results.setColorFilasBackgound2(new java.awt.Color(230, 230, 230));
        Results.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        Results.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        Results.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        Results.setColorSelBackgound(new java.awt.Color(232, 57, 95));
        Results.setFocusable(false);
        Results.setFuenteFilas(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        Results.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        Results.setFuenteHead(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Results.setGridColor(new java.awt.Color(0, 0, 0));
        Results.setGrosorBordeFilas(0);
        Results.setGrosorBordeHead(0);
        Results.setMultipleSeleccion(false);
        Results.setName(""); // NOI18N
        Results.setRowHeight(26);
        Results.setSelectionBackground(new java.awt.Color(232, 57, 95));
        Results.setShowGrid(false);
        Results.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResultsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Results);

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jLabel4.setText("Student Results");

        javax.swing.GroupLayout ResultPanelLayout = new javax.swing.GroupLayout(ResultPanel);
        ResultPanel.setLayout(ResultPanelLayout);
        ResultPanelLayout.setHorizontalGroup(
            ResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ResultPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(235, 235, 235))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ResultPanelLayout.createSequentialGroup()
                .addGroup(ResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ResultPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ResultPanelLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(GetResult, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        ResultPanelLayout.setVerticalGroup(
            ResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ResultPanelLayout.createSequentialGroup()
                .addGroup(ResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ResultPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ResultPanelLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(GetResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab6", ResultPanel);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab7", jPanel3);

        BackgroundPanel.add(jTabbedPane1);
        jTabbedPane1.setBounds(170, 30, 830, 630);

        getContentPane().add(BackgroundPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 650));

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

    private void CreateQuizButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateQuizButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateQuizButtonMouseEntered

    private void CreateQuizButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateQuizButtonActionPerformed
        jTabbedPane1.setSelectedIndex(1);
        textField1.setText("");
        combobox1.setSelectedIndex(-1);
    }//GEN-LAST:event_CreateQuizButtonActionPerformed

    private void DashBoardButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashBoardButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DashBoardButtonMouseEntered

    private void DashBoardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashBoardButtonActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_DashBoardButtonActionPerformed

    private void UpdateButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateButtonMouseEntered

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        jTabbedPane1.setSelectedIndex(3);
        examChooser.setText("");
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
            Statement st = con.createStatement();
            String query = "select * from quiz_questions where exam_id = '"+textField1.getText()+"'";
            ResultSet rs = st.executeQuery(query);
            if(combobox1.getSelectedIndex() == -1 || textField1.getText().equals("") || examTitle.getText().equals("") || sessionChooser.getSelectedIndex() == -1 || deptChooser.getSelectedIndex() == -1){
                JOptionPane.showMessageDialog(null, "Empty Field");
            }
            else if(rs.next()){
                JOptionPane.showMessageDialog(null, "Duplicate Exam ID");
            }
            else{
//                String query1 = "insert into quiz_questions(couse_code, exam_id) values('"+combobox1.getSelectedItem()+"', '"+textField1.getText()+"')";
//                st.executeUpdate(query1);
                jTabbedPane1.setSelectedIndex(2);
                q_no = 0;
                QuestionTypeChooser1.setSelectedIndex(-1);
                CorrectAnswerChooser.setSelectedIndex(-1);
                textArea0.setText("");
                textArea1.setText("");
                textArea2.setText("");
                textArea3.setText("");
                textArea4.setText("");
                Q_no.setText(Integer.toString(q_no+1));
            }

        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void FinishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinishButtonActionPerformed
        JOptionPane.showMessageDialog(null, "Created Quiz Successfully");
        jTabbedPane1.setSelectedIndex(1);
        DefaultTableModel model = (DefaultTableModel) exam_list.getModel();
        Vector<String> vec = new Vector<String>();
                
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
            Statement st = con.createStatement();
            String query = "insert into exam_list values('"+id.getText()+"', '"+name.getText()+"', '"+textField1.getText()+"', '"+combobox1.getSelectedItem()+"', '"+timeSetter.getText()+"', '"+examTitle.getText()+"', '"+deptChooser.getSelectedItem()+"', '"+sessionChooser.getSelectedItem()+"', '"+marksSetter.getText()+"', '"+combobox2.getSelectedIndex()+"', '"+0+"')";
            String query1 = "select * from exam_list where teacher_id = '"+id.getText()+"'";
            st.executeUpdate(query);
            ResultSet rs = st.executeQuery(query1);
            vec.add(rs.getString("title"));
            vec.add(rs.getString("exam_id"));
            vec.add(rs.getString("marks"));
            vec.add(rs.getString("time"));
            if(rs.getInt("isOver") == 0) vec.add("Running");
            else vec.add("Finished");
            model.addRow(vec);
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        
        combobox1.setSelectedIndex(-1);
        textField1.setText("");
        examTitle.setText("");
        sessionChooser.setSelectedIndex(-1);
        deptChooser.setSelectedIndex(-1);
    }//GEN-LAST:event_FinishButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
            Statement st = con.createStatement();

            if(QuestionTypeChooser1.getSelectedIndex() == 1 && !textArea0.getText().isBlank()){
                //System.out.println("i am inside short question");
                q_no++;
                String query = "insert into quiz_questions values('"+id.getText()+"','"+combobox1.getSelectedItem()+"','"+textField1.getText()+"','"+q_no+"','"+textArea0.getText()+"','"+null+"','"+null+"','"+null+"','"+null+"','N')";
                st.executeUpdate(query);
                textArea0.setText("");
                CorrectAnswerChooser.setSelectedIndex(-1);
                Q_no.setText(Integer.toString(q_no+1));
            }
            else if(QuestionTypeChooser1.getSelectedIndex() == 2 && !textArea0.getText().isBlank() && CorrectAnswerChooser.getSelectedIndex() != -1){
                //System.out.println("i am inside true false");
                q_no++;
                String query = "insert into quiz_questions values('"+id.getText()+"','"+combobox1.getSelectedItem()+"','"+textField1.getText()+"','"+q_no+"','"+textArea0.getText()+"','"+null+"','"+null+"','"+null+"','"+null+"','"+CorrectAnswerChooser.getSelectedIndex()+"')";
                st.executeUpdate(query);
                textArea0.setText("");
                CorrectAnswerChooser.setSelectedIndex(-1);
                Q_no.setText(Integer.toString(q_no+1));
            }
            else if(textArea0.getText().isBlank() || textArea1.getText().isBlank() || textArea2.getText().isBlank() || textArea3.getText().isBlank() || textArea4.getText().isBlank()){
                JOptionPane.showMessageDialog(null, "Blank Question or Option");
            }
            else if(QuestionTypeChooser1.getSelectedIndex() == 0 && !textArea0.getText().isBlank() && CorrectAnswerChooser.getSelectedIndex() != -1 && !textArea1.getText().isBlank() && !textArea2.getText().isBlank() && !textArea3.getText().isBlank() && !textArea4.getText().isBlank()){
                q_no++;
                String query = "insert into quiz_questions values('"+id.getText()+"','"+combobox1.getSelectedItem()+"','"+textField1.getText()+"','"+q_no+"','"+textArea0.getText()+"','"+textArea1.getText()+"','"+textArea2.getText()+"','"+textArea3.getText()+"','"+textArea4.getText()+"','"+CorrectAnswerChooser.getSelectedItem()+"')";
                st.executeUpdate(query);
                textArea0.setText("");
                textArea1.setText("");
                textArea2.setText("");
                textArea3.setText("");
                textArea4.setText("");
                CorrectAnswerChooser.setSelectedIndex(-1);
                Q_no.setText(Integer.toString(q_no+1));
            }
            else JOptionPane.showMessageDialog(null, "Choose correct answer.");

        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_AddButtonActionPerformed

    private void QuestionTypeChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuestionTypeChooser1ActionPerformed
        switch (QuestionTypeChooser1.getSelectedIndex()) {
            case 0 -> {
                String[] choice1 = {"A", "B", "C", "D"};
                CorrectAnswerChooser.setModel(new DefaultComboBoxModel(choice1));
                CorrectAnswerChooser.setSelectedIndex(-1);
                CorrectAnswerChooser.setVisible(true);
                Option1.setVisible(true);
                Option2.setVisible(true);
                Option3.setVisible(true);
                Option4.setVisible(true);
                textArea0.setText("");
                textArea1.setText("");
                textArea2.setText("");
                textArea3.setText("");
                textArea4.setText("");
            }
            case 1 -> {
                String[] choice2 = {"True", "False"};
                CorrectAnswerChooser.setModel(new DefaultComboBoxModel(choice2));
                CorrectAnswerChooser.setSelectedIndex(-1);
                CorrectAnswerChooser.setVisible(true);
                Option1.setVisible(false);
                Option2.setVisible(false);
                Option3.setVisible(false);
                Option4.setVisible(false);
                textArea0.setText("");
                textArea1.setText("");
                textArea2.setText("");
                textArea3.setText("");
                textArea4.setText("");
            }
            default -> {
            }
        }
    }//GEN-LAST:event_QuestionTypeChooser1ActionPerformed
    
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        try{
            q_no = 1;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
            Statement st = con.createStatement();
            String query = "select * from quiz_questions where exam_id = '"+examChooser.getText()+"' and question_no = '"+1+"'";
            ResultSet rs = st.executeQuery(query);
            if(rs.next()){
                NextButton.setEnabled(true);
                PreviousButton.setEnabled(true);
                jTabbedPane1.setSelectedIndex(4);
                Q_no1.setText("1");
                if(rs.getString("correct_ans") == null){
                    // short question
                    textArea6.setVisible(false);
                    textArea5.setVisible(false);
                    textArea9.setVisible(false);
                    textArea8.setVisible(false);
                    textArea7.setVisible(true);
                    CorrectAnswerChooser1.setVisible(false);
                    textArea7.setText(rs.getString("question"));
                }
                else if(rs.getString("correct_ans").equals("0") || rs.getString("correct_ans").equals("1")){
                    // true false
                    String[] choice2 = {"True", "False"};
                    CorrectAnswerChooser1.setModel(new DefaultComboBoxModel(choice2));
                    textArea6.setVisible(false);
                    textArea5.setVisible(false);
                    textArea9.setVisible(false);
                    textArea8.setVisible(false);
                    textArea7.setVisible(true);
                    CorrectAnswerChooser1.setVisible(true);
                    textArea7.setText(rs.getString("question"));
                    if(rs.getString("correct_ans").equals("0")) CorrectAnswerChooser1.setSelectedIndex(0);
                    else CorrectAnswerChooser1.setSelectedIndex(1);
                }
                else{
                    // mcq
                    String[] choice1 = {"A", "B", "C", "D"};
                    CorrectAnswerChooser.setModel(new DefaultComboBoxModel(choice1));
                    textArea6.setVisible(true);
                    textArea5.setVisible(true);
                    textArea9.setVisible(true);
                    textArea8.setVisible(true);
                    textArea7.setVisible(true);
                    CorrectAnswerChooser1.setVisible(true);
                    textArea7.setText(rs.getString("question"));
                    textArea8.setText(rs.getString("option1"));
                    textArea9.setText(rs.getString("option2"));
                    textArea5.setText(rs.getString("option3"));
                    textArea6.setText(rs.getString("option4"));
                    if(rs.getString("correct_ans").equals("A")) CorrectAnswerChooser1.setSelectedIndex(0);
                    else if(rs.getString("correct_ans").equals("B")) CorrectAnswerChooser1.setSelectedIndex(1);
                    else if(rs.getString("correct_ans").equals("C")) CorrectAnswerChooser1.setSelectedIndex(2);
                    else if(rs.getString("correct_ans").equals("D")) CorrectAnswerChooser1.setSelectedIndex(3);
                }
            }
            else JOptionPane.showMessageDialog(null, "No such Exam ID.");
            con.close();

        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void FinishButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinishButton1ActionPerformed
        int n = JOptionPane.showConfirmDialog(null, "Do you want to finish editing?");
        if(n == 0){
            jTabbedPane1.setSelectedIndex(0);
        }
    }//GEN-LAST:event_FinishButton1ActionPerformed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
            Statement st = con.createStatement();
            String query = "select * from quiz_questions where exam_id = '"+examChooser.getText()+"' and question_no = '"+Integer.toString(++q_no)+"'";
            ResultSet rs = st.executeQuery(query);
            if(rs.next()){
                jTabbedPane1.setSelectedIndex(4);
                PreviousButton.setEnabled(true);
                Q_no1.setText(Integer.toString(q_no));
                if(rs.getString("correct_ans") == null){
                    // short question
                    textArea6.setVisible(false);
                    textArea5.setVisible(false);
                    textArea9.setVisible(false);
                    textArea8.setVisible(false);
                    textArea7.setVisible(true);
                    CorrectAnswerChooser1.setVisible(false);
                    textArea7.setText(rs.getString("question"));
                }
                else if(rs.getString("correct_ans").equals("0") || rs.getString("correct_ans").equals("1")){
                    // true false
                    String[] choice2 = {"True", "False"};
                    CorrectAnswerChooser1.setModel(new DefaultComboBoxModel(choice2));
                    textArea6.setVisible(false);
                    textArea5.setVisible(false);
                    textArea9.setVisible(false);
                    textArea8.setVisible(false);
                    textArea7.setVisible(true);
                    CorrectAnswerChooser1.setVisible(true);
                    textArea7.setText(rs.getString("question"));
                    if(rs.getString("correct_ans").equals("0")) CorrectAnswerChooser1.setSelectedIndex(0);
                    else CorrectAnswerChooser1.setSelectedIndex(1);
                }
                else{
                    // mcq
                    String[] choice1 = {"A", "B", "C", "D"};
                    CorrectAnswerChooser.setModel(new DefaultComboBoxModel(choice1));
                    textArea6.setVisible(true);
                    textArea5.setVisible(true);
                    textArea9.setVisible(true);
                    textArea8.setVisible(true);
                    textArea7.setVisible(true);
                    CorrectAnswerChooser1.setVisible(true);
                    textArea7.setText(rs.getString("question"));
                    textArea8.setText(rs.getString("option1"));
                    textArea9.setText(rs.getString("option2"));
                    textArea5.setText(rs.getString("option3"));
                    textArea6.setText(rs.getString("option4"));
                    if(rs.getString("correct_ans").equals("A")) CorrectAnswerChooser1.setSelectedIndex(0);
                    else if(rs.getString("correct_ans").equals("B")) CorrectAnswerChooser1.setSelectedIndex(1);
                    else if(rs.getString("correct_ans").equals("C")) CorrectAnswerChooser1.setSelectedIndex(2);
                    else if(rs.getString("correct_ans").equals("D")) CorrectAnswerChooser1.setSelectedIndex(3);
                }
            }
            else{
                NextButton.setEnabled(false);
                --q_no;
            }
            con.close();

        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_NextButtonActionPerformed

    private void CorrectAnswerChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorrectAnswerChooserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CorrectAnswerChooserActionPerformed

    private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousButtonActionPerformed
        if(q_no == 1){
            PreviousButton.setEnabled(false);
            return;
        }
        NextButton.setEnabled(true);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
            Statement st = con.createStatement();
            String query = "select * from quiz_questions where exam_id = '"+examChooser.getText()+"' and question_no = '"+Integer.toString(--q_no)+"'";
            ResultSet rs = st.executeQuery(query);
            if(rs.next()){
                jTabbedPane1.setSelectedIndex(4);
                Q_no1.setText(Integer.toString(q_no));
                if(rs.getString("correct_ans") == null){
                    // short question
                    textArea6.setVisible(false);
                    textArea5.setVisible(false);
                    textArea9.setVisible(false);
                    textArea8.setVisible(false);
                    textArea7.setVisible(true);
                    CorrectAnswerChooser1.setVisible(false);
                    textArea7.setText(rs.getString("question"));
                }
                else if(rs.getString("correct_ans").equals("0") || rs.getString("correct_ans").equals("1")){
                    // true false
                    String[] choice2 = {"True", "False"};
                    CorrectAnswerChooser1.setModel(new DefaultComboBoxModel(choice2));
                    textArea6.setVisible(false);
                    textArea5.setVisible(false);
                    textArea9.setVisible(false);
                    textArea8.setVisible(false);
                    textArea7.setVisible(true);
                    CorrectAnswerChooser1.setVisible(true);
                    textArea7.setText(rs.getString("question"));
                    if(rs.getString("correct_ans").equals("0")) CorrectAnswerChooser1.setSelectedIndex(0);
                    else CorrectAnswerChooser1.setSelectedIndex(1);
                }
                else{
                    // mcq
                    String[] choice1 = {"A", "B", "C", "D"};
                    CorrectAnswerChooser.setModel(new DefaultComboBoxModel(choice1));
                    textArea6.setVisible(true);
                    textArea5.setVisible(true);
                    textArea9.setVisible(true);
                    textArea8.setVisible(true);
                    textArea7.setVisible(true);
                    CorrectAnswerChooser1.setVisible(true);
                    textArea7.setText(rs.getString("question"));
                    textArea8.setText(rs.getString("option1"));
                    textArea9.setText(rs.getString("option2"));
                    textArea5.setText(rs.getString("option3"));
                    textArea6.setText(rs.getString("option4"));
                    if(rs.getString("correct_ans").equals("A")) CorrectAnswerChooser1.setSelectedIndex(0);
                    else if(rs.getString("correct_ans").equals("B")) CorrectAnswerChooser1.setSelectedIndex(1);
                    else if(rs.getString("correct_ans").equals("C")) CorrectAnswerChooser1.setSelectedIndex(2);
                    else if(rs.getString("correct_ans").equals("D")) CorrectAnswerChooser1.setSelectedIndex(3);
                }
            }
            con.close();

        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_PreviousButtonActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
            
            if(textArea8.isVisible()){
                // mcq
                String query = "update quiz_questions set question = ?, option1 = ?, option2 = ?, option3 = ?, option4 = ?, correct_ans = ? where exam_id = '"+examChooser.getText()+"' and question_no = '"+q_no+"'";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, textArea7.getText());
                ps.setString(2, textArea8.getText());
                ps.setString(3, textArea9.getText());
                ps.setString(4, textArea5.getText());
                ps.setString(5, textArea7.getText());
                ps.setString(6, (String) CorrectAnswerChooser1.getSelectedItem());
                ps.executeUpdate();
            }
            else if(!CorrectAnswerChooser1.isVisible()){
                // short question
                String query = "update quiz_questions set question = ? where exam_id = '"+examChooser.getText()+"' and question_no = '"+q_no+"'";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, textArea7.getText());
                ps.executeUpdate();
            }
            else{
                // true false
                String query = "update quiz_questions set question = ?, correct_ans = ? where exam_id = '"+examChooser.getText()+"' and question_no = '"+q_no+"'";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, textArea7.getText());
                ps.setString(2, Integer.toString(CorrectAnswerChooser1.getSelectedIndex()));
                ps.executeUpdate();
            }
        }
        catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void ResultButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ResultButtonMouseEntered

    private void ResultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResultButtonActionPerformed
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_ResultButtonActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        int val = JOptionPane.showConfirmDialog(null, "Do you want to Log out?");
        if(val == 0){
            HomePage hp = new HomePage();
            hp.setVisible(true);
            hp.setLocation(this.getX(), this.getY());
            dispose();
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        int row = exam_list.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(null, "Select an Exam");
            return;
        }
        String xmid = exam_list.getModel().getValueAt(row, 1).toString();
        StringSelection str = new StringSelection (xmid);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard ();
        clpbrd.setContents (str, null);
    }//GEN-LAST:event_kButton2ActionPerformed

    private void exam_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exam_listMouseClicked
        kButton2.setVisible(true);
        jCheckBoxCustom1.setVisible(true);
        jCheckBoxCustom1.setSelected(false);
    }//GEN-LAST:event_exam_listMouseClicked

    private void jCheckBoxCustom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxCustom1MouseClicked
        int row = exam_list.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(null, "Select an Exam");
            return;
        }
        exam_list.getModel().setValueAt("Finished", row, 4);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
            String query = "update exam_list set isOver = '"+1+"' where exam_id = '"+exam_list.getModel().getValueAt(row, 1).toString()+"'";
            Statement st = con.createStatement();
            st.executeUpdate(query);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jCheckBoxCustom1MouseClicked

    private void ResultsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultsMouseClicked
        //        int row = UpcomingQuizes.getSelectedRow();
        //        String sName = UpcomingQuizes.getModel().getValueAt(row, 0).toString();
        //        String sID = UpcomingQuizes.getModel().getValueAt(row, 1).toString();
        //        StudentName.setText(sName);
        //        Reg_no.setText(sID);
    }//GEN-LAST:event_ResultsMouseClicked
    
    public ArrayList<Exams1> ResultList(String str){
        ArrayList<Exams1> resultlist = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
            String query = "select * from result where exam_id = '"+str+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            Exams1 exams;
            while (rs.next()) {
                exams = new Exams1(rs.getString("exam_name"), rs.getString("name"), rs.getString("id"), rs.getString("marks"));
                resultlist.add(exams);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return resultlist;
    }
    
    private void GetResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetResultActionPerformed
        if(textField2.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Give an Exam ID.");
            return;
        }
        ArrayList<Exams1> list = ResultList(textField2.getText());
        DefaultTableModel model = (DefaultTableModel) Results.getModel();
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getTitle();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getId();
            row[3] = list.get(i).getMarks();
            model.addRow(row);
        }
    }//GEN-LAST:event_GetResultActionPerformed

    private void jCheckBoxCustom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCustom1ActionPerformed
        
    }//GEN-LAST:event_jCheckBoxCustom1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(TeacherDashBoard2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherDashBoard2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherDashBoard2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherDashBoard2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String a1 = null, a2 = null, a3 = null, a4 = null;
                new TeacherDashBoard2(a1, a2, a3, a4).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton AddButton;
    private javax.swing.JPanel BackgroundPanel;
    private combobox.Combobox CorrectAnswerChooser;
    private combobox.Combobox CorrectAnswerChooser1;
    private keeptoo.KGradientPanel CreateQuiz;
    private com.k33ptoo.components.KButton CreateQuizButton;
    private keeptoo.KGradientPanel CreateQuizPanel;
    private com.k33ptoo.components.KButton DashBoardButton;
    private keeptoo.KGradientPanel DashBoardPanel;
    private javax.swing.JLabel DeptLabel;
    private com.k33ptoo.components.KButton FinishButton;
    private com.k33ptoo.components.KButton FinishButton1;
    private com.k33ptoo.components.KButton GetResult;
    private keeptoo.KGradientPanel NavigationMenu;
    private com.k33ptoo.components.KButton NextButton;
    private textarea.TextAreaScroll Option1;
    private textarea.TextAreaScroll Option2;
    private textarea.TextAreaScroll Option3;
    private textarea.TextAreaScroll Option4;
    private textarea.TextAreaScroll Option5;
    private textarea.TextAreaScroll Option6;
    private textarea.TextAreaScroll Option7;
    private textarea.TextAreaScroll Option8;
    private com.k33ptoo.components.KButton PreviousButton;
    private javax.swing.JLabel Q_no;
    private javax.swing.JLabel Q_no1;
    private textarea.TextAreaScroll QuestionArea;
    private textarea.TextAreaScroll QuestionArea1;
    private combobox.Combobox QuestionTypeChooser1;
    private com.k33ptoo.components.KButton ResultButton;
    private javax.swing.JPanel ResultPanel;
    private rojerusan.RSTableMetro Results;
    private keeptoo.KGradientPanel TitleBar;
    private com.k33ptoo.components.KButton Update;
    private com.k33ptoo.components.KButton UpdateButton;
    private combobox.Combobox combobox1;
    private combobox.Combobox combobox2;
    private javax.swing.JLabel dept;
    private combobox.Combobox deptChooser;
    private com.k33ptoo.components.KButton editButton;
    private javax.swing.JLabel email;
    private javax.swing.JLabel emailLabel;
    private textfield.TextField examChooser;
    private textfield.TextField examTitle;
    private rojerusan.RSTableMetro exam_list;
    private javax.swing.JLabel id;
    private javax.swing.JLabel idLabel;
    private checkbox.JCheckBoxCustom jCheckBoxCustom1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton2;
    private textfield.TextField marksSetter;
    private javax.swing.JLabel name;
    private roundpanel.PanelRound panelRound3;
    private roundpanel.PanelRound panelRound4;
    private combobox.Combobox sessionChooser;
    private textarea.TextArea textArea0;
    private textarea.TextArea textArea1;
    private textarea.TextArea textArea2;
    private textarea.TextArea textArea3;
    private textarea.TextArea textArea4;
    private textarea.TextArea textArea5;
    private textarea.TextArea textArea6;
    private textarea.TextArea textArea7;
    private textarea.TextArea textArea8;
    private textarea.TextArea textArea9;
    private textfield.TextField textField1;
    private textfield.TextField textField2;
    private textfield.TextField timeSetter;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == a){
            System.exit(0);
        }
        if(e.getSource() == b){
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
