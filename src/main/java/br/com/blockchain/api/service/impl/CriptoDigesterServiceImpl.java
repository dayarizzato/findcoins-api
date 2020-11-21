package br.com.blockchain.api.service.impl;

import java.nio.CharBuffer;
import java.nio.charset.Charset;

import org.jasypt.contrib.org.apache.commons.codec_1_3.binary.Base64;
import org.jasypt.digest.StandardByteDigester;
import org.springframework.stereotype.Service;

import br.com.blockchain.api.enumeration.AlgorithmEnum;
import br.com.blockchain.api.service.CriptoDigesterService;

/**
 * Classe responsável por criptografar e decriptografar senhas.
 * @author Dayana
 */
@Service
public class CriptoDigesterServiceImpl implements CriptoDigesterService {

	/**
	 * Método que faz a criptografia da senha.
	 * @param password
	 * @return String
	 */
	@Override
	public final String encodePassword(String password) {
		StandardByteDigester digester = initDigester();
		char[] rawPass = password.toCharArray();
        return new String(Base64.encodeBase64(digester.digest(toBytes(rawPass))));
	}

	/**
	 * Método que verifica se a senha informada é a mesma da criptografia.
	 * @param encPass
	 * @param password
	 * @return boolean
	 */
	@Override
	public final boolean verifyPassword(String encPass, String password) {
		StandardByteDigester digester = initDigester();
		char[] rawPass = password.toCharArray();
        return digester.matches(toBytes(rawPass), Base64.decodeBase64(encPass.getBytes()));
	}
	
	/**
	 * Método que faz o parse de char para byte.
	 * @param rawPass
	 * @return byte[]
	 */
	@Override
	public byte[] toBytes(char[] rawPass) {
		return Charset.forName("UTF-8").encode(CharBuffer.wrap(rawPass)).array();
	}
	
	/**
     * Método que cria o objeto StandardByteDigester
     * @return StandardByteDigester
     */
	private StandardByteDigester initDigester() {
		StandardByteDigester digester = new StandardByteDigester();
		digester.setAlgorithm(AlgorithmEnum.SHA256.algorithm());
        digester.setIterations(100000);
        digester.setSaltSizeBytes(16);
        digester.initialize();
		return digester;
	}

}
