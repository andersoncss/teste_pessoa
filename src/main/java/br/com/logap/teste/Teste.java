package br.com.logap.teste;

import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.logap.dominio.Endereco;
import br.com.logap.dominio.Pessoa;
import br.com.logap.negocio.ProcessadorEndereco;
import br.com.logap.negocio.ProcessadorPessoa;

@ApplicationScoped  
public class Teste {
	
	
	@Inject
	private ProcessadorEndereco processadorEndereco;
	
	@Inject
	private ProcessadorPessoa processadorPessoa;
	
	
	
	/**
	 * Método que executa os testes.
	 */
	public void executarTestes() {
		Endereco endereco = criarEndereco();
		
		Pessoa pessoa = criarPessoa(endereco);
		
		inserirEnderecoPessoa(endereco, pessoa);
		
		endereco.setComplemento("UERN");
		pessoa.setNome("Paulo");
		
		atualizarEnderecoPessoa(endereco, pessoa);
		
		Endereco enderecoConsultado = buscarEnderecoPorId(endereco.getId());
		Pessoa pessoaConsultada = buscarPessoaPorId(pessoa.getId());
		
		removerEnderecoPessoa(endereco, pessoa);
		
		System.out.println("Rua: " + enderecoConsultado.getRua());
		System.out.println("Nome: " + pessoaConsultada.getNome());
	}
	
	/**
	 * Metodo usado para criar um endereço.
	 * 
	 * @return
	 */
	private Endereco criarEndereco() {
		Endereco endereco = new Endereco();
		endereco.setBairro("Lagoa Nova");
		endereco.setCep("59078-970");
		endereco.setComplemento("UFRN");
		endereco.setNumero(56);
		endereco.setRua("Capitão Mor Gouveia");
		
		return endereco;
	}
	
	/**
	 * Método usado para criar uma pessoa com determinado endereço.
	 * 
	 * @param endereco
	 * @return
	 */
	private Pessoa criarPessoa(Endereco endereco) {
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("056.963.789-21");
		pessoa.setDataNascimento(new Date());
		pessoa.setNome("João");
		pessoa.setEndereco(endereco);
		
		return pessoa;
	}
	
	/**
	 * Método utilizado para atualizar um endereço e uma pessoa.
	 * 
	 * @param endereco
	 * @param pessoa
	 */
	private void atualizarEnderecoPessoa(Endereco endereco, Pessoa pessoa) {
		processadorEndereco.atualizar(endereco);
		processadorPessoa.atualizar(pessoa);
	}
	
	/**
	 * Método utilizado para inserir um endereço e uma pessoa.
	 * 
	 * @param endereco
	 * @param pessoa
	 */
	private void inserirEnderecoPessoa(Endereco endereco, Pessoa pessoa) {
		
		processadorEndereco.inserir(endereco);
		processadorPessoa.inserir(pessoa);
	}
	
	/**
	 * Método utilizado para remover um endereço e uma pessoa.
	 * 
	 * @param endereco
	 * @param pessoa
	 */
	private void removerEnderecoPessoa(Endereco endereco, Pessoa pessoa) {
		processadorPessoa.remover(pessoa);
		processadorEndereco.remover(endereco);
	}
	
	/**
	 * Método utilizado para buscar um endereço pelo id.
	 * 
	 * @param idEndereco
	 * @return
	 */
	private Endereco buscarEnderecoPorId(int idEndereco) {
		return processadorEndereco.buscarPorId(idEndereco);
	}
	
	/**
	 * Método utilizado para buscar uma pessoa pelo id.
	 * 
	 * @param idPessoa
	 * @return
	 */
	private Pessoa buscarPessoaPorId(int idPessoa) {
		return processadorPessoa.buscarPorId(idPessoa);
	}
}
