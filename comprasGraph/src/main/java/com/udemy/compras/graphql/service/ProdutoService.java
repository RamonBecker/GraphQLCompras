package com.udemy.compras.graphql.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.compras.graphql.entities.Produto;
import com.udemy.compras.graphql.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public List<Produto> findAll() {
		return repository.findAll();
	}

	public Produto findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional
	public Produto save(Produto p) {
		return repository.save(p);
	}

	@Transactional
	public Boolean deleteById(Long id) {
		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
}
