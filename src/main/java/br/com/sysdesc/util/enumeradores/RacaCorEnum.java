package br.com.sysdesc.util.enumeradores;

import java.util.HashMap;
import java.util.Map;

public enum RacaCorEnum {

	BRANCO(1L, "Branco"),

	NEGRO(2L, "Negro"),

	PARDO(3L, "Pardo"),

	OUTRO(4L, "Outro");

	private static Map<Long, RacaCorEnum> mapa = new HashMap<>();

	static {

		for (RacaCorEnum programa : RacaCorEnum.values()) {
			mapa.put(programa.getCodigo(), programa);
		}
	}

	private final Long codigo;

	private final String descricao;

	RacaCorEnum(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static RacaCorEnum findByCodigo(Long codigoPrograma) {
		return mapa.get(codigoPrograma);
	}

	@Override
	public String toString() {

		return descricao;
	}
}
