package br.com.fiap.satih.modelo;

public class Medicacao extends Prontuario {

	private String medicacao;
	
	private String dosagem;

	public String getMedicacao() {
		return medicacao;
	}

	public void setMedicacao(String medicacao) {
		this.medicacao = medicacao;
	}

	public String getDosagem() {
		return dosagem;
	}

	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}	
}
