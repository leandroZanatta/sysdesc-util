package br.com.sysdesc.util.enumeradores;

import java.util.HashMap;
import java.util.Map;

public enum TipoStatusBoletoEnum {

    GERADO(1L, "Gerado"),

    ENVIANDO_REMESSA(2L, "Enviando remessa");

    private static Map<Long, TipoStatusBoletoEnum> mapa = new HashMap<>();

    static {

        for (TipoStatusBoletoEnum programa : TipoStatusBoletoEnum.values()) {
            mapa.put(programa.getCodigo(), programa);
        }
    }

    private final Long codigo;

    private final String descricao;

    TipoStatusBoletoEnum(Long codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoStatusBoletoEnum findByCodigo(Long codigoPrograma) {
        return mapa.get(codigoPrograma);
    }

    @Override
    public String toString() {

        return descricao;
    }
}
