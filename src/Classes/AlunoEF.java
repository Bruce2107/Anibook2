package Classes;
/** Classe que cria um Objeto do tipo AlunoEF
 * @author Eduardo Henrique
 */
public class AlunoEF extends AlunoDados{
    Object presente;

    public Object getPresente() {
        return presente;
    }
    public AlunoEF() {
    }

    public AlunoEF(Object presente, int id, int faltas,int compensar, int compensadas, int aulasPrevistas, int aulasDadas, String nome, Object ativo) {
        super(id, faltas,compensar, compensadas, aulasPrevistas, aulasDadas, nome, ativo);
        this.presente = presente;
    }

    
    
}
