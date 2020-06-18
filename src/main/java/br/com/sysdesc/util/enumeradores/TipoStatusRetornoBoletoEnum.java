package br.com.sysdesc.util.enumeradores;

import java.util.HashMap;
import java.util.Map;

public enum TipoStatusRetornoBoletoEnum {

	PROCESSADO(1L, "Processado"),

	BOLETO_INEXISTENTE(2L, "Boleto Inexistente"),

	ERRO(3L, "Erro ao Processar");

	private static Map<Long, TipoStatusRetornoBoletoEnum> mapa = new HashMap<>();

	static {

		for (TipoStatusRetornoBoletoEnum programa : TipoStatusRetornoBoletoEnum.values()) {
			mapa.put(programa.getCodigo(), programa);
		}
	}

	private final Long codigo;

	private final String descricao;

	TipoStatusRetornoBoletoEnum(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoStatusRetornoBoletoEnum findByCodigo(Long codigoPrograma) {
		return mapa.get(codigoPrograma);
	}

	@Override
	public String toString() {

		return descricao;
	}
}
