package br.com.fiap.satih.modelo;

import java.time.LocalDate;

import br.com.fiap.satih.componente.StatusLeito;
import br.com.fiap.satih.componente.TipoLeito;

public class Leito {
	
	private long id;
	
	private String numero;
	
	private	TipoLeito tipo;
	
	private LocalDate dataLiberacao;
	
	private StatusLeito status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public TipoLeito getTipo() {
		return tipo;
	}

	public void setTipo(TipoLeito tipo) {
		this.tipo = tipo;
	}

	public LocalDate getDataLiberacao() {
		return dataLiberacao;
	}

	public void setDataLiberacao(LocalDate dataLiberacao) {
		this.dataLiberacao = dataLiberacao;
	}

	public StatusLeito getStatus() {
		return status;
	}

	public void setStatus(StatusLeito status) {
		this.status = status;
	}
}
