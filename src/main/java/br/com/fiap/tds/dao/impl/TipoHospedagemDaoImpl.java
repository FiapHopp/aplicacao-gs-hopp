package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.TipoHospedagemDao;
import br.com.fiap.tds.entity.TipoHospedagem;

public class TipoHospedagemDaoImpl extends GenericDAOImpl<TipoHospedagem, Integer> implements TipoHospedagemDao{

	public TipoHospedagemDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
