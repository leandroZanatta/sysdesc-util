package br.com.sysdesc.util.enumeradores;

public enum TipoTituloEnum {

	DM_DUPLICATA_MERCANTIL(2),

	DS_DUPLICATA_DE_SERVICO(4);

	private final Integer codigo;

	TipoTituloEnum(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

}
