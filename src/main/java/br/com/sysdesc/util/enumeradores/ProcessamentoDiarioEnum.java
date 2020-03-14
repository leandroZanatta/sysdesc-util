package br.com.sysdesc.util.enumeradores;

import java.util.HashMap;
import java.util.Map;

public enum ProcessamentoDiarioEnum {

	INICIANDO(0L),

	CONCLUIDO(1L),

	ERRO(2L);

	private static Map<Long, ProcessamentoDiarioEnum> mapa = new HashMap<>();

	static {

		for (ProcessamentoDiarioEnum programa : ProcessamentoDiarioEnum.values()) {
			mapa.put(programa.getCodigo(), programa);
		}
	}

	private final Long codigo;

	ProcessamentoDiarioEnum(Long codigo) {
		this.codigo = codigo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public static ProcessamentoDiarioEnum findByCodigo(Long codigoPrograma) {
		return mapa.get(codigoPrograma);
	}

}
