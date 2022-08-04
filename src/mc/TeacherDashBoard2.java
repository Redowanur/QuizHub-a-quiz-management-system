package mc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TeacherDashBoard2 extends javax.swing.JFrame {
    int x, xx, y, yy, q_no = 0;

    public TeacherDashBoard2() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPanel = new javax.swing.JPanel();
        TitleBar = new keeptoo.KGradientPanel();
        NavigationMenu = new keeptoo.KGradientPanel();
        CreateQuizButton = new com.k33ptoo.components.KButton();
        DashBoardButton = new com.k33ptoo.components.KButton();
        UpdateButton = new com.k33ptoo.components.KButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        DashBoardPanel = new keeptoo.KGradientPanel();
        id = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        CreateQuiz = new keeptoo.KGradientPanel();
        combobox1 = new combobox.Combobox();
        textField1 = new textfield.TextField();
        kButton1 = new com.k33ptoo.components.KButton();
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
        jPanel1 = new javax.swing.JPanel();
        examChooser = new textfield.TextField();
        editButton = new com.k33ptoo.components.KButton();
        jPanel2 = new javax.swing.JPanel();
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
        CreateQuizButton.setText("Create Quiz");
        CreateQuizButton.setToolTipText("");
        CreateQuizButton.setFocusable(false);
        CreateQuizButton.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        CreateQuizButton.setkBorderRadius(38);
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
        CreateQuizButton.setBounds(10, 210, 180, 40);

        DashBoardButton.setBorder(null);
        DashBoardButton.setText("Dashboard");
        DashBoardButton.setToolTipText("");
        DashBoardButton.setFocusable(false);
        DashBoardButton.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        DashBoardButton.setkBorderRadius(38);
        DashBoardButton.setkEndColor(new java.awt.Color(50, 50, 50));
        DashBoardButton.setkHoverEndColor(new java.awt.Color(9, 144, 30));
        DashBoardButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        DashBoardButton.setkHoverStartColor(new java.awt.Color(76, 241, 101));
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
        DashBoardButton.setBounds(10, 160, 180, 40);

        UpdateButton.setBorder(null);
        UpdateButton.setText("Edit Quiz");
        UpdateButton.setToolTipText("");
        UpdateButton.setFocusable(false);
        UpdateButton.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        UpdateButton.setkBorderRadius(38);
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
        UpdateButton.setBounds(10, 260, 180, 40);

        BackgroundPanel.add(NavigationMenu);
        NavigationMenu.setBounds(0, 27, 170, 623);

        DashBoardPanel.setkEndColor(new java.awt.Color(255, 255, 255));
        DashBoardPanel.setkGradientFocus(800);
        DashBoardPanel.setkStartColor(new java.awt.Color(255, 255, 255));
        DashBoardPanel.setVisible(true);

        id.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N

        idLabel.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        idLabel.setText("ID:");

        javax.swing.GroupLayout DashBoardPanelLayout = new javax.swing.GroupLayout(DashBoardPanel);
        DashBoardPanel.setLayout(DashBoardPanelLayout);
        DashBoardPanelLayout.setHorizontalGroup(
            DashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardPanelLayout.createSequentialGroup()
                .addContainerGap(397, Short.MAX_VALUE)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(290, 290, 290))
            .addGroup(DashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardPanelLayout.createSequentialGroup()
                    .addGap(246, 246, 246)
                    .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(445, Short.MAX_VALUE)))
        );
        DashBoardPanelLayout.setVerticalGroup(
            DashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashBoardPanelLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(487, Short.MAX_VALUE))
            .addGroup(DashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardPanelLayout.createSequentialGroup()
                    .addGap(86, 86, 86)
                    .addComponent(idLabel)
                    .addContainerGap(487, Short.MAX_VALUE)))
        );

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

        javax.swing.GroupLayout CreateQuizLayout = new javax.swing.GroupLayout(CreateQuiz);
        CreateQuiz.setLayout(CreateQuizLayout);
        CreateQuizLayout.setHorizontalGroup(
            CreateQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateQuizLayout.createSequentialGroup()
                .addGroup(CreateQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CreateQuizLayout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CreateQuizLayout.createSequentialGroup()
                        .addGap(353, 353, 353)
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        CreateQuizLayout.setVerticalGroup(
            CreateQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateQuizLayout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addGroup(CreateQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
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
        textArea0.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        QuestionArea.setViewportView(textArea0);

        Option1.setLabelText("Enter 1st Option");
        Option1.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N

        textArea1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textArea1.setColumns(20);
        textArea1.setRows(5);
        textArea1.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        Option1.setViewportView(textArea1);

        Option2.setLabelText("Enter 2nd option");
        Option2.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N

        textArea2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textArea2.setColumns(20);
        textArea2.setRows(5);
        textArea2.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        Option2.setViewportView(textArea2);

        Option3.setLabelText("Enter 3rd Option");
        Option3.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N

        textArea3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textArea3.setColumns(20);
        textArea3.setRows(5);
        textArea3.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        Option3.setViewportView(textArea3);

        Option4.setLabelText("Enter 4th Option");
        Option4.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N

        textArea4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textArea4.setColumns(20);
        textArea4.setRows(5);
        textArea4.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        Option4.setViewportView(textArea4);

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
        CorrectAnswerChooser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
        CorrectAnswerChooser.setSelectedIndex(-1);
        CorrectAnswerChooser.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        CorrectAnswerChooser.setLabeText("Correct Answer");

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
        QuestionTypeChooser1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MCQ", "Short Question", "T/F" }));
        QuestionTypeChooser1.setSelectedIndex(-1);
        QuestionTypeChooser1.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        QuestionTypeChooser1.setLabeText("Question Type");
        QuestionTypeChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuestionTypeChooser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CreateQuizPanelLayout = new javax.swing.GroupLayout(CreateQuizPanel);
        CreateQuizPanel.setLayout(CreateQuizPanelLayout);
        CreateQuizPanelLayout.setHorizontalGroup(
            CreateQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateQuizPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(QuestionTypeChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(406, 406, 406)
                .addComponent(CorrectAnswerChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(CreateQuizPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(QuestionArea, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        );
        CreateQuizPanelLayout.setVerticalGroup(
            CreateQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateQuizPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(CreateQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(QuestionTypeChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(CorrectAnswerChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        examChooser.setLabelText("Exam ID");

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
                .addContainerGap(253, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 825, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab5", jPanel2);

        jPanel3.setBackground(new java.awt.Color(51, 255, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 825, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab6", jPanel3);

        BackgroundPanel.add(jTabbedPane1);
        jTabbedPane1.setBounds(170, 27, 830, 623);

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
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
            Statement st = con.createStatement();
            String query = "select * from quiz_questions where exam_id = '"+textField1.getText()+"'";
            ResultSet rs = st.executeQuery(query);
            if(combobox1.getSelectedIndex() == -1 || textField1.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Enter Course Code and Exam ID");
            }
            else if(rs.next()){
                JOptionPane.showMessageDialog(null, "Duplicate Exam ID");
            }
            else{
//                String query1 = "insert into quiz_questions(couse_code, exam_id) values('"+combobox1.getSelectedItem()+"', '"+textField1.getText()+"')";
//                st.executeUpdate(query1);
                jTabbedPane1.setSelectedIndex(2);

            }

        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void FinishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinishButtonActionPerformed
        JOptionPane.showMessageDialog(null, "Created Quiz Successfully");
        jTabbedPane1.setSelectedIndex(1);
        combobox1.setSelectedIndex(-1);
        textField1.setText("");
    }//GEN-LAST:event_FinishButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
            Statement st = con.createStatement();

            if(QuestionTypeChooser1.getSelectedIndex() == 1 && !textArea0.getText().isBlank()){
                //System.out.println("i am inside short question");
                q_no++;
                String query = "insert into quiz_questions values('"+id.getText()+"','"+combobox1.getSelectedItem()+"','"+textField1.getText()+"','"+q_no+"','"+textArea0.getText()+"','"+null+"','"+null+"','"+null+"','"+null+"','"+null+"')";
                st.executeUpdate(query);
                textArea0.setText("");
            }
            else if(QuestionTypeChooser1.getSelectedIndex() == 2 && !textArea0.getText().isBlank()){
                //System.out.println("i am inside true false");
                q_no++;
                String query = "insert into quiz_questions values('"+id.getText()+"','"+combobox1.getSelectedItem()+"','"+textField1.getText()+"','"+q_no+"','"+textArea0.getText()+"','"+null+"','"+null+"','"+null+"','"+null+"','"+CorrectAnswerChooser.getSelectedIndex()+"')";
                st.executeUpdate(query);
                textArea0.setText("");
            }
            else if(textArea0.getText().isBlank() || textArea1.getText().isBlank() || textArea2.getText().isBlank() || textArea3.getText().isBlank() || textArea4.getText().isBlank()){
                JOptionPane.showMessageDialog(null, "Blank Question or Option");
            }
            else{
                q_no++;
                String query = "insert into quiz_questions values('"+id.getText()+"','"+combobox1.getSelectedItem()+"','"+textField1.getText()+"','"+q_no+"','"+textArea0.getText()+"','"+textArea1.getText()+"','"+textArea2.getText()+"','"+textArea3.getText()+"','"+textArea4.getText()+"','"+CorrectAnswerChooser.getSelectedItem()+"')";
                st.executeUpdate(query);
                textArea0.setText("");
                textArea1.setText("");
                textArea2.setText("");
                textArea3.setText("");
                textArea4.setText("");
            }

        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_AddButtonActionPerformed

    private void QuestionTypeChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuestionTypeChooser1ActionPerformed
        switch (QuestionTypeChooser1.getSelectedIndex()) {
            case 0 -> {
                String[] choice1 = {"1", "2", "3", "4"};
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
                CorrectAnswerChooser.setVisible(false);
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
            case 2 -> {
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
    
    public ArrayList<Questions> questionList(){
        String xmID = examChooser.getText().toString();
        ArrayList<Questions> questionList = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
            Statement st = con.createStatement();
            String query = "select * from quiz_questions where teacher_id='"+id.getText()+"' and exam_id='"+xmID+"'";
            ResultSet rs = st.executeQuery(query);
            Questions questions;
            while(rs.next()){
                questions = new Questions(rs.getString("question_no"), rs.getString("question"), rs.getString("option1"), rs.getString("option2"), rs.getString("option3"), rs.getString("option4"), rs.getString("correct_ans"));
                questionList.add(questions);
            }
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return questionList;
    }
    
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        questionList();
        ArrayList<Questions> list = questionList();
        //Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {
//            row[0] = list.get(i).getName();
//            row[1] = list.get(i).getReg();
//            row[2] = list.get(i).getDept();
//            row[3] = list.get(i).getAddress();
//            row[4] = list.get(i).getPhone();
        }
    }//GEN-LAST:event_editButtonActionPerformed
    
    public void updateID(String n){
        id.setText(n);
    }
    
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
                new TeacherDashBoard2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton AddButton;
    private javax.swing.JPanel BackgroundPanel;
    private combobox.Combobox CorrectAnswerChooser;
    private keeptoo.KGradientPanel CreateQuiz;
    private com.k33ptoo.components.KButton CreateQuizButton;
    private keeptoo.KGradientPanel CreateQuizPanel;
    private com.k33ptoo.components.KButton DashBoardButton;
    private keeptoo.KGradientPanel DashBoardPanel;
    private com.k33ptoo.components.KButton FinishButton;
    private keeptoo.KGradientPanel NavigationMenu;
    private textarea.TextAreaScroll Option1;
    private textarea.TextAreaScroll Option2;
    private textarea.TextAreaScroll Option3;
    private textarea.TextAreaScroll Option4;
    private textarea.TextAreaScroll QuestionArea;
    private combobox.Combobox QuestionTypeChooser1;
    private keeptoo.KGradientPanel TitleBar;
    private com.k33ptoo.components.KButton UpdateButton;
    private combobox.Combobox combobox1;
    private com.k33ptoo.components.KButton editButton;
    private textfield.TextField examChooser;
    private javax.swing.JLabel id;
    private javax.swing.JLabel idLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.k33ptoo.components.KButton kButton1;
    private textarea.TextArea textArea0;
    private textarea.TextArea textArea1;
    private textarea.TextArea textArea2;
    private textarea.TextArea textArea3;
    private textarea.TextArea textArea4;
    private textfield.TextField textField1;
    // End of variables declaration//GEN-END:variables

}
