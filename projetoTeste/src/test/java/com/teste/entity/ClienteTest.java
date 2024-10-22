package com.teste.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClienteTest {

private Cliente cliente;
	
	@BeforeEach
	void setUp() {
		//Arrange
		cliente = new Cliente(1L,"Julia Maria", "(00)0000-0000", "12345693848", "0987654321");
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		//Act
		cliente.setId(2L);
		//Assert
		assertEquals(2L,cliente.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void testNome() {
		//Act
		cliente.setNome("Joao Paulo");
		//Assert
		assertEquals("Joao Paulo", cliente.getNome());
	}
	
	
	@Test
	@DisplayName("Testando o getter e setter do campo telefone")
	void testTelefone() {
		//Act
		cliente.setTelefone("11-1111-1111");
		//Assert
		assertEquals("11-1111-1111", cliente.getTelefone());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo cpf")
	void testCpf() {
		//Act
		cliente.setCpf("09876543210");
		//Assert
		assertEquals("09876543210", cliente.getCpf());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo rg")
	void testRg() {
		//Act
		cliente.setRg("8907654976");
		//Assert
		assertEquals("8907654976", cliente.getRg());
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testContrutorAll() {
		//Act
		Cliente novoCliente = new Cliente(3L,"Matheus", "15-1111-1111", "05876543123", "0987697856");
		//Assertion
		assertAll("novoHospede",
				()-> assertEquals(3L, novoCliente.getId()),
				()-> assertEquals("Matheus", novoCliente.getNome()),
				()-> assertEquals("15-1111-1111", novoCliente.getTelefone()),
				()-> assertEquals("05876543123", novoCliente.getCpf()),
				()-> assertEquals("0987697856", novoCliente.getRg()));
	}

}
