/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

/**
 *
 * @author DELL
 */
public class VerHorario extends javax.swing.JFrame {

    /**
     * Creates new form VerHorario
     */
    public VerHorario() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        Lab3 = new javax.swing.JButton();
        Lab1 = new javax.swing.JButton();
        Lab4 = new javax.swing.JButton();
        Lab2 = new javax.swing.JButton();
        regresar = new javax.swing.JButton();
        exitPr = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lab3.setBackground(new java.awt.Color(0, 0, 51));
        Lab3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Lab3.setForeground(new java.awt.Color(255, 255, 255));
        Lab3.setText("LABORATORIO 03");
        Lab3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lab3ActionPerformed(evt);
            }
        });
        jPanel4.add(Lab3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, -1, 40));

        Lab1.setBackground(new java.awt.Color(0, 0, 51));
        Lab1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Lab1.setForeground(new java.awt.Color(255, 255, 255));
        Lab1.setText("LABORATORIO 01");
        Lab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lab1ActionPerformed(evt);
            }
        });
        jPanel4.add(Lab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, 40));

        Lab4.setBackground(new java.awt.Color(0, 0, 51));
        Lab4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Lab4.setForeground(new java.awt.Color(255, 255, 255));
        Lab4.setText("LABORATORIO 04");
        Lab4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lab4ActionPerformed(evt);
            }
        });
        jPanel4.add(Lab4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, -1, 40));

        Lab2.setBackground(new java.awt.Color(0, 0, 51));
        Lab2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Lab2.setForeground(new java.awt.Color(255, 255, 255));
        Lab2.setText("LABORATORIO 02");
        Lab2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lab2ActionPerformed(evt);
            }
        });
        jPanel4.add(Lab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, -1, 40));

        regresar.setBackground(new java.awt.Color(0, 0, 51));
        regresar.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        regresar.setForeground(new java.awt.Color(255, 255, 255));
        regresar.setText("REGRESAR");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });
        jPanel4.add(regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 100, 30));

        exitPr.setBackground(new java.awt.Color(0, 0, 51));
        exitPr.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        exitPr.setForeground(new java.awt.Color(255, 255, 255));
        exitPr.setText("SALIR");
        exitPr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitPrActionPerformed(evt);
            }
        });
        jPanel4.add(exitPr, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 430, 100, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTION DE LABORATORIOS");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/LogoP2.png"))); // NOI18N
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/FondoAzul.png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        // TODO add your handling code here:
        Principal Pr = new Principal();
        Pr.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_regresarActionPerformed

    private void exitPrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitPrActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exitPrActionPerformed

    private void Lab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lab1ActionPerformed
        // TODO add your handling code here:
        VerLab1 verLab = new VerLab1();
        verLab.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Lab1ActionPerformed

    private void Lab2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lab2ActionPerformed
        // TODO add your handling code here:
        VerLab2 verLab = new VerLab2();
        verLab.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Lab2ActionPerformed

    private void Lab3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lab3ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        VerLab3 verLab = new VerLab3();
        verLab.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Lab3ActionPerformed

    private void Lab4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lab4ActionPerformed
        // TODO add your handling code here:
        VerLab4 verLab = new VerLab4();
        verLab.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Lab4ActionPerformed

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
            java.util.logging.Logger.getLogger(VerHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerHorario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Lab1;
    private javax.swing.JButton Lab2;
    private javax.swing.JButton Lab3;
    private javax.swing.JButton Lab4;
    private javax.swing.JButton exitPr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables
}
