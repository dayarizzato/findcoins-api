package br.com.blockchain.api.controller.v1;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.blockchain.api.controller.ClienteControllerApi;
import br.com.blockchain.api.domain.model.ClienteFindResponse;
import br.com.blockchain.api.domain.model.ClienteRequest;
import br.com.blockchain.api.domain.model.ClienteUpdateRequest;
import br.com.blockchain.api.exception.BusinessException;
import br.com.blockchain.api.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Controle exposto para manipulação de dados de Clientes
 * @author Dayana
 */
@RestController
@Api(value = "ClienteController")
public class ClienteController implements ClienteControllerApi{
	
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ClienteService clienteService;

	@Override
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Cliente cadastrado com sucesso"),
			@ApiResponse(code = 400, message = "Já existe um cliente com esse email cadastrado"),
			@ApiResponse(code = 400, message = "Já existe um cliente com esse CPF/CPNJ cadastrado"),
			@ApiResponse(code = 500, message = "Erro Interno na API", response = Exception.class)
	})
	public ResponseEntity<?> save(@Valid final ClienteRequest request) throws Exception {
		try {
		    clienteService.save(request);
		}catch (final BusinessException e) {
			LOGGER.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}catch (Exception e) {
			LOGGER.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@Override
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cliente obtido com exito"),
			@ApiResponse(code = 500, message = "Erro Interno na API", response = Exception.class)
	})
	public ResponseEntity<?> findByID(final Long id) throws Exception {
		ClienteFindResponse cliente = null;
		try {
			cliente = this.clienteService.findByID(id);
		}catch (final Exception e) {
			LOGGER.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}

	@Override
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cliente excluido com sucesso"),
			@ApiResponse(code = 500, message = "Erro Interno na API", response = Exception.class)
	})
	public ResponseEntity<?> delete(final Long id) throws Exception {
		try {
			this.clienteService.deleteCliente(id);
		}catch (final Exception e) {
			LOGGER.error(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cliente atualizado com sucesso"),
			@ApiResponse(code = 500, message = "Erro Interno na API", response = Exception.class)
	})
	public ResponseEntity<?> update(@Valid final ClienteUpdateRequest request) {
		try {
			this.clienteService.update(request);
		}catch (final Exception e) {
			LOGGER.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}	
}
