package br.com.fiap.satih.teste;

import java.time.LocalDate;

import br.com.fiap.satih.dao.PacienteDAO;
import br.com.fiap.satih.modelo.Paciente;

public class TesteUpdate {
	
	public static void main(String[] args) {
		
		Paciente p = new Paciente();
		p.setNome("Carlos Alberto");
		p.setCpf(23_586_999_920L);
		p.setEmail("caca@fiap.com.br");
		p.setResponsavel("Dalva");
		p.setTelefone("(11) 98273-9399");
		p.setNascimento(LocalDate.of(1997, 5, 14));
		p.setId(45L);
		
		PacienteDAO dao = new PacienteDAO();
		try {
			dao.altera(p);
			System.out.println("Paciente alterado com sucesso");
		} catch (Exception e) {
			System.out.println("Erro na alteração");
			e.printStackTrace();
		}
		
		
	}

}
