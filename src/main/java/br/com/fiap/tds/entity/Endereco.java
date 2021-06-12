package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_ENDERECO")
@SequenceGenerator(name = "seqEndereco", sequenceName = "SEQ_T_ENDERECO")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEndereco")
	@Column(name = "ID_ENDERECO", length = 10)
	private int id;

	@Column(name = "CEP", length = 8)
	private int cep;

	@Column(name = "NR_ENDERECO", length = 5)
	private int numeroEndereco;

	@Column(name = "COMPLEMENTO", length = 100)
	private String complemento;

	@ManyToOne
	@JoinColumn(name="ID_LOCAL_DE_HOSPEDAGEM")
	private LocalHospedagem localHospedagem;
	
	public Endereco() {}
	
	public Endereco(int id, int cep, int numeroEndereco, String complemento, LocalHospedagem localHospedagem) {
		super();
		this.id = id;
		this.cep = cep;
		this.numeroEndereco = numeroEndereco;
		this.complemento = complemento;
		this.localHospedagem = localHospedagem;
	}
	public Endereco(int cep, int numeroEndereco, String complemento) {
		super();
		this.cep = cep;
		this.numeroEndereco = numeroEndereco;
		this.complemento = complemento;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public int getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(int numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public LocalHospedagem getLocalHospedagem() {
		return localHospedagem;
	}

	public void setLocalHospedagem(LocalHospedagem localHospedagem) {
		this.localHospedagem = localHospedagem;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", cep=" + cep + ", numeroEndereco=" + numeroEndereco + ", complemento="
				+ complemento + ", localHospedagem=" + localHospedagem + "]";
	}
	
}
