package br.com.sysdesc.util.enumeradores;

import java.util.HashMap;
import java.util.Map;

public enum TipoContasReceberEnum {

	PRIMEIRO_DIA(1L, false, "PRIMEIRO DIA DO MÊS"),

	ULTIMO_DIA(2L, false, "ÚLTIMO DIA DO MÊS"),

	DIA_FIXO(3L, true, "DIA FIXO"),

	BASE_MENSALIDADE(4L, true, "NÚMERO DE DIAS COM BASE NA MENSALIDADE");

	private static Map<Long, TipoContasReceberEnum> mapa = new HashMap<>();

	static {

		for (TipoContasReceberEnum tipoContasReceberEnum : TipoContasReceberEnum.values()) {
			mapa.put(tipoContasReceberEnum.getCodigo(), tipoContasReceberEnum);
		}
	}

	private final Long codigo;

	private final boolean usaDias;

	private final String descricao;

	TipoContasReceberEnum(Long codigo, boolean usaDias, String descricao) {
		this.codigo = codigo;
		this.usaDias = usaDias;
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public boolean isUsaDias() {
		return usaDias;
	}

	@Override
	public String toString() {

		return descricao;
	}

	public static TipoContasReceberEnum findByCodigo(Long codigoPrograma) {
		return mapa.get(codigoPrograma);
	}
}
