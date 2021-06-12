package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.AvaliacaoHospedagemDao;
import br.com.fiap.tds.entity.AvaliacaoHospedagem;

public class AvaliacaoHospedagemDaoImpl extends GenericDAOImpl<AvaliacaoHospedagem, Integer> implements AvaliacaoHospedagemDao{

	public AvaliacaoHospedagemDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
