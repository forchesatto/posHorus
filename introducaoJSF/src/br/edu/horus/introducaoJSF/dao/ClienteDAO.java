package br.edu.horus.introducaoJSF.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.horus.introducaoJSF.model.Cliente;

@Stateless
public class ClienteDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Cliente cliente) {
		if (cliente.getCodigo() == null) {
			this.inserir(cliente);
		} else {
			this.alterar(cliente);
		}
	}

	public void inserir(Cliente cliente) {
		entityManager.persist(cliente);
	}

	public void alterar(Cliente cliente) {
		entityManager.merge(cliente);
	}

	public void remover(Integer codigo) {
		entityManager.remove(entityManager.getReference(Cliente.class, codigo));
	}

	public List<Cliente> todos() {
		return entityManager.createQuery("select c from Cliente c",
				Cliente.class).getResultList();
	}

	public Cliente get(Integer codigo) {
		return entityManager.find(Cliente.class, codigo);
	}

	public List<Cliente> buscarPorNome(String nome) {
		TypedQuery<Cliente> query = entityManager.createQuery(
				"select c from Cliente c where c.nome like :nome",
				Cliente.class);
		query.setParameter("nome", "%" + nome + "%");
		return query.getResultList();
	}

}
