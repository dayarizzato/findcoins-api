package br.com.blockchain.api.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.blockchain.api.domain.Cliente;
import br.com.blockchain.api.domain.Endereco;
import br.com.blockchain.api.domain.User;
import br.com.blockchain.api.domain.model.ClienteFindResponse;
import br.com.blockchain.api.domain.model.ClienteRequest;
import br.com.blockchain.api.domain.model.ClienteUpdateRequest;
import br.com.blockchain.api.domain.model.EnderecoFindResponse;
import br.com.blockchain.api.exception.BusinessException;
import br.com.blockchain.api.repository.ClienteRepository;
import br.com.blockchain.api.repository.UserRepository;
import br.com.blockchain.api.service.ClienteService;
import br.com.blockchain.api.service.CriptoDigesterService;
import br.com.blockchain.api.util.LocalDateUtil;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CriptoDigesterService criptoDigesterService;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void save(final ClienteRequest request) throws BusinessException, Exception {
		
		final Cliente cliente = this.converterRequestEntidade(request);
		
		if(this.findByCpfCnpj(cliente.getCpfCnpj()).isPresent()) {
			 throw new BusinessException(MSG_CPF_CNPJ_EXISTENTE);
		}
		if(this.findByEmail(cliente.getEmail()).isPresent()) {
			 throw new BusinessException(MSG_EMAIL_EXISTENTE);
		}
		
		final Cliente clienteSalvo = clienteRepository.save(cliente);
		final User us = new User(clienteSalvo.getCodigoCliente(), request.getEmail(), encodePassword(request.getPassword()));
		this.userRepository.save(us);
	}
	
	@Override
	public Optional<Cliente> findByCpfCnpj(final String cpfCnpj) throws Exception{
		return Optional.ofNullable(clienteRepository.findByCpfCnpj(cpfCnpj));
	}
	
	@Override
	public Optional<Cliente> findByEmail(final String email) throws Exception {
		return Optional.ofNullable(clienteRepository.findByEmail(email));
	}
	
	private String encodePassword(final String password) {
		return criptoDigesterService.encodePassword(password);
	}
	
	/**
	 * Converte a requsição para entidade {@link Cliente}
	 * @param request ClienteRequest
	 * @return Cliente
	 */
	private Cliente converterRequestEntidade(final ClienteRequest request) {
		final Cliente cliente = new Cliente();
		cliente.setNome(request.getNome());
		cliente.setSobrenome(request.getSobrenome());
		cliente.setDtNascimento(LocalDateUtil.convertStringtToLocalDate(request.getDtNascimento()));
		cliente.setSexo(request.getSexo());
		cliente.setCpfCnpj(request.getRootCpfCnpj());
		cliente.setEmail(request.getEmail());
		cliente.setCelular(request.getCelular());
		cliente.setTelefone(request.getTelefone());
		cliente.setDataCadastro(LocalDateTime.now());
		cliente.setEndereco(new Endereco());
		cliente.getEndereco().setBairro(request.getEndereco().getBairro());
		cliente.getEndereco().setCep(request.getEndereco().getCep());
		cliente.getEndereco().setCidade(request.getEndereco().getCidade());
		cliente.getEndereco().setComplemento(request.getEndereco().getComplemento());
		cliente.getEndereco().setEstado(request.getEndereco().getEstado());
		cliente.getEndereco().setLogradouro(request.getEndereco().getLogradouro());
		cliente.getEndereco().setNumero(request.getEndereco().getNumero());
		cliente.getEndereco().setPontoReferencia(request.getEndereco().getPontoReferencia());
		return cliente;
	}

	@Override
	public ClienteFindResponse findByID(final Long id){
		final Optional<Cliente> find = this.clienteRepository.findById(id);
		if(find.isPresent()) {
			return convertEntityFromResponse(find.get());
		}else {
			return null;
		}
	}

	@Override
	public void deleteCliente(final Long id) {
		this.clienteRepository.deleteById(id);
		this.userRepository.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(final ClienteUpdateRequest request) throws Exception {
		this.clienteRepository.saveAndFlush(this.convertRequestUpdateFromCliente(request));
		this.userRepository.save(this.convertRequestFromUser(request));
	}
	
	public Cliente convertRequestUpdateFromCliente(final ClienteUpdateRequest request) {
		final Cliente cliente = new Cliente();
		cliente.setCodigoCliente(request.getCodigoCliente());
		cliente.setNome(request.getNome());
		cliente.setSobrenome(request.getSobrenome());
		cliente.setDtNascimento(LocalDateUtil.convertStringtToLocalDate(request.getDtNascimento()));
		cliente.setSexo(request.getSexo());
		cliente.setCpfCnpj(request.getRootCpfCnpj());
		cliente.setEmail(request.getEmail());
		cliente.setCelular(request.getCelular());
		cliente.setTelefone(request.getTelefone());
		cliente.setDataCadastro(LocalDateUtil.convertStringToLocalDateTime(request.getDataCadastro()));
		Endereco endereco = new Endereco();
		endereco.setCodigo_cliente(request.getEndereco().getCodigo_cliente());
		endereco.setBairro(request.getEndereco().getBairro());
		endereco.setCep(request.getEndereco().getCep());
		endereco.setCidade(request.getEndereco().getCidade());
		endereco.setComplemento(request.getEndereco().getComplemento());
		endereco.setEstado(request.getEndereco().getEstado());
		endereco.setLogradouro(request.getEndereco().getLogradouro());
		endereco.setNumero(request.getEndereco().getNumero());
		endereco.setPontoReferencia(request.getEndereco().getPontoReferencia());
		cliente.setEndereco(endereco);
		return cliente;
	}
	
	public User convertRequestFromUser(final ClienteUpdateRequest request) {
		final User user = new User();
		user.setEmail(request.getEmail());
		user.setId(request.getCodigoCliente());
		user.setPassword(this.criptoDigesterService.encodePassword(request.getPassword()));
		return user;
	}
	
	public ClienteFindResponse convertEntityFromResponse(final Cliente cliente) {
		final ClienteFindResponse response = new ClienteFindResponse();
		response.setCodigoCliente(cliente.getCodigoCliente());
		response.setCelular(cliente.getCelular());
		response.setCpfCnpj(cliente.getCpfCnpj());
		response.setDtNascimento(LocalDateUtil.convertLocalDateToString(cliente.getDtNascimento()));
		response.setEmail(cliente.getEmail());
		response.setNome(cliente.getNome());
		response.setSexo(cliente.getSexo());
		response.setDataCadastro(LocalDateUtil.convertLocalDateTimeToString(cliente.getDataCadastro()));
		response.setSobrenome(cliente.getSobrenome());
		response.setTelefone(cliente.getTelefone());
		response.setEndereco(new EnderecoFindResponse());
		response.getEndereco().setCodigo_cliente(cliente.getEndereco().getCodigo_cliente());
		response.getEndereco().setBairro(cliente.getEndereco().getBairro());
		response.getEndereco().setCep(cliente.getEndereco().getCep());
		response.getEndereco().setCidade(cliente.getEndereco().getCidade());
		response.getEndereco().setComplemento(cliente.getEndereco().getComplemento());
		response.getEndereco().setEstado(cliente.getEndereco().getEstado());
		response.getEndereco().setLogradouro(cliente.getEndereco().getLogradouro());
		response.getEndereco().setNumero(cliente.getEndereco().getNumero());
		response.getEndereco().setPontoReferencia(cliente.getEndereco().getPontoReferencia());
		return response;
	}
}
