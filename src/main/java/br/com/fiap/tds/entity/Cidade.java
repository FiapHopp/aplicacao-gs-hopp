package br.com.fiap.tds.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_CIDADE")
@SequenceGenerator(name = "seqCidade", sequenceName = "SEQ_TB_CIDADE",allocationSize = 1)
public class Cidade {

	@Id
	@Column(name = "ID_CIDADE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCidade")
	private int id;

	@Column(name = "ID_ESTADO")
	private int idEstado;

	@Column(name = "NM_CIDADE")
	private String nomeCidade;

	@OneToMany(mappedBy = "cidade")
	private List<PontoTuristico> pontosTuristicos;

	public Cidade() {
	}

	public Cidade(int id, int idEstado, String nomeCidade) {
		super();
		this.id = id;
		this.idEstado = idEstado;
		this.nomeCidade = nomeCidade;
	}
	
	public Cidade( int idEstado, String nomeCidade) {
		super();
		this.idEstado = idEstado;
		this.nomeCidade = nomeCidade;
	}
	
	public void addPontoTuristico(PontoTuristico pontoTuristico) {
		if (pontosTuristicos == null)
			pontosTuristicos = new ArrayList<>();

		pontosTuristicos.add(pontoTuristico);
		pontoTuristico.setCidade(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public List<PontoTuristico> getPontosTuristicos() {
		return pontosTuristicos;
	}

	public void setPontosTuristicos(List<PontoTuristico> pontoTuristico) {
		this.pontosTuristicos = pontoTuristico;
	}

	@Override
	public String toString() {
		return "Cidade [id=" + id + ", idEstado=" + idEstado + ", nomeCidade=" + nomeCidade + ", pontosTuristicos="
				+ pontosTuristicos + "]";
	}
	
}