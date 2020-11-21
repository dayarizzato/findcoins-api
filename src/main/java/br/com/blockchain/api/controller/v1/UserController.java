package br.com.blockchain.api.controller.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.blockchain.api.controller.UserControllerApi;
import br.com.blockchain.api.domain.model.RecoverEmailRequest;
import br.com.blockchain.api.domain.model.UserRequest;
import br.com.blockchain.api.domain.model.UserResponse;
import br.com.blockchain.api.exception.BadCredentialsException;
import br.com.blockchain.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController()
@Api(value = "UserController")
public class UserController implements UserControllerApi{
	
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService userService;

	@Override
	@ApiResponses(value = {
			@ApiResponse(code = 202, message = "Autorizado"),
			@ApiResponse(code = 401, message = "Usuário ou senha Inválidos"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public ResponseEntity<?> autenticate(final UserRequest request) throws Exception {
		UserResponse user = null;
		try {
			user = this.userService.autenticate(request.getEmail(), request.getPassword());
		}catch (final BadCredentialsException e) {
			LOGGER.error(e.getMessage() + request.getEmail());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}catch (final Exception e) {
			LOGGER.error(e.getMessage() + request.getEmail());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
	}

	@Override
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Enviado com sucesso"),
			@ApiResponse(code = 400, message = "E-mail inválido"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public ResponseEntity<?> recoverPassword(final RecoverEmailRequest request) throws Exception {
		try {
			this.userService.sendEmail(request.getEmail());
		}catch (final BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}catch (final Exception e) {
			LOGGER.error(e.getMessage() + request.getEmail());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
