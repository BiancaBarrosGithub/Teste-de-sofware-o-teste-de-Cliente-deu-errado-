package com.teste.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VeiculoTest {
	
private Veiculo veiculo;
	
	@BeforeEach
	void setUp() {
		//Arrange
		veiculo = new Veiculo(1L,"Ford", "Ford Aspire", 2020, "preto");
	}

	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		//Act
		veiculo.setId(2L);
		//Assert
		assertEquals(2L,veiculo.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo marca")
	void testMarca() {
		//Act
		veiculo.setMarca("BMW");
		//Assert
		assertEquals("BMW", veiculo.getMarca());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo email")
	void testModelo() {
		//Act
		veiculo.setModelo("BMW. X2");
		//Assert
		assertEquals("BMW. X2", veiculo.getModelo());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo ano")
	void testAno() {
		//Act
		veiculo.setAno(2023);
		//Assert
		assertEquals(2023, veiculo.getAno());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo cor")
	void testCor() {
		//Act
		veiculo.setCor("cinza");
		//Assert
		assertEquals("cinza", veiculo.getCor());
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testContrutorAll() {
		//Act
		Veiculo novoVeiculo = new Veiculo(3L,"Honda","Honda Accord", 2019, "azul");
		//Assertion
		assertAll("novoVeiculo",
				()-> assertEquals(3L, novoVeiculo.getId()),
				()-> assertEquals("Honda", novoVeiculo.getMarca()),
				()-> assertEquals("Honda Accord", novoVeiculo.getModelo()),
				()-> assertEquals(2019, novoVeiculo.getAno()),
				()-> assertEquals("azul", novoVeiculo.getCor()));
	}

}


