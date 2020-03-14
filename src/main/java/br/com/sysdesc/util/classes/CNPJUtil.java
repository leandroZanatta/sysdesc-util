package br.com.sysdesc.util.classes;

import java.util.InputMismatchException;

public class CNPJUtil {

	private CNPJUtil() {
	}

	public static Boolean isCNPJValido(String cnpjStr) {

		String cnpj = cnpjStr.replaceAll("\\D+", "");

		if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222")
				|| cnpj.equals("33333333333333") || cnpj.equals("44444444444444") || cnpj.equals("55555555555555")
				|| cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888")
				|| cnpj.equals("99999999999999") || (cnpj.length() != 14)) {
			return false;
		}

		return verificarDigitos(cnpj);
	}

	private static Boolean verificarDigitos(String cnpj) {

		char dig13;
		char dig14;

		int soma;
		int contadorDigito;
		int razao;
		int num;
		int peso;

		try {
			soma = 0;
			peso = 2;

			for (contadorDigito = 11; contadorDigito >= 0; contadorDigito--) {
				num = cnpj.charAt(contadorDigito) - 48;
				soma = soma + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			razao = soma % 11;
			if ((razao == 0) || (razao == 1))
				dig13 = '0';
			else
				dig13 = (char) ((11 - razao) + 48);

			soma = 0;
			peso = 2;

			for (contadorDigito = 12; contadorDigito >= 0; contadorDigito--) {
				num = cnpj.charAt(contadorDigito) - 48;
				soma = soma + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			razao = soma % 11;
			if ((razao == 0) || (razao == 1))
				dig14 = '0';
			else
				dig14 = (char) ((11 - razao) + 48);

			if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13)))
				return true;
			else
				return false;

		} catch (InputMismatchException erro) {
			return false;
		}
	}

}
