package com.teste.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.teste.entity.Cliente;

@DataJpaTest
class ClienteRepositoryTest {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@DisplayName("Testando o save")
	@Test
	void testSalvarRespository() {
		
		// Given / Arrange
		Cliente cliente1 = new Cliente(null, "Julia Maria", "(00)0000-0000", "12345693848", "0987654321");
		
		// When / Act
		Cliente saveCliente = clienteRepository.save(cliente1);
		
		// Then / Assert
		assertNotNull(saveCliente);
		assertTrue(saveCliente.getId() > 0);
		
	}
	
	@DisplayName("Testando Get para todos Cliente")
	@Test
	void testGetAllRespository() {
		
		// Given / Arrange
		Cliente cliente1 = new Cliente(null, "Julia Maria", "(00)0000-0000", "12345693848", "0987654321");
		
		Cliente cliente2 = new Cliente(null, "Joao Paulo", "11-1111-1111", "09876543210", "8907654976");
		
		clienteRepository.save(cliente1);
		clienteRepository.save(cliente2);

		
		// When / Act
		List<Cliente> clienteList = clienteRepository.findAll();	
		
		
		// Then / Assert
		assertNotNull(clienteList);
		assertEquals(2, clienteList.size());
		
	}
	
	@DisplayName("Testando GET By ID")
	@Test
	void testGetById() {
		
		// Given / Arrange
		Cliente cliente1 = new Cliente(null, "Beatriz Mendes", "09120120912", "09876105789", "890763567");
		
		clienteRepository.save(cliente1);
		
		// When / Act
		Cliente saveCliente = clienteRepository.findById(cliente1.getId()).get();	
		
		
		// Then / Assert
		assertNotNull(saveCliente);
		assertEquals(cliente1.getId(), saveCliente.getId());
		
	}
	
	@DisplayName("Testando UPDATE")
	@Test
	void testUpdateCliente() {
		
		// Given / Arrange
		Cliente cliente1 = new Cliente(null, "Beatriz Mendes", "09120120912", "09876105789", "890763567");
		
		clienteRepository.save(cliente1);
		
		// When / Act
		Cliente saveCliente = clienteRepository.findById(cliente1.getId()).get();
		cliente1.setNome("Matheus");
		cliente1.setTelefone("15-1111-1111");
		cliente1.setCpf("05876543123");
		cliente1.setRg("0987697856");
		
		Cliente updateCliente = clienteRepository.save(saveCliente);
		
		
		// Then / Assert
		assertNotNull(updateCliente);
		assertEquals("Beatriz Mendes", updateCliente.getNome());
		assertEquals("09120120912", updateCliente.getTelefone());
		assertEquals("09876105789", updateCliente.getCpf());
		assertEquals("890763567", updateCliente.getRg());
		
	}
	
	@DisplayName("Testando o Delete")
	@Test
	void testDeleteCliente() {
		
		// Given / Arrange
		Cliente cliente1 = new Cliente(null, "Beatriz Mendes", "09120120912", "09876105789", "890763567");
		
		clienteRepository.save(cliente1);
		
		// When / Act
	     clienteRepository.deleteById(cliente1.getId());
		
		Optional<Cliente> clienteOptional = clienteRepository.findById(cliente1.getId());
		
		// Then / Assert
		assertTrue(clienteOptional.isEmpty());
	}
	

}

