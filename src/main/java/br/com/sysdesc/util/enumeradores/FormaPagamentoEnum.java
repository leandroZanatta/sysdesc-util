package br.com.sysdesc.util.enumeradores;

import java.util.HashMap;
import java.util.Map;

public enum FormaPagamentoEnum {

	DINHEIRO(1L, false, false, "Dinheiro"),

	CHEQUE(2L, true, true, "Cheque"),

	BOLETO(3L, false, true, "Boleto"),

	CARTAO_DEBITO(4L, false, true, "Cartão de débito"),

	CARTAO_CREDITO(5L, true, true, "Cartão de Crédito");

	private static Map<Long, FormaPagamentoEnum> mapa = new HashMap<>();

	private final Long codigo;

	private final boolean pagamentoAPrazo;

	private final boolean utilizaBanco;

	private final String descricao;

	static {
		for (FormaPagamentoEnum tipoFieldEnum : FormaPagamentoEnum.values()) {
			mapa.put(tipoFieldEnum.getCodigo(), tipoFieldEnum);
		}
	}

	private FormaPagamentoEnum(Long codigo, boolean pagamentoAPrazo, boolean utilizaBanco, String descricao) {
		this.codigo = codigo;
		this.pagamentoAPrazo = pagamentoAPrazo;
		this.utilizaBanco = utilizaBanco;
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public Boolean getPagamentoAPrazo() {
		return pagamentoAPrazo;
	}

	public String getDescricao() {
		return descricao;
	}

	public boolean isUtilizaBanco() {
		return utilizaBanco;
	}

	@Override
	public String toString() {

		return this.descricao;
	}

	public static FormaPagamentoEnum forCodigo(Long codigo) {

		return mapa.get(codigo);
	}

}
