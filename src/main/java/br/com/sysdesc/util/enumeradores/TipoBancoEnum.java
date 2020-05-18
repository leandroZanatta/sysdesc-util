package br.com.sysdesc.util.enumeradores;

import java.util.HashMap;
import java.util.Map;

public enum TipoBancoEnum {

    BANCO_BRASIL(1L, "Banco do Brasil"),

    BANCO_SANTANDER(33L, "Banco Santander"),

    BANCO_ITAU(341L, "Itaú"),

    BANCO_BRADESCO(237L, "Bradesco"),

    BANCO_HSBC(399L, " HSBC"),

    BANCO_CAIXA(104L, "Caixa"),

    BANCO_SAFRA(422L, "Banco Safra"),

    BANCO_SICOOB(756L, "SICOOB"),

    BANCO_SICREDI(748L, "SICREDI");

    private final Long codigo;

    private final String descricao;

    private static Map<Long, TipoBancoEnum> mapa = new HashMap<>();

    static {
        for (TipoBancoEnum tipoTamanho : TipoBancoEnum.values()) {
            mapa.put(tipoTamanho.getCodigo(), tipoTamanho);
        }

    }

    private TipoBancoEnum(Long codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoBancoEnum forCodigo(Long codigo) {
        return mapa.get(codigo);
    }

    @Override
    public String toString() {

        return this.descricao;
    }
}