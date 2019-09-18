package Visual;
/** JForm onde o usuário tenta realizar o login
 * @author Eduardo Henrique
 */
import Banco.FuncoesDAO;
import Classes.Funcoes;
import java.sql.ResultSet;
import de.mkammerer.argon2.Argon2;
//import de.mkammerer.argon2.Argon2Advanced;
import de.mkammerer.argon2.Argon2Factory;
//import de.mkammerer.argon2.Argon2Factory.Argon2Types;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
//import static java.util.Objects.hash;
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        this.setLocationRelativeTo( null );
        getRootPane().setDefaultButton(btnLogar);
        Usuario.requestFocus();
        mensagem.setVisible(false);
    }
    Funcoes f = new Funcoes();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        Senha = new javax.swing.JPasswordField();
        Usuario = new javax.swing.JTextField();
        btnLogar = new javax.swing.JButton();
        mensagem = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema De Controle de Frequência");
        setBackground(new java.awt.Color(245, 245, 245));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setName("Login"); // NOI18N
        setResizable(false);

        Senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SenhaKeyPressed(evt);
            }
        });

        btnLogar.setBackground(new java.awt.Color(230, 230, 250));
        btnLogar.setText("Entrar");
        btnLogar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLogar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogarMouseClicked(evt);
            }
        });
        btnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogarActionPerformed(evt);
            }
        });

        mensagem.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        mensagem.setForeground(new java.awt.Color(255, 0, 0));
        mensagem.setText("Usuário ou senha incorretos");

        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Criar Conta!");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Esqueceu sua senha?");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setLabelFor(Usuario);
        jLabel3.setText("CPF");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Senha");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, Senha, org.jdesktop.beansbinding.ObjectProperty.create(), jLabel4, org.jdesktop.beansbinding.BeanProperty.create("labelFor"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(mensagem)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2))
                            .addComponent(Senha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Usuario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLogar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                        .addContainerGap(98, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void logar(){
        FuncoesDAO fdao = new FuncoesDAO();
        
        Argon2 argon2 = Argon2Factory.create();
        String user = Usuario.getText();
        String senha = String.valueOf(Senha.getPassword());
        ResultSet a = fdao.Consulta(user);
        String hash = "";
        try{
            while(a.next()){
                hash = a.getString("senha");
            }
        }catch(SQLException e){
            System.err.print(e.getMessage());
        }
        
        if (argon2.verify(hash, senha)) {
            Logado l = new Logado();
            l.getCPF(user);
            l.setVisible(true);
            dispose();
        }
        else{
            JOptionPane optionPane = new JOptionPane("Usuário ou senha incorreto", JOptionPane.ERROR_MESSAGE);    
            JDialog dialog = optionPane.createDialog("Erro");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
            //mensagem.setVisible(true);
        }      
    }
    private void btnLogarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogarMouseClicked
        logar();
    }//GEN-LAST:event_btnLogarMouseClicked

    private void SenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SenhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            logar();
    }//GEN-LAST:event_SenhaKeyPressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        f.AbrirNavegador("http://www.anibook.com.br/TCC/paginas/criarconta.php");
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogarActionPerformed
        logar();
    }//GEN-LAST:event_btnLogarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Senha;
    private javax.swing.JTextField Usuario;
    private javax.swing.JButton btnLogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel mensagem;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
