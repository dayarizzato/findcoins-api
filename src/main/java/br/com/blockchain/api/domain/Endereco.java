package br.com.blockchain.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ENDERECO")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CODIGO_CLIENTE")
	private Long codigo_cliente;
	
	@NotNull(message = "Logradouro é obrigatorio")
	@Column(name = "LOGRADOURO")
	private String logradouro;
	
	@NotNull(message = "CEP é obrigatorio")
	@Column(name = "CEP")
	private String cep;
	
	@NotNull(message = "Bairro é obrigatorio")
	@Column(name = "BAIRRO")
	private String bairro;
	
	@NotNull(message = "Cidade é obrigatorio")
	@Column(name = "CIDADE")
	private String cidade;
	
	@NotNull(message = "Numero é obrigatorio")
	@Column(name = "NUMERO")
	private String numero;
	
	@NotNull(message = "Estado é obrigatorio")
	@Column(name = "ESTADO")
	private String estado;
	
	@NotNull(message = "Complemento é obrigatorio")
	@Column(name = "COMPLEMENTO")
	private String complemento;
	
	@NotNull(message = "Ponto referencia é obrigatorio")
	@Column(name = "PONTO_REFERENCIA")
	private String pontoReferencia;

	public Long getCodigo_cliente() {
		return codigo_cliente;
	}

	public void setCodigo_cliente(Long codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

}
