package br.com.blockchain.api.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserResponse {

	private Long codigo;
	
	private String email;
	
	private ClienteResponse clienteResponse;
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	
	public ClienteResponse getClienteResponse() {
		return clienteResponse;
	}
	
	public void setClienteResponse(ClienteResponse clienteResponse) {
		this.clienteResponse = clienteResponse;
	}
}
