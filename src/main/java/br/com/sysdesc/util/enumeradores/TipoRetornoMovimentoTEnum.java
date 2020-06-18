package br.com.sysdesc.util.enumeradores;

import java.util.HashMap;
import java.util.Map;

public enum TipoRetornoMovimentoTEnum {

	ENTRADA_CONFIRMADA(2L, "Entrada Confirmada");

	private static Map<Long, TipoRetornoMovimentoTEnum> mapa = new HashMap<>();

	static {

		for (TipoRetornoMovimentoTEnum programa : TipoRetornoMovimentoTEnum.values()) {
			mapa.put(programa.getCodigo(), programa);
		}
	}

	private final Long codigo;

	private final String descricao;

	TipoRetornoMovimentoTEnum(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoRetornoMovimentoTEnum findByCodigo(Long codigoPrograma) {
		return mapa.get(codigoPrograma);
	}

	@Override
	public String toString() {

		return descricao;
	}
}
