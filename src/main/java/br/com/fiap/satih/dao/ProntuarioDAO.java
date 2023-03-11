package br.com.fiap.satih.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import br.com.fiap.satih.modelo.Medicacao;
import br.com.fiap.satih.modelo.Prontuario;
import br.com.fiap.satih.modelo.Triagem;

public class ProntuarioDAO {

	public void inclui(Prontuario p) throws SQLException {
		
		String sql = "INSERT INTO tbl_prontuario(discriminator, data, observacoes," +
				"temperatura, pressao, saturacao, medicacao, dosagem, paciente_id)" +
				"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection con = new ConnectionFactory().getConexao();
		  PreparedStatement pstmt = con.prepareStatement(sql, new String[]{"id"})){
			
			pstmt.setTimestamp(2, Timestamp.valueOf(p.getData()));
			
			pstmt.setString(3, p.getObservacoes());
			pstmt.setLong(9, p.getPaciente().getId());
			
			if (p instanceof Medicacao) {
				pstmt.setString(1, "MEDICACAO");
				pstmt.setString(7, ((Medicacao)p).getMedicacao());
				pstmt.setString(8, ((Medicacao)p).getDosagem());
				
				pstmt.setDouble(4, 0);
				pstmt.setString(5, null);
				pstmt.setDouble(6, 0);
			}
			else if (p instanceof Triagem) {
				pstmt.setString(1, "TRIAGEM");
				pstmt.setString(7, null);
				pstmt.setString(8, null);
				
				pstmt.setDouble(4, ((Triagem) p).getTemperatura());
				pstmt.setString(5, ((Triagem) p).getPressao());
				pstmt.setDouble(6, ((Triagem) p).getSaturacao());				
			}
			else {
				pstmt.setString(1, "PRONTUARIO");
				pstmt.setString(7, null);
				pstmt.setString(8, null);				
				pstmt.setDouble(4, 0);
				pstmt.setString(5, null);
				pstmt.setDouble(6, 0);
			}
			pstmt.executeUpdate();			
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void apaga(long id) {
		
	}
	
	public void altera(Prontuario p) {
		
	}
	
	public Prontuario recupera(long id) {
		return null;
	}
	
}
