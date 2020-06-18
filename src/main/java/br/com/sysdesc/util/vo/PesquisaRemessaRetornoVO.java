package br.com.sysdesc.util.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PesquisaRemessaRetornoVO {

	private Long numeroDocumento;

	private Long codigoBanco;

	private Long codigoStatus;

	private Date dataInicial;

	private Date dataFinal;

}