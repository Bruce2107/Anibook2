package Visual;
/**JIternalFrame responsável pela edição das informações de cada aluno
 * @author Eduardo Henrique
 */

import Banco.FuncoesDAO;
import Classes.Funcoes;
import Classes.TabelaEF;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class EditarTurma extends javax.swing.JInternalFrame {

    TabelaEF t = new TabelaEF();
    String cpf;
    int rown = -1;
    FuncoesDAO fdao = new FuncoesDAO();
    Funcoes f = new Funcoes();
    public EditarTurma(String cpf) {
        initComponents();
        this.cpf = cpf;
        f.AtualizaCombo(cpf, Turmas);
        t.visualizar(Tabela, cpf+(String)Turmas.getSelectedItem());
        salvar.setEnabled(false);nome.setEnabled(false);id.setEnabled(false);faltas.setEnabled(false);compensadas.setEnabled(false);ativo.setEnabled(false);sug.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Turmas = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        faltas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        compensadas = new javax.swing.JTextField();
        ativo = new javax.swing.JRadioButton();
        salvar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        sug = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 245, 245));
        setPreferredSize(new java.awt.Dimension(724, 494));

        Turmas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Turmas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TurmasItemStateChanged(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(245, 245, 245));
        jLabel1.setText("ID");

        id.setBackground(new java.awt.Color(245, 245, 245));
        id.setText(" ");

        jLabel2.setBackground(new java.awt.Color(245, 245, 245));
        jLabel2.setText("Nome");

        jLabel3.setBackground(new java.awt.Color(245, 245, 245));
        jLabel3.setText("Faltas");

        jLabel4.setBackground(new java.awt.Color(245, 245, 245));
        jLabel4.setText("Compensadas");

        ativo.setBackground(new java.awt.Color(245, 245, 245));
        ativo.setText("Ativo");

        salvar.setText("Salvar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        jButton2.setText("Excluir Turma");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabela);

        jButton1.setText("Compensar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(245, 245, 245));
        jLabel5.setText("Sugestão de compensadas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(faltas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(compensadas)))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sug, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ativo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Turmas, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id)
                    .addComponent(jLabel3)
                    .addComponent(faltas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sug, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(compensadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salvar)
                    .addComponent(ativo))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Turmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TurmasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TurmasItemStateChanged
        if(Turmas.getSelectedItem() != null)
            t.visualizar(Tabela,cpf+(String)Turmas.getSelectedItem());
    }//GEN-LAST:event_TurmasItemStateChanged

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        int idt = Integer.parseInt(id.getText());
        String nomet = nome.getText();
        int faltast = Integer.parseInt(faltas.getText());
        int compt = Integer.parseInt(compensadas.getText());
        int sugt = Integer.parseInt(sug.getText());
        boolean ativot = ativo.isSelected();
        if(fdao.Salvar(idt, nomet, faltast,sugt, compt, ativot,cpf+Turmas.getSelectedItem())){
            salvar.setEnabled(false);nome.setText("");id.setText("");faltas.setText("");compensadas.setText("");sug.setText("");ativo.setSelected(false);
            nome.setEnabled(false);id.setEnabled(false);faltas.setEnabled(false);compensadas.setEnabled(false);ativo.setEnabled(false);sug.setEnabled(false);
            t.visualizar(Tabela, cpf+Turmas.getSelectedItem());
        }
        else{
            JOptionPane optionPane = new JOptionPane("Não foi possível salvar as alterações", JOptionPane.ERROR_MESSAGE);    
            JDialog dialog = optionPane.createDialog("Erro");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }

    }//GEN-LAST:event_salvarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int r = JOptionPane.showConfirmDialog(null, "Deseja excluir a turma?", "", JOptionPane.YES_NO_OPTION);
        if(r == JOptionPane.YES_OPTION)
            if(fdao.ApagarTurma(cpf+Turmas.getSelectedItem()))
                JOptionPane.showMessageDialog(null,"Turma apagada com sucesso"); else{JOptionPane optionPane = new JOptionPane("Não foi possível excluir a turma", JOptionPane.ERROR_MESSAGE);    
        JDialog dialog = optionPane.createDialog("Erro");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);}
        f.AtualizaCombo(cpf, Turmas);
        t.visualizar(Tabela, cpf+(String)Turmas.getSelectedItem());
                
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaMouseClicked

        rown = Tabela.rowAtPoint(evt.getPoint());
        int column = Tabela.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/Tabela.getRowHeight();
        
        if(row < Tabela.getRowCount() && row >= 0 && column < Tabela.getColumnCount() && column >= 0){
            Object value = Tabela.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton) value;
                salvar.setEnabled(true);
                nome.setEnabled(true);id.setEnabled(true);faltas.setEnabled(true);compensadas.setEnabled(true);ativo.setEnabled(true);
                int idt = (int) Tabela.getValueAt(rown,0);
                String nomet = (String) Tabela.getValueAt(rown,1);
                int faltast = (int) Tabela.getValueAt(rown,2);
                int compt = (int) Tabela.getValueAt(rown,3);
                int compst = (int) Tabela.getValueAt(rown,4);
                boolean ativot = (boolean) Tabela.getValueAt(rown,5);
                if(boton.getName().equals("v")){
                     try{
                        id.setText(""+idt);
                        nome.setText(""+nomet);
                        faltas.setText(""+faltast);
                        sug.setText(""+compt);
                        compensadas.setText(""+compst);
                        ativo.setSelected(ativot);                       
                     }catch(Exception ex){
                        System.out.println(ex.getMessage());
                     }
                    
                }
            }
        }
    }//GEN-LAST:event_TabelaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(fdao.Compensar(cpf+Turmas.getSelectedItem()))
            JOptionPane.showMessageDialog(null, "Sucesso");
        else{
            JOptionPane optionPane = new JOptionPane("Não foi possível realizar a compensação", JOptionPane.ERROR_MESSAGE);    
            JDialog dialog = optionPane.createDialog("Erro");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
        t.visualizar(Tabela, cpf+(String)Turmas.getSelectedItem());
    }//GEN-LAST:event_jButton1ActionPerformed
    public void atualiza() {
        if(Turmas.getSelectedItem() != null)
            t.visualizar(Tabela,cpf+(String)Turmas.getSelectedItem());
        f.AtualizaCombo(cpf, Turmas);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabela;
    private javax.swing.JComboBox Turmas;
    private javax.swing.JRadioButton ativo;
    private javax.swing.JTextField compensadas;
    private javax.swing.JTextField faltas;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nome;
    private javax.swing.JButton salvar;
    private javax.swing.JTextField sug;
    // End of variables declaration//GEN-END:variables
}
