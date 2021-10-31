package com.udemy.compras.graphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.compras.graphql.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
