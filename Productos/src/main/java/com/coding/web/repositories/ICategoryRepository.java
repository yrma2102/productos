package com.coding.web.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coding.web.models.Categoria;
import com.coding.web.models.Producto;

public interface ICategoryRepository extends CrudRepository<Categoria, Long>{
	List<Categoria> findAll();
	List<Categoria> findByProductsNotContains(Producto producto);
}
