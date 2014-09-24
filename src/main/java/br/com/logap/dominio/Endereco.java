package br.com.logap.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Classe que representa o endereço.
 * 
 * @author Anderson Santos
 *
 */
@Entity
@Table(name = "endereco", schema = "teste")
public class Endereco extends PadraoDominio {
	/**
	 * Identificador do endereço.
	 */
	@Id
	@SequenceGenerator(name = "sequencia", sequenceName = "teste.seq_endereco")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequencia")
	@Column(name = "id")
	private int id;
	
	/**
	 * CEP do endereço.
	 */
	@Column(name = "cep")
	private String cep;
	
	/**
	 * Bairro do endereço.
	 */
	@Column(name = "bairro")
	private String bairro;
	
	/**
	 * Rua do endereço.
	 */
	@Column(name = "rua")
	private String rua;
	
	/**
	 * Número do endereço.
	 */
	@Column(name = "numero")
	private int numero;
	
	/**
	 * Complemento do endereço.
	 */
	@Column(name = "complemento")
	private String complemento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
