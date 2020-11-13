package br.com.sysdesc.util.resources;

import java.io.File;

public class Configuracoes {

	private Configuracoes() {
	}

	public static final String USER_DIR = System.getProperty("user.dir");
	public static final String SEPARATOR = File.separator;
	public static final String FOLDER_RESOURCES = USER_DIR + SEPARATOR + "resources";
	public static final String FOLDER_VERSOES = USER_DIR + SEPARATOR + "versoes";
	public static final String VERSAO = FOLDER_VERSOES + SEPARATOR + "versao.json";
	public static final String VERSAO_SERVIDOR = FOLDER_VERSOES + SEPARATOR + "versaoservidor.json";
	public static final String FOLDER_IMAGE = FOLDER_RESOURCES + SEPARATOR + "image";
	public static final String FOLDER_TRANSFER = FOLDER_RESOURCES + SEPARATOR + "transfer";
	public static final String FOLDER_PESQUISAS = FOLDER_RESOURCES + SEPARATOR + "pesquisas";
	public static final String FOLDER_REPORTS = FOLDER_RESOURCES + SEPARATOR + "reports";

	public static final String FOLDER_CONFIG = USER_DIR + SEPARATOR + "config";
	public static final String CONEXAO = FOLDER_CONFIG + SEPARATOR + "config.01";
	public static final String RESOURCES = FOLDER_CONFIG + SEPARATOR + "resources.01";
	public static final String FILE_APPLICATION = FOLDER_CONFIG + SEPARATOR + "application.properties";

	public static final String UPGRADE = USER_DIR + SEPARATOR + "upgrade";
	public static final String CHANGELOG = UPGRADE + SEPARATOR + "db.changelog-master.xml";

	public static final String TEMPLATES = FOLDER_RESOURCES + SEPARATOR + "templates";
	public static final String TEMPLATE_MENSALIDADE = TEMPLATES + SEPARATOR + "mensalidade.html";
	public static final String CABECALHO_MENSALIDADE = TEMPLATES + SEPARATOR + "cabecalho.png";
}
