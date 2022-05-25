package mc;

import javax.swing.JOptionPane;

public class SplashScreen extends javax.swing.JFrame {
    
    public SplashScreen() {
        initComponents();
    }
                         
    private void initComponents() {

        BackgroundPanel = new javax.swing.JPanel();
        LoadingLabel = new javax.swing.JLabel();
        AppName = new javax.swing.JLabel();
        LoadingBar = new javax.swing.JProgressBar();
        LoadingValue = new javax.swing.JLabel();
        WelcomeNote = new javax.swing.JLabel();
        BackgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        BackgroundPanel.setBackground(new java.awt.Color(0, 255, 255));
        BackgroundPanel.setPreferredSize(new java.awt.Dimension(1000, 650));
        BackgroundPanel.setLayout(null);

        LoadingLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LoadingLabel.setForeground(new java.awt.Color(255, 255, 255));
        LoadingLabel.setText("Loading....");
        LoadingLabel.setBounds(10, 610, 200, 30);
        BackgroundPanel.add(LoadingLabel);

        AppName.setFont(new java.awt.Font("Segoe UI", 1, 70)); // NOI18N
        AppName.setForeground(new java.awt.Color(255, 255, 255));
        AppName.setText("Quiz Hub");
        AppName.setBounds(155, 368, 310, 80);
        BackgroundPanel.add(AppName);

        LoadingBar.setBackground(new java.awt.Color(255, 255, 255));
        LoadingBar.setForeground(new java.awt.Color(249, 66, 66));
        LoadingBar.setBorder(null);
        LoadingBar.setBorderPainted(false);
        LoadingBar.setBounds(0, 640, 1000, 10);
        BackgroundPanel.add(LoadingBar);

        LoadingValue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LoadingValue.setForeground(new java.awt.Color(255, 255, 255));
        LoadingValue.setText("0 %");
        LoadingValue.setBounds(950, 605, 50, 40);
        BackgroundPanel.add(LoadingValue);

        WelcomeNote.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        WelcomeNote.setForeground(new java.awt.Color(255, 255, 255));
        WelcomeNote.setText("Make quiz with ease");
        WelcomeNote.setBounds(160, 440, 200, 40);
        BackgroundPanel.add(WelcomeNote);

        BackgroundImage.setIcon(new javax.swing.ImageIcon("src/mc/assests/gradient.png")); // NOI18N
        BackgroundImage.setBounds(0, -30, 1060, 710);
        BackgroundPanel.add(BackgroundImage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }                       

    public static void main(String args[]) {
        //UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Metal".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        SplashScreen sp = new SplashScreen();
        sp.setVisible(true);
        
        try{
            for(int i = 0; i <= 100; i++){
                Thread.sleep(30);
                sp.LoadingValue.setText(i +"%");
                
                if(i == 10){
                    sp.LoadingLabel.setText("Turning on Modules...");
                }
                if(i == 20){
                    sp.LoadingLabel.setText("Loading Modules...");
                }
                if(i == 50){
                    sp.LoadingLabel.setText("Connecting to Database...");
                }
                if(i == 70){
                    sp.LoadingLabel.setText("Connection Successful !");
                }
                if(i == 80){
                    sp.LoadingLabel.setText("Launching Application...");
                }
                sp.LoadingBar.setValue(i);
            }
            HomePage homePage = new HomePage();
            homePage.setVisible(true);
            homePage.setLocationRelativeTo(null);
            sp.dispose();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel AppName;
    private javax.swing.JLabel BackgroundImage;
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JProgressBar LoadingBar;
    private javax.swing.JLabel LoadingLabel;
    private javax.swing.JLabel LoadingValue;
    private javax.swing.JLabel WelcomeNote;
    // End of variables declaration                   
}
