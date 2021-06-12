package br.com.fiap.tds.bean;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import br.com.fiap.tds.entity.LocalHospedagem;

@Named
@RequestScoped
public class LocalHospedagemBean {

	private LocalHospedagem localHospedagem = new LocalHospedagem();

	public LocalHospedagem getLocalHospedagem() {
		return localHospedagem;
	}

	public void setLocalHospedagem(LocalHospedagem localHospedagem) {
		this.localHospedagem = localHospedagem;
	}

}
