package com.corjava.pizzeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.corjava.pizzeria.model.Pizza;
import com.corjava.pizzeria.repository.PizzaRepo;


@Controller
@RequestMapping("/pizze")
public class PizzaController {
	@Autowired
	PizzaRepo pizzaRepo;

	@GetMapping
	public String index(Model model) {
		List<Pizza> elencoPizze = pizzaRepo.findAll();
		model.addAttribute("elencoPizze", elencoPizze);
		return "indexPizze";
	}
}
