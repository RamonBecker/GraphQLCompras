package com.udemy.compras.graphql.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.udemy.compras.graphql.dto.CompraResumoDTO;
import com.udemy.compras.graphql.entities.Cliente;
import com.udemy.compras.graphql.entities.Compra;
import com.udemy.compras.graphql.exceptions.DomainException;
import com.udemy.compras.graphql.repositories.CompraRepository;

@Service
public class CompraService {

	@Autowired
	private CompraRepository repository;

	public List<Compra> findAll(Pageable pageable) {
		return repository.findAll(pageable).getContent();
	}

	public Compra findBydId(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional
	@CacheEvict(value = "comprasByCliente", key = "#c.cliente.id")
	public Compra save(Compra c) {
		if (c.getQuantidade() > 100) {
			throw new DomainException("Não é possível fazer uma compra com mais de 100 itens");
		}
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

	@Cacheable(value = "comprasByCliente", key = "#c.id")
	public List<Compra> findAllByCliente(Cliente c) {
		return repository.findAllByCliente(c);
	}

	public List<CompraResumoDTO> findAllComprasRelatorio() {
		return repository.findAllComprasRelatorio();
	}

	/*
	 * public List<Compra> findAllByClienteAndQuantidade(Cliente c, int quantidade)
	 * { return repository.findAllByClienteAndQuantidade(c, quantidade); }
	 */
}
