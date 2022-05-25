package mc;

public class TeacherDashBoard extends javax.swing.JFrame {
    int x, y, xx, yy;
    
    public TeacherDashBoard() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ContainerPanel = new javax.swing.JPanel();
        TitleBar = new keeptoo.KGradientPanel();
        NavigationMenu = new keeptoo.KGradientPanel();
        DashBoardButton = new com.k33ptoo.components.KButton();
        AttendanceButton = new com.k33ptoo.components.KButton();
        QuizesButton = new com.k33ptoo.components.KButton();
        ResultButton = new com.k33ptoo.components.KButton();
        SettingsButton = new com.k33ptoo.components.KButton();
        DashboardPanel = new keeptoo.KGradientPanel();
        ID = new javax.swing.JLabel();
        IDLabel = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        GenderLabel = new javax.swing.JLabel();
        DepartmentLabel = new javax.swing.JLabel();
        AdmissionDateLabel = new javax.swing.JLabel();
        AdmissionDate = new javax.swing.JLabel();
        Department = new javax.swing.JLabel();
        Gender = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        AttendancePanel = new javax.swing.JPanel();
        QuizPanel = new javax.swing.JPanel();
        ResultPanel = new javax.swing.JPanel();
        SettingsPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ContainerPanel.setBackground(new java.awt.Color(229, 231, 233));
        ContainerPanel.setLayout(null);

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

        ContainerPanel.add(TitleBar);
        TitleBar.setBounds(0, 0, 1000, 27);

        NavigationMenu.setkEndColor(new java.awt.Color(85, 116, 159));
        NavigationMenu.setkGradientFocus(0);
        NavigationMenu.setkStartColor(new java.awt.Color(36, 55, 72));
        NavigationMenu.setLayout(null);

        DashBoardButton.setBorder(null);
        DashBoardButton.setText("Dashboard");
        DashBoardButton.setToolTipText("");
        DashBoardButton.setFocusable(false);
        DashBoardButton.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        DashBoardButton.setkBorderRadius(38);
        DashBoardButton.setkEndColor(new java.awt.Color(44, 83, 100));
        DashBoardButton.setkHoverEndColor(new java.awt.Color(9, 144, 30));
        DashBoardButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        DashBoardButton.setkHoverStartColor(new java.awt.Color(76, 241, 101));
        DashBoardButton.setkIndicatorThickness(5);
        DashBoardButton.setkPressedColor(new java.awt.Color(229, 231, 233));
        DashBoardButton.setkSelectedColor(new java.awt.Color(50, 255, 0));
        DashBoardButton.setkStartColor(new java.awt.Color(15, 32, 49));
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

        AttendanceButton.setBorder(null);
        AttendanceButton.setText("Attendance");
        AttendanceButton.setToolTipText("");
        AttendanceButton.setFocusable(false);
        AttendanceButton.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        AttendanceButton.setkBorderRadius(38);
        AttendanceButton.setkEndColor(new java.awt.Color(44, 83, 100));
        AttendanceButton.setkHoverEndColor(new java.awt.Color(9, 144, 30));
        AttendanceButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        AttendanceButton.setkHoverStartColor(new java.awt.Color(76, 241, 101));
        AttendanceButton.setkIndicatorThickness(5);
        AttendanceButton.setkPressedColor(new java.awt.Color(102, 102, 102));
        AttendanceButton.setkSelectedColor(new java.awt.Color(50, 255, 0));
        AttendanceButton.setkStartColor(new java.awt.Color(15, 32, 49));
        AttendanceButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AttendanceButtonMouseEntered(evt);
            }
        });
        AttendanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttendanceButtonActionPerformed(evt);
            }
        });
        NavigationMenu.add(AttendanceButton);
        AttendanceButton.setBounds(10, 210, 180, 40);

        QuizesButton.setBorder(null);
        QuizesButton.setText("Quizes");
        QuizesButton.setToolTipText("");
        QuizesButton.setFocusable(false);
        QuizesButton.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        QuizesButton.setkBorderRadius(38);
        QuizesButton.setkEndColor(new java.awt.Color(44, 83, 100));
        QuizesButton.setkHoverEndColor(new java.awt.Color(9, 144, 30));
        QuizesButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        QuizesButton.setkHoverStartColor(new java.awt.Color(76, 241, 101));
        QuizesButton.setkIndicatorThickness(5);
        QuizesButton.setkPressedColor(new java.awt.Color(102, 102, 102));
        QuizesButton.setkSelectedColor(new java.awt.Color(50, 255, 0));
        QuizesButton.setkStartColor(new java.awt.Color(15, 32, 49));
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
        QuizesButton.setBounds(10, 260, 180, 40);

        ResultButton.setBorder(null);
        ResultButton.setText("Result");
        ResultButton.setToolTipText("");
        ResultButton.setFocusable(false);
        ResultButton.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        ResultButton.setkBorderRadius(38);
        ResultButton.setkEndColor(new java.awt.Color(44, 83, 100));
        ResultButton.setkHoverEndColor(new java.awt.Color(9, 144, 30));
        ResultButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        ResultButton.setkHoverStartColor(new java.awt.Color(76, 241, 101));
        ResultButton.setkIndicatorThickness(5);
        ResultButton.setkPressedColor(new java.awt.Color(102, 102, 102));
        ResultButton.setkSelectedColor(new java.awt.Color(50, 255, 0));
        ResultButton.setkStartColor(new java.awt.Color(15, 32, 49));
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
        ResultButton.setBounds(10, 310, 180, 40);

        SettingsButton.setBorder(null);
        SettingsButton.setText("Settings");
        SettingsButton.setToolTipText("");
        SettingsButton.setFocusable(false);
        SettingsButton.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        SettingsButton.setkBorderRadius(38);
        SettingsButton.setkEndColor(new java.awt.Color(44, 83, 100));
        SettingsButton.setkHoverEndColor(new java.awt.Color(9, 144, 30));
        SettingsButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        SettingsButton.setkHoverStartColor(new java.awt.Color(76, 241, 101));
        SettingsButton.setkIndicatorThickness(5);
        SettingsButton.setkPressedColor(new java.awt.Color(102, 102, 102));
        SettingsButton.setkSelectedColor(new java.awt.Color(50, 255, 0));
        SettingsButton.setkStartColor(new java.awt.Color(15, 32, 49));
        SettingsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SettingsButtonMouseEntered(evt);
            }
        });
        SettingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsButtonActionPerformed(evt);
            }
        });
        NavigationMenu.add(SettingsButton);
        SettingsButton.setBounds(10, 360, 180, 40);

        ContainerPanel.add(NavigationMenu);
        NavigationMenu.setBounds(0, 27, 170, 623);

        DashboardPanel.setkEndColor(new java.awt.Color(238, 242, 243));
        DashboardPanel.setkGradientFocus(800);
        DashboardPanel.setkStartColor(new java.awt.Color(142, 158, 171));
        DashboardPanel.setLayout(null);

        ID.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        DashboardPanel.add(ID);
        ID.setBounds(380, 100, 160, 20);

        IDLabel.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        IDLabel.setText("ID:");
        DashboardPanel.add(IDLabel);
        IDLabel.setBounds(240, 100, 130, 20);

        NameLabel.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        NameLabel.setText("Name:");
        DashboardPanel.add(NameLabel);
        NameLabel.setBounds(240, 130, 130, 20);

        GenderLabel.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        GenderLabel.setText("Gender:");
        DashboardPanel.add(GenderLabel);
        GenderLabel.setBounds(240, 160, 130, 20);

        DepartmentLabel.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        DepartmentLabel.setText("Department:");
        DashboardPanel.add(DepartmentLabel);
        DepartmentLabel.setBounds(240, 190, 130, 20);

        AdmissionDateLabel.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        AdmissionDateLabel.setText("Admission Date:");
        DashboardPanel.add(AdmissionDateLabel);
        AdmissionDateLabel.setBounds(240, 220, 130, 20);

        AdmissionDate.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        DashboardPanel.add(AdmissionDate);
        AdmissionDate.setBounds(380, 220, 160, 20);

        Department.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        DashboardPanel.add(Department);
        Department.setBounds(380, 190, 160, 20);

        Gender.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        DashboardPanel.add(Gender);
        Gender.setBounds(380, 160, 160, 20);

        Name.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        DashboardPanel.add(Name);
        Name.setBounds(380, 130, 160, 20);

        ContainerPanel.add(DashboardPanel);
        DashboardPanel.setBounds(170, 27, 830, 623);

        AttendancePanel.setBackground(new java.awt.Color(0, 255, 0));

        javax.swing.GroupLayout AttendancePanelLayout = new javax.swing.GroupLayout(AttendancePanel);
        AttendancePanel.setLayout(AttendancePanelLayout);
        AttendancePanelLayout.setHorizontalGroup(
            AttendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        AttendancePanelLayout.setVerticalGroup(
            AttendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        AttendancePanel.setVisible(false);

        ContainerPanel.add(AttendancePanel);
        AttendancePanel.setBounds(170, 27, 830, 630);

        QuizPanel.setBackground(new java.awt.Color(255, 0, 255));

        javax.swing.GroupLayout QuizPanelLayout = new javax.swing.GroupLayout(QuizPanel);
        QuizPanel.setLayout(QuizPanelLayout);
        QuizPanelLayout.setHorizontalGroup(
            QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        QuizPanelLayout.setVerticalGroup(
            QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );

        QuizPanel.setVisible(false);

        ContainerPanel.add(QuizPanel);
        QuizPanel.setBounds(170, 27, 830, 623);

        ResultPanel.setBackground(new java.awt.Color(0, 0, 204));

        javax.swing.GroupLayout ResultPanelLayout = new javax.swing.GroupLayout(ResultPanel);
        ResultPanel.setLayout(ResultPanelLayout);
        ResultPanelLayout.setHorizontalGroup(
            ResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        ResultPanelLayout.setVerticalGroup(
            ResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );

        ResultPanel.setVisible(false);

        ContainerPanel.add(ResultPanel);
        ResultPanel.setBounds(170, 27, 830, 623);

        SettingsPanel.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout SettingsPanelLayout = new javax.swing.GroupLayout(SettingsPanel);
        SettingsPanel.setLayout(SettingsPanelLayout);
        SettingsPanelLayout.setHorizontalGroup(
            SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        SettingsPanelLayout.setVerticalGroup(
            SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );

        SettingsPanel.setVisible(false);

        ContainerPanel.add(SettingsPanel);
        SettingsPanel.setBounds(170, 27, 830, 623);

        getContentPane().add(ContainerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void updateID(String n){
        ID.setText(n);
    }
            
    public void updateName(String n){
        Name.setText(n);
    }
    
    public void updateGender(String n){
        Gender.setText(n);
    }
    
    public void updateDep(String n){
        Department.setText(n);
    }
    
    public void updateDate(String n){
        AdmissionDate.setText(n);
    }
    private void TitleBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TitleBarMousePressed
        xx = evt.getX();
        yy = evt.getY();
    }//GEN-LAST:event_TitleBarMousePressed

    private void TitleBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TitleBarMouseDragged
        x = evt.getXOnScreen();
        y = evt.getYOnScreen();
        this.setLocation(x - xx, y - yy);
    }//GEN-LAST:event_TitleBarMouseDragged
    
    private void DashBoardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashBoardButtonActionPerformed
        DashboardPanel.setVisible(true);
        AttendancePanel.setVisible(false);
        QuizPanel.setVisible(false);
        ResultPanel.setVisible(false);
        SettingsPanel.setVisible(false);
    }//GEN-LAST:event_DashBoardButtonActionPerformed

    private void AttendanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttendanceButtonActionPerformed
        DashboardPanel.setVisible(false);
        AttendancePanel.setVisible(true);
        QuizPanel.setVisible(false);
        ResultPanel.setVisible(false);
        SettingsPanel.setVisible(false);
    }//GEN-LAST:event_AttendanceButtonActionPerformed

    private void QuizesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuizesButtonActionPerformed
        DashboardPanel.setVisible(false);
        AttendancePanel.setVisible(false);
        QuizPanel.setVisible(true);
        ResultPanel.setVisible(false);
        SettingsPanel.setVisible(false);
    }//GEN-LAST:event_QuizesButtonActionPerformed

    private void ResultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResultButtonActionPerformed
        DashboardPanel.setVisible(false);
        AttendancePanel.setVisible(false);
        QuizPanel.setVisible(false);
        ResultPanel.setVisible(true);
        SettingsPanel.setVisible(false);
    }//GEN-LAST:event_ResultButtonActionPerformed

    private void SettingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingsButtonActionPerformed
        DashboardPanel.setVisible(false);
        AttendancePanel.setVisible(false);
        QuizPanel.setVisible(false);
        ResultPanel.setVisible(false);
        SettingsPanel.setVisible(true);
    }//GEN-LAST:event_SettingsButtonActionPerformed
    
    private void DashBoardButtonMouseEntered(java.awt.event.MouseEvent evt){}
    private void AttendanceButtonMouseEntered(java.awt.event.MouseEvent evt){}
    private void QuizesButtonMouseEntered(java.awt.event.MouseEvent evt){}
    private void ResultButtonMouseEntered(java.awt.event.MouseEvent evt){}
    private void SettingsButtonMouseEntered(java.awt.event.MouseEvent evt){}
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherDashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdmissionDate;
    private javax.swing.JLabel AdmissionDateLabel;
    private com.k33ptoo.components.KButton AttendanceButton;
    private javax.swing.JPanel AttendancePanel;
    private javax.swing.JPanel ContainerPanel;
    private com.k33ptoo.components.KButton DashBoardButton;
    private keeptoo.KGradientPanel DashboardPanel;
    private javax.swing.JLabel Department;
    private javax.swing.JLabel DepartmentLabel;
    private javax.swing.JLabel Gender;
    private javax.swing.JLabel GenderLabel;
    private javax.swing.JLabel ID;
    private javax.swing.JLabel IDLabel;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel NameLabel;
    private keeptoo.KGradientPanel NavigationMenu;
    private javax.swing.JPanel QuizPanel;
    private com.k33ptoo.components.KButton QuizesButton;
    private com.k33ptoo.components.KButton ResultButton;
    private javax.swing.JPanel ResultPanel;
    private com.k33ptoo.components.KButton SettingsButton;
    private javax.swing.JPanel SettingsPanel;
    private keeptoo.KGradientPanel TitleBar;
    // End of variables declaration//GEN-END:variables
}
