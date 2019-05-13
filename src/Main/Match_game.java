/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Button;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mrrob
 */
public class Match_game extends javax.swing.JFrame {

    /**
     * Creates new form Match_game
     */
    int score=0;
    public Match_game() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        btnassign();

        //setup.start();
    }

    JButton[] b = new JButton[8];
    int[] a = new int[8];
    int[] flag = new int[8];
    int click=0;

    void btnassign() {
        for (int i = 0; i < 8; i++) {
            a[i] = 0;
            flag[i] = 0;
        }
        b[0] = jButton1;
        b[1] = jButton2;
        b[2] = jButton3;
        b[3] = jButton4;
        b[4] = jButton5;
        b[5] = jButton6;
        b[6] = jButton7;
        b[7] = jButton8;
        
        cover();
        
    }

    Thread setup = new Thread(new Runnable() {
        @Override
        public void run() {
            Random rand = new Random();
            for (int i = 1; i <= 4; i++) {
                String s = "/pfoto/200_" + i + ".png";
                System.out.println(s);
                int count = 2;
                while (count > 0) {
                    int r = rand.nextInt(8);
                    if (a[r] == 0) {
                        a[r] = i;
                        b[r].setIcon(new ImageIcon(getClass().getResource(s)));
                        r = rand.nextInt(8);
                        count--;
                    }
                }
            }
            goto1();
        }
    });

    void goto1() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ex) {
            Logger.getLogger(Match_game.class.getName()).log(Level.SEVERE, null, ex);
        }

        start.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Match_game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Thread start = new Thread(new Runnable() {
        @Override
        public void run() {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Match_game.class.getName()).log(Level.SEVERE, null, ex);
//            }

            cover();

            setup.stop();

            int count = 4;

            while (count > 0) {
                System.out.println(click);
                if (click == 2) {
                    //System.out.println("2 click");
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (i != j && flag[i] == 1 && flag[j] == 1 && a[i] == a[j]) {
                                try {
                                    TimeUnit.MILLISECONDS.sleep(400);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(Match_game.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                System.out.println("Milse");
                                count--;
                                b[i].setIcon(new ImageIcon(getClass().getResource("/pfoto/b_cvr.png")));
                                b[j].setIcon(new ImageIcon(getClass().getResource("/pfoto/b_cvr.png")));
                                b[i].setEnabled(false);
                                b[j].setEnabled(false);
                                flag[i] = 2;
                                flag[j] = 2;
                                click = 0;
                                score+=10;
                                Scr.setText("Score: "+score);
                            }
                        }
                    }

                }
                if (click == 2) {
                    //System.out.println("0 click");
                    for (int i = 0; i < 8; i++) {
                        if (flag[i] == 1) {
                            flag[i] = 0;
                            b[i].setIcon(new ImageIcon(getClass().getResource("/pfoto/f_cvr.png")));
                        }
                    }
                    score-=5;
                    Scr.setText("Score: "+score);
                    click=0;
                }

            }
            
            Menu m = new Menu();
            m.setVisible(true);
            dispose();

        }

    });

    private void cover() {
        String s = "/pfoto/f_cvr.png";
        for (int i = 0; i < 8; i++) {
            if(flag[i]==0){
                b[i].setIcon(new ImageIcon(getClass().getResource(s)));
            }
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

        jPanel2 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        Scr = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Bacground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(null);

        jButton9.setText("Start");
        jButton9.setBorder(new javax.swing.border.MatteBorder(null));
        jButton9.setBorderPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9);
        jButton9.setBounds(250, 300, 60, 20);

        Scr.setBackground(new java.awt.Color(255, 233, 245));
        Scr.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Scr.setForeground(new java.awt.Color(255, 255, 255));
        Scr.setText("Score: 00");
        jPanel2.add(Scr);
        Scr.setBounds(20, 10, 110, 30);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pfoto/200_4.png"))); // NOI18N
        jButton7.setText("jButton2");
        jButton7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7);
        jButton7.setBounds(430, 170, 90, 60);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pfoto/200_4.png"))); // NOI18N
        jButton8.setText("jButton2");
        jButton8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8);
        jButton8.setBounds(430, 80, 90, 60);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pfoto/200_3.png"))); // NOI18N
        jButton4.setText("jButton2");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(300, 170, 90, 60);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pfoto/200_2.png"))); // NOI18N
        jButton5.setText("jButton2");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(190, 170, 90, 60);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pfoto/200_1.png"))); // NOI18N
        jButton6.setText("jButton1");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6);
        jButton6.setBounds(70, 170, 90, 60);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pfoto/200_3.png"))); // NOI18N
        jButton3.setText("jButton2");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(300, 80, 90, 60);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pfoto/200_2.png"))); // NOI18N
        jButton2.setText("jButton2");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(190, 80, 90, 60);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pfoto/200_1.png"))); // NOI18N
        jButton1.setText("jButton1");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(70, 80, 90, 60);

        Bacground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/game_screen.jpg"))); // NOI18N
        Bacground.setText("jLabel2");
        jPanel2.add(Bacground);
        Bacground.setBounds(0, 0, 600, 400);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        flag[0] = 1;
        click++;

        switch (a[0]) {
            case 1:
                b[0].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_1.png")));
                break;
            case 2:
                b[0].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_2.png")));
                break;
            case 3:
                b[0].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_3.png")));
                break;
            case 4:
                b[0].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_4.png")));
                break;
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        flag[1] = 1;

        click++;

        switch (a[1]) {
            case 1:
                b[1].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_1.png")));
                break;
            case 2:
                b[1].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_2.png")));
                break;
            case 3:
                b[1].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_3.png")));
                break;
            case 4:
                b[1].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_4.png")));
                break;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        flag[2] = 1;
        click++;

        switch (a[2]) {
            case 1:
                b[2].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_1.png")));
                break;
            case 2:
                b[2].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_2.png")));
                break;
            case 3:
                b[2].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_3.png")));
                break;
            case 4:
                b[2].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_4.png")));
                break;
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        flag[7] = 1;
        click++;

        switch (a[7]) {
            case 1:
                b[7].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_1.png")));
                break;
            case 2:
                b[7].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_2.png")));
                break;
            case 3:
                b[7].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_3.png")));
                break;
            case 4:
                b[7].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_4.png")));
                break;
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        flag[5] = 1;
        click++;

        switch (a[5]) {
            case 1:
                b[5].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_1.png")));
                break;
            case 2:
                b[5].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_2.png")));
                break;
            case 3:
                b[5].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_3.png")));
                break;
            case 4:
                b[5].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_4.png")));
                break;
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        flag[4] = 1;
        click++;

        switch (a[4]) {
            case 1:
                b[4].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_1.png")));
                break;
            case 2:
                b[4].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_2.png")));
                break;
            case 3:
                b[4].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_3.png")));
                break;
            case 4:
                b[4].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_4.png")));
                break;
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        flag[3] = 1;
        click++;

        switch (a[3]) {
            case 1:
                b[3].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_1.png")));
                break;
            case 2:
                b[3].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_2.png")));
                break;
            case 3:
                b[3].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_3.png")));
                break;
            case 4:
                b[3].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_4.png")));
                break;
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        flag[6] = 1;
        click++;

        switch (a[6]) {
            case 1:
                b[6].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_1.png")));
                break;
            case 2:
                b[6].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_2.png")));
                break;
            case 3:
                b[6].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_3.png")));
                break;
            case 4:
                b[6].setIcon(new ImageIcon(getClass().getResource("/pfoto/200_4.png")));
                break;
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        setup.start();
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(Match_game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Match_game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Match_game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Match_game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Match_game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bacground;
    private javax.swing.JLabel Scr;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
