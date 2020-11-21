package br.com.blockchain.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.blockchain.api.domain.model.RecoverEmailRequest;
import br.com.blockchain.api.domain.model.UserRequest;
import io.swagger.annotations.ApiOperation;

@RequestMapping(path = "/v1/blockchain-api/login")
public interface UserControllerApi {

	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@PostMapping
	@ApiOperation(value = "Serviço validar autenticação do usuário", httpMethod = "POST")
	ResponseEntity<?> autenticate(@RequestBody final UserRequest request) throws Exception;
	
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@PostMapping(path = "/recover-password")
	@ApiOperation(value = "Serviço recuperar senha do cliente", httpMethod = "POST")
	ResponseEntity<?> recoverPassword(@RequestBody final RecoverEmailRequest request) throws Exception;

}
