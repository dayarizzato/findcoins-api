package br.com.blockchain.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.blockchain.api.domain.model.ClienteRequest;
import br.com.blockchain.api.domain.model.ClienteUpdateRequest;
import io.swagger.annotations.ApiOperation;

@RequestMapping(path = "/v1/blockchain-api/cliente")
@CrossOrigin
public interface ClienteControllerApi {

	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	@PostMapping
	@ApiOperation(value = "Serviço para inclusão de Clientes", httpMethod = "POST")
	ResponseEntity<?> save(@RequestBody final ClienteRequest rquest) throws Exception;
	
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@GetMapping
	@ApiOperation(value = "Serviço para busca de Clientes a partir do código", httpMethod = "GET")
	ResponseEntity<?> findByID(@RequestParam final Long id) throws Exception;
	
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping
	@ApiOperation(value = "Serviço Exclusão de Clientes", httpMethod = "DELETE")
	ResponseEntity<?> delete(@RequestParam final Long id) throws Exception;
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping
	@ResponseBody
	@ApiOperation(value = "Serviço para atualização de Clientes", httpMethod = "PUT")
	ResponseEntity<?> update(@RequestBody final ClienteUpdateRequest request);
}
