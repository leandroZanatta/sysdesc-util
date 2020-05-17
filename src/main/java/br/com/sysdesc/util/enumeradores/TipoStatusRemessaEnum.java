package br.com.sysdesc.util.enumeradores;

import java.util.HashMap;
import java.util.Map;

public enum TipoStatusRemessaEnum {

    GERADO(1L, "Gerado"),

    ENVIADO(2L, "Enviado");

    private static Map<Long, TipoStatusRemessaEnum> mapa = new HashMap<>();

    static {

        for (TipoStatusRemessaEnum programa : TipoStatusRemessaEnum.values()) {
            mapa.put(programa.getCodigo(), programa);
        }
    }

    private final Long codigo;

    private final String descricao;

    TipoStatusRemessaEnum(Long codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoStatusRemessaEnum findByCodigo(Long codigoPrograma) {
        return mapa.get(codigoPrograma);
    }

    @Override
    public String toString() {

        return descricao;
    }
}
