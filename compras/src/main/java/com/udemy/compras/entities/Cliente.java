package com.udemy.compras.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	private String nome;
	private String email;
	
	public Cliente(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	
}
