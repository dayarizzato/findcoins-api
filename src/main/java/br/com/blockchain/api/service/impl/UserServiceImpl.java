package br.com.blockchain.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blockchain.api.domain.User;
import br.com.blockchain.api.domain.model.ClienteResponse;
import br.com.blockchain.api.domain.model.UserResponse;
import br.com.blockchain.api.exception.BadCredentialsException;
import br.com.blockchain.api.repository.UserRepository;
import br.com.blockchain.api.service.CriptoDigesterService;
import br.com.blockchain.api.service.SendEmailService;
import br.com.blockchain.api.service.UserService;
import br.com.blockchain.api.util.LocalDateUtil;
import br.com.blockchain.api.util.PasswordUtils;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CriptoDigesterService criptoDigesterService;
	
	@Autowired
	private SendEmailService sendEmailService;
	
	private static final int TEN = 10;

	@Override
	public UserResponse autenticate(final String email, final String password) throws BadCredentialsException, Exception  {
		final Optional<User> usuarioAutenticado = this.userRepository.findByEmail(email);
		if(usuarioAutenticado.isPresent()) {
			if(this.decodePassword(usuarioAutenticado.get().getPassword(), password)) {
				return convertUserFromResponse(usuarioAutenticado.get());
			}else {
				throw new BadCredentialsException(MSG_INVALID_USER);
			}
		}else {
			throw new BadCredentialsException(MSG_INVALID_USER);
		}
	}

	
	private Boolean decodePassword(final String passwordCript, final String password) {
		return this.criptoDigesterService.verifyPassword(passwordCript, password);
	}
	
	private UserResponse convertUserFromResponse(final User user) {
		final UserResponse response = new UserResponse();
		response.setCodigo(user.getId());
		response.setEmail(user.getEmail());
		response.setClienteResponse(new ClienteResponse());
		response.getClienteResponse().setCodigoCliente(user.getCliente().getCodigoCliente());
		response.getClienteResponse().setEmail(user.getCliente().getEmail());
		response.getClienteResponse().setDataCadastro(LocalDateUtil.convertLocalDateTimeToString(user.getCliente().getDataCadastro()));
		response.getClienteResponse().setNome(user.getCliente().getNome());
		response.getClienteResponse().setSobrenome(user.getCliente().getSobrenome());
		return response;
	}


	@Override
	public void sendEmail(final String email) throws Exception {
		final Optional<User> user = this.userRepository.findByEmail(email);
		if(user.isPresent()) {
			String newPassword = this.genetaredPassword();
			System.out.println("nova senha gerada: " + newPassword);
			user.get().setPassword(this.criptoDigesterService.encodePassword(newPassword));
			this.userRepository.save(user.get());
			this.sendEmailService.send(email, newPassword);
		}else {
			throw new BadCredentialsException(MSG_INVALID_EMAIL);
		}
	}
	
	private String genetaredPassword() {
		return PasswordUtils.generatedPassword(TEN);
	}
}
