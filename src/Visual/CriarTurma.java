package Visual;
/**JIternalFrame responsável pela criação de turmas e inserção de alunos
 * @author Eduardo Henrique
 */
import Banco.FuncoesDAO;
import Classes.Funcoes;
import Classes.TabelaLA;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class CriarTurma extends javax.swing.JInternalFrame {
    String cpf;
    int qtdDados;
    FuncoesDAO fdao = new FuncoesDAO();
    Funcoes f = new Funcoes();
    TabelaLA la = new TabelaLA();
    public CriarTurma(String cpf) {
        initComponents();
        this.cpf = cpf;
        f.AtualizaCombo(cpf, Turmas);
        la.visualizar(Tabela, cpf+(String)Turmas.getSelectedItem());
        qtdDados = fdao.QtdRegistros(cpf+Turmas.getSelectedItem());
        if(qtdDados > 0){
            AulasDadas.setEnabled(false);
            AulasPrevistas.setEnabled(false);
            ArrayList<Integer> dados = fdao.getDadasPrev(cpf+Turmas.getSelectedItem());
            AulasDadas.setText(""+dados.get(0));
            AulasPrevistas.setText(""+dados.get(1));
        }
        FaltasAluno.setText("0");
        CompensadasAluno.setText("0");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nomeTurma = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Turmas = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nomeAluno = new javax.swing.JTextField();
        FaltasAluno = new javax.swing.JTextField();
        CompensadasAluno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        AulasPrevistas = new javax.swing.JTextField();
        AulasDadas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        mensagem = new javax.swing.JLabel();
        mensagem2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 245, 245));
        setPreferredSize(new java.awt.Dimension(724, 494));

        jLabel1.setBackground(new java.awt.Color(245, 245, 245));
        jLabel1.setLabelFor(nomeTurma);
        jLabel1.setText("Nome da Turma:");

        jButton1.setText("Criar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Turmas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Turmas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TurmasItemStateChanged(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(176, 196, 222));
        jButton2.setText("Inserir Aluno");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(245, 245, 245));
        jLabel2.setLabelFor(nomeAluno);
        jLabel2.setText("Nome:");

        jLabel3.setBackground(new java.awt.Color(245, 245, 245));
        jLabel3.setLabelFor(FaltasAluno);
        jLabel3.setText("Faltas:");

        jLabel4.setBackground(new java.awt.Color(245, 245, 245));
        jLabel4.setLabelFor(CompensadasAluno);
        jLabel4.setText("Compensadas:");

        jLabel5.setBackground(new java.awt.Color(245, 245, 245));
        jLabel5.setLabelFor(AulasPrevistas);
        jLabel5.setText("Aulas Previstas:");

        jLabel6.setBackground(new java.awt.Color(245, 245, 245));
        jLabel6.setLabelFor(AulasDadas);
        jLabel6.setText("Aulas Dadas:");

        mensagem.setBackground(new java.awt.Color(245, 245, 245));
        mensagem.setForeground(new java.awt.Color(255, 0, 51));
        mensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        mensagem2.setBackground(new java.awt.Color(245, 245, 245));
        mensagem2.setForeground(new java.awt.Color(0, 204, 51));
        mensagem2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel7.setBackground(new java.awt.Color(245, 245, 245));
        jLabel7.setLabelFor(Turmas);
        jLabel7.setText("Selecione a turma");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AulasPrevistas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AulasDadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CompensadasAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FaltasAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nomeTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(Turmas, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mensagem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(Turmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(nomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CompensadasAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(FaltasAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(AulasPrevistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AulasDadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mensagem2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if("".equals(nomeTurma.getText())){
            //mensagem.setText("Não foi possível criar a turma, coloque algum nome"); mensagem2.setText("");
            JOptionPane optionPane = new JOptionPane("A turma deve possuir um nome", JOptionPane.ERROR_MESSAGE);    
            JDialog dialog = optionPane.createDialog("Erro");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
        else{
            if(fdao.CriarTurma(cpf, nomeTurma.getText().replace(" ", "_"))){
                /*mensagem2.setText("A turma foi criada com sucesso");
                mensagem.setText("");*/
                JOptionPane.showMessageDialog(null,"A turma foi criada com sucesso");
                f.AtualizaCombo(cpf, Turmas);
            }
            else{ //mensagem.setText("Não foi possível criar a turma! Não utilize caracteres especiais");mensagem2.setText("");
                JOptionPane optionPane = new JOptionPane("Não foi possível criar a turma!\nVocê já não criou esta turma?\nNão utilize caracteres especiais (!,@,#,$,%)", JOptionPane.ERROR_MESSAGE);    
                JDialog dialog = optionPane.createDialog("Erro");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TurmasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TurmasItemStateChanged
        if(Turmas.getSelectedItem() != null){
            qtdDados = fdao.QtdRegistros(cpf+Turmas.getSelectedItem());
            la.visualizar(Tabela, cpf+(String)Turmas.getSelectedItem());
            if(qtdDados > 0){
                AulasDadas.setEnabled(false);
                AulasPrevistas.setEnabled(false);
                ArrayList<Integer> dados = fdao.getDadasPrev(cpf+Turmas.getSelectedItem());
                AulasDadas.setText(""+dados.get(0));
                AulasPrevistas.setText(""+dados.get(1));
            }else{
                AulasDadas.setEnabled(true);
                AulasPrevistas.setEnabled(true);
                AulasDadas.setText("0");
                AulasPrevistas.setText("0");
            }
        }
    }//GEN-LAST:event_TurmasItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String nomet = nomeAluno.getText();
        int dadast = Integer.parseInt(AulasDadas.getText());
        int previstast = Integer.parseInt(AulasPrevistas.getText());
        int faltast = Integer.parseInt(FaltasAluno.getText());
        int compensadast = Integer.parseInt(CompensadasAluno.getText());
        if(!"".equals(nomet) && nomet != null){
            if(fdao.InsereAluno(cpf+Turmas.getSelectedItem(), nomet, faltast, 0, dadast, previstast,compensadast)){
                /*mensagem2.setText("Aluno adcionado com sucesso");
                nomeAluno.setText("");*/
                JOptionPane.showMessageDialog(null,"Aluno adicionado com sucesso");
                FaltasAluno.setText("0");
                CompensadasAluno.setText("0");
            }
            else{
                JOptionPane optionPane = new JOptionPane("Não foi possível adicionar o aluno", JOptionPane.ERROR_MESSAGE);    
                JDialog dialog = optionPane.createDialog("Erro");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }
        }else{JOptionPane optionPane = new JOptionPane("Informe o nome do aluno", JOptionPane.ERROR_MESSAGE);    
                JDialog dialog = optionPane.createDialog("Erro");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);}
        
    }//GEN-LAST:event_jButton2ActionPerformed
    public void atualiza(){
        f.AtualizaCombo(cpf, Turmas);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AulasDadas;
    private javax.swing.JTextField AulasPrevistas;
    private javax.swing.JTextField CompensadasAluno;
    private javax.swing.JTextField FaltasAluno;
    private javax.swing.JTable Tabela;
    private javax.swing.JComboBox<String> Turmas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mensagem;
    private javax.swing.JLabel mensagem2;
    private javax.swing.JTextField nomeAluno;
    private javax.swing.JTextField nomeTurma;
    // End of variables declaration//GEN-END:variables
}
