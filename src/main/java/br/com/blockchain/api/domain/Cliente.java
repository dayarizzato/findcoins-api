package br.com.blockchain.api.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * Entidade que representa a tabela CLIENTE
 * @author Dayana
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CODIGO_CLIENTE")
	private Long codigoCliente;
	
	@NotNull(message = "Nome é obrigatorio")
	@Column(name = "NOME")
	private String nome;
	
	@NotNull(message = "Sobrenome é obrigatorio")
	@Column(name = "SOBRENOME")
	private String sobrenome;
	
	@NotNull(message = "Data nascimento é obrigatorio")
	@Column(name = "DT_NASCIMENTO")
	private LocalDate dtNascimento;
	
	@NotNull(message = "Sexo é obrigatorio")
	@Column(name = "SEXO")
	private char sexo;
	
	@NotNull(message = "CPF/CNPJ é obrigatorio")
	@Column(name = "CPFCNPJ", nullable = false)
	private String cpfCnpj;
	
	@NotNull(message = "E-mail é obrigatorio")
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "TELEFONE")
	private String telefone;
	
	@NotNull(message = "Celular é obrigatorio")
	@Column(name = "CELULAR")
	private String celular;
	
	@NotNull(message = "Data de cadastro é obrigatorio")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime dataCadastro;
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER )
	@JoinColumn(name = "CODIGO_CLIENTE", referencedColumnName = "CODIGO_CLIENTE")
	private Endereco endereco;

	public Long getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
