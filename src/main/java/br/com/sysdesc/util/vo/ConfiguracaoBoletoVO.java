package br.com.sysdesc.util.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfiguracaoBoletoVO {

	private boolean gerarboletos = true;

	private boolean enviarEmail = true;
}