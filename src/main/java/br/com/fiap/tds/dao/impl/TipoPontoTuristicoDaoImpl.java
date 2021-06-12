package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.TipoPontoTuristicoDao;
import br.com.fiap.tds.entity.TipoPontoTuristico;

public class TipoPontoTuristicoDaoImpl extends GenericDAOImpl<TipoPontoTuristico, Integer>
		implements TipoPontoTuristicoDao {

	public TipoPontoTuristicoDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
}
