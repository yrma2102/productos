package com.coding.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding.web.models.Categoria;
import com.coding.web.models.Producto;
import com.coding.web.models.ProductosCategorias;
import com.coding.web.services.MainService;

import jakarta.validation.Valid;

@Controller
public class CategoryController {
	@Autowired
	private MainService mainService;
	
	@GetMapping("/categories/new")
	public String formularioCategoria(@ModelAttribute("categoria") Categoria categoria) {
		System.out.println(" SI INGRESE POR AQUI");
		return "newcategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String nuevoProducto(@Valid @ModelAttribute("categoria") Categoria categoria, BindingResult resultado) {
		if(resultado.hasErrors()) {
			return "newcategory.jsp";
		}
		mainService.crearCategoria(categoria);
		return "redirect:/";
		
	}

	@GetMapping("/categories/{idCategory}")
	public String mostrarCategoria(@PathVariable("idCategory") Long idCategory,
			@ModelAttribute("asociacion") ProductosCategorias productoscategorias, Model viewModel) {
		Categoria categoria = mainService.getCategoria(idCategory);
		//Producto producto = mainService.getProducto(idProduct);
		viewModel.addAttribute("categoria", categoria);
		viewModel.addAttribute("productos", mainService.categoriaSinProducto(categoria));

		return "mostrarcategoria.jsp";

	}
}
