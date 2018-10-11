package br.com.cast.crudwithspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.crudwithspring.business.PessoaBusiness;
import br.com.cast.crudwithspring.dto.PessoaDTO;

@RestController
@RequestMapping(path="/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaBusiness repository;
	
	@RequestMapping(method=RequestMethod.POST)
	public String inserir(@RequestBody PessoaDTO pessoaDTO) {
		repository.inserir(pessoaDTO);
		
		return "Inserido com sucesso..";
	}
	
	@RequestMapping(path="/{cpf}", method=RequestMethod.GET)
	public PessoaDTO buscarPorCpf(@PathVariable String cpf) {
		PessoaDTO pessoaDTO = repository.buscarPorCpf(cpf);
		return pessoaDTO;
	}
	
	@RequestMapping(path="/{cpf}", method=RequestMethod.DELETE)
	public String remover(@PathVariable String cpf) {
		PessoaDTO pessoaDTO = repository.buscarPorCpf(cpf);
		repository.remover(pessoaDTO);
		return "Excluindo a pessoa com o cpf: " + cpf;
	}
	
	@RequestMapping(path="/{cpf}", method=RequestMethod.PUT)
	public String alterar(@PathVariable("cpf") String cpf, @RequestBody PessoaDTO pessoaDTO) {
		repository.alterar(cpf,pessoaDTO);
		return "Alterando a pessoa com o cpf: " + pessoaDTO.getCpf(); 
	}
}
