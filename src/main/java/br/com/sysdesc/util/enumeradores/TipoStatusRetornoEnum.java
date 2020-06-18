package br.com.sysdesc.util.enumeradores;

import java.util.HashMap;
import java.util.Map;

public enum TipoStatusRetornoEnum {

	IMPORTADO(1L, "Importado"),

	PROCESSADO(2L, "Processado"),

	ERRO(3L, "Erro");

	private static Map<Long, TipoStatusRetornoEnum> mapa = new HashMap<>();

	static {

		for (TipoStatusRetornoEnum programa : TipoStatusRetornoEnum.values()) {
			mapa.put(programa.getCodigo(), programa);
		}
	}

	private final Long codigo;

	private final String descricao;

	TipoStatusRetornoEnum(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoStatusRetornoEnum findByCodigo(Long codigoPrograma) {
		return mapa.get(codigoPrograma);
	}

	@Override
	public String toString() {

		return descricao;
	}
}
