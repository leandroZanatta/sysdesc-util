package br.com.sysdesc.util.dao;

import static br.com.sysdesc.util.constants.MensagemUtilConstants.MENSAGEM_DRIVER_NAO_ENCONTRADO;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import javax.naming.ConfigurationException;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.apache.commons.io.FileUtils;

import com.mysema.query.sql.H2Templates;
import com.mysema.query.sql.PostgresTemplates;
import com.mysema.query.sql.SQLTemplates;

import br.com.sysdesc.util.classes.CryptoUtil;
import br.com.sysdesc.util.constants.MensagemUtilConstants;
import br.com.sysdesc.util.exception.SysDescException;
import br.com.sysdesc.util.resources.Configuracoes;
import br.com.sysdesc.util.resources.Resources;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Conexao {

	private Conexao() {
	}

	private static EntityManager entityManager;

	private static SQLTemplates sqlTemplates;

	private static boolean isconfigured() {
		return new File(Configuracoes.CONEXAO).exists();
	}

	public static File getConfiguracaoBanco() throws ConfigurationException {

		if (!isconfigured()) {

			throw new ConfigurationException("Configuração de banco de dados não encontrada");
		}

		return new File(Configuracoes.CONEXAO);
	}

	public static void buildEntityManager() throws ConfigurationException {

		createConnection(getConfiguracaoBanco());
	}

	public static void createConnection(File configuracaoBanco) throws ConfigurationException {

		Properties propertiesConexao = buscarPropertiesConexao(configuracaoBanco);

		entityManager = Persistence.createEntityManagerFactory("SysTrans", propertiesConexao).createEntityManager();

		sqlTemplates = createTemplate(propertiesConexao);
	}

	private static SQLTemplates createTemplate(Properties propertiesConexao) {

		String driver = propertiesConexao.getProperty("javax.persistence.jdbc.driver", "");

		switch (driver) {
		case "org.postgresql.Driver":
			return PostgresTemplates.DEFAULT;
		case "org.h2.Driver":
			return H2Templates.DEFAULT;
		default:
			throw new SysDescException(MENSAGEM_DRIVER_NAO_ENCONTRADO);
		}

	}

	public static EntityManager getEntityManager() {

		return entityManager;
	}

	public static SQLTemplates getSqlTemplates() {
		return sqlTemplates;
	}

	public static Properties buscarPropertiesConexao(File configuracaoBanco) throws ConfigurationException {

		try {
			String arquivoConfiguracao = CryptoUtil
					.fromBlowfish(FileUtils.readFileToString(configuracaoBanco, StandardCharsets.UTF_8));

			if (arquivoConfiguracao == null) {
				throw new ConfigurationException("Configuração de conexão inválida");
			}

			Properties properties = new Properties();

			properties.load(new StringReader(arquivoConfiguracao));

			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.format_sql", "true");

			return properties;

		} catch (IOException e) {

			log.error(Resources.translate(MensagemUtilConstants.MENSAGEM_LOG_PROPRIEDADES_CONEXAO), e);

			return null;
		}
	}

}
