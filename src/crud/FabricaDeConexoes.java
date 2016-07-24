package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {
 public Connection criaConexao (){
	 String url="jdbc:mysql://localhost/crud";
	 String usuario="root";
	 String senha="";
	 try {
		return DriverManager.getConnection(url, usuario, senha);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 return null;
 }
}
