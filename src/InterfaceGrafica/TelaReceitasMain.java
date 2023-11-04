/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfaceGrafica;

import Receita.Receita;
import bancoDeDados.BancoDeDados;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import restaurantes.Restaurante;

/**
 *
 * @author junio
 */
public class TelaReceitasMain extends javax.swing.JFrame {

    ArrayList<JButton> botoes;
    ArrayList<JLabel> labels;
    ArrayList<JPanel> panels;
    String usuario = "postgres";
    String senha = "1Z2ht6b.";
    String nomedb = "CMP1611_Felipe_Valteci_Willian";
    
    public TelaReceitasMain() {
        botoes = new ArrayList<>();
        labels = new ArrayList<>();
        panels = new ArrayList<>();
        
        initComponents();
        configurarTela();
        configurarCores();
    }
    
    private void mostrarReceitas(ArrayList<Receita> receitas) {
        
        DefaultTableModel model = (DefaultTableModel) 
                                   jTable_consulta.getModel();
        
        while (model.getRowCount()> 0)
            model.removeRow(0);
        
        for (Receita receita : receitas) {
                model.addRow(new Object[]{
                    receita.getCodigo(),
                    receita.getNomeReceita(),
                    receita.getDiaCriacao(),
                    receita.getNomeChef(),
                    receita.getCodigoCategoria()
                });
        }
    }
    
    private void configurarCores() {
        jPanelFundo.setBackground(PaletaCores.FUNDO);
        jPanelTitulo.setBackground(PaletaCores.FUNDO);
        
        for (var label : labels)
            label.setForeground(PaletaCores.TEXTO_FONTE);
        
        for (var panel : panels)
            panel.setBackground(PaletaCores.PANEL_FUNDO);
        
        for (var botao : botoes)
            botao.setBackground(PaletaCores.BOTAO);
    }
    
    private void configurarTela() {        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
        jPanelTitulo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_consulta = new javax.swing.JTable();
        bt_procurarCodigo = new javax.swing.JButton();
        bt_listarTodos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelFundo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("RECEITAS");
        jPanelTitulo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 440, 50));

        jPanelFundo.add(jPanelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 60));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(PaletaCores.PANEL_BORDA, 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_consulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome da Receita", "Data Crição", "Nome do Chefe", "Código da Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        jScrollPane1.setViewportView(jTable_consulta);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1040, 170));

        bt_procurarCodigo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_procurarCodigo.setText("Procurar por Código");
        bt_procurarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_procurarCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(bt_procurarCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 210, 40));
        botoes.add(bt_procurarCodigo);

        bt_listarTodos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_listarTodos.setText("Listar Todos");
        bt_listarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_listarTodosActionPerformed(evt);
            }
        });
        jPanel1.add(bt_listarTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, 40));
        botoes.add(bt_listarTodos);

        jPanelFundo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 1080, 250));
        panels.add(jPanel1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("visão geral");
        jPanelFundo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 220, 30));

        getContentPane().add(jPanelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_listarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_listarTodosActionPerformed
        
        try { 
            
            BancoDeDados banco = BancoDeDados.getInstance(
                    usuario,
                    senha,
                    nomedb
            );
            
            ArrayList<Receita> receitas = banco.getReceitas();
            mostrarReceitas(receitas);
            
            
        } catch(Exception e) {
            
            JOptionPane.showMessageDialog(
                    rootPane,
                    e.getMessage(),
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_bt_listarTodosActionPerformed

    private void bt_procurarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_procurarCodigoActionPerformed
        
        try {
            
            String codigo_str = JOptionPane.showInputDialog(
                    this,
                    "Digite o código da receita:"
            );
            
            if (codigo_str == null || codigo_str.equals(""))
                return;
            
            if (! codigo_str.matches("\\d+"))
                throw new Exception("Erro: código inválido");
            
            int codigo = Integer.parseInt(codigo_str);
            
            BancoDeDados banco = BancoDeDados.getInstance(
                    usuario,
                    senha,
          nomedb
            );
            
            Receita receita = banco.getReceitaCodigo(codigo);
            var receitas = new ArrayList<Receita>();
            receitas.add(receita);
            mostrarReceitas(receitas);
                                    
        } catch(Exception e) {
            
            JOptionPane.showMessageDialog(
                    rootPane,
                    e.getMessage(),
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_bt_procurarCodigoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaReceitasMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaReceitasMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaReceitasMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaReceitasMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaReceitasMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_listarTodos;
    private javax.swing.JButton bt_procurarCodigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelFundo;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_consulta;
    // End of variables declaration//GEN-END:variables
}
