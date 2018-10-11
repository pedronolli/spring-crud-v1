package br.com.cast.crudwithspring.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.crudwithspring.dto.EnderecoDTO;
import br.com.cast.crudwithspring.dto.PessoaDTO;
import br.com.cast.crudwithspring.model.Endereco;
import br.com.cast.crudwithspring.model.Pessoa;
import br.com.cast.crudwithspring.repository.PessoaRepository;

@Service
public class PessoaBusiness {
	
	@Autowired
	private PessoaRepository perepository;
	
	
	@Transactional
	public void inserir(PessoaDTO pessoaDTO) {
		Endereco endereco = new Endereco();
		
		endereco.setCep(pessoaDTO.getEnderecoDTO().getCep());
		endereco.setBairro(pessoaDTO.getEnderecoDTO().getBairro());
		endereco.setCidade(pessoaDTO.getEnderecoDTO().getCidade());
		endereco.setLogradouro(pessoaDTO.getEnderecoDTO().getLogradouro());
		endereco.setNumero(pessoaDTO.getEnderecoDTO().getNumero());
		endereco.setUf(pessoaDTO.getEnderecoDTO().getUf());
		endereco.setComplemento(pessoaDTO.getEnderecoDTO().getComplemento());
		
		Pessoa pessoa = new Pessoa();
		
		
		
		pessoa.setCpf(pessoaDTO.getCpf());
		pessoa.setEmail(pessoaDTO.getEmail());
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setEndereco(endereco);
		
		perepository.inserir(pessoa);
	}
	
	public PessoaDTO buscarPorCpf(String cpf) {
		Pessoa pessoa = perepository.buscarPorCpf(cpf);
		
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		
		enderecoDTO.setCep(pessoa.getEndereco().getCep());
		enderecoDTO.setBairro(pessoa.getEndereco().getBairro());
		enderecoDTO.setCidade(pessoa.getEndereco().getCidade());
		enderecoDTO.setComplemento(pessoa.getEndereco().getComplemento());
		enderecoDTO.setLogradouro(pessoa.getEndereco().getLogradouro());
		enderecoDTO.setNumero(pessoa.getEndereco().getNumero());
		enderecoDTO.setUf(pessoa.getEndereco().getUf());
		
		
		PessoaDTO pessoaDTO = new PessoaDTO();
		
		pessoaDTO.setCpf(pessoa.getCpf());
		pessoaDTO.setEmail(pessoa.getEmail());
		pessoaDTO.setNome(pessoa.getNome());
		pessoaDTO.setEnderecoDTO(enderecoDTO);
		
		return pessoaDTO;
		
	}
	
	@Transactional
	public void remover(PessoaDTO pessoaDTO) {
		Pessoa pessoa = perepository.buscarPorCpf(pessoaDTO.getCpf());
		perepository.remover(pessoa);
	}
	
	@Transactional
	public void alterar(String cpf, PessoaDTO pessoaDTO) {
		Pessoa pessoa = perepository.buscarPorCpf(cpf);
		
		Endereco endereco = new Endereco();
		
		endereco.setCep(pessoaDTO.getEnderecoDTO().getCep());
		endereco.setBairro(pessoaDTO.getEnderecoDTO().getBairro());
		endereco.setCidade(pessoaDTO.getEnderecoDTO().getCidade());
		endereco.setLogradouro(pessoaDTO.getEnderecoDTO().getLogradouro());
		endereco.setNumero(pessoaDTO.getEnderecoDTO().getNumero());
		endereco.setUf(pessoaDTO.getEnderecoDTO().getUf());
		endereco.setComplemento(pessoaDTO.getEnderecoDTO().getComplemento());
		
		
		
		
		pessoa.setCpf(pessoaDTO.getCpf());
		pessoa.setEmail(pessoaDTO.getEmail());
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setEndereco(endereco);
		
		perepository.alterar(pessoa);
		
	}
	
}
