package com.udemy.compras.graphql.dto;

import java.util.Objects;

public class CompraResumoDTO {

	private Long compraId;
	private String cliente;
	private String produto;
	private int quantidade;

	public CompraResumoDTO() {
	}

	public CompraResumoDTO(Long compraId, String cliente, String produto, int quantidade) {
		this.compraId = compraId;
		this.cliente = cliente;
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Long getCompraId() {
		return compraId;
	}

	public void setCompraId(Long compraId) {
		this.compraId = compraId;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(compraId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompraResumoDTO other = (CompraResumoDTO) obj;
		return Objects.equals(compraId, other.compraId);
	}

}
