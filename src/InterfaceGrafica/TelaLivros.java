/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfaceGrafica;

import Livros.Livro;
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
public class TelaLivros extends javax.swing.JFrame {

    ArrayList<JButton> botoes;
    ArrayList<JLabel> labels;
    ArrayList<JPanel> panels;
    String usuario = "postgres";
    String senha = "1Z2ht6b.";
    String nomedb = "CMP1611_Felipe_Valteci_Willian";
    
    public TelaLivros() {
        
        botoes = new ArrayList<>();
        labels = new ArrayList<>();
        panels = new ArrayList<>();
        
        initComponents();
        configurarTela();
        configurarCores();
    }
    
    private void mostrarLivros(ArrayList<Livro> livros) {
        DefaultTableModel model = (DefaultTableModel) 
                                   jTable_consulta.getModel();
        
        while (model.getRowCount()> 0)
            model.removeRow(0);
        
        for (Livro livro : livros) {
                model.addRow(new Object[]{
                    livro.getISBN(),
                    livro.getTitulo(),
                    livro.getCpfEditor()
                });
        }
    }
    
    private void configurarTela() {
        this.setLocationRelativeTo(null);                                
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        lb_novoCPFeditor.setVisible(false);
        lb_novoISBN.setVisible(false);
        lb_novoTitulo.setVisible(false);
        
        txt_novoCPFeditor.setVisible(false);
        txt_novoISBN.setVisible(false);
        txt_novoTitulo.setVisible(false);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_cadastrarISBN = new javax.swing.JTextField();
        txt_cadastrarTitulo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_cadastrarCPFeditor = new javax.swing.JTextField();
        bt_cadastrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_deletarISBN = new javax.swing.JTextField();
        bt_deletar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_consulta = new javax.swing.JTable();
        bt_listarTodos = new javax.swing.JButton();
        bt_listarISBN = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txt_ISBNatualizar = new javax.swing.JTextField();
        ckb_atualizarISBN = new javax.swing.JCheckBox();
        ckb_atualizarTitulo = new javax.swing.JCheckBox();
        ckb_atualizarCPFeditor = new javax.swing.JCheckBox();
        lb_novoISBN = new javax.swing.JLabel();
        txt_novoISBN = new javax.swing.JTextField();
        lb_novoTitulo = new javax.swing.JLabel();
        txt_novoTitulo = new javax.swing.JTextField();
        lb_novoCPFeditor = new javax.swing.JLabel();
        txt_novoCPFeditor = new javax.swing.JTextField();
        bt_atualizar = new javax.swing.JButton();
        bt_autalizar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelFundo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LIVROS DE RECEITA");
        jPanelTitulo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 440, -1));

        jPanelFundo.add(jPanelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 80));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(PaletaCores.PANEL_BORDA, 3));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("ISBN: ");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 50, -1));
        jPanel3.add(txt_cadastrarISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 140, -1));
        jPanel3.add(txt_cadastrarTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 250, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Título: ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 50, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("CPF Editor:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 90, -1));
        jPanel3.add(txt_cadastrarCPFeditor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 120, -1));

        bt_cadastrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_cadastrar.setText("Cadastrar");
        bt_cadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TelaLivros.this.mousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TelaLivros.this.mouseReleased(evt);
            }
        });
        bt_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrarActionPerformed(evt);
            }
        });
        jPanel3.add(bt_cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 240, 30));
        botoes.add(bt_cadastrar);

        jPanelFundo.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 380, 200));
        panels.add(jPanel3);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Deletar Livro");
        jPanelFundo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(PaletaCores.PANEL_BORDA, 3));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("ISBN: ");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 50, -1));
        jPanel4.add(txt_deletarISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 140, -1));

        bt_deletar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_deletar.setText("Deletar");
        bt_deletar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TelaLivros.this.mousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TelaLivros.this.mouseReleased(evt);
            }
        });
        bt_deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deletarActionPerformed(evt);
            }
        });
        jPanel4.add(bt_deletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 240, 30));
        botoes.add(bt_deletar);

        jPanelFundo.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 380, 120));
        panels.add(jPanel4);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Cadastrar Livro");
        jPanelFundo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(PaletaCores.PANEL_BORDA, 3));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                {null, null, null}
            },
            new String [] {
                "ISBN", "Título", "CPF Editor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_consulta);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 380, 150));

        bt_listarTodos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_listarTodos.setText("Listar Todos");
        bt_listarTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TelaLivros.this.mousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TelaLivros.this.mouseReleased(evt);
            }
        });
        bt_listarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_listarTodosActionPerformed(evt);
            }
        });
        jPanel5.add(bt_listarTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 180, 30));
        botoes.add(bt_listarTodos);

        bt_listarISBN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_listarISBN.setText("Listar por ISBN");
        bt_listarISBN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TelaLivros.this.mousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TelaLivros.this.mouseReleased(evt);
            }
        });
        bt_listarISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_listarISBNActionPerformed(evt);
            }
        });
        jPanel5.add(bt_listarISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 160, 30));
        botoes.add(bt_listarISBN);

        jPanelFundo.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, 430, 240));
        panels.add(jPanel5);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(PaletaCores.PANEL_BORDA, 3));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("ISBN do Livro a Ser Atualizado");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        labels.add(jLabel13);
        jPanel6.add(txt_ISBNatualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 220, -1));

        ckb_atualizarISBN.setText("Atulizar ISBN");
        ckb_atualizarISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckb_atualizarISBNActionPerformed(evt);
            }
        });
        jPanel6.add(ckb_atualizarISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        ckb_atualizarTitulo.setText("Atulizar TÍtulo");
        ckb_atualizarTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckb_atualizarTituloActionPerformed(evt);
            }
        });
        jPanel6.add(ckb_atualizarTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

        ckb_atualizarCPFeditor.setText("Atualizar CPF do Editor");
        ckb_atualizarCPFeditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckb_atualizarCPFeditorActionPerformed(evt);
            }
        });
        jPanel6.add(ckb_atualizarCPFeditor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        lb_novoISBN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lb_novoISBN.setText("Novo ISBN:");
        jPanel6.add(lb_novoISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));
        labels.add(lb_novoISBN);
        jPanel6.add(txt_novoISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 180, -1));

        lb_novoTitulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lb_novoTitulo.setText("Novo Título:");
        jPanel6.add(lb_novoTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));
        labels.add(lb_novoTitulo);
        jPanel6.add(txt_novoTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 180, -1));

        lb_novoCPFeditor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lb_novoCPFeditor.setText("Novo CPF do Editor:");
        jPanel6.add(lb_novoCPFeditor, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));
        labels.add(lb_novoCPFeditor);
        jPanel6.add(txt_novoCPFeditor, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 110, -1));

        bt_atualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_atualizar.setText("Atualizar");
        bt_atualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bt_atualizarmousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bt_atualizarmouseReleased(evt);
            }
        });
        bt_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_atualizarActionPerformed(evt);
            }
        });
        jPanel6.add(bt_atualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 400, 30));
        botoes.add(bt_atualizar);

        bt_autalizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_autalizar.setText("Atualizar");
        bt_autalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TelaLivros.this.mousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TelaLivros.this.mouseReleased(evt);
            }
        });
        bt_autalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_autalizarActionPerformed(evt);
            }
        });
        jPanel6.add(bt_autalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 240, 30));
        botoes.add(bt_autalizar);

        jPanelFundo.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 690, 190));
        panels.add(jPanel6);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Listar Livros");
        jPanelFundo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Atualizar Livros");
        jPanelFundo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, -1, -1));

        getContentPane().add(jPanelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ckb_atualizarISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckb_atualizarISBNActionPerformed
        lb_novoISBN.setVisible(ckb_atualizarISBN.isSelected());
        txt_novoISBN.setVisible(ckb_atualizarISBN.isSelected());
    }//GEN-LAST:event_ckb_atualizarISBNActionPerformed

    private void ckb_atualizarTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckb_atualizarTituloActionPerformed
        lb_novoTitulo.setVisible(ckb_atualizarTitulo.isSelected());
        txt_novoTitulo.setVisible(ckb_atualizarTitulo.isSelected());
    }//GEN-LAST:event_ckb_atualizarTituloActionPerformed

    private void ckb_atualizarCPFeditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckb_atualizarCPFeditorActionPerformed
        lb_novoCPFeditor.setVisible(ckb_atualizarCPFeditor.isSelected());
        txt_novoCPFeditor.setVisible(ckb_atualizarCPFeditor.isSelected());
    }//GEN-LAST:event_ckb_atualizarCPFeditorActionPerformed

    private void bt_atualizarmousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_atualizarmousePressed
        JButton botao = (JButton) evt.getSource();
        botao.setBackground(PaletaCores.BOTAO_ENTER);
    }//GEN-LAST:event_bt_atualizarmousePressed

    private void bt_atualizarmouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_atualizarmouseReleased
        JButton botao = (JButton) evt.getSource();
        botao.setBackground(PaletaCores.BOTAO);
    }//GEN-LAST:event_bt_atualizarmouseReleased

    private void bt_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_atualizarActionPerformed
        
    }//GEN-LAST:event_bt_atualizarActionPerformed

    private void mousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mousePressed
        
        JButton botao = (JButton) evt.getSource();
        botao.setBackground(PaletaCores.BOTAO_ENTER);
    }//GEN-LAST:event_mousePressed

    private void mouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseReleased
        
        JButton botao = (JButton) evt.getSource();
        botao.setBackground(PaletaCores.BOTAO);
    }//GEN-LAST:event_mouseReleased

    private void bt_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarActionPerformed
        
        try {
            
            String ISBN = txt_cadastrarISBN.getText();
            String titulo = txt_cadastrarTitulo.getText();
            String cpfEditor = txt_cadastrarCPFeditor.getText();
            
            if (ISBN.equals(""))
                throw new Exception("Preencha o ISBN");
            
            if (titulo.equals(""))
                throw new Exception("Título é obrigatório");
            
            BancoDeDados banco = BancoDeDados.getInstance(
                    usuario,
                    senha,
                    nomedb
            );
            
            banco.inserirLivro(ISBN, titulo, cpfEditor);
            
            JOptionPane.showMessageDialog(
                    rootPane, 
                    "Livro Cadastrado com sucesso!",
                    "SUCESSO",
                    JOptionPane.INFORMATION_MESSAGE
            );
            
            
        } catch(Exception e) {
            
            JOptionPane.showMessageDialog(
                    rootPane,
                    e.getMessage(),
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_bt_cadastrarActionPerformed

    private void bt_listarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_listarTodosActionPerformed
        
        try { 
            
            BancoDeDados banco = BancoDeDados.getInstance(
                    usuario,
                    senha,
                    nomedb
            );
            
            ArrayList<Livro> livros = banco.getLivros();
            mostrarLivros(livros);
            
            
        } catch(Exception e) {
            
            JOptionPane.showMessageDialog(
                    rootPane,
                    e.getMessage(),
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_bt_listarTodosActionPerformed

    private void bt_listarISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_listarISBNActionPerformed
        
        try {
            
            String ISBN = JOptionPane.showInputDialog(
                    this,
                    "Digite o ISBN:"
            );
            
            if (ISBN == null || ISBN.equals(""))
                return;                        
            
            BancoDeDados banco = BancoDeDados.getInstance(
                    usuario,
                    senha,
          nomedb
            );
            
            Livro livro = banco.getLivroISBN(ISBN);
            var livros = new ArrayList<Livro>();
            livros.add(livro);
            mostrarLivros(livros);
                                    
        } catch(Exception e) {
            
            JOptionPane.showMessageDialog(
                    rootPane,
                    e.getMessage(),
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        
    }//GEN-LAST:event_bt_listarISBNActionPerformed

    private void bt_deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deletarActionPerformed
        
        try {
            
            String ISBN = txt_deletarISBN.getText();
            
            BancoDeDados banco = BancoDeDados.getInstance(
                    usuario,
                    senha,
                    nomedb
            );
            
            
            banco.getLivroISBN(ISBN);
            banco.deletarLivro(ISBN);
            
            JOptionPane.showMessageDialog(
                    rootPane, 
                    "Livro deletado com sucesso!",
                    "SUCESSO",
                    JOptionPane.INFORMATION_MESSAGE
            );
            
        } catch(Exception e) {
            
            JOptionPane.showMessageDialog(
                    rootPane,
                    e.getMessage(),
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_bt_deletarActionPerformed

    private void bt_autalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_autalizarActionPerformed
        
        try {
            
            BancoDeDados banco = BancoDeDados.getInstance(
                    usuario,
                    senha,
                    nomedb
            );
            
            String ISBNoriginal = txt_ISBNatualizar.getText();
            Livro livro = banco.getLivroISBN(ISBNoriginal);
            
            if(ckb_atualizarISBN.isSelected()) {
                livro.setISBN((txt_novoISBN.getText()));
            }
            
            if (ckb_atualizarTitulo.isSelected()) {
                
                if (txt_novoTitulo.getText().equals(""))
                    throw new Exception("Preencha o título");
                
                livro.setTitulo(txt_novoTitulo.getText());
            }
            
            if (ckb_atualizarCPFeditor.isSelected()) {
                livro.setCpfEditor(txt_novoCPFeditor.getText());
            }
            
            banco.atualizarLivro(livro, ISBNoriginal);
            
            JOptionPane.showMessageDialog(
                    rootPane, 
                    "Livro atualizado com sucesso!",
                    "SUCESSO",
                    JOptionPane.INFORMATION_MESSAGE
            );
            
        } catch(Exception e) {
            
            JOptionPane.showMessageDialog(
                    rootPane,
                    e.getMessage(),
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        
    }//GEN-LAST:event_bt_autalizarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLivros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_atualizar;
    private javax.swing.JButton bt_autalizar;
    private javax.swing.JButton bt_cadastrar;
    private javax.swing.JButton bt_deletar;
    private javax.swing.JButton bt_listarISBN;
    private javax.swing.JButton bt_listarTodos;
    private javax.swing.JCheckBox ckb_atualizarCPFeditor;
    private javax.swing.JCheckBox ckb_atualizarISBN;
    private javax.swing.JCheckBox ckb_atualizarTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelFundo;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_consulta;
    private javax.swing.JLabel lb_novoCPFeditor;
    private javax.swing.JLabel lb_novoISBN;
    private javax.swing.JLabel lb_novoTitulo;
    private javax.swing.JTextField txt_ISBNatualizar;
    private javax.swing.JTextField txt_cadastrarCPFeditor;
    private javax.swing.JTextField txt_cadastrarISBN;
    private javax.swing.JTextField txt_cadastrarTitulo;
    private javax.swing.JTextField txt_deletarISBN;
    private javax.swing.JTextField txt_novoCPFeditor;
    private javax.swing.JTextField txt_novoISBN;
    private javax.swing.JTextField txt_novoTitulo;
    // End of variables declaration//GEN-END:variables
}
