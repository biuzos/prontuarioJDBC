package br.com.fiap.satih.teste;

import java.sql.SQLException;
import java.time.LocalDateTime;

import br.com.fiap.satih.dao.ProntuarioDAO;
import br.com.fiap.satih.modelo.Medicacao;
import br.com.fiap.satih.modelo.Paciente;
import br.com.fiap.satih.modelo.Prontuario;

public class TesteInsertProntuario {
	
	public static void main(String[] args) {
		
		Prontuario p = new Medicacao();
		
		LocalDateTime ldt = LocalDateTime.of(2022, 8, 25, 12, 30);
		p.setData(ldt);
		p.setObservacoes("Intravenoso");
		
		((Medicacao)p).setDosagem("5ml");
		((Medicacao)p).setMedicacao("Doril");
		
		Paciente pessoa = new Paciente();
		pessoa.setId(3L);		
		p.setPaciente(pessoa);
		
		ProntuarioDAO banco = new ProntuarioDAO();
		try {
		
			banco.inclui(p);
			System.out.println("Incluido com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}
