package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.EnderecoDao;
import br.com.fiap.tds.entity.Endereco;

public class EnderecoDaoImpl extends GenericDAOImpl<Endereco, Integer> implements EnderecoDao {

	public EnderecoDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
