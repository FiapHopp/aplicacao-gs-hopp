package br.com.fiap.tds.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_TIPO_PONTO_TURISTICO")
@SequenceGenerator(name = "seqTipoPontoTuristico", sequenceName = "SEQ_T_TIPO_PONTO_TURISTICO", allocationSize = 1)
public class TipoPontoTuristico {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTipoPontoTuristico")
	@Column(name = "ID_TIPO_PONTO_TURISTICO")
	private int id;

	@OneToMany(mappedBy = "idTipoPontoTuristico", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<PontoTuristico> pontosTuristicos;

	@Column(name = "DES_TIPO_PONTO_TURISTICO")
	private String descricao;

	public TipoPontoTuristico() {
	}

	public TipoPontoTuristico(int id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public void addPontoTuristico(PontoTuristico pontoTuristico) {
		if (pontosTuristicos == null)
			pontosTuristicos = new ArrayList<>();

		pontosTuristicos.add(pontoTuristico);
		pontoTuristico.setIdTipoPontoTuristico(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<PontoTuristico> getPontoTuristico() {
		return pontosTuristicos;
	}

	public void setPontoTuristico(List<PontoTuristico> pontoTuristico) {
		this.pontosTuristicos = pontoTuristico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "TipoPontoTuristico [id=" + id + ", pontosTuristicos=" + pontosTuristicos + ", descricao=" + descricao
				+ "]";
	}
	
}
