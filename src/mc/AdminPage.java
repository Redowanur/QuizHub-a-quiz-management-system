/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mc;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ASUS
 */
public class AdminPage extends javax.swing.JFrame implements MouseInputListener {
    JLabel label5, a, label6, label7, b;
    int x, xx, y, yy;

    /**
     * Creates new form AdminPage
     */
    public AdminPage() {
        initComponents();
        StudentTable.fixTable(jScrollPane1);
        TeacherTable.fixTable(jScrollPane2);
        StudentTable.getColumnModel().getColumn(2).setPreferredWidth(3);
        StudentTable.getColumnModel().getColumn(1).setPreferredWidth(30);
        TeacherTable.getColumnModel().getColumn(2).setPreferredWidth(3);
        TeacherTable.getColumnModel().getColumn(1).setPreferredWidth(30);
        show_students();
        show_teachers();
        
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
    }

    public ArrayList<Students> StudentList() {
        ArrayList<Students> StudentList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
            String query = "select * from student";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            Students students;
            while (rs.next()) {
                students = new Students(rs.getString("name"), rs.getString("reg_no"), rs.getString("department"), rs.getString("address"), rs.getString("phone"));
                StudentList.add(students);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return StudentList;
    }

    public void show_students() {
        ArrayList<Students> list = StudentList();
        DefaultTableModel model = (DefaultTableModel) StudentTable.getModel();
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getName();
            row[1] = list.get(i).getReg();
            row[2] = list.get(i).getDept();
            row[3] = list.get(i).getAddress();
            row[4] = list.get(i).getPhone();
            model.addRow(row);
        }
    }

    public ArrayList<Teachers> TeacherList() {
        ArrayList<Teachers> TeacherList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
            String query = "select * from teacher";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            Teachers teachers;
            while (rs.next()) {
                teachers = new Teachers(rs.getString("name"), rs.getString("id"), rs.getString("department"), rs.getString("address"), rs.getString("phone"));
                TeacherList.add(teachers);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return TeacherList;
    }

    public void show_teachers() {
        ArrayList<Teachers> list = TeacherList();
        DefaultTableModel model = (DefaultTableModel) TeacherTable.getModel();
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getName();
            row[1] = list.get(i).getId();
            row[2] = list.get(i).getDept();
            row[3] = list.get(i).getAddress();
            row[4] = list.get(i).getPhone();
            model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        pan = new keeptoo.KGradientPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        kButton1 = new com.k33ptoo.components.KButton();
        kButton2 = new com.k33ptoo.components.KButton();
        jLabel7 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        StudentPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        StudentTable = new tabledark.TableDark();
        jLabel1 = new javax.swing.JLabel();
        ExportButton1 = new com.k33ptoo.components.KButton();
        StudentDelete = new com.k33ptoo.components.KButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Reg_no = new textfield.TextField();
        StudentName = new textfield.TextField();
        ImportButton1 = new com.k33ptoo.components.KButton();
        TeacherPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TeacherTable = new tabledark.TableDark();
        jLabel2 = new javax.swing.JLabel();
        ExportButton2 = new com.k33ptoo.components.KButton();
        ImportButton2 = new com.k33ptoo.components.KButton();
        TeacherDelete = new com.k33ptoo.components.KButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TeacherID = new textfield.TextField();
        TeacherName = new textfield.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pan.setkEndColor(new java.awt.Color(52, 73, 94));
        pan.setkGradientFocus(0);
        pan.setkStartColor(new java.awt.Color(23, 32, 42));
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

        javax.swing.GroupLayout panLayout = new javax.swing.GroupLayout(pan);
        pan.setLayout(panLayout);
        panLayout.setHorizontalGroup(
            panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        panLayout.setVerticalGroup(
            panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jPanel1.add(pan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 191, 143));
        kGradientPanel1.setkGradientFocus(300);
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 21, 16));
        kGradientPanel1.setLayout(null);

        kButton1.setBorder(null);
        kButton1.setText("Students");
        kButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        kButton1.setkBorderRadius(0);
        kButton1.setkEndColor(new java.awt.Color(56, 239, 125));
        kButton1.setkHoverEndColor(new java.awt.Color(17, 153, 142));
        kButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton1.setkHoverStartColor(new java.awt.Color(56, 239, 125));
        kButton1.setkStartColor(new java.awt.Color(17, 153, 142));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(kButton1);
        kButton1.setBounds(0, 140, 150, 36);

        kButton2.setBorder(null);
        kButton2.setText("Teachers");
        kButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        kButton2.setkBorderRadius(0);
        kButton2.setkEndColor(new java.awt.Color(56, 239, 125));
        kButton2.setkHoverEndColor(new java.awt.Color(17, 153, 142));
        kButton2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton2.setkHoverStartColor(new java.awt.Color(56, 239, 125));
        kButton2.setkStartColor(new java.awt.Color(17, 153, 142));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(kButton2);
        kButton2.setBounds(0, 204, 150, 36);

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
        kGradientPanel1.add(jLabel7);
        jLabel7.setBounds(28, 580, 90, 30);

        jPanel1.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 27, 150, 623));

        jTabbedPane1.setBackground(new java.awt.Color(51, 51, 51));

        StudentPanel.setBackground(new java.awt.Color(51, 51, 51));
        StudentPanel.setLayout(null);

        jScrollPane1.setHorizontalScrollBarPolicy(30);
        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));

        StudentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Reg no", "Dept", "Address", "Phone"
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
        StudentTable.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        StudentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(StudentTable);

        StudentPanel.add(jScrollPane1);
        jScrollPane1.setBounds(230, 60, 600, 500);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Student Information");
        StudentPanel.add(jLabel1);
        jLabel1.setBounds(450, 20, 180, 30);

        ExportButton1.setBorder(null);
        ExportButton1.setText("Export (Excel)");
        ExportButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        ExportButton1.setkBorderRadius(20);
        ExportButton1.setkEndColor(new java.awt.Color(100, 100, 100));
        ExportButton1.setkHoverEndColor(new java.awt.Color(70, 70, 70));
        ExportButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        ExportButton1.setkHoverStartColor(new java.awt.Color(100, 100, 100));
        ExportButton1.setkStartColor(new java.awt.Color(70, 70, 70));
        ExportButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportButton1ActionPerformed(evt);
            }
        });
        StudentPanel.add(ExportButton1);
        ExportButton1.setBounds(390, 580, 120, 35);

        StudentDelete.setBorder(null);
        StudentDelete.setText("Delete");
        StudentDelete.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        StudentDelete.setkBorderRadius(20);
        StudentDelete.setkEndColor(new java.awt.Color(100, 100, 100));
        StudentDelete.setkHoverEndColor(new java.awt.Color(70, 70, 70));
        StudentDelete.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        StudentDelete.setkHoverStartColor(new java.awt.Color(100, 100, 100));
        StudentDelete.setkStartColor(new java.awt.Color(70, 70, 70));
        StudentDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentDeleteActionPerformed(evt);
            }
        });
        StudentPanel.add(StudentDelete);
        StudentDelete.setBounds(20, 260, 80, 35);

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Reg no:");
        StudentPanel.add(jLabel3);
        jLabel3.setBounds(20, 160, 70, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name:");
        StudentPanel.add(jLabel4);
        jLabel4.setBounds(20, 60, 40, 30);

        Reg_no.setBackground(new java.awt.Color(51, 51, 51));
        Reg_no.setBorder(null);
        Reg_no.setForeground(new java.awt.Color(255, 255, 255));
        Reg_no.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Reg_no.setLabelText("");
        Reg_no.setLineColor(new java.awt.Color(255, 255, 255));
        Reg_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reg_noActionPerformed(evt);
            }
        });
        StudentPanel.add(Reg_no);
        Reg_no.setBounds(20, 200, 190, 30);

        StudentName.setBackground(new java.awt.Color(51, 51, 51));
        StudentName.setBorder(null);
        StudentName.setForeground(new java.awt.Color(255, 255, 255));
        StudentName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        StudentName.setLabelText("");
        StudentName.setLineColor(new java.awt.Color(255, 255, 255));
        StudentPanel.add(StudentName);
        StudentName.setBounds(20, 100, 190, 30);

        ImportButton1.setBorder(null);
        ImportButton1.setText("Import (Excel)");
        ImportButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        ImportButton1.setkBorderRadius(20);
        ImportButton1.setkEndColor(new java.awt.Color(100, 100, 100));
        ImportButton1.setkHoverEndColor(new java.awt.Color(70, 70, 70));
        ImportButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        ImportButton1.setkHoverStartColor(new java.awt.Color(100, 100, 100));
        ImportButton1.setkStartColor(new java.awt.Color(70, 70, 70));
        ImportButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportButton1ActionPerformed(evt);
            }
        });
        StudentPanel.add(ImportButton1);
        ImportButton1.setBounds(230, 580, 120, 35);

        jTabbedPane1.addTab("Student", StudentPanel);

        TeacherPanel.setBackground(new java.awt.Color(51, 51, 51));
        TeacherPanel.setLayout(null);

        jScrollPane1.setHorizontalScrollBarPolicy(30);
        jScrollPane2.setBackground(new java.awt.Color(0, 0, 0));

        TeacherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "ID", "Dept", "Address", "Phone"
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
        TeacherTable.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        TeacherTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TeacherTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TeacherTable);

        TeacherPanel.add(jScrollPane2);
        jScrollPane2.setBounds(230, 60, 600, 500);

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Teacher Information");
        TeacherPanel.add(jLabel2);
        jLabel2.setBounds(450, 20, 180, 30);

        ExportButton2.setBorder(null);
        ExportButton2.setText("Export (Excel)");
        ExportButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        ExportButton2.setkBorderRadius(20);
        ExportButton2.setkEndColor(new java.awt.Color(100, 100, 100));
        ExportButton2.setkHoverEndColor(new java.awt.Color(70, 70, 70));
        ExportButton2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        ExportButton2.setkHoverStartColor(new java.awt.Color(100, 100, 100));
        ExportButton2.setkStartColor(new java.awt.Color(70, 70, 70));
        ExportButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportButton2ActionPerformed(evt);
            }
        });
        TeacherPanel.add(ExportButton2);
        ExportButton2.setBounds(390, 580, 120, 35);

        ImportButton2.setBorder(null);
        ImportButton2.setText("Import (Excel)");
        ImportButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        ImportButton2.setkBorderRadius(20);
        ImportButton2.setkEndColor(new java.awt.Color(100, 100, 100));
        ImportButton2.setkHoverEndColor(new java.awt.Color(70, 70, 70));
        ImportButton2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        ImportButton2.setkHoverStartColor(new java.awt.Color(100, 100, 100));
        ImportButton2.setkStartColor(new java.awt.Color(70, 70, 70));
        ImportButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportButton2ActionPerformed(evt);
            }
        });
        TeacherPanel.add(ImportButton2);
        ImportButton2.setBounds(230, 580, 120, 35);

        TeacherDelete.setBorder(null);
        TeacherDelete.setText("Delete");
        TeacherDelete.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        TeacherDelete.setkBorderRadius(20);
        TeacherDelete.setkEndColor(new java.awt.Color(100, 100, 100));
        TeacherDelete.setkHoverEndColor(new java.awt.Color(70, 70, 70));
        TeacherDelete.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        TeacherDelete.setkHoverStartColor(new java.awt.Color(100, 100, 100));
        TeacherDelete.setkStartColor(new java.awt.Color(70, 70, 70));
        TeacherDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeacherDeleteActionPerformed(evt);
            }
        });
        TeacherPanel.add(TeacherDelete);
        TeacherDelete.setBounds(20, 260, 80, 35);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID:");
        TeacherPanel.add(jLabel5);
        jLabel5.setBounds(20, 160, 70, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Name:");
        TeacherPanel.add(jLabel6);
        jLabel6.setBounds(20, 60, 40, 30);

        TeacherID.setBackground(new java.awt.Color(51, 51, 51));
        TeacherID.setBorder(null);
        TeacherID.setForeground(new java.awt.Color(255, 255, 255));
        TeacherID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TeacherID.setLabelText("");
        TeacherID.setLineColor(new java.awt.Color(255, 255, 255));
        TeacherID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeacherIDActionPerformed(evt);
            }
        });
        TeacherPanel.add(TeacherID);
        TeacherID.setBounds(20, 200, 190, 30);

        TeacherName.setBackground(new java.awt.Color(51, 51, 51));
        TeacherName.setBorder(null);
        TeacherName.setForeground(new java.awt.Color(255, 255, 255));
        TeacherName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TeacherName.setLabelText("");
        TeacherName.setLineColor(new java.awt.Color(255, 255, 255));
        TeacherPanel.add(TeacherName);
        TeacherName.setBounds(20, 100, 190, 30);

        jTabbedPane1.addTab("Teacher", TeacherPanel);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, -10, 850, 660));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void panMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panMouseDragged
        x = evt.getXOnScreen();
        y = evt.getYOnScreen();
        this.setLocation(x - xx, y - yy);
    }//GEN-LAST:event_panMouseDragged

    private void panMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panMousePressed
        xx = evt.getX();
        yy = evt.getY();
    }//GEN-LAST:event_panMousePressed

    private void Reg_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reg_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Reg_noActionPerformed

    private void TeacherIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeacherIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TeacherIDActionPerformed

    private void TeacherTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TeacherTableMouseClicked
        int row = TeacherTable.getSelectedRow();
        String tName = TeacherTable.getModel().getValueAt(row, 0).toString();
        String tID = TeacherTable.getModel().getValueAt(row, 1).toString();
        TeacherName.setText(tName);
        TeacherID.setText(tID);
    }//GEN-LAST:event_TeacherTableMouseClicked

    private void StudentDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentDeleteActionPerformed
        int row = StudentTable.getSelectedRow();
        String sID = StudentTable.getModel().getValueAt(row, 1).toString();
        DefaultTableModel model = (DefaultTableModel) StudentTable.getModel();
        try {
            if (StudentTable.getSelectedRowCount() == 1) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
                String query = "delete from student where reg_no = '" + sID + "'";
                Statement st = con.createStatement();
                st.executeUpdate(query);
                model.removeRow(row);
                StudentName.setText("");
                Reg_no.setText("");
            } else {
                if (StudentTable.getSelectedRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "Table is Empty.");
                } else {
                    JOptionPane.showMessageDialog(this, "Please select single row to delete.");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_StudentDeleteActionPerformed

    private void StudentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentTableMouseClicked
        int row = StudentTable.getSelectedRow();
        String sName = StudentTable.getModel().getValueAt(row, 0).toString();
        String sID = StudentTable.getModel().getValueAt(row, 1).toString();
        StudentName.setText(sName);
        Reg_no.setText(sID);
    }//GEN-LAST:event_StudentTableMouseClicked

    private void TeacherDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeacherDeleteActionPerformed
        int row = TeacherTable.getSelectedRow();
        String tID = TeacherTable.getModel().getValueAt(row, 1).toString();
        DefaultTableModel model = (DefaultTableModel) TeacherTable.getModel();
        try {
            if (TeacherTable.getSelectedRowCount() == 1) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
                String query = "delete from teacher where id = '" + tID + "'";
                Statement st = con.createStatement();
                st.executeUpdate(query);
                model.removeRow(row);
                TeacherName.setText("");
                TeacherID.setText("");
            } else {
                if (TeacherTable.getSelectedRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "Table is Empty.");
                } else {
                    JOptionPane.showMessageDialog(this, "Please select single row to delete.");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_TeacherDeleteActionPerformed

    private void ImportButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) StudentTable.getModel();
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelTableImport = null;
        String defPath = "C:\\Users\\ASUS\\Documents";
        JFileChooser fileChooser = new JFileChooser(defPath);
        int excelChooser = fileChooser.showOpenDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            try {
                excelFile = fileChooser.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelTableImport = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelTableImport.getSheetAt(0);
                
                for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
                    XSSFRow excelRow = excelSheet.getRow(row);
                    
                    XSSFCell name = excelRow.getCell(0);
                    XSSFCell reg_no = excelRow.getCell(1);
                    XSSFCell dept = excelRow.getCell(2);
                    XSSFCell adrs = excelRow.getCell(3);
                    XSSFCell phn = excelRow.getCell(4);
                    
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
                    String query = "insert into student(name, reg_no, department, address, phone) value('"+name+"', '"+reg_no+"', '"+dept+"', '"+adrs+"', '"+phn+"')";
                    Statement st = con.createStatement();
                    st.executeUpdate(query);
                    model.addRow(new Object[] {name, reg_no, dept, adrs, phn});
                }
                
                JOptionPane.showMessageDialog(null, "Imported Successfully.");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ImportButton1ActionPerformed

    private void ExportButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportButton1ActionPerformed
        FileOutputStream output = null;
        BufferedOutputStream bou = null;
        XSSFWorkbook te = null;
        DefaultTableModel model = (DefaultTableModel) StudentTable.getModel();
        String defPath = "C:\\Users\\ASUS\\Documents";
        JFileChooser fileChooser = new JFileChooser(defPath);
        fileChooser.setDialogTitle("save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        fileChooser.setFileFilter(fnef);
        int chooser = fileChooser.showSaveDialog(null);
        
        if(chooser == JFileChooser.APPROVE_OPTION){
            try {
                te = new XSSFWorkbook();
                XSSFSheet sheet = te.createSheet("JTable Sheet");

                for(int i = 0; i < model.getRowCount(); i++){
                    XSSFRow row = sheet.createRow(i);
                    for(int j = 0; j < model.getColumnCount(); j++){
                        XSSFCell cell = row.createCell(j);
                        cell.setCellValue(model.getValueAt(i, j).toString());
                    }
                }
                output = new FileOutputStream(fileChooser.getSelectedFile() + ".xlsx");
                bou = new BufferedOutputStream(output);
                te.write(bou);
                JOptionPane.showMessageDialog(null, "Exported Successfully.");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if(bou != null){
                        bou.close();
                    }
                    if(output != null){
                        output.close();
                    }
                    if(te != null){
                        te.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_ExportButton1ActionPerformed

    private void ImportButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) TeacherTable.getModel();
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelTableImport = null;
        String defPath = "C:\\Users\\ASUS\\Documents";
        JFileChooser fileChooser = new JFileChooser(defPath);
        int excelChooser = fileChooser.showOpenDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            try {
                excelFile = fileChooser.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelTableImport = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelTableImport.getSheetAt(0);
                
                for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
                    XSSFRow excelRow = excelSheet.getRow(row);
                    
                    XSSFCell name = excelRow.getCell(0);
                    XSSFCell id = excelRow.getCell(1);
                    XSSFCell dept = excelRow.getCell(2);
                    XSSFCell adrs = excelRow.getCell(3);
                    XSSFCell phn = excelRow.getCell(4);
                    
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizhub", "root", "connected");
                    String query = "insert into teacher(name, id, department, address, phone) value('"+name+"', '"+id+"', '"+dept+"', '"+adrs+"', '"+phn+"')";
                    Statement st = con.createStatement();
                    st.executeUpdate(query);
                    model.addRow(new Object[] {name, id, dept, adrs, phn});
                }
                
                JOptionPane.showMessageDialog(null, "Imported Successfully.");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ImportButton2ActionPerformed

    private void ExportButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportButton2ActionPerformed
        FileOutputStream output = null;
        BufferedOutputStream bou = null;
        XSSFWorkbook te = null;
        DefaultTableModel model = (DefaultTableModel) TeacherTable.getModel();
        String defPath = "C:\\Users\\ASUS\\Documents";
        JFileChooser fileChooser = new JFileChooser(defPath);
        fileChooser.setDialogTitle("save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        fileChooser.setFileFilter(fnef);
        int chooser = fileChooser.showSaveDialog(null);
        
        if(chooser == JFileChooser.APPROVE_OPTION){
            try {
                te = new XSSFWorkbook();
                XSSFSheet sheet = te.createSheet("JTable Sheet");

                for(int i = 0; i < model.getRowCount(); i++){
                    XSSFRow row = sheet.createRow(i);
                    for(int j = 0; j < model.getColumnCount(); j++){
                        XSSFCell cell = row.createCell(j);
                        cell.setCellValue(model.getValueAt(i, j).toString());
                    }
                }
                output = new FileOutputStream(fileChooser.getSelectedFile() + ".xlsx");
                bou = new BufferedOutputStream(output);
                te.write(bou);
                JOptionPane.showMessageDialog(null, "Exported Successfully.");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if(bou != null){
                        bou.close();
                    }
                    if(output != null){
                        output.close();
                    }
                    if(te != null){
                        te.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_ExportButton2ActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_kButton1ActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_kButton2ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        int val = JOptionPane.showConfirmDialog(null, "Do you want to Log out?");
        if(val == 0){
            HomePage hp = new HomePage();
            hp.setVisible(true);
            hp.setLocation(this.getX(), this.getY());
            dispose();
        }
    }//GEN-LAST:event_jLabel7MouseClicked

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
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton ExportButton1;
    private com.k33ptoo.components.KButton ExportButton2;
    private com.k33ptoo.components.KButton ImportButton1;
    private com.k33ptoo.components.KButton ImportButton2;
    private textfield.TextField Reg_no;
    private com.k33ptoo.components.KButton StudentDelete;
    private textfield.TextField StudentName;
    private javax.swing.JPanel StudentPanel;
    private tabledark.TableDark StudentTable;
    private com.k33ptoo.components.KButton TeacherDelete;
    private textfield.TextField TeacherID;
    private textfield.TextField TeacherName;
    private javax.swing.JPanel TeacherPanel;
    private tabledark.TableDark TeacherTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel pan;
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
