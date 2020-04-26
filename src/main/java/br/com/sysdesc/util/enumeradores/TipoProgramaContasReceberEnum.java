package br.com.sysdesc.util.enumeradores;

import java.util.HashMap;
import java.util.Map;

public enum TipoProgramaContasReceberEnum {

    MENSALIDADE("MENS", "Mensalidade");

    private static Map<String, TipoProgramaContasReceberEnum> mapa = new HashMap<>();

    static {

        for (TipoProgramaContasReceberEnum programa : TipoProgramaContasReceberEnum.values()) {
            mapa.put(programa.getCodigo(), programa);
        }
    }

    private final String codigo;

    private final String descricao;

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return descricao;
    }

    TipoProgramaContasReceberEnum(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static TipoProgramaContasReceberEnum findByCodigo(String tipoPrograma) {
        return mapa.get(tipoPrograma);
    }

}