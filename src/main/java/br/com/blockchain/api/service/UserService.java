package br.com.blockchain.api.service;

import br.com.blockchain.api.domain.model.UserResponse;
import br.com.blockchain.api.exception.BadCredentialsException;

public interface UserService {
	
	String MSG_INVALID_USER = "Usuário ou senha inválido";
	
	String MSG_INVALID_EMAIL = "E-mail inválido";

	UserResponse autenticate(final String email, final String password) throws BadCredentialsException, Exception;
	
	void sendEmail(final String email) throws Exception;
}
