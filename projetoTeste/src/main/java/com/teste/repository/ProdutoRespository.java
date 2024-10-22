package com.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.entity.Produto;

public interface ProdutoRespository extends JpaRepository<Produto, Long>  {

}
