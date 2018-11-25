/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zils_prova.telas;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import zils_prova.DAO.FuncionarioDAO;
import zils_prova.DAO.MotoristaDAO;
import zils_prova.model.DateUtil;
import zils_prova.model.Funcionario;
import zils_prova.model.Motorista;

/**
 *
 * @author eduar
 */
public class AdicionaMotorista extends javax.swing.JDialog {

    MotoristaDAO motoristaDAO = new MotoristaDAO();
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    /**
     * Creates new form AdicionaFuncionario
     */
    public AdicionaMotorista(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        carregaTable(motoristaDAO.getAll());
        carregaCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btAdicionar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        tfCNH = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfDt_vencimento = new javax.swing.JFormattedTextField();
        btAlterar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        cbFuncionario = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        jLabel5.setText("Novo Motorista");

        jLabel6.setText("Motoristas");

        jLabel1.setText("Funcionario");

        btAdicionar.setText("Adicionar Motorista");
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        btVoltar.setText("↩");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "CNH", "Vencimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela);

        jLabel4.setText("Codigo do Motorista #");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel3.setText("Numero CNH");

        jLabel7.setText("Data Vencimento");

        try {
            tfDt_vencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btRemover.setText("Remover");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        cbFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfCNH, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(tfDt_vencimento))
                                .addComponent(cbFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfCNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tfDt_vencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btVoltar)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.dispose();
        Menu dialog = null;
        dialog = new Menu(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        try {
            Adicionar();        // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(AdicionaMotorista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        Motorista f = new Motorista() {
        };
        try {
            f = motoristaDAO.getById((int) tabela.getValueAt(tabela.getSelectedRow(), 0));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Favor Selecionar um item da tabela");
            ex.printStackTrace();
        }
        tfCNH.setText(String.valueOf(f.getNr_cnh()));
        tfDt_vencimento.setText(String.valueOf(f.getDt_vencimento()));
    }//GEN-LAST:event_tabelaMouseClicked

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        try {
            Excluir();        // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(AdicionaMotorista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btRemoverActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        try {
            Alterar();        // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(AdicionaMotorista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        verificaCampos();        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseMoved

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
            java.util.logging.Logger.getLogger(AdicionaMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionaMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionaMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionaMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdicionaMotorista dialog = null;
                try {
                    dialog = new AdicionaMotorista(new javax.swing.JFrame(), true);
                } catch (SQLException ex) {
                    Logger.getLogger(AdicionaMotorista.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox<String> cbFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField tfCNH;
    private javax.swing.JFormattedTextField tfDt_vencimento;
    // End of variables declaration//GEN-END:variables

    private void carregaTable(List<Motorista> listaMotoristas) throws SQLException {
        if (listaMotoristas == null) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setRowCount(0);
        for (Motorista f : listaMotoristas) {
            model.addRow(new Object[]{f.getCodigo(), f.getFuncionario().nm_funcionario, f.getNr_cnh(), f.getDt_vencimento()});
        }
        UltimoID();
    }

    private void Adicionar() throws SQLException {
        Motorista f = new Motorista() {
        };
        Funcionario funci = new Funcionario();
        try {
            funci = (Funcionario) cbFuncionario.getSelectedItem();
            String data = tfDt_vencimento.getText();
            Date dataFormatada = DateUtil.stringToDate(data);
            System.out.println(dataFormatada);

            f.setCodigo(motoristaDAO.getLastId());
            f.setNr_cnh(Integer.parseInt(tfCNH.getText()));
            f.setDt_vencimento(dataFormatada);
            f.setFuncionario(funci);
            motoristaDAO.save(f);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Favor informar dados validos");
            ex.getStackTrace();
        }
        carregaTable(motoristaDAO.getAll());
        limpaCampos();
    }

    private void limpaCampos() {
        tfCNH.setText("");
        tfDt_vencimento.setText("");
    }

    private void UltimoID() throws SQLException {
        jLabel4.setText("Codigo do Funcionario #" + motoristaDAO.getLastId());
    }

    private void Alterar() throws SQLException {
        Motorista f = new Motorista() {
        };
        try {
            f = motoristaDAO.getById((int) tabela.getValueAt(tabela.getSelectedRow(), 0));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Favor Selecionar um item da tabela");
            ex.printStackTrace();
        }

        f.setNr_cnh(Integer.parseInt(tfCNH.getText()));
        f.setDt_vencimento(DateUtil.stringToDate(tfDt_vencimento.getText()));
        motoristaDAO.update(f);
        carregaTable(motoristaDAO.getAll());
        limpaCampos();
    }

    private void Excluir() throws SQLException {
        int codigoRemover = (int) tabela.getValueAt(tabela.getSelectedRow(), 0);
        try {
            motoristaDAO.delete(codigoRemover);
            carregaTable(motoristaDAO.getAll());
            JOptionPane.showMessageDialog(null, "Registro Removido Com Sucesso!!!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        carregaTable(motoristaDAO.getAll());
        limpaCampos();
    }

    private void carregaCombo() throws SQLException {
        List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
        for (Funcionario f : funcionarioDAO.getAll()) {
            listaFuncionarios.add(f);
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(listaFuncionarios.toArray());
        cbFuncionario.setModel(modelo);
    }

    private void verificaCampos() {
        if (tfCNH.getText().trim().length() > 0 && tfDt_vencimento.getText().trim().length() > 0) {
            btAdicionar.setEnabled(true);
        } else {
            btAdicionar.setEnabled(false);
        }
        if (tabela.getSelectedRow() < 0) {
            btAlterar.setEnabled(false);
            btRemover.setEnabled(false);
        } else {
            btAlterar.setEnabled(true);
            btRemover.setEnabled(true);
        }

    }

}
