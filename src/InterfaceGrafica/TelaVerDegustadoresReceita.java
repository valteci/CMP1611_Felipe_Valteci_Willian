/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfaceGrafica;

import bancoDeDados.BancoDeDados;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author junio
 */
public class TelaVerDegustadoresReceita extends javax.swing.JFrame {

    ArrayList<JButton> botoes;
    ArrayList<JLabel> labels;
    ArrayList<JPanel> panels;

    
    public TelaVerDegustadoresReceita(int codigoReceita) {
        
        try {
            botoes = new ArrayList<>();
            labels = new ArrayList<>();
            panels = new ArrayList<>();

            initComponents();
            configurarTela();
            configurarCores();
            
            BancoDeDados banco = BancoDeDados.getInstance();

            var itens = banco.getDegustadoresReceita(codigoReceita);
            mostrarDegustadores(itens);
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(
                    rootPane,
                    e.getMessage(),
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        
    }
    
    
    private void mostrarDegustadores(ArrayList<ArrayList<Object>> degustadores) {
        
        DefaultTableModel model = (DefaultTableModel) 
                                   jTable_consulta.getModel();
        
        while (model.getRowCount()> 0)
            model.removeRow(0);
        
        SimpleDateFormat dataFormato = new SimpleDateFormat(
                    "dd/MM/yyyy"
        );
        
        
        for (var linha : degustadores) {
        
            String dataTeste = dataFormato.format(linha.get(1));
            
            model.addRow(new Object[]{
                linha.get(0),
                dataTeste,
                linha.get(2),
            });
        }
        
    }
    
    
    private void configurarCores() {
        jPanelFundo.setBackground(PaletaCores.FUNDO);
        jPanelTitulo.setBackground(PaletaCores.FUNDO);
        jTable_consulta.setBackground(PaletaCores.FUNDO);
        
        
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_consulta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelFundo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTA DE DEGUSTADORES");
        jPanelTitulo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 480, 60));

        jPanelFundo.add(jPanelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 80));

        jTable_consulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome Degustador", "Data", "Nota"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_consulta);

        jPanelFundo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 520, 330));

        getContentPane().add(jPanelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(int codigoReceita) {
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
            java.util.logging.Logger.getLogger(TelaVerDegustadoresReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVerDegustadoresReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVerDegustadoresReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVerDegustadoresReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVerDegustadoresReceita(codigoReceita).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelFundo;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_consulta;
    // End of variables declaration//GEN-END:variables
}
