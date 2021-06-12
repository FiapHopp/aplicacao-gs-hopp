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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_PONTO_TURISTICO")
@SequenceGenerator(name = "seqPontoTuristico", sequenceName = "SEQ_T_PONTO_TURISTICO")
public class PontoTuristico {

	@Id
	@Column(name = "ID_PONTO_TURISTICO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPontoTuristico")
	private int idPontoTuristico;

	@OneToMany(mappedBy = "pontoTuristico", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<AvaliacaoPontoTuristico> avaliacoes;

	@ManyToOne
	@JoinColumn(name = "ID_CIDADE")
	private Cidade cidade;

	@ManyToOne
	@JoinColumn(name = "ID_TIPO_PONTO_TURISTICO")
	private TipoPontoTuristico idTipoPontoTuristico;

	@Column(name = "NM_PONTO_TURISTICO")
	private String nomePontoTuristico;

	public PontoTuristico() {
	}

	public PontoTuristico(int idPontoTuristico, Cidade cidade,
			TipoPontoTuristico idTipoPontoTuristico, String nomePontoTuristico) {
		super();
		this.idPontoTuristico = idPontoTuristico;
		this.cidade = cidade;
		this.idTipoPontoTuristico = idTipoPontoTuristico;
		this.nomePontoTuristico = nomePontoTuristico;
	}
	
	public PontoTuristico(Cidade cidade,
			TipoPontoTuristico idTipoPontoTuristico, String nomePontoTuristico) {
		super();
		this.cidade = cidade;
		this.idTipoPontoTuristico = idTipoPontoTuristico;
		this.nomePontoTuristico = nomePontoTuristico;
	}
	


	public void addAvalicoes(AvaliacaoPontoTuristico avaliacao) {
		if (avaliacoes == null)
			avaliacoes = new ArrayList<>();

		avaliacoes.add(avaliacao);
		avaliacao.setPontoTuristico(this);
	}

	public int getIdPontoTuristico() {
		return idPontoTuristico;
	}

	public void setIdPontoTuristico(int idPontoTuristico) {
		this.idPontoTuristico = idPontoTuristico;
	}

	public List<AvaliacaoPontoTuristico> getAvaliacao() {
		return avaliacoes;
	}

	public void setAvaliacao(List<AvaliacaoPontoTuristico> avaliacao) {
		this.avaliacoes = avaliacao;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public TipoPontoTuristico getIdTipoPontoTuristico() {
		return idTipoPontoTuristico;
	}

	public void setIdTipoPontoTuristico(TipoPontoTuristico idTipoPontoTuristico) {
		this.idTipoPontoTuristico = idTipoPontoTuristico;
	}

	public String getNomePontoTuristico() {
		return nomePontoTuristico;
	}

	public void setNomePontoTuristico(String nomePontoTuristico) {
		this.nomePontoTuristico = nomePontoTuristico;
	}

	@Override
	public String toString() {
		return "PontoTuristico [idPontoTuristico=" + idPontoTuristico + ", avaliacoes=" + avaliacoes + ", cidade="
				+ cidade + ", idTipoPontoTuristico=" + idTipoPontoTuristico + ", nomePontoTuristico="
				+ nomePontoTuristico + "]";
	}
	

}
