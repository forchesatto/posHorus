package br.edu.horus.projetoBasico.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.edu.horus.projetoBasico.dao.PessoaDAO;
import br.edu.horus.projetoBasico.model.Pessoa;

@ManagedBean
public class PessoaController {

	@Inject
	private PessoaDAO pessoaDao;
	
	private Pessoa pessoa;
	
	@PostConstruct
	public void init(){
		pessoa = new Pessoa();
	}
	
	public void salvar(){
		pessoaDao.salvar(pessoa);
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(
        						FacesMessage.SEVERITY_INFO,
        						"Salvo com sucesso",
        						"Pessoa salva com sucesso");
        context.addMessage(null,message);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
