package br.com.blockchain.api.domain.model;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;

public class ClienteUpdateRequest implements Serializable {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 2178490739723962201L;
	
	@ApiModelProperty(required = true, name = "Código do Cliente")
	private Long codigoCliente;
	
	@ApiModelProperty(required = true, name = "Nome do Cliente")
	private String nome;
	
	@ApiModelProperty(required = true, name = "Sobrenome do Cliente")
	private String sobrenome;
	
	@ApiModelProperty(required = true, name = "Data nascimento do Cliente")
	private String dtNascimento;
	
	@ApiModelProperty(required = true, name = "Sexo do Cliente")
	private char sexo;
	
	@ApiModelProperty(required = true, name = "CPF/CNPJ do Cliente")
	private String rootCpfCnpj;
	
	@ApiModelProperty(required = true, name = "E-mail do Cliente")
	private String email;
	
	@ApiModelProperty(required = true, name = "Telefone do Cliente")
	private String telefone;
	
	@ApiModelProperty(required = true, name = "Celular do Cliente")
	private String celular;
	
	@ApiModelProperty(required = true, name = "senha")
	private String password;
	
	private String dataCadastro;
	
	@ApiModelProperty(required = true, name = "Dados Endereço Cliente")
	private EnderecoRequest endereco;
	
	public Long getCodigoCliente() {
		return codigoCliente;
	}
	
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
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

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getRootCpfCnpj() {
		return rootCpfCnpj;
	}

	public void setRootCpfCnpj(String rootCpfCnpj) {
		this.rootCpfCnpj = rootCpfCnpj;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EnderecoRequest getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoRequest endereco) {
		this.endereco = endereco;
	}

}
