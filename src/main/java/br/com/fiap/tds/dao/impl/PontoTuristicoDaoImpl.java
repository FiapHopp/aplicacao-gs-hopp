package br.com.fiap.tds.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import br.com.fiap.tds.dao.PontoTuristicoDao;
import br.com.fiap.tds.entity.PontoTuristico;

public class PontoTuristicoDaoImpl extends GenericDAOImpl<PontoTuristico, Integer> implements PontoTuristicoDao{

	public PontoTuristicoDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	public List<PontoTuristico> getAll() {
		String jpql= "SELECT s FROM PontoTuristico s";
		TypedQuery<PontoTuristico> query = em.createQuery(jpql,PontoTuristico.class);
		return query.getResultList();
	}

}
