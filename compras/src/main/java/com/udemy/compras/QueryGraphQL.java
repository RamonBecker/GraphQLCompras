package com.udemy.compras;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

	public List<Cliente> clientes() {
		List<Cliente> list = new ArrayList<Cliente>();

		for (int i = 0; i < 10; i++) {
			list.add(new Cliente("Cliente " + i, "cliente"+i+"@gmail.com"));
		}

		return list;
	}
}
