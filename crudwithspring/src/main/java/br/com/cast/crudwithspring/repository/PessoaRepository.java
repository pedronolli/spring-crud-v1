package br.com.cast.crudwithspring.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cast.crudwithspring.model.Pessoa;

@Repository
public class PessoaRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void inserir(Pessoa pessoa) {
		em.persist(pessoa);
	}
	
	public void remover(Pessoa pessoa) {
		em.remove(pessoa);
	}
	
	public void alterar(Pessoa pessoa) {
		em.merge(pessoa);
	}
	
	public Pessoa buscarPorCpf(String cpf) {
		return em.find(Pessoa.class, cpf);
	}
	
	public List<Pessoa> buscarTodas(){
		StringBuilder hql = new StringBuilder(); 
			
			hql.append("SELECT p ").append("FROM ").append(Pessoa.class.getName()).append(" p ")
			.append("JOIN FETCH p.endereco");
		
		return em.createQuery(hql.toString(), Pessoa.class).getResultList();	
	}
}
