package br.com.fiap.tds.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.LocalHospedagemDao;
import br.com.fiap.tds.dao.LoginDao;
import br.com.fiap.tds.dao.PontoTuristicoDao;
import br.com.fiap.tds.dao.impl.LocalHospedagemDaoImpl;
import br.com.fiap.tds.dao.impl.LoginDaoImpl;
import br.com.fiap.tds.dao.impl.PontoTuristicoDaoImpl;
import br.com.fiap.tds.entity.*;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class PopulaBanco {
	public static void main(String[] args) throws CommitException {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();


		//CADASTRO DE LOGIN
		Calendar dtNasc1 = new GregorianCalendar(1995,Calendar.FEBRUARY,26);
		Usuario usuario1 = new Usuario("Pablo","rm86328@fiap.com.br",dtNasc1);
		
		Login login1 = new Login(usuario1,"rm86328","rm86328");

		LoginDao loginDao = new LoginDaoImpl(em);

		loginDao.cadastrar(login1);
		loginDao.salvar();

		//CADASTRO DE LOCAL DE HOSPEDAGEM
		TipoHospedagem tipoHospedagem = new TipoHospedagem("Hotel","Prédio");
		Endereco endereco = new Endereco(01310200,1500,"C");

		LocalHospedagem localHospedagem = new LocalHospedagem(tipoHospedagem,endereco,"Av Paulista","Prédio azul",11,40028922,"hotelAzul@gmail.com");
		LocalHospedagemDao localHospedagemDao= new LocalHospedagemDaoImpl(em);

		localHospedagemDao.cadastrar(localHospedagem);
		localHospedagemDao.salvar();

		//CADASTRO DE PONTO TURISTICO

		Cidade cidade = new Cidade(1,"São Paulo");
		TipoPontoTuristico tipoPontoTuristico = new TipoPontoTuristico(1,"Museu");

		PontoTuristico pontoTuristico = new PontoTuristico(cidade,tipoPontoTuristico,"Museu do Ipiranga");

		PontoTuristicoDao pontoTuristicoDao = new PontoTuristicoDaoImpl(em);

		pontoTuristicoDao.cadastrar(pontoTuristico);
		pontoTuristicoDao.salvar();

		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}

}
