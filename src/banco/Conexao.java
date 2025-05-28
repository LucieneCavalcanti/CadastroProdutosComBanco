package banco;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private Connection con;
    public Connection getConexao(){
        return con;
    }
    public Conexao() throws Exception{
        String url="jdbc:sqlserver://LAB01-MAQ18:1433;databaseName=BDLPINOITE;encrypt=false;trustServerCertificate=true";
        String usuario="aluno";
        String senha="dba";
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        Class.forName(driver);
        con = DriverManager.getConnection(url, 
        usuario, senha);
    }
}
