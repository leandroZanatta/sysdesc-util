package br.com.sysdesc.util.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CampoClientesHabilitadosVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean cgc = true;

	private boolean nome = true;

	private boolean grupo = true;

	private boolean rg = true;

	private boolean nomeMae = true;

	private boolean nomePai = true;

	private boolean dataNascimento = true;

	private boolean cidade = true;

	private boolean endereco = true;

	private boolean numero = true;

	private boolean naturalidade = true;

	private boolean bairro = true;

	private boolean cep = true;

	private boolean celular = true;

	private boolean email = true;

	private boolean estadoCivil = true;

	private boolean escolaridade = true;

	private boolean sexo = true;

	private boolean raca = true;

	private boolean religiao = true;

	private boolean situacao = true;

}
