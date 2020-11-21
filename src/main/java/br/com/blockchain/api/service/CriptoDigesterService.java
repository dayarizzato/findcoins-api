package br.com.blockchain.api.service;

public interface CriptoDigesterService {

	/**
	 * Responsável por realizar o encode da senha do usuário
	 * @param password String
	 * @return retorna senha criptografada
	 */
	String encodePassword(String password);
	
	/**
	 * Responsável por verificar se a senha é válida
	 * @param encPass senha criptografada
	 * @param password senha
	 * @return Boolean
	 */
	boolean verifyPassword(String encPass, String password);
	
	/**
	 * Método que faz o parse de char para byte.
	 * @param rawPass
	 * @return byte[]
	 */
	byte[] toBytes(char[] rawPass);
}
