package br.com.sysdesc.util.enumeradores;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public enum ConfiguracaoEmailEnum {

	CONFIGURACAO_GMAIL(1L, "Gmail", getPropertiesGmail()),

	CONFIGURACAO_HOTMAIL(2L, "Hotmail", getPropertiesHotmail());

	private final Long codigo;

	private final String descricao;

	private final Properties configuracao;

	private static Map<Long, ConfiguracaoEmailEnum> mapa = new HashMap<>();

	static {
		for (ConfiguracaoEmailEnum tipoTamanho : ConfiguracaoEmailEnum.values()) {
			mapa.put(tipoTamanho.getCodigo(), tipoTamanho);
		}

	}

	private ConfiguracaoEmailEnum(Long codigo, String descricao, Properties configuracao) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.configuracao = configuracao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public Properties getConfiguracao() {
		return configuracao;
	}

	public static ConfiguracaoEmailEnum forCodigo(Long codigo) {
		return mapa.get(codigo);
	}

	@Override
	public String toString() {

		return this.descricao;
	}

	private static Properties getPropertiesGmail() {

		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		return props;
	}

	private static Properties getPropertiesHotmail() {

		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.live.com");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");

		return props;
	}
}