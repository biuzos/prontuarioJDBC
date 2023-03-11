package br.com.fiap.satih.modelo;

public class Triagem extends Prontuario {
	
	private double temperatura;
	
	private double saturacao;
	
	private String pressao;

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public double getSaturacao() {
		return saturacao;
	}

	public void setSaturacao(double saturacao) {
		this.saturacao = saturacao;
	}

	public String getPressao() {
		return pressao;
	}

	public void setPressao(String pressao) {
		this.pressao = pressao;
	}
	
	

}
