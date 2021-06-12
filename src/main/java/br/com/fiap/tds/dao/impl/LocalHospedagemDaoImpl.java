package br.com.fiap.tds.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.tds.dao.LocalHospedagemDao;
import br.com.fiap.tds.entity.LocalHospedagem;

public class LocalHospedagemDaoImpl extends GenericDAOImpl<LocalHospedagem, Integer> implements LocalHospedagemDao{

	public LocalHospedagemDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	public List<LocalHospedagem> getAll() {
		String jpql= "SELECT s FROM LocalHospedagem s";
		TypedQuery<LocalHospedagem> query = em.createQuery(jpql,LocalHospedagem.class);
		return query.getResultList();
	}

}
