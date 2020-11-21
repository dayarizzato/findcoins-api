package br.com.blockchain.api.exception;

import java.io.Serializable;

/**
 * Exceção para tratar erros de usuário e senha inválidos.
 * @author Dayana
 *
 */
public class BadCredentialsException extends Exception implements Serializable {

	/**
	 * SerialversionUID
	 */
	private static final long serialVersionUID = -5371296133632941495L;

	public BadCredentialsException(final String message) {
		super(message);
	}
}
