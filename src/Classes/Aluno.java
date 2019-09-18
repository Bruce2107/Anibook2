package Classes;
/** Classe que cria um Objeto do tipo Aluno 
 * @author Eduardo Henrique
 */
public class Aluno{ 
    int faltas,id;
    String nome;
    Object presente;

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Object getPresente() {
        return presente;
    }

    public void setPresente(Object presente) {
        this.presente = presente;
    }
}
