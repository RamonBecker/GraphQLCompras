package com.udemy.compras.graphql.resolvers;

import java.text.DecimalFormat;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.udemy.compras.graphql.entities.Produto;

@Component
public class ProdutoResolver implements GraphQLResolver<Produto> {

	public String valorReais(Produto p) {
		String valorFormatado = new DecimalFormat("#,##0.00").format(p.getValor());
		return valorFormatado;
	}
}
