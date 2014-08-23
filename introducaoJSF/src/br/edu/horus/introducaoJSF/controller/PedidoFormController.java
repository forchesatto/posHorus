package br.edu.horus.introducaoJSF.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.edu.horus.introducaoJSF.dao.PedidoDAO;
import br.edu.horus.introducaoJSF.model.Pedido;

@ManagedBean
public class PedidoFormController {
	
	private static final String URL_FORM = "pedidoForm";

	private Pedido pedido;
	private List<Pedido> pedidos;
	
	@Inject
	private PedidoDAO pedidoDAO;

	@PostConstruct
	public void init(){
		atualizaGrid();
		pedido = new Pedido();
	}
	
	private void atualizaGrid(){
		pedidos = pedidoDAO.todos();
	}
	
	public String salvar(){
		pedidoDAO.salvar(pedido);
		atualizaGrid();
		return "pedidoLista";
	}
	
	public String novo(){
		return URL_FORM;
	}
	
	public void remover(Pedido pedido){
		pedidoDAO.remover(pedido.getCodigo());
		atualizaGrid();
	}
	
	public String editar(Pedido pedido){
		this.pedido = pedido;
		return URL_FORM;
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}
