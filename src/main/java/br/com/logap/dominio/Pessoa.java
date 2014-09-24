package br.com.logap.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Classe que representa uma pessoa.
 * 
 * @author Anderson Santos
 * 
 */
@Entity
@Table(name = "pessoa", schema = "teste")
public class Pessoa extends PadraoDominio {
	/**
	 * Identificador da pessoa.
	 */
	@Id
	@SequenceGenerator(name = "sequencia", sequenceName = "teste.seq_pessoa")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequencia")
	@Column(name = "id")
	private int id;
	
	/**
	 * Nome da pessoa.
	 */
	@Column(name = "nome")
	private String nome;
	
	/**
	 * Data de nascimento da pessoa.
	 */
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	
	/**
	 * CPF da pessoa.
	 */
	@Column(name = "cpf")
	private String cpf;
	
	/**
	 * Endereço da pessoa.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
