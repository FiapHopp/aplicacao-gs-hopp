package br.com.fiap.tds.rest;


import java.util.List;
import javax.ws.rs.core.MediaType;


import javax.ws.rs.Produces; 
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.com.fiap.tds.dao.impl.PontoTuristicoDaoImpl;
import br.com.fiap.tds.entity.PontoTuristico;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

@Path("pontosTuristico")
@Produces(MediaType.APPLICATION_JSON)
public class PontoTuristicoEndpoint {
	
	EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	PontoTuristicoDaoImpl dao = new PontoTuristicoDaoImpl(em);
	
	@GET
	public List<PontoTuristico> index() {
		return dao.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(PontoTuristico pontoTuristico) {
		if (pontoTuristico == null) {
			return Response
					.status(Response.Status.BAD_REQUEST)
					.build();
		}
		try {
			dao.cadastrar(pontoTuristico);
		} catch (Exception e) {
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		}
		return Response
				.status(Response.Status.CREATED)
				.entity(pontoTuristico)
				.build();
	}
	
	@GET
	@Path("{id}")
	public Response show(@PathParam("id") int id) {
		PontoTuristico pontoTuristico = dao.pesquisar(id);
		if (pontoTuristico == null) {
			return Response
					.status(Response.Status.NOT_FOUND)
					.build();

		}
		return Response
					.status(Response.Status.OK)
					.entity(pontoTuristico)
					.build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, PontoTuristico pontoTuristico ) {
		pontoTuristico.setIdPontoTuristico(id);
		dao.alterar(pontoTuristico);
		return Response
				.status(Response.Status.OK)
				.entity(pontoTuristico)
				.build();
	}	

}