package br.com.blockchain.api.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Entidade que representa a tabela de usuários
 * @author Dayana
 */

@Entity
@Table(name = "USUARIO")
public class User extends Object {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private Long id;
	
	@NotNull(message = "Nome é obrigatorio")
	@Column(name = "USUARIO")
	private String email;
	
	@NotNull(message = "Nome é obrigatorio")
	@Column(name = "PASSWORD")
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn(name = "codigo", referencedColumnName = "CODIGO_CLIENTE")
	private Cliente cliente;
	
	public User() {
		super();
	}
	
	public User(final Long codigo, final String email, final String password) {
		this.id = codigo;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
