package br.com.blockchain.api.util;

/**
 * Classe aleatoria para gerar senhas
 * @author Dayana
 */
public final class PasswordUtils {

	public static String generatedPassword(final int qtdMaxCaracters) {

		String[] caracteres = { "0", "1", "b", "2", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g",
				"h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

		StringBuilder senha = new StringBuilder();

		for (int i = 0; i < qtdMaxCaracters; i++) {
			int posicao = (int) (Math.random() * caracteres.length);
			senha.append(caracteres[posicao]);
		}
		return senha.toString();
	}
}
