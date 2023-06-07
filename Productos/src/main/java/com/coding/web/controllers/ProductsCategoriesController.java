package com.coding.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding.web.models.ProductosCategorias;
import com.coding.web.services.MainService;

@Controller
public class ProductsCategoriesController {
	@Autowired
	private MainService mainService;
	
	@PostMapping("/aso/{idProduct}")
	public String asociarCategoriaProducto(@PathVariable("idProduct")Long idProduct,
			@ModelAttribute("asociacion") ProductosCategorias productoscategorias,
			Model viewModel, BindingResult resultado) {
		if(resultado.hasErrors()) {
			return "mostrarproducto.jsp";
		}
		mainService.crearVinculo(productoscategorias);
		return "redirect:/products/"+idProduct;
	}
	@PostMapping("/aso2/{idCategory}")
	public String asociarProductoCategoria(@PathVariable("idCategory")Long idCategory,
			@ModelAttribute("asociacion") ProductosCategorias productoscategorias,
			Model viewModel, BindingResult resultado) {
		if(resultado.hasErrors()) {
			return "mostrarcategoria.jsp";
		}
		mainService.crearVinculo(productoscategorias);
		return "redirect:/categories/"+idCategory;
	}
}
