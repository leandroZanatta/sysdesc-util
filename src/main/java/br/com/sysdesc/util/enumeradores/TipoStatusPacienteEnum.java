package br.com.sysdesc.util.enumeradores;

import java.util.HashMap;
import java.util.Map;

public enum TipoStatusPacienteEnum {

	ATIVO(1L, "Ativo"),

	INATIVO(2L, "Inativo"),

	OBITO(3L, "Óbito");

	private static Map<Long, TipoStatusPacienteEnum> mapa = new HashMap<>();

	static {

		for (TipoStatusPacienteEnum programa : TipoStatusPacienteEnum.values()) {
			mapa.put(programa.getCodigo(), programa);
		}
	}

	private final Long codigo;

	private final String descricao;

	TipoStatusPacienteEnum(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoStatusPacienteEnum findByCodigo(Long codigoPrograma) {
		return mapa.get(codigoPrograma);
	}

	@Override
	public String toString() {

		return descricao;
	}
}
