package Classes;
/** Classe com as funções que podem ser utilizadas por qualque classe
 * @author Eduardo Henrique
 */
import Banco.FuncoesDAO;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Funcoes {
    FuncoesDAO fdao = new FuncoesDAO();
    /** Função que abre o navegador
     * @param url - Link que será aberto
     */
    public void AbrirNavegador(String url){
        try{
            Desktop.getDesktop().browse(new URI(url));
        }catch(URISyntaxException | IOException e){System.err.println("Erro ao abrir o link: "+url);
        }
    }
    /** Função que atualiza o combobox com as turmas
     * @param cpf - CPF professor
     * @param Turmas - Referencia ao ComboBox 
     */
    public void AtualizaCombo(String cpf,JComboBox Turmas){
        ArrayList<String> turmas = fdao.Tabelas(cpf);
        Turmas.removeAllItems();
        turmas.stream().forEach((turma)->{
            Turmas.addItem(turma);
        });
    }
    
}
