package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.AvaliacaoPontoTuristicoDao;
import br.com.fiap.tds.entity.AvaliacaoPontoTuristico;

public class AvaliacaoPontoTuristicoDaoImpl extends GenericDAOImpl<AvaliacaoPontoTuristico, Integer>
		implements AvaliacaoPontoTuristicoDao {

	public AvaliacaoPontoTuristicoDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
