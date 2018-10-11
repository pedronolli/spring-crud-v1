package br.com.cast.crudwithspring.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cast.crudwithspring.model.Endereco;

@Repository
public class EnderecoRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void inserir(Endereco endereco) {
		em.persist(endereco);
	}
	
	public void remover(Endereco endereco) {
		em.remove(endereco);
	}
	
	public void alterar(Endereco endereco) {
		em.merge(endereco);
	}
	
	public Endereco buscarPorCep(String cep) {
		return em.find(Endereco.class, cep);
	}
	
	public List<Endereco> buscarTodos(){
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT e ").append("FROM ").append(Endereco.class.getName()).append(" e ");
		
			return em.createQuery(hql.toString(), Endereco.class).getResultList();
	}
}
