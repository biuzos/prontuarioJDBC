package br.com.fiap.satih.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.satih.modelo.Paciente;

public class PacienteDAO {

	public void inclui(Paciente p) throws Exception {
		String sql = "INSERT INTO tbl_paciente(nome, telefone, email, cpf, "
		         + "responsavel, nascimento) VALUES(?, ?, ?, ?, ?, ?)";
		try (Connection con = new ConnectionFactory().getConexao();
			PreparedStatement pstmt = con.prepareStatement(sql, new String[]{"id"})){
			
			pstmt.setString(1, p.getNome());
			pstmt.setString(2, p.getTelefone());
			pstmt.setString(3, p.getEmail());
			pstmt.setLong(4, p.getCpf());
			pstmt.setString(5, p.getResponsavel());
			pstmt.setDate(6, Date.valueOf(p.getNascimento()));
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				long id = rs.getBigDecimal(1).longValue();
				p.setId(id);
			}			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void apaga(long id) throws Exception {
		String sql = "DELETE FROM tbl_paciente WHERE id=?";
		try(Connection con = new ConnectionFactory().getConexao();
			PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setLong(1, id);
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Paciente recupera(long id) throws Exception {
		Paciente p = new Paciente();
		p.setId(id);
		String sql = "SELECT * FROM tbl_paciente WHERE id=?";
		try(Connection con = new ConnectionFactory().getConexao();
			PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				p.setNome(rs.getString("nome"));
				p.setEmail(rs.getString("email"));
				p.setTelefone(rs.getString("telefone"));
				p.setResponsavel(rs.getString("responsavel"));
				p.setCpf(rs.getLong("cpf"));
				
				Date d = rs.getDate("nascimento");
				p.setNascimento(d.toLocalDate());
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}		
		return p;
	}
	
	public void altera(Paciente p) throws Exception {
		String jdbc = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
		String sql = "UPDATE tbl_paciente SET nome=?, cpf=?, nascimento=?, telefone=?,"
				+ "email=?, responsavel=? WHERE id=?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(jdbc, "pf0313", "eduFiap2022");
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, p.getNome());
			pstmt.setLong(2, p.getCpf());
			pstmt.setDate(3, Date.valueOf(p.getNascimento()));
			pstmt.setString(4, p.getTelefone());
			pstmt.setString(5, p.getEmail());
			pstmt.setString(6, p.getResponsavel());
			pstmt.setLong(7, p.getId());
			
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			pstmt.close();
			con.close();
		}
	}
}
