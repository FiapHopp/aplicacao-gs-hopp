package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_AVALIACAO")
@SequenceGenerator(name = "seqAvaliacaoPonto", sequenceName = "SEQ_T_AVALIACAO_PONTO", allocationSize = 1)
public class AvaliacaoPontoTuristico {

	@Id
	@Column(name = "ID_AVALIACAO_PONTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAvaliacaoPonto")
	private int idAvaliacaoPonto;

	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "ID_PONTO_TURISTICO")
	private PontoTuristico pontoTuristico;

	@Column(name = "NOTA")
	private int nota;

	@Column(name = "DES_AVALIACAO")
	private String descricaoAvaliacao;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DT_AVALIACAO")
	private Calendar dataAvaliacao;
	
	public AvaliacaoPontoTuristico() {}
	
	public AvaliacaoPontoTuristico(int idAvaliacaoPonto, Usuario usuario, PontoTuristico pontoTuristico, int nota,
			String descricaoAvaliacao, Calendar dataAvaliacao) {
		super();
		this.idAvaliacaoPonto = idAvaliacaoPonto;
		this.usuario = usuario;
		this.pontoTuristico = pontoTuristico;
		this.nota = nota;
		this.descricaoAvaliacao = descricaoAvaliacao;
		this.dataAvaliacao = dataAvaliacao;
	}

	public int getIdAvaliacaoPonto() {
		return idAvaliacaoPonto;
	}

	public void setIdAvaliacaoPonto(int idAvaliacaoPonto) {
		this.idAvaliacaoPonto = idAvaliacaoPonto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public PontoTuristico getPontoTuristico() {
		return pontoTuristico;
	}

	public void setPontoTuristico(PontoTuristico pontoTuristico) {
		this.pontoTuristico = pontoTuristico;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getDescricaoAvaliacao() {
		return descricaoAvaliacao;
	}

	public void setDescricaoAvaliacao(String descricaoAvaliacao) {
		this.descricaoAvaliacao = descricaoAvaliacao;
	}

	public Calendar getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Calendar dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	@Override
	public String toString() {
		return "AvaliacaoPontoTuristico [idAvaliacaoPonto=" + idAvaliacaoPonto + ", usuario=" + usuario
				+ ", pontoTuristico=" + pontoTuristico + ", nota=" + nota + ", descricaoAvaliacao=" + descricaoAvaliacao
				+ ", dataAvaliacao=" + dataAvaliacao + "]";
	}
	

}
