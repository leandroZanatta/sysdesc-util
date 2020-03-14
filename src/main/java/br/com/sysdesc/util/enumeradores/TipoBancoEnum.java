package br.com.sysdesc.util.enumeradores;

import java.util.HashMap;
import java.util.Map;

public enum TipoBancoEnum {

	BANCO_BRASIL(1L, "Banco do Brasil S.A."),

	BANCO_SANTANDER(33L, "Banco Santander (Brasil) S.A."),

	BANCO_ITAU(341L, "Banco Itaú S.A."),

	BANCO_BRADESCO(237L, "Banco Bradesco S.A."),

	BANCO_HSBC(399L, "HSBC Bank Brasil S.A. – Banco Múltiplo"),

	BANCO_CAIXA(104L, "Caixa Econômica Federal"),

	BANCO_SAFRA(422L, "Banco Safra S.A."),

	BANCO_SICOOB(756L, "Banco Cooperativo do Brasil S.A. – BANCOOB"),

	BANCO_SICREDI(748L, "Banco Cooperativo Sicredi S.A.");

	private final Long codigo;

	private final String descricao;

	private static Map<Long, TipoBancoEnum> mapa = new HashMap<>();

	static {
		for (TipoBancoEnum tipoTamanho : TipoBancoEnum.values()) {
			mapa.put(tipoTamanho.getCodigo(), tipoTamanho);
		}

	}

	private TipoBancoEnum(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoBancoEnum forCodigo(Long codigo) {
		return mapa.get(codigo);
	}

	@Override
	public String toString() {

		return this.descricao;
	}
}