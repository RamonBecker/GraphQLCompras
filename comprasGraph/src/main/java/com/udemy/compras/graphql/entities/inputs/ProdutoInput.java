package com.udemy.compras.graphql.entities.inputs;

import java.util.Objects;

public class ProdutoInput {
	private Long id;
	private String nome;
	private double valor;

	public ProdutoInput() {
	}

	public ProdutoInput(Long id, String nome, double valor) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoInput other = (ProdutoInput) obj;
		return Objects.equals(id, other.id);
	}
}
