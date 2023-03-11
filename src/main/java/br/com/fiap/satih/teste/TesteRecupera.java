package br.com.fiap.satih.teste;

import br.com.fiap.satih.dao.PacienteDAO;
import br.com.fiap.satih.modelo.Paciente;

public class TesteRecupera {
	
	public static void main(String[] args) {
		
		PacienteDAO dao = new PacienteDAO();
		try {
			Paciente pac = dao.recupera(44);
			
			System.out.println(pac);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
