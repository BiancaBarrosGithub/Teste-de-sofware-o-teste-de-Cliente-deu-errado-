package com.teste.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProdutoTest {

	private Produto produto;
	
	@BeforeEach
	void setUp() {
		//Arrange
		produto = new Produto(1L,"esmalte", 2.90);
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		//Act
		produto.setId(2L);
		//Assert
		assertEquals(2L,produto.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void testNome() {
		//Act
		produto.setNome("camiseta");
		//Assert
		assertEquals("camiseta", produto.getNome());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo preco")
	void testPreco() {
		//Act
		produto.setPreco(23.50);
		//Assert
		assertEquals(23.50, produto.getPreco());
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testContrutorAll() {
		//Act
		Produto novoProduto = new Produto(3L,"celular", 3.500 );
		//Assertion
		assertAll("novoProduto",
				()-> assertEquals(3L, novoProduto.getId()),
				()-> assertEquals("celular", novoProduto.getNome()),
				()-> assertEquals(3.500, novoProduto.getPreco()));
				
	}

}
