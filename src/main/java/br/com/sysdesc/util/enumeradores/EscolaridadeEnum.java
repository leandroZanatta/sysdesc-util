package br.com.sysdesc.util.enumeradores;

import java.util.HashMap;
import java.util.Map;

public enum EscolaridadeEnum {

	SEM_ESCOLARIDADE(1L, "Sem Escolaridade"),

	FUNDAMENTAL_I(2L, "Fundamental I"),

	FUNDAMENTAL_II(3L, "Fundamental II"),

	ENSINO_MEDIO(4L, "Ensino Médio"),

	BAXARELADO(5L, "Baixarelado"),

	POS_GRADUADO(6L, "Pós Graduado"),

	MESTRE(7L, "Mestre"),

	DOUTOR(8L, "Doutor"),

	PHD(9L, "PHD");

	private static Map<Long, EscolaridadeEnum> mapa = new HashMap<>();

	static {

		for (EscolaridadeEnum programa : EscolaridadeEnum.values()) {
			mapa.put(programa.getCodigo(), programa);
		}
	}

	private final Long codigo;

	private final String descricao;

	EscolaridadeEnum(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EscolaridadeEnum findByCodigo(Long codigoPrograma) {
		return mapa.get(codigoPrograma);
	}

	@Override
	public String toString() {

		return descricao;
	}
}
