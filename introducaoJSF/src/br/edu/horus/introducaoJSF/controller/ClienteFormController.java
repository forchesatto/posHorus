package br.edu.horus.introducaoJSF.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.edu.horus.introducaoJSF.dao.ClienteDAO;
import br.edu.horus.introducaoJSF.model.Cliente;

@ManagedBean
public class ClienteFormController {
	
	private static final String URL_FORM = "clienteFormPrime";

	private Cliente cliente;
	private List<Cliente> clientes;
	
	@Inject
	private ClienteDAO clienteDAO;

	@PostConstruct
	public void init(){
		atualizaGrid();
		this.cliente = new Cliente();
	}
	
	private void atualizaGrid(){
		clientes = clienteDAO.todos();
	}
	
	public String salvar(){
		clienteDAO.salvar(cliente);
		atualizaGrid();
		return "clienteLista";
	}
	
	public String novo(){
		cliente = new Cliente();
		return URL_FORM;
	}
	
	public void remover(Cliente cliente){
		clienteDAO.remover(cliente.getCodigo());
		atualizaGrid();
	}
	
	public String editar(Cliente cliente){
		this.cliente = cliente;
		return URL_FORM;
	}
	
	public List<Cliente> autoComplete(String nome){
		return clienteDAO.buscarPorNome(nome);
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
