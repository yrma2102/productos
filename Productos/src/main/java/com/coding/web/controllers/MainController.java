package com.coding.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.coding.web.services.MainService;

@Controller
public class MainController {
	@Autowired
	private MainService mainService;

	@GetMapping("/")
	public String raiz(Model viewModel) {
		viewModel.addAttribute("productos", mainService.todosProductos());
		viewModel.addAttribute("categorias", mainService.todosCategorias());
		return "index.jsp";
	}
}
