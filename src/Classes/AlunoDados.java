package Classes;
/**Classe que cria um Objeto do tipo AlunoDados
 * @author Eduardo Henrique
 */
public class AlunoDados {
    int id,faltas,compensar,compensadas,aulasPrevistas,aulasDadas;
    String nome;
    Object ativo;

    public int getCompensar() {
        return compensar;
    }

    public AlunoDados() {
    }

    public AlunoDados(int id, int faltas,int compensar, int compensadas, int aulasPrevistas, int aulasDadas, String nome, Object ativo) {
        this.id = id;
        this.faltas = faltas;
        this.compensadas = compensadas;
        this.aulasPrevistas = aulasPrevistas;
        this.aulasDadas = aulasDadas;
        this.nome = nome;
        this.ativo = ativo;
        this.compensar = compensar;
    }

    public int getId() {
        return id;
    }

    public int getFaltas() {
        return faltas;
    }

    public int getCompensadas() {
        return compensadas;
    }

    public int getAulasPrevistas() {
        return aulasPrevistas;
    }

    public int getAulasDadas() {
        return aulasDadas;
    }

    public String getNome() {
        return nome;
    }

    public Object getAtivo() {
        return ativo;
    }
    
}
