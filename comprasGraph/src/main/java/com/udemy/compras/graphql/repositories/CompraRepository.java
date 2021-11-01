package com.udemy.compras.graphql.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.udemy.compras.graphql.entities.Cliente;
import com.udemy.compras.graphql.entities.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {

	@Query("SELECT c FROM Compra c WHERE c.cliente = :cliente")
	List<Compra> findAllByCliente(@Param("cliente") Cliente cliente);
	/*
	 * List<Compra> findAllByClienteAndQuantidade(Cliente c, int quantidade);
	 */	
}
