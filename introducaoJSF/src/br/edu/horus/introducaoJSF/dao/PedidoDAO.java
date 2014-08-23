package br.edu.horus.introducaoJSF.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.horus.introducaoJSF.model.Pedido;

@Stateless
public class PedidoDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Pedido pedido){
		if(pedido.getCodigo() == null){
			this.inserir(pedido);
		} else {
			this.alterar(pedido);	
		}
	}
	
	public void inserir(Pedido pedido){
		entityManager.persist(pedido);
	}
	
	public void alterar(Pedido pedido){
		entityManager.merge(pedido);
	}
	
	public void remover(Integer codigo){
		entityManager.remove(entityManager.getReference(Pedido.class, codigo));
	}
	
	public List<Pedido> todos(){
		return entityManager
				.createQuery("select c from Pedido c", Pedido.class)
				.getResultList();
	}
	
	public Pedido get(Integer codigo){
		return entityManager.find(Pedido.class, codigo);
	}
	

}
