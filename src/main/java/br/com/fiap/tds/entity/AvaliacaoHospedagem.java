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
@Table(name = "T_AVALIACAO_HOSPEDAGEM")
@SequenceGenerator(name = "seqAvaliacaoHospedagem", sequenceName = "T_SEQ_AVALIACAO_HOSPEDAGEM", allocationSize = 1)
public class AvaliacaoHospedagem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAvaliacaoHospedagem")
	@Column(name = "ID_AVALIACAO_HOSPEDAGEM")
	private int id;

	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "ID_LOCAL_DE_HOSPEDAGEM")
	private LocalHospedagem localHospedagem;

	@Column(name = "NOTA", length = 2)
	private int nota;

	@Column(name = "DES_AVALIACAO", length = 200)
	private String descricao;

	@Temporal(TemporalType.DATE)
	@Column(name = "DT_AVALIACAO")
	private Calendar dataAvalicao;

	public AvaliacaoHospedagem() {
	}

	public AvaliacaoHospedagem(int id, Usuario usuario, LocalHospedagem idLocalHospedagem, int nota, String descricao,
			Calendar dataAvalicao) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.localHospedagem = idLocalHospedagem;
		this.nota = nota;
		this.descricao = descricao;
		this.dataAvalicao = dataAvalicao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalHospedagem getLocalHospedagem() {
		return localHospedagem;
	}

	public void setLocalHospedagem(LocalHospedagem idLocalHospedagem) {
		this.localHospedagem = idLocalHospedagem;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataAvalicao() {
		return dataAvalicao;
	}

	public void setDataAvalicao(Calendar dataAvalicao) {
		this.dataAvalicao = dataAvalicao;
	}

	@Override
	public String toString() {
		return "AvaliacaoHospedagem [id=" + id + ", usuario=" + usuario + ", localHospedagem=" + localHospedagem
				+ ", nota=" + nota + ", descricao=" + descricao + ", dataAvalicao=" + dataAvalicao + "]";
	}

}
