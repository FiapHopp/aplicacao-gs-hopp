package br.com.fiap.tds.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fiap.tds.dao.LoginDao;
import br.com.fiap.tds.entity.Login;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class LoginDaoImpl extends GenericDAOImpl<Login, Integer> implements LoginDao{

	public LoginDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Login> listar() {
		TypedQuery<Login> query = em.createQuery("from Login", Login.class);
		return query.getResultList();
		
	}

	@Override
	public List<Login> buscarPorLogin(String login) {
		TypedQuery<Login> query = em.createNamedQuery("from Login l where l.login = :login", Login.class);
		query.setParameter("login", login);
		return query.getResultList();
	}

	public List<Login> getAll() {
		String jpql= "SELECT s FROM Login s";
		TypedQuery<Login> query = em.createQuery(jpql,Login.class);
		return query.getResultList();
	}
	
	public boolean exist(Login Login) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		TypedQuery<Login> query = em.createQuery(
				"SELECT u FROM User u WHERE "
				+ "u.email = :email AND "
				+ "u.password = :password", Login.class);
		query.setParameter("email", Login.getLogin());
		query.setParameter("password", Login.getSenha());
		
		try {
			query.getSingleResult();
		} catch (NoResultException e) {
			return false;
		}
		
		return true;
		
	}

}
