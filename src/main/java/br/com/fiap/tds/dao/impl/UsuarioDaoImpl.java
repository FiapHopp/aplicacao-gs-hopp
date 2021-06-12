package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.entity.Usuario;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;
import br.com.fiap.tds.dao.UsuarioDao;

public class UsuarioDaoImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDao{

	public UsuarioDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	

}
