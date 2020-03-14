package br.com.sysdesc.util.vo;

import java.util.ArrayList;
import java.util.List;

public class PermissaoPesquisaVO {

	private String descricao;

	private Long codigoPesquisa;

	private Long idPesquisa;

	private Boolean flagLeitura = Boolean.FALSE;

	private List<PermissaoPesquisaVO> childs = new ArrayList<>();

	public Long getIdPesquisa() {
		return idPesquisa;
	}

	public void setIdPesquisa(Long idPesquisa) {
		this.idPesquisa = idPesquisa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getFlagLeitura() {
		return flagLeitura;
	}

	public void setFlagLeitura(Boolean flagLeitura) {
		this.flagLeitura = flagLeitura;
	}

	public List<PermissaoPesquisaVO> getChilds() {
		return childs;
	}

	public void setChilds(List<PermissaoPesquisaVO> childs) {
		this.childs = childs;
	}

	public void addChild(PermissaoPesquisaVO child) {

		this.childs.add(child);
	}

	public Long getCodigoPesquisa() {
		return codigoPesquisa;
	}

	public void setCodigoPesquisa(Long codigoPesquisa) {
		this.codigoPesquisa = codigoPesquisa;
	}

}
