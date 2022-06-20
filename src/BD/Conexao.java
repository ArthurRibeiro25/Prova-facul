package BD;

/** 
 * Essa classe é responsável por criar a conexão entre o programa e o banco de dados
**/
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

    public static Connection getConnection() {

        Connection conn = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver carregado com sucesso!");
        } catch (Exception e) {
            System.out.println("O driver não carregou corretamente!");
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escola", "root", "");
            System.out.println("Conexao bem sucedida!");
        } catch (Exception e) {
            System.out.println(e);
            conn = null;
        }
        return conn;
    }
    
    public static void fecha(Connection con, Statement s, ResultSet r){
        
        try{
            if(r != null) r.close();
            if(s != null) s.close();
            if(con != null) con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
