package br.edu.horus.introducaoJSF.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.horus.introducaoJSF.model.Cliente;

@ManagedBean
@ViewScoped
public class ClienteController {

	private Cliente cliente;
	private List<Cliente> clientes;

	@PostConstruct
	private void init(){
		cliente = new Cliente();
		clientes = new ArrayList<>();
	}
	
	public void salvar(){
		if(! clientes.contains(cliente)){
			clientes.add(cliente);	
		}
		novo();
	}
	
	public void novo(){
		cliente = new Cliente();
	}
	
	public void remover(Cliente cliente){
		clientes.remove(cliente);
	}
	
	public void editar(Cliente cliente){
		this.cliente = cliente;
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
