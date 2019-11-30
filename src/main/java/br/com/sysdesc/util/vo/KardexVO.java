package br.com.sysdesc.util.vo;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class KardexVO {

	private Date dataMovimento;

	private String tipoOperacao;

	private BigDecimal quantidade;

	private BigDecimal valorOperacao;

	private BigDecimal saldoTotal;

	private BigDecimal quantidadeTotal;

	private BigDecimal custoUnitario;

}
