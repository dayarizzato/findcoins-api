package br.com.blockchain.api.service;

import java.util.Optional;

import br.com.blockchain.api.domain.Cliente;
import br.com.blockchain.api.domain.model.ClienteFindResponse;
import br.com.blockchain.api.domain.model.ClienteRequest;
import br.com.blockchain.api.domain.model.ClienteUpdateRequest;
import br.com.blockchain.api.exception.BusinessException;

public interface ClienteService {
	
	String MSG_EMAIL_EXISTENTE = "Já existe um cliente com esse email cadastrado";
			
	String MSG_CPF_CNPJ_EXISTENTE = "Já existe um cliente com esse CPF/CPNJ cadastrado";
	
	/**
	 * Faz a validação se já existe algum cliente com o mesmo CPF/CPNJ
	 * @param String rootCpfCnpj
	 * @return Optional<Cliente>
	 * @throws BusinessException
	 */
	Optional<Cliente> findByCpfCnpj(final String rootCpfCnpj) throws Exception;
	
	/**
	 * Faz a validação se já existe algum cliente com o mesmo CPF/CPNJ
	 * @param String rootCpfCnpj
	 * @return Optional<Cliente>
	 * @throws BusinessException
	 */
	Optional<Cliente> findByEmail(final String email) throws Exception;
	
	/**
	 * Faz a inclusão do cliente
	 * @param Cliente cliente
	 * @return Cliente
	 * @throws BusinessException, {@link Exception}
	 */
	void save(final ClienteRequest cliente) throws BusinessException, Exception;
	
	/**
	 * Busca o Cliente a partir do código
	 * @param id Long
	 * @return {@link Cliente}
	 */
	ClienteFindResponse findByID(final Long id);
	
	/**
	 * Detela o Cliente passando o ID
	 * @param id
	 */
	void deleteCliente(final Long id);
	
	void update(final ClienteUpdateRequest request) throws Exception;

}
