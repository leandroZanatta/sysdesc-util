package br.com.sysdesc.util.vo;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ValoresContasReceberVO {

	private final BigDecimal valor;

	private BigDecimal valorPago = BigDecimal.ZERO;

	private BigDecimal acrescimo = BigDecimal.ZERO;

	private BigDecimal desconto = BigDecimal.ZERO;

	private BigDecimal valorJuros = BigDecimal.ZERO;

	public ValoresContasReceberVO(BigDecimal valor) {
		this.valor = valor;
	}

}