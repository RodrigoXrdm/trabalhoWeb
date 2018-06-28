package com.ufc.br.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.br.model.Produto;
import com.ufc.br.service.ProdutoService;

@Controller
public class produtoController {
	
	@Autowired
	private ProdutoService serv;
	
	
	@GetMapping("/")
	public ModelAndView mostrarProdutos() {
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("produtos", serv.findAll());
		return mv;
	}
	
	@GetMapping("cadastro")
	public ModelAndView add(Produto prod) {
		ModelAndView mv = new ModelAndView("cadastro");
		mv.addObject("produto", prod);
		return mv;
	}
	
	@GetMapping
	public ModelAndView apagarProduto(@PathVariable("id") Long id) {
		serv.delete(id);
		return mostrarProdutos();
	}
	@PostMapping
	public ModelAndView criarprodruto(@Valid Produto prod, BindingResult tratar) {
		if(tratar.hasErrors()) {
			return add(prod);
			
		}
		serv.save(prod);
		return mostrarProdutos();
	}
}
