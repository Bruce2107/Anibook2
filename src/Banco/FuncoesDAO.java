package Banco;
/** Classe que contém as funcões sql da aplicação
 * @author Eduardo Henrique
 */
import Classes.Aluno;
import Classes.AlunoDados;
import Classes.SalvarFaltas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncoesDAO {
    /** Função que retorna todos os alunos com dados específicos
     * @param attr - campos que deseja obter da tabela
     * @param turma - tabela que deseja buscar os dados
     * @param cond - condição da sentança sql, deve incluir o WHERE ou estar vazio
     * @return ArrayList do tipo Aluno - lista com todos os alunos da tabela
     */
    public ArrayList<Aluno> Listar_AlunosLF(String attr,String turma,String cond){
        ArrayList<Aluno> lista = new ArrayList();
        Conectar c = new Conectar();
        String sql = "select "+attr+" from "+turma+" "+cond+" order by nome";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = c.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt(1));
                aluno.setNome(rs.getString(2));
                aluno.setFaltas(rs.getInt(3));
                lista.add(aluno);
            }
        }catch(SQLException e){
            System.err.println(e);
        }finally{
            try{
                ps.close();
                rs.close();
                c.desconectar();
            }catch(SQLException e){System.err.println(e.getMessage());}
        }
        return lista;
    }
    /**Função que retorna verdadeiro caso a atualização no banco ocorreu com sucesso
     * 
     * @param sf - Objeto do tipo SalvarFaltas que possui as informacões do aluno
     * @param tabela - Tabela que sofrerá as alterações 
     * @param falta - Quantidade de faltas da aula: 1 ou 2
     * @param AD - Quantidade de Aulas Dadas: 1 ou 2
     * @return boolean - true caso o comando update foi executado com sucesso 
     */
    public boolean LancarFaltas(SalvarFaltas sf, String tabela,int falta,int AD){
        Conectar c = new Conectar();
        if((boolean)sf.getPresente())
            falta = 0;
        try{
            PreparedStatement stmt;
            stmt = (PreparedStatement)c.getConnection().prepareStatement("update "+tabela+" set faltas = faltas + "+falta+", dadas = dadas + "+AD+" where id = "+sf.getId());
            stmt.execute();
            stmt.close();
            return true;
        }catch(SQLException e){System.err.println(e.getMessage());}
        return false;
    }
    /**Função que retorna todas as tabelas de um determinado professor
     * @param cpf - CPF do professor
     * @return ArrayList do tipo String que possui o nome de todas as tabelas de um professor
     */
    public ArrayList<String> Tabelas(String cpf){
        Conectar c = new Conectar();
        String sql = "select table_name from INFORMATION_SCHEMA.tables where table_name like \""+cpf+"%\"";
        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<String> lista = new ArrayList();
        try{
            ps = c.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String[] texto = rs.getString(1).split(cpf);
                lista.add(texto[1]);
            }
        }catch(SQLException e){System.err.println(e.getMessage());}finally{
            try{
                rs.close();
                ps.close();
                c.desconectar();
            }catch(SQLException e){System.err.println(e.getMessage());}
        }
        return lista;
    }
    /** Função que busca a senha de um professor
     * @param cpf - CPF do professor
     * @return ResultSet - contém a senha com hash em Argon2 do professor
     */
    public ResultSet Consulta(String cpf){
        Conectar c = new Conectar();
        String sql = "select senha from professor where cpf = "+cpf;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = c.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        }catch(SQLException e){System.err.print(e.getMessage());}
        return null;
    }
    /** Função que retorna todas as informações de todos os alunos
     * @param tabela - Tabela que contém os alunos
     * @return ArrayList do tipo AlunoDados com todas as informações do aluno
     */
    public ArrayList<AlunoDados> Listar_AlunoEF(String tabela){
        ArrayList<AlunoDados> lista = new ArrayList();
        Conectar c = new Conectar();
        String sql = "select * from "+tabela+" order by nome";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = c.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                AlunoDados aluno;
                aluno = new AlunoDados(rs.getInt(1),rs.getInt(3),rs.getInt(4),rs.getInt(8),rs.getInt(6),rs.getInt(7),rs.getString(2),rs.getObject(5));
                lista.add(aluno);
            }
        }catch(SQLException e){System.err.println(e.getMessage());}finally{
            try{
                rs.close();
                ps.close();
                c.desconectar();
            }catch(SQLException e){System.err.println(e.getMessage());}
        }
        return lista;
    }
    /** Função que retorna verdadeiro caso a atualização ocorreu com sucesso
     * @param id - ID do aluno
     * @param nome - Nome do aluno
     * @param faltas - Faltas do Aluno
     * @param compensar - Quantidade sugerida de faltas para serem compensadas
     * @param compensadas - Quantidade específicada pelo professor
     * @param ativo - Valor booleano para do aluno, false para inativo
     * @param tabela - Tabela em que está o aluno
     * @return boolean - true se o UPDATE for realizado com sucesso
     */
    public boolean Salvar(int id,String nome,int faltas,int compensar,int compensadas, boolean ativo,String tabela){
        Conectar c = new Conectar();
        int at = ativo ? 1: 0;
        String sql = "update "+tabela+" set nome = \""+nome+"\", faltas = "+faltas+", compensar = "+compensar+", ativo = "+at+",compensadas = "+compensadas+" where id = "+id;
        try{
            PreparedStatement stmt;
            stmt = (PreparedStatement)c.getConnection().prepareStatement(sql);
            stmt.execute();
            stmt.close();
            return true;
        }catch(SQLException e){System.err.println(e.getMessage());}
        return false;
    }
    /** Função que deleta uma tabela do banco de dados
     * @param tabela - Tabela a ser apagada
     * @return boolean - false caso ocorra algum erro na exclusão
     */
    public boolean ApagarTurma(String tabela){
            Conectar c = new Conectar();
            String sql = "drop table "+tabela;
            try{
                PreparedStatement stmt;
                stmt = c.getConnection().prepareStatement(sql);
                stmt.executeUpdate();
                return true;
            }catch(SQLException e){System.err.println(e.getMessage());}
        return false;   
    }
    /** Função que calcula o valor minímo de aulas que devem ser compensadas 
     * @param tabela - Tabela que está o aluno
     * @return boolean - true caso não ocorra nenhum problema
     */
    public boolean Compensar(String tabela){
        Conectar c = new Conectar();
        String sql = "update "+tabela+" set compensar = faltas - (dadas*0.25) where faltas/dadas > 0.25";
        try{
            try (PreparedStatement stmt = (PreparedStatement)c.getConnection().prepareStatement(sql)) {
                stmt.execute();
            }
            return true;
        }catch(SQLException e){System.err.println(e.getMessage());}
        return false;
    }
    /** Função que cria uma nova tabela
     * @param cpf - CPF do professor
     * @param nome - Nome da turma
     * @return boolean - true caso a tabela seja criada
     */
    public boolean CriarTurma(String cpf,String nome){
        Conectar c = new Conectar();
        String sql = "create table "+cpf+nome+"(id int not null AUTO_INCREMENT, nome varchar(45) not null,faltas int null,compensar int null,ativo bit null,previstas int not null,dadas int null,compensadas int not null, primary key (id))";
        try{
            PreparedStatement stmt = (PreparedStatement)c.getConnection().prepareStatement(sql);
            stmt.executeUpdate();
            return true;
        }catch(SQLException e){System.err.println(e.getMessage());}
        return false;
    }
    /** Função que retorna a quantidade de registros em uma tabela
     * @param tabela - Nome da tabela
     * @return int valor maior ou igual a 0 
     */
    public int QtdRegistros(String tabela){
        Conectar c = new Conectar();
        String sql = "select count(id) from "+tabela;
        ResultSet rs = null;
        PreparedStatement ps = null;
        int d = 0;
        try{
            ps = c.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
                d = rs.getInt(1);
        }catch(SQLException e){System.err.println(e.getMessage());}
        return d;
    }
    /** Função que retorna a quantidade de aulas previstas e dadas
     * @param tabela - Nome da tabela
     * @return ArrayList do tipo inteiro: possui dois valores Aulas Dadas e Previstas
     */
    public ArrayList<Integer> getDadasPrev(String tabela){
        Conectar c = new Conectar();
        String sql = "select previstas,dadas from "+tabela+" where ativo = 1 limit 1";
        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Integer> lista = new ArrayList();
        try{
            ps = c.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                lista.add(rs.getInt("dadas"));
                lista.add(rs.getInt("previstas"));
            }
        }catch(SQLException e){System.err.println(e.getMessage());}finally{
            try{
                rs.close();
                ps.close();
                c.desconectar();
            }catch(SQLException e){System.err.println(e.getMessage());}
        }
        return lista;
    }
    /** Função que retorna verdadeiro caso insira um dado na tabela 
     * @param tabela - Nome Tabela
     * @param nome - Nome Aluno
     * @param faltas - Total de faltas
     * @param compensar - Total de aulas a serem compensadas
     * @param dadas - Total de aulas dadas
     * @param previstas - Total de aulas previstas
     * @param compensadas - Total de aulas compensadas
     * @return boolean - true caso insira o registro
     */
    public boolean InsereAluno(String tabela, String nome,int faltas,int compensar,int dadas,int previstas,int compensadas){
        Conectar c = new Conectar();
        String sql = "insert into "+tabela+"(nome,faltas,compensar,ativo,previstas,dadas,compensadas) values(?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = (PreparedStatement)c.getConnection().prepareStatement(sql);
            stmt.setString(1,nome);
            stmt.setInt(2,faltas);
            stmt.setInt(3, compensar);
            stmt.setBoolean(4, true);
            stmt.setInt(5, previstas);
            stmt.setInt(6,dadas);
            stmt.setInt(7, compensadas);
            stmt.execute();
            return true;
        }catch(SQLException e){System.err.println(e.getMessage());}
        return false;
    }
}
