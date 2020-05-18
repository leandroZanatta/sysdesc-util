package br.com.sysdesc.util.enumeradores;

import java.util.HashMap;
import java.util.Map;

public enum TipoEnvioEmailEnum {

    PENDENTE(1L, "Pendente"),

    AGUARDANDO(2L, "Aguardando"),

    ENVIADO(3L, "Enviado"),

    REENVIADO(4L, "Reenviado");

    private static Map<Long, TipoEnvioEmailEnum> mapa = new HashMap<>();

    static {

        for (TipoEnvioEmailEnum programa : TipoEnvioEmailEnum.values()) {
            mapa.put(programa.getCodigo(), programa);
        }
    }

    private final Long codigo;

    private final String descricao;

    public Long getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return descricao;
    }

    TipoEnvioEmailEnum(Long codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static TipoEnvioEmailEnum findByCodigo(Long codigo) {
        return mapa.get(codigo);
    }

}
