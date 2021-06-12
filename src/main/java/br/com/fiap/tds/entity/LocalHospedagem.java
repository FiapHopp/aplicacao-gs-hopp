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
@Table(name = "T_LOCAL_HOSPEDAGEM")
@SequenceGenerator(name = "seqLocalHospedagem", sequenceName = "SEQ_T_LOCAL_HOSPEDAGEM", allocationSize = 1)
public class LocalHospedagem {

	@Id
	@Column(name = "ID_LOCAL_DE_HOSPEDAGEM")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLocalHospedagem")
	private int id;

	@OneToMany(mappedBy = "localHospedagem", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<AvaliacaoHospedagem> avaliacoes;

	@ManyToOne
	@JoinColumn(name = "ID_TIPO_HOSPEDAGEM")
	private TipoHospedagem tipoHospedagem;

	@ManyToOne
	@JoinColumn(name = "ID_ENDERECO")
	private Endereco endereco;

	@Column(name = "NM_LOCAL_HOSPEDAGEM")
	private String localHospedagem;

	@Column(name = "DESC_LOCAL_HOSPEDAGEM", length = 2000)
	private String descricao;

	@Column(name = "DDD", length = 2)
	private int ddd;

	@Column(name = "TEL_HOSPEDAGEM", length = 9)
	private int telefone;

	@Column(name = "EMAIL_HOSPEDAGEM", length = 100)
	private String email;

	public LocalHospedagem() {
	}

	public LocalHospedagem(int id, TipoHospedagem tipoHospedagem, Endereco endereco, String localHospedagem,
			String descricao, int ddd, int telefone, String email) {
		super();
		this.id = id;
		this.tipoHospedagem = tipoHospedagem;
		this.endereco = endereco;
		this.localHospedagem = localHospedagem;
		this.descricao = descricao;
		this.ddd = ddd;
		this.telefone = telefone;
		this.email = email;
	}
	public LocalHospedagem(TipoHospedagem tipoHospedagem, Endereco endereco, String localHospedagem,
			String descricao, int ddd, int telefone, String email) {
		super();
		this.tipoHospedagem = tipoHospedagem;
		this.endereco = endereco;
		this.localHospedagem = localHospedagem;
		this.descricao = descricao;
		this.ddd = ddd;
		this.telefone = telefone;
		this.email = email;
	}




	public void addAvaliacaoHospedagem(AvaliacaoHospedagem avaliacao) {
		if (avaliacoes == null)
			avaliacoes = new ArrayList<>();

		avaliacoes.add(avaliacao);
		avaliacao.setLocalHospedagem(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<AvaliacaoHospedagem> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoesm(List<AvaliacaoHospedagem> avaliacaoHospedagem) {
		this.avaliacoes = avaliacaoHospedagem;
	}

	public TipoHospedagem getTipoHospedagem() {
		return tipoHospedagem;
	}

	public void setTipoHospedagem(TipoHospedagem tipoHospedagem) {
		this.tipoHospedagem = tipoHospedagem;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getLocalHospedagem() {
		return localHospedagem;
	}

	public void setLocalHospedagem(String localHospedagem) {
		this.localHospedagem = localHospedagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "LocalHospedagem [id=" + id + ", avaliacoes=" + avaliacoes + ", tipoHospedagem=" + tipoHospedagem
				+ ", endereco=" + endereco + ", localHospedagem=" + localHospedagem + ", descricao=" + descricao
				+ ", ddd=" + ddd + ", telefone=" + telefone + ", email=" + email + "]";
	}
	
}