package br.com.fiap.satih.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteSelect {
	
	public static void main(String[] args) {
		String jdbc = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
		String sql = "SELECT id, nome, cpf, telefone, email, nascimento FROM tbl_paciente";
		Connection con = null;
		Statement stmt = null;
		try {
			con = DriverManager.getConnection(jdbc, "pf0313", "eduFiap2022");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				long id = rs.getLong("id");
				String nome = rs.getString("nome");
				String telefone = rs.getString("telefone");
				System.out.println(id + " " + nome + " " + telefone);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
