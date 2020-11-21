package br.com.blockchain.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.blockchain.api.domain.User;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long> {
	
	/**
	 * Busca por e-mail e senha
	 * @param email
	 * @param password
	 * @return
	 */
	Optional<User> findByEmail(String email);

}
