package br.com.sysdesc.util.vo;

import lombok.Data;

@Data
public class ConfiguracaoMensalidadeVO {

	private ConfiguracaoContasReceberVO configuracaoContasReceber = new ConfiguracaoContasReceberVO();

	private ConfiguracaoDiarioVO configuracaoDiario = new ConfiguracaoDiarioVO();

	private ConfiguracaoBoletoVO configuracaoBoletoVO = new ConfiguracaoBoletoVO();
}
