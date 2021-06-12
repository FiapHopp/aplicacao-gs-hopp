package br.com.fiap.tds.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_TIPO_HOSPEDAGEM")
public class TipoHospedagem {

	@Id
	@Column(name = "ID_TIPO_HOSPEDAGEM")
	private int id;

	@OneToMany(mappedBy = "tipoHospedagem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<LocalHospedagem> local;

	@Column(name = "NM_TIPO_HOSPEDAGEM")
	private String nomeTipoHospedagem;

	@Column(name = "DES_TIPO_HOSPEDAGEM")
	private String descTipoHospedagem;

	public TipoHospedagem() {
	}

	public TipoHospedagem(int id, String nomeTipoHospedagem, String descTipoHospedagem) {
		super();
		this.id = id;
		this.nomeTipoHospedagem = nomeTipoHospedagem;
		this.descTipoHospedagem = descTipoHospedagem;
	}
	
	public TipoHospedagem( String nomeTipoHospedagem, String descTipoHospedagem) {
		super();
		this.nomeTipoHospedagem = nomeTipoHospedagem;
		this.descTipoHospedagem = descTipoHospedagem;
	}

	public void addLocalHospedagem(LocalHospedagem localHospedagem) {
		if (local == null)
			local = new ArrayList<>();

		local.add(localHospedagem);
		localHospedagem.setTipoHospedagem(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<LocalHospedagem> getLocal() {
		return local;
	}

	public void setLocal(List<LocalHospedagem> local) {
		this.local = local;
	}

	public String getNomeTipoHospedagem() {
		return nomeTipoHospedagem;
	}

	public void setNomeTipoHospedagem(String nomeTipoHospedagem) {
		this.nomeTipoHospedagem = nomeTipoHospedagem;
	}

	public String getDescTipoHospedagem() {
		return descTipoHospedagem;
	}

	public void setDescTipoHospedagem(String descTipoHospedagem) {
		this.descTipoHospedagem = descTipoHospedagem;
	}

	@Override
	public String toString() {
		return "TipoHospedagem [id=" + id + ", local=" + local + ", nomeTipoHospedagem=" + nomeTipoHospedagem
				+ ", descTipoHospedagem=" + descTipoHospedagem + "]";
	}
	

}
