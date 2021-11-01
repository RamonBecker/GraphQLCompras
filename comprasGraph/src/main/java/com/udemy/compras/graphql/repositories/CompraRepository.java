package com.udemy.compras.graphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.compras.graphql.entities.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {

}
