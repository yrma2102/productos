package com.coding.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.web.models.Categoria;
import com.coding.web.models.Producto;
import com.coding.web.models.ProductosCategorias;
import com.coding.web.repositories.ICategoryRepository;
import com.coding.web.repositories.IProductRepository;
import com.coding.web.repositories.IProductsCategoriesRepository;

@Service
public class MainService {
	@Autowired 
	private IProductRepository productRepo;
	@Autowired 
	private ICategoryRepository categoryRepo;
	@Autowired
	private IProductsCategoriesRepository productcategoriesRepo;
	
	
	// SERVICIOS PARA PRODUCTO
	public Producto crearProducto(Producto producto) {
		return productRepo.save(producto);
	}
	public List<Producto> todosProductos(){
		return productRepo.findAll();
		}
	public Producto getProducto(Long idProducto) {
		return productRepo.findById(idProducto).orElse(null);
	}
	public Categoria getCategoria(Long idCategoria) {
		return categoryRepo.findById(idCategoria).orElse(null);
	}
	
	//SERVICIOS PARA CATEGORIAS
	public Categoria crearCategoria(Categoria categoria) {
		return categoryRepo.save(categoria);
	}
	public List<Categoria> todosCategorias(){
		return categoryRepo.findAll();
		}
	public List<Categoria> productoSinCategoria(Producto producto){
		return categoryRepo.findByProductsNotContains(producto);
	}
	public List<Producto> categoriaSinProducto(Categoria categoria){
		return productRepo.findByCategoriesNotContains(categoria);
	}
	
	//SERVICIOS TABLA INTERMEDIA
	public ProductosCategorias crearVinculo(ProductosCategorias productoscategorias) {
		return productcategoriesRepo.save(productoscategorias);
	}
}
