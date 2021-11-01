package com.udemy.compras.graphql.repositories;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import com.udemy.compras.graphql.dto.CompraResumoDTO;
import com.udemy.compras.graphql.entities.Cliente;
import com.udemy.compras.graphql.entities.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {

	@Query("SELECT c FROM Compra c WHERE c.cliente = :cliente")
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value = "true") })
	List<Compra> findAllByCliente(@Param("cliente") Cliente cliente);
	/*
	 * List<Compra> findAllByClienteAndQuantidade(Cliente c, int quantidade);
	 */

	@Query("SELECT new com.udemy.compras.graphql.dto.CompraResumoDTO(c.id, cli.nome, p.nome, c.quantidade) FROM Compra c INNER JOIN c.cliente cli INNER JOIN c.produto p")
	List<CompraResumoDTO> findAllComprasRelatorio();
}
