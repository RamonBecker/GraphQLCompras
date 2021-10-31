package com.udemy.compras.graphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.compras.graphql.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
