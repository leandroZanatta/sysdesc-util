package br.com.sysdesc.util.classes;

import java.util.InputMismatchException;

public class CPFUtil {

	private CPFUtil() {
	}

	public static boolean isCPFValido(String cpfStr) {

		String cpf = cpfStr.replaceAll("\\D+", "");

		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999") || (cpf.length() != 11))
			return (false);

		char dig10;
		char dig11;

		int soma;
		int contadorDigito;
		int razao;
		int num;
		int peso;

		try {
			soma = 0;
			peso = 10;

			for (contadorDigito = 0; contadorDigito < 9; contadorDigito++) {
				num = cpf.charAt(contadorDigito) - 48;
				soma = soma + (num * peso);
				peso = peso - 1;
			}

			razao = 11 - (soma % 11);
			if ((razao == 10) || (razao == 11))
				dig10 = '0';
			else
				dig10 = (char) (razao + 48);
			soma = 0;
			peso = 11;

			for (contadorDigito = 0; contadorDigito < 10; contadorDigito++) {
				num = cpf.charAt(contadorDigito) - 48;
				soma = soma + (num * peso);
				peso = peso - 1;
			}

			razao = 11 - (soma % 11);

			if ((razao == 10) || (razao == 11))
				dig11 = '0';
			else
				dig11 = (char) (razao + 48);

			if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
				return (true);
			else
				return (false);

		} catch (InputMismatchException erro) {
			return (false);
		}
	}

}
