package br.com.blockchain.api.domain.model;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;

public class UserRequest implements Serializable {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 7732075145817230681L;

	@ApiModelProperty(name = "Email")
	private String email;
	
	@ApiModelProperty(name = "Senha")
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
