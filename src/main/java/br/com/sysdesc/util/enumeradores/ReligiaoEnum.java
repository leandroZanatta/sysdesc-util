package br.com.sysdesc.util.enumeradores;

import java.util.HashMap;
import java.util.Map;

public enum ReligiaoEnum {

    COTOLICO(1L, "Católico"),

    EVANGELICO(2L, "Evangélico"),

    ESPIRITA(3L, "Espírita"),

    MASSON(4L, "Massônico"),

    OUTRO(5L, "Outro");

    private static Map<Long, ReligiaoEnum> mapa = new HashMap<>();

    static {

        for (ReligiaoEnum programa : ReligiaoEnum.values()) {
            mapa.put(programa.getCodigo(), programa);
        }
    }

    private final Long codigo;

    private final String descricao;

    ReligiaoEnum(Long codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static ReligiaoEnum findByCodigo(Long codigoPrograma) {
        return mapa.get(codigoPrograma);
    }

    @Override
    public String toString() {

        return descricao;
    }
}
