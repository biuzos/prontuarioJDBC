package br.com.fiap.satih.teste;

import java.time.LocalDate;

import br.com.fiap.satih.dao.PacienteDAO;
import br.com.fiap.satih.modelo.Paciente;

public class TesteInsertPaciente {
	
	public static void main(String[] args) {
		
		Paciente pac = new Paciente();
		pac.setNome("José Magalhães");
		pac.setCpf(8238429L);
		pac.setEmail("magalhaes@fiap.com.br");
		pac.setTelefone("(11) 82839-0820");
		pac.setNascimento(LocalDate.of(1980, 5, 23));
		
		PacienteDAO persist = new PacienteDAO();
		
		try {
			persist.inclui(pac);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ID " + pac.getId());
	}

}
