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

import com.teste.entity.Veiculo;

@DataJpaTest
class VeiculoRepositoryTest {

	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@DisplayName("Testando o save")
	@Test
	void testSalvarRespository() {
		
		// Given / Arrange
		Veiculo veiculo1 = new Veiculo(null, "Ford", "Ford Aspire", 2020, "preto");
		
		// When / Act
		Veiculo saveVeiculo = veiculoRepository.save(veiculo1);
		
		// Then / Assert
		assertNotNull(saveVeiculo);
		assertTrue(saveVeiculo.getId() > 0);
		
	}
	
	@DisplayName("Testando Get para todos Veiculos")
	@Test
	void testGetAllRespository() {
		
		// Given / Arrange
		Veiculo veiculo1 = new Veiculo(null, "Ford", "Ford Aspire", 2020, "preto");
		
		Veiculo veiculo2 = new Veiculo(null, "BMW", "BMW. X2", 2023, "cinza");
		
		veiculoRepository.save(veiculo1);
		veiculoRepository.save(veiculo2);

		
		// When / Act
		List<Veiculo> veiculoList = veiculoRepository.findAll();	
		
		
		// Then / Assert
		assertNotNull(veiculoList);
		assertEquals(2, veiculoList.size());
		
	}
	
	@DisplayName("Testando GET By ID")
	@Test
	void testGetById() {
		
		// Given / Arrange
		Veiculo veiculo1 = new Veiculo(null, "BMW", "BMW. X2", 2023, "cinza");
		
		veiculoRepository.save(veiculo1);
		
		// When / Act
		Veiculo saveVeiculo = veiculoRepository.findById(veiculo1.getId()).get();	
		
		
		// Then / Assert
		assertNotNull(saveVeiculo);
		assertEquals(veiculo1.getId(), saveVeiculo.getId());
		
	}
	
	@DisplayName("Testando UPDATE")
	@Test
	void testUpdateVeiculo() {
		
		// Given / Arrange
		Veiculo veiculo1 = new Veiculo(null, "BMW", "BMW. X2", 2023, "cinza");
		
		veiculoRepository.save(veiculo1);
		
		// When / Act
		Veiculo saveveiculo = veiculoRepository.findById(veiculo1.getId()).get();
		veiculo1.setMarca("Honda");
		veiculo1.setModelo("Honda Accord");
		veiculo1.setAno(2019);
		veiculo1.setCor("azul");
		
		Veiculo updateVeiculo = veiculoRepository.save(saveveiculo);
		
		
		// Then / Assert
		assertNotNull(updateVeiculo);
		assertEquals("Honda", updateVeiculo.getMarca());
		assertEquals("Honda Accord", updateVeiculo.getModelo());
		assertEquals(2019, updateVeiculo.getAno());
		assertEquals("azul", updateVeiculo.getCor());
		
	}
	
	@DisplayName("Testando o Delete")
	@Test
	void testDeleteVeiculo() {
		
		// Given / Arrange
		Veiculo veiculo1 = new Veiculo(null, "BMW", "BMW. X2", 2023, "cinza");
		
		veiculoRepository.save(veiculo1);
		
		// When / Act
	     veiculoRepository.deleteById(veiculo1.getId());
		
		Optional<Veiculo> veiculoOptional = veiculoRepository.findById(veiculo1.getId());
		
		// Then / Assert
		assertTrue(veiculoOptional.isEmpty());
	}

}
