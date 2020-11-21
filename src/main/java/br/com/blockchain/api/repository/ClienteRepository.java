package br.com.blockchain.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.com.blockchain.api.domain.Cliente;

/**
 * Interface de camada de acesso a dados referente do {@link Cliente}
 * @author Dayana
 */
@Repository
@Transactional(readOnly = true)
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	/**
	 * A partir do CPF/CPNJ passado por parametro verifica na base se já possui cadastro
	 * @param  String rootCpfCnpj 
	 * @return Optional<Cliente>
	 */
	Cliente findByCpfCnpj(String cpfCnpj);
	
	/**
	 * A partir do email passado por parametro verifica na base se já possui cadastro
	 * @param  String email 
	 * @return Optional<Cliente>
	 */
	Cliente findByEmail(final String email);
	
}
