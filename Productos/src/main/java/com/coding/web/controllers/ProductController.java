package com.coding.web.controllers;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding.web.models.Producto;
import com.coding.web.models.ProductosCategorias;
import com.coding.web.services.MainService;

import jakarta.validation.Valid;

@Controller
public class ProductController {
	@Autowired
	private MainService mainService;

	@GetMapping("/products/new")
	public String formularioProducto(@ModelAttribute("producto") Producto producto) {
		return "newproduct.jsp";
	}

	@PostMapping("/products/new")
	public String nuevoProducto(@Valid @ModelAttribute("producto") Producto producto, BindingResult resultado) {
		if (resultado.hasErrors()) {

			// LOG BindingResult errors
			System.out.println(producto.getName() + "IMPORTANTE" + resultado.getFieldErrors());
			// Get error message
			Map<String, String> errors = resultado.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
			System.out.println(errors + " AQUIQUIQUQUIQUIQ");
			return "newproduct.jsp";
		}
		mainService.crearProducto(producto);
		return "redirect:/";
	}

	@GetMapping("/products/{idProduct}")
	public String mostrarProducto(@PathVariable("idProduct") Long idProduct,
			@ModelAttribute("asociacion") ProductosCategorias productoscategorias, Model viewModel) {
		Producto producto = mainService.getProducto(idProduct);
		viewModel.addAttribute("producto", producto);
		viewModel.addAttribute("categorias", mainService.productoSinCategoria(producto));

		return "mostrarproducto.jsp";

	}
}
