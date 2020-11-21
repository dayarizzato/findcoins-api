package br.com.blockchain.api.domain.model;

import java.io.Serializable;

public class RecoverEmailRequest implements Serializable {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 3785564945087616428L;
	
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
