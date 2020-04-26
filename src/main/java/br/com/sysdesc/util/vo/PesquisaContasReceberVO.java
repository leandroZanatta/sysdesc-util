package br.com.sysdesc.util.vo;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class PesquisaContasReceberVO {

    private Long codigoContasReceber;

    private String programa;

    private Long codigoCliente;

    private Long codigoFormaPagamento;

    private Date dataVencimentoInicial;

    private Date dataVencimentoFinal;

    private BigDecimal valorParcelaInicial;

    private BigDecimal valorParcelaFinal;

    private boolean documentoBaixado;

}