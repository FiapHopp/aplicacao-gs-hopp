package br.com.fiap.tds.dao;

import java.util.List;

import br.com.fiap.tds.entity.Login;

public interface LoginDao extends GenericDAO<Login, Integer>{
	List<Login> listar();
	List<Login> buscarPorLogin(String login);
}
