package br.com.sysdesc.util.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Resources {

	private Resources() {
	}

	private static Properties mapaValores;

	public static final String APPLICATION_JAR = "APPLICATION_JAR";
	public static final String APPLICATION_VERSOES = "APPLICATION_VERSOES";

	public static final String OPTION_VALIDACAO = "OPTION_VALIDACAO";
	public static final String OPTION_ERRO = "OPTION_ERRO";

	public static final String FRMLOGIN_LB_LOGIN = "FRMLOGIN_LB_LOGIN";
	public static final String FRMLOGIN_BT_LOGAR = "FRMLOGIN_BT_LOGAR";
	public static final String FRMLOGIN_LB_USUARIO = "FRMLOGIN_LB_USUARIO";
	public static final String FRMLOGIN_LB_SENHA = "FRMLOGIN_LB_SENHA";
	public static final String FRMLOGIN_BT_CANCELAR = "FRMLOGIN_BT_CANCELAR";
	public static final String FRMLOGIN_MSG_SENHA = "FRMLOGIN_MSG_SENHA";
	public static final String FRMLOGIN_MSG_USUARIO = "FRMLOGIN_MSG_USUARIO";
	public static final String FRMLOGIN_MSG_LOGIN = "FRMLOGIN_MSG_LOGIN";
	public static final String FRMLOGIN_MSG_VERIFICACAO = "FRMLOGIN_MSG_VERIFICACAO";

	public static final String TBLCONFIG_DESCRICAO = "TBLCONFIG_DESCRICAO";
	public static final String TBLCONFIG_ALIAS = "TBLCONFIG_ALIAS";
	public static final String TBLCONFIG_TIPO_DADO = "TBLCONFIG_TIPO_DADO";
	public static final String TBLCONFIG_CAMPO = "TBLCONFIG_CAMPO";
	public static final String TBLCONFIG_FORMATO = "TBLCONFIG_FORMATO";
	public static final String TBLCONFIG_TIPO_TAMANHO = "TBLCONFIG_TIPO_TAMANHO";
	public static final String TBLCONFIG_TAMANHO = "TBLCONFIG_TAMANHO";
	public static final String TBLCONFIG_FORMATACAO = "TBLCONFIG_FORMATACAO";

	public static final String TBLSALARIO_DATA_ALTERACAO = "TBLSALARIO_DATA_ALTERACAO";
	public static final String TBLSALARIO_VALOR_SALARIO = "TBLSALARIO_VALOR_SALARIO";

	public static final String FRMCONEXAO_TITULO = "FRMCONEXAO_TITULO";
	public static final String FRMCONEXAO_MSG_SALVAR = "FRMCONEXAO_MSG_SALVAR";
	public static final String FRMCONEXAO_PRP_CONEXAO = "FRMCONEXAO_PRP_CONEXAO";
	public static final String FRMCONEXAO_BT_SALVAR = "FRMCONEXAO_BT_SALVAR";
	public static final String FRMCONEXAO_BT_CANCELAR = "FRMCONEXAO_BT_CANCELAR";
	public static final String FRMCONEXAO_LB_TIPOBANCO = "FRMCONEXAO_LB_TIPOBANCO";
	public static final String FRMCONEXAO_LB_URL = "FRMCONEXAO_LB_URL";
	public static final String FRMCONEXAO_LB_PORTA = "FRMCONEXAO_LB_PORTA";
	public static final String FRMCONEXAO_LB_USUARIO = "FRMCONEXAO_LB_USUARIO";
	public static final String FRMCONEXAO_LB_SENHA = "FRMCONEXAO_LB_SENHA";
	public static final String FRMCONEXAO_LB_BANCO = "FRMCONEXAO_LB_BANCO";

	public static final String FRMUSUARIO_TITLE = "FRMUSUARIO_TITLE";
	public static final String FRMUSUARIO_LB_CODIGO = "FRMUSUARIO_LB_CODIGO";
	public static final String FRMUSUARIO_LB_USUARIO = "FRMUSUARIO_LB_USUARIO";
	public static final String FRMUSUARIO_LB_SENHA = "FRMUSUARIO_LB_SENHA";

	public static final String FRMAPPLICATION_MN_CADASTRO = "FRMAPPLICATION_MN_CADASTRO";
	public static final String FRMAPPLICATION_MI_USUARIOS = "FRMAPPLICATION_MI_USUARIOS";
	public static final String FRMAPPLICATION_LB_USUARIO = "FRMAPPLICATION_LB_USUARIO";

	public static final String FRMESTADO_TITLE = "FRMESTADO_TITLE";
	public static final String FRMESTADO_LB_CODIGO = "FRMESTADO_LB_CODIGO";
	public static final String FRMESTADO_LB_DESCRICAO = "FRMESTADO_LB_DESCRICAO";
	public static final String FRMESTADO_LB_UF = "FRMESTADO_LB_UF";

	public static final String FRMCIDADE_TITLE = "FRMCIDADE_TITLE";
	public static final String FRMCIDADE_LB_CODIGO = "FRMCIDADE_LB_CODIGO";
	public static final String FRMCIDADE_LB_DESCRICAO = "FRMCIDADE_LB_DESCRICAO";
	public static final String FRMCIDADE_LB_ESTADO = "FRMCIDADE_LB_ESTADO";

	public static final String FRMPERFIL_TITLE = "FRMPERFIL_TITLE";
	public static final String FRMPERFIL_LB_CODIGO = "FRMPERFIL_LB_CODIGO";
	public static final String FRMPERFIL_LB_DESCRICAO = "FRMPERFIL_LB_DESCRICAO";

	public static final String FRMPESQUISA_TITLE = "FRMPESQUISA_TITLE";
	public static final String FRMPESQUISA_LB_CODIGO = "FRMPESQUISA_LB_CODIGO";
	public static final String FRMPESQUISA_LB_PESQUISA = "FRMPESQUISA_LB_PESQUISA";
	public static final String FRMPESQUISA_LB_PAGINACAO = "FRMPESQUISA_LB_PAGINACAO";
	public static final String FRMPESQUISA_LB_DESCRICAO = "FRMPESQUISA_LB_DESCRICAO";
	public static final String FRMPESQUISA_LB_USUARIO = "FRMPESQUISA_LB_USUARIO";
	public static final String FRMPESQUISA_LB_PERFIL = "FRMPESQUISA_LB_PERFIL";
	public static final String FRMPESQUISA_MSG_DESCRICAO = "FRMPESQUISA_MSG_DESCRICAO";
	public static final String FRMPESQUISA_MSG_PAGINACAO = "FRMPESQUISA_MSG_PAGINACAO";
	public static final String FRMPESQUISA_MSG_PESQUISA = "FRMPESQUISA_MSG_PESQUISA";

	public static final String FRMVALIDARSENHA_TITLE = "FRMVALIDARSENHA_TITLE";
	public static final String FRMVALIDARSENHA_LB_SENHA = "FRMVALIDARSENHA_LB_SENHA";
	public static final String FRMVALIDARSENHA_LB_CONFIRMAR_SENHA = "FRMVALIDARSENHA_LB_CONFIRMAR_SENHA";

	public static final String FRMCLIENTE_TITLE = "FRMCLIENTE_TITLE";
	public static final String FRMCLIENTE_LBL_CODIGO = "FRMCLIENTE_LBL_CODIGO";
	public static final String FRMCLIENTE_LBL_CPF_CNPJ = "FRMCLIENTE_LBL_CPF_CNPJ";
	public static final String FRMCLIENTE_RB_PESSOA_FISICA = "FRMCLIENTE_RB_PESSOA_FISICA";
	public static final String FRMCLIENTE_RB_PESSOA_JURIDICA = "FRMCLIENTE_RB_PESSOA_JURIDICA";
	public static final String FRMCLIENTE_LBL_RAZAO_SOCIAL = "FRMCLIENTE_LBL_RAZAO_SOCIAL";
	public static final String FRMCLIENTE_LBL_INSCRICAO_ESTADUAL = "FRMCLIENTE_LBL_INSCRICAO_ESTADUAL";
	public static final String FRMCLIENTE_LBL_DATA_DE_NASCIMENTO = "FRMCLIENTE_LBL_DATA_DE_NASCIMENTO";
	public static final String FRMCLIENTE_LBL_ESTADO = "FRMCLIENTE_LBL_ESTADO";
	public static final String FRMCLIENTE_LBL_CIDADE = "FRMCLIENTE_LBL_CIDADE";
	public static final String FRMCLIENTE_LBL_ENDERECO = "FRMCLIENTE_LBL_ENDERECO";
	public static final String FRMCLIENTE_LBL_NUMERO = "FRMCLIENTE_LBL_NUMERO";
	public static final String FRMCLIENTE_LBL_BAIRRO = "FRMCLIENTE_LBL_BAIRRO";
	public static final String FRMCLIENTE_LBL_CEP = "FRMCLIENTE_LBL_CEP";
	public static final String FRMCLIENTE_LBL_CELULAR = "FRMCLIENTE_LBL_CELULAR";
	public static final String FRMCLIENTE_LBL_ESTADO_CIVIL = "FRMCLIENTE_LBL_ESTADO_CIVIL";
	public static final String FRMCLIENTE_LBL_SEXO = "FRMCLIENTE_LBL_SEXO";
	public static final String FRMCLIENTE_LBL_SITUACAO = "FRMCLIENTE_LBL_SITUACAO";
	public static final String FRMCLIENTE_LBL_EMAIL = "FRMCLIENTE_LBL_EMAIL";

	public static final String FRMFUNCIONARIO_TITLE = "FRMFUNCIONARIO_TITLE";
	public static final String FRMFUNCIONARIO_LB_CODIGO = "FRMFUNCIONARIO_LB_CODIGO";
	public static final String FRMFUNCIONARIO_LB_CLIENTE = "FRMFUNCIONARIO_LB_CLIENTE";
	public static final String FRMFUNCIONARIO_LB_SALARIO = "FRMFUNCIONARIO_LB_SALARIO";
	public static final String FRMFUNCIONARIO_LB_ADMISSAO = "FRMFUNCIONARIO_LB_ADMISSAO";
	public static final String FRMFUNCIONARIO_LB_CARGO = "FRMFUNCIONARIO_LB_CARGO";
	public static final String FRMFUNCIONARIO_LB_DEMISSAO = "FRMFUNCIONARIO_LB_DEMISSAO";
	static {
		try {
			File arquivoConfiguracao = new File(Configuracoes.RESOURCES);

			if (!arquivoConfiguracao.exists()) {
				FileUtils.writeStringToFile(arquivoConfiguracao, "pt_br.properties", StandardCharsets.UTF_8);
			}

			String arquivoConfig = FileUtils.readFileToString(arquivoConfiguracao, StandardCharsets.UTF_8);

			mapaValores = new Properties();

			mapaValores.load(new InputStreamReader(
					new FileInputStream(Configuracoes.FOLDER_RESOURCES + Configuracoes.SEPARATOR + arquivoConfig),
					StandardCharsets.UTF_8));

		} catch (IOException e) {

			log.error("Erro ao malipular arquivo de resources", e);
		}
	}

	public static String translate(String menu, String defaultStr) {

		return mapaValores.getProperty(menu, defaultStr);

	}

	public static String translate(String menu) {

		return mapaValores.getProperty(menu);

	}

}
