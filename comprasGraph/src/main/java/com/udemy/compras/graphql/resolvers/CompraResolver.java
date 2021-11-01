package com.udemy.compras.graphql.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.udemy.compras.graphql.entities.Cliente;
import com.udemy.compras.graphql.entities.Compra;
import com.udemy.compras.graphql.entities.Produto;
import com.udemy.compras.graphql.service.ClienteService;
import com.udemy.compras.graphql.service.ProdutoService;

@Component
public class CompraResolver implements GraphQLResolver<Compra> {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ProdutoService produtoService;

	public Produto produto(Compra c) {
		return produtoService.findById(c.getProduto().getId());
	}

	public Cliente cliente(Compra c) {
		return clienteService.findById(c.getCliente().getId());
	}

	public String status(Compra c) {
		return "Teste:" + c.getStatus();
	}
}
