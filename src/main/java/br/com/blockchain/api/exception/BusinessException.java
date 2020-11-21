package br.com.blockchain.api.exception;

/**
 * Classe responsável por tratar exceções de negocio da API
 * @author Dayana
 */
public class BusinessException extends Exception {

	/**
	 * SerialversionUID
	 */
	private static final long serialVersionUID = -6903396262219665994L;
	
	public BusinessException(final String msg) {
		super(msg);
	}
	
	public BusinessException(final String message, final Exception exception) {
		super(message, exception);
	}
}
