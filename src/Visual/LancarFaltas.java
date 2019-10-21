package Visual;
/**JIternalFrame responsável pelo lançamento de faltas
 * @author Eduardo Henrique
 */

import Banco.FuncoesDAO;
import Classes.Funcoes;
import Classes.SalvarFaltas;
import Classes.TabelaLF;
public class LancarFaltas extends javax.swing.JInternalFrame {
    TabelaLF t = new TabelaLF();
    String cpf;
    FuncoesDAO fdao = new FuncoesDAO();
    Funcoes f = new Funcoes();
    public LancarFaltas(String cpf) {
        initComponents();
        this.cpf = cpf;
        f.AtualizaCombo(cpf, Turmas);
        t.visualizar(Tabela,cpf+(String)Turmas.getSelectedItem());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        Turmas = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        AulaDupla = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(245, 245, 245));
        setForeground(java.awt.Color.lightGray);
        setPreferredSize(new java.awt.Dimension(724, 494));

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
        jScrollPane1.setViewportView(Tabela);

        Turmas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Turmas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TurmasItemStateChanged(evt);
            }
        });

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        AulaDupla.setBackground(new java.awt.Color(245, 245, 245));
        AulaDupla.setText("AulaDupla");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Turmas, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addComponent(AulaDupla)
                        .addGap(86, 86, 86))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Turmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AulaDupla)
                    .addComponent(jButton1))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TurmasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TurmasItemStateChanged
        if(Turmas.getSelectedItem() != null)
            t.visualizar(Tabela,cpf+(String)Turmas.getSelectedItem());
    }//GEN-LAST:event_TurmasItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SalvarFaltas sf = new SalvarFaltas();
        int falta = 1;
        if(AulaDupla.isSelected())
            falta = 2;
        for(int i = 0;i<Tabela.getRowCount();i++){
            sf.setId((int)Tabela.getValueAt(i, 0));
            sf.setNome((String)Tabela.getValueAt(i, 1));
            if((Object)Tabela.getValueAt(i,2) == null)
                sf.setPresente(false);
            else
                sf.setPresente((Object)Tabela.getValueAt(i, 2));
            if(!fdao.LancarFaltas(sf, cpf+Turmas.getSelectedItem(), falta,falta)){
                f.gerarMessageBox("ERRO", "Não foi possível salvar as alterações");
            }else
                f.gerarMessageBox("", "As faltas foram lançadas com sucesso");
        }
        t.visualizar(Tabela, cpf+Turmas.getSelectedItem());
    }//GEN-LAST:event_jButton1ActionPerformed
    public void atualiza(){
        if(Turmas.getSelectedItem() != null)
            t.visualizar(Tabela,cpf+(String)Turmas.getSelectedItem());
        f.AtualizaCombo(cpf, Turmas);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AulaDupla;
    private javax.swing.JTable Tabela;
    private javax.swing.JComboBox Turmas;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
}
