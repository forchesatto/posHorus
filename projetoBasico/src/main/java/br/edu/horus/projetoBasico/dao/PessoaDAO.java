package br.edu.horus.projetoBasico.dao;

import javax.inject.Named;

import br.edu.horus.projetoBasico.model.Pessoa;

@Named
public class PessoaDAO {

	public void salvar(Pessoa pessoa){
		System.out.println("Pessoa salva com sucesso" + pessoa.getNome());
	}
}
