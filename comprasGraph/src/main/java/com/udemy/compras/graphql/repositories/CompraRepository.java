package com.udemy.compras.graphql.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.compras.graphql.entities.Cliente;
import com.udemy.compras.graphql.entities.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {

	List<Compra> findAllByCliente(Cliente c);
	List<Compra> findAllByClienteAndQuantidade(Cliente c, int quantidade);
	
}
