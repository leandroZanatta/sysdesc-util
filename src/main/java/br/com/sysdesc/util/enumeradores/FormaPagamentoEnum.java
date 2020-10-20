package br.com.sysdesc.util.enumeradores;

import java.util.HashMap;
import java.util.Map;

public enum FormaPagamentoEnum {

	DINHEIRO(1L, false, "Dinheiro"),

	CHEQUE(2L, true, "Cheque"),

	BOLETO(3L, true, "Boleto"),

	CREDIARIO(4L, true, "Crediário"),

	CARTAO_DEBITO(5L, false, "Cartão de débito"),

	CARTAO_CREDITO(6L, true, "Cartão de Crédito");

	private static Map<Long, FormaPagamentoEnum> mapa = new HashMap<>();

	private final Long codigo;

	private final boolean pagamentoAPrazo;

	private final String descricao;

	static {
		for (FormaPagamentoEnum tipoFieldEnum : FormaPagamentoEnum.values()) {
			mapa.put(tipoFieldEnum.getCodigo(), tipoFieldEnum);
		}
	}

	private FormaPagamentoEnum(Long codigo, boolean pagamentoAPrazo, String descricao) {
		this.codigo = codigo;
		this.pagamentoAPrazo = pagamentoAPrazo;
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

	@Override
	public String toString() {

		return this.descricao;
	}

	public static FormaPagamentoEnum forCodigo(Long codigo) {

		return mapa.get(codigo);
	}

}
