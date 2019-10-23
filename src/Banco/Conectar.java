package Banco;
/** Classe para conexão com o banco de dados
 * @author Eduardo Henrique
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
    static String bancodados = "cl17115";
    static String login = "cl17115";
    static String senha = "cl*21072001";
    static String url = "jdbc:mysql://143.106.241.3/"+bancodados;
    Connection c = null;
    public Conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(url, login, senha);
            
        }catch(ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
        }
    }
    /**
     * Método para retorno da variavel de conexão
     * @return Connection - valor da conexão
     */
    public Connection getConnection(){
        return c;
    }
    
    /**
     * Método para encerrar a conexão com o banco
     */
    public void desconectar(){
        c = null;
    }
}
