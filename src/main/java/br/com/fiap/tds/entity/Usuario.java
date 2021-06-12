package br.com.fiap.tds.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_USUARIO")
@SequenceGenerator(name = "seqUsuario", sequenceName = "SEQ_T_USUARIO", allocationSize = 1)
public class Usuario {

	@Id
	@Column(name = "ID_USUARIO", length = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUsuario")
	private int id;

	@OneToOne(mappedBy = "usuario", cascade = CascadeType.PERSIST)
	private Login login;

	@OneToMany(mappedBy = "usuario")
	private List<AvaliacaoPontoTuristico> avaliacaoPontoTuristico;

	@OneToMany(mappedBy = "usuario")
	private List<AvaliacaoHospedagem> avaliacaoHospedagem;

	@Column(name = "NM_NAME", length = 100)
	private String name;

	@Column(name = "NM_EMAIL", length = 100, nullable = false)
	private String email;

	@Column(name = "DT_NASCIMENTO", length = 100)
	private Calendar dataNascimento;

	public Usuario() {
	}

	public Usuario(int id, String name, String email, Calendar dataNascimento) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public Usuario(String name, String email, Calendar dataNascimento) {
		super();
		this.name = name;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<AvaliacaoPontoTuristico> getAvaliacaoPontoTuristico() {
		return avaliacaoPontoTuristico;
	}

	public void setAvaliacaoPontoTuristico(List<AvaliacaoPontoTuristico> avaliacaoPontoTuristico) {
		this.avaliacaoPontoTuristico = avaliacaoPontoTuristico;
	}

	public List<AvaliacaoHospedagem> getAvaliacaoHospedagem() {
		return avaliacaoHospedagem;
	}

	public void setAvaliacaoHospedagem(List<AvaliacaoHospedagem> avaliacaoHospedagem) {
		this.avaliacaoHospedagem = avaliacaoHospedagem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", avaliacaoPontoTuristico=" + avaliacaoPontoTuristico
				+ ", avaliacaoHospedagem=" + avaliacaoHospedagem + ", name=" + name + ", email=" + email
				+ ", dataNascimento=" + dataNascimento + "]";
	}

}
