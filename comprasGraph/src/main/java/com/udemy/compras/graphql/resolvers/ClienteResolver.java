package com.udemy.compras.graphql.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.udemy.compras.graphql.entities.Cliente;
import com.udemy.compras.graphql.entities.Compra;
import com.udemy.compras.graphql.service.CompraService;

@Component
public class ClienteResolver implements GraphQLResolver<Cliente> {

	@Autowired
	private CompraService compraService;

	public List<Compra> compras(Cliente c) {
		return compraService.findAllByCliente(c);
	}

	public List<Compra> compras(Cliente c, int quantidade) {
		return compraService.findAllByClienteAndQuantidade(c, quantidade);
	}
}
