package br.edu.horus.projetoBasico.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Pessoa {

	@NotNull
	private Integer codigo;
	
	@Size(max=50, min=3)
	private String nome;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
