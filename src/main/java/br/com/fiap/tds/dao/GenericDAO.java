package br.com.fiap.tds.dao;

import javax.persistence.EntityNotFoundException;

import br.com.fiap.tds.exception.CommitException;

public interface GenericDAO<T, K> {

	void cadastrar(T entity);

	void alterar(T entity);

	void remover(K codigo) throws EntityNotFoundException;

	T pesquisar(K codigo);

	void salvar() throws CommitException;

}