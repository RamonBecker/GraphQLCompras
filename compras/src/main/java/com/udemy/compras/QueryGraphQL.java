package com.udemy.compras;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.entities.Cliente;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

	public String hello() {
		return "Hello graphQL";
	}

	public int soma(int a, int b) {
		return a + b;
	}

	public Cliente cliente() {
		return new Cliente("Maria", "Maria@gmail.com");
	}
}
