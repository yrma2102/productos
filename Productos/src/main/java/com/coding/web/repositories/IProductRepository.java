package com.coding.web.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coding.web.models.Categoria;
import com.coding.web.models.Producto;

public interface IProductRepository extends CrudRepository<Producto, Long> {
	List<Producto> findAll();
	List<Producto> findByCategoriesNotContains(Categoria categoria);
}
