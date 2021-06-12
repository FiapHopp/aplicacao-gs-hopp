package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.CidadeDao;
import br.com.fiap.tds.entity.Cidade;

public class CidadeDaoImpl  extends GenericDAOImpl<Cidade, Integer> implements CidadeDao{

	public CidadeDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	

}
