package com.udemy.compras.graphql.repositories;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import com.udemy.compras.graphql.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	@Override
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value = "true") })
	List<Produto> findAll();
}
