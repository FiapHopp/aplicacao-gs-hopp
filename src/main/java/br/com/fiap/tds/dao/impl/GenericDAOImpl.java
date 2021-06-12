package br.com.fiap.tds.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import br.com.fiap.tds.dao.GenericDAO;
import br.com.fiap.tds.exception.CommitException;

public abstract class GenericDAOImpl<T,K> implements GenericDAO<T, K> {

	protected EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		clazz = (Class<T>) ((ParameterizedType)getClass()
			.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(T entity) {
		em.persist(entity);
	}

	@Override
	public void alterar(T entity) {
		em.merge(entity);
	}

	@Override
	public void remover(K codigo) throws EntityNotFoundException {
		T entidade = pesquisar(codigo);
		if (entidade == null){
			throw new EntityNotFoundException("Entidade não encontrada");
		}
		em.remove(entidade);
	}

	@Override
	public T pesquisar(K codigo) {
		return em.find(clazz, codigo);
	}
	
	@Override
	public void salvar() throws CommitException{
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new CommitException("Erro no commit", e);
		}
	}

}
