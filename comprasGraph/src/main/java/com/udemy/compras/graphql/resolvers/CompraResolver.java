package com.udemy.compras.graphql.resolvers;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.udemy.compras.graphql.entities.Compra;

@Component
public class CompraResolver implements GraphQLResolver<Compra> {

	public String status(Compra c) {
		return "Teste:" + c.getStatus();
	}
}
