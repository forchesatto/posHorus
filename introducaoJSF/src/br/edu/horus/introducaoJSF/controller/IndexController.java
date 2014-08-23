package br.edu.horus.introducaoJSF.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class IndexController {

	private String nome;
	private String ufSelecionada;
	
	private List<String> nomes;
	
	@PostConstruct
	public void init(){
		nomes = new ArrayList<>();
	}
	
	public void salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"salvo com sucesso", "Mensagem completa"));
		nomes.add(nome);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getUfs() {
		return Arrays.asList("SC","PR","RS");
	}

	public String getUfSelecionada() {
		return ufSelecionada;
	}

	public void setUfSelecionada(String ufSelecionada) {
		this.ufSelecionada = ufSelecionada;
	}

	public List<String> getNomes() {
		return nomes;
	}

	public void setNomes(List<String> nomes) {
		this.nomes = nomes;
	}

}
