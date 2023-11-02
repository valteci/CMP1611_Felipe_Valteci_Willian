/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfaceGrafica;

import java.util.ArrayList;
import javax.swing.JButton;


public class main extends javax.swing.JFrame {

    ArrayList<JButton> botoes;
    
    public main() {
        botoes = new ArrayList<JButton>();
        initComponents();
        configurarTela();
    }
    
    private void configurarTela() {
        this.setLocationRelativeTo(null);                        
        jPanelFundo.setBackground(PaletaCores.FUNDO);
        
        for (var botao : botoes)
            botao.setBackground(PaletaCores.BOTAO);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFundo = new javax.swing.JPanel();
        bt_ingredientes = new javax.swing.JButton();
        bt_funcionarios = new javax.swing.JButton();
        bt_receitas = new javax.swing.JButton();
        bt_restaurantes = new javax.swing.JButton();
        bt_livroReceitas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelFundo.setBackground(new java.awt.Color(204, 204, 204));
        jPanelFundo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_ingredientes.setBackground(new java.awt.Color(255, 255, 255));
        bt_ingredientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_ingredientes.setForeground(new java.awt.Color(0, 0, 0));
        bt_ingredientes.setText("Ingredientes");
        bt_ingredientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mousePress(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                main.this.mouseReleased(evt);
            }
        });
        jPanelFundo.add(bt_ingredientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 520, 30));
        botoes.add(bt_ingredientes);

        bt_funcionarios.setBackground(new java.awt.Color(255, 255, 255));
        bt_funcionarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_funcionarios.setForeground(new java.awt.Color(0, 0, 0));
        bt_funcionarios.setText("Funcionários");
        bt_funcionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mousePress(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                main.this.mouseReleased(evt);
            }
        });
        bt_funcionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_funcionariosActionPerformed(evt);
            }
        });
        jPanelFundo.add(bt_funcionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 520, 30));
        botoes.add(bt_funcionarios);

        bt_receitas.setBackground(new java.awt.Color(255, 255, 255));
        bt_receitas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_receitas.setForeground(new java.awt.Color(0, 0, 0));
        bt_receitas.setText("Receitas");
        bt_receitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mousePress(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                main.this.mouseReleased(evt);
            }
        });
        bt_receitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_receitasActionPerformed(evt);
            }
        });
        jPanelFundo.add(bt_receitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 520, 30));
        botoes.add(bt_receitas);

        bt_restaurantes.setBackground(new java.awt.Color(255, 255, 255));
        bt_restaurantes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_restaurantes.setForeground(new java.awt.Color(0, 0, 0));
        bt_restaurantes.setText("Restaurantes");
        bt_restaurantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mousePress(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                main.this.mouseReleased(evt);
            }
        });
        jPanelFundo.add(bt_restaurantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 520, 30));
        botoes.add(bt_restaurantes);

        bt_livroReceitas.setBackground(new java.awt.Color(255, 255, 255));
        bt_livroReceitas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_livroReceitas.setForeground(new java.awt.Color(0, 0, 0));
        bt_livroReceitas.setText("Livros de receita");
        bt_livroReceitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mousePress(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                main.this.mouseReleased(evt);
            }
        });
        jPanelFundo.add(bt_livroReceitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 520, 30));
        botoes.add(bt_livroReceitas);

        getContentPane().add(jPanelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mousePress(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mousePress
        JButton botao = (JButton) evt.getSource();
        botao.setBackground(PaletaCores.BOTAO_ENTER);
    }//GEN-LAST:event_mousePress

    private void mouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseReleased
        JButton botao = (JButton) evt.getSource();
        botao.setBackground(PaletaCores.BOTAO);
    }//GEN-LAST:event_mouseReleased

    private void bt_receitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_receitasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_receitasActionPerformed

    private void bt_funcionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_funcionariosActionPerformed
        
        TelaFuncionario.main(null);
    }//GEN-LAST:event_bt_funcionariosActionPerformed

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_funcionarios;
    private javax.swing.JButton bt_ingredientes;
    private javax.swing.JButton bt_livroReceitas;
    private javax.swing.JButton bt_receitas;
    private javax.swing.JButton bt_restaurantes;
    private javax.swing.JPanel jPanelFundo;
    // End of variables declaration//GEN-END:variables
}
