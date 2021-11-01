package com.udemy.compras.graphql.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.compras.graphql.entities.Cliente;
import com.udemy.compras.graphql.entities.Compra;
import com.udemy.compras.graphql.repositories.CompraRepository;

@Service
public class CompraService {

	@Autowired
	private CompraRepository repository;

	public List<Compra> findAll() {
		return repository.findAll();
	}

	public Compra findBydId(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional
	public Compra save(Compra c) {
		return repository.save(c);
	}

	@Transactional
	public Boolean deleteById(Long id) {
		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Compra> findAllByCliente(Cliente c) {
		
		return repository.findAllByCliente(c);
	}
}
