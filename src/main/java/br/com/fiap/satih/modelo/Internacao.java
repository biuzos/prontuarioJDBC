package br.com.fiap.satih.modelo;

import java.time.LocalDateTime;

import br.com.fiap.satih.componente.LiberacaoLeito;

public class Internacao {

	private long id;
	
	private LocalDateTime entrada;
	
	private LocalDateTime saida;
	
	private LiberacaoLeito motivo;
	
	private Leito leito;
	
	private Paciente paciente;
	
	private Funcionario medico;
	
}
