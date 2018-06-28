package com.ufc.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.br.model.Produto;
import com.ufc.br.repository.ProdrutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdrutoRepository repositorioP;
	
	
	public Produto save(Produto prod) {
		return repositorioP.save(prod); 
	}
	
	public void delete(Long id) {
		repositorioP.deleteById(id);
	}
	
	public List<Produto> findAll() {
		return (List <Produto>) repositorioP.findAll();
	}
}
