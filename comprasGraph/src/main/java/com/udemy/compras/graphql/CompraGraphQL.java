package com.udemy.compras.graphql;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.graphql.dto.CompraResumoDTO;
import com.udemy.compras.graphql.entities.Compra;
import com.udemy.compras.graphql.entities.inputs.CompraInput;
import com.udemy.compras.graphql.service.ClienteService;
import com.udemy.compras.graphql.service.CompraService;
import com.udemy.compras.graphql.service.ProdutoService;

@Component
public class CompraGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

	@Autowired
	private CompraService service;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ProdutoService produtoService;

	public Compra compra(Long id) {
		return service.findBydId(id);
	}

	public List<Compra> getCompras(int page, int size) {
		org.springframework.data.domain.Pageable pageable = PageRequest.of(page, size, Sort.by("quantidade").descending());
		return service.findAll(pageable);
	}

	public Compra saveCompra(CompraInput input) {
		ModelMapper m = new ModelMapper();
		Compra c = m.map(input, Compra.class);

		c.setData(new Date());

		c.setCliente(clienteService.findById(input.getClienteId()));
		c.setProduto(produtoService.findById(input.getProdutoId()));

		return service.save(c);
	}

	public Boolean deleteCompra(Long id) {
		return service.deleteById(id);
	}
	
	public List<CompraResumoDTO> getComprasRelatorio(){
		return service.findAllComprasRelatorio();
	}
}
