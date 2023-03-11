package br.com.fiap.satih.teste;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class TesteInsert {

	public static void main(String[] args) {

		String jdbc = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
		String sql = "INSERT INTO tbl_paciente(nome, cpf, nascimento) values(?, ?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(jdbc, "pf0313", "eduFiap2022");
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, "Roberto Carlos");
			pstmt.setLong(2, 23_355_789_900L);
			
			LocalDate ld = LocalDate.of(2000, 10, 12);
			
			pstmt.setDate(3, Date.valueOf(ld));
			
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
