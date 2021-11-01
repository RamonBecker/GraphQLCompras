package com.udemy.compras.graphql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.udemy.compras.graphql.entities.Cliente;
import com.udemy.compras.graphql.repositories.ClienteRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public Cliente findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Cacheable("clientes")
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Cliente save(Cliente c) {
        return repository.save(c);
    }

    @Transactional
    public Boolean deleteById(Long id) {
        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
