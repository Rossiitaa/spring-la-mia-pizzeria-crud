package com.corjava.pizzeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.corjava.pizzeria.model.Pizza;
import com.corjava.pizzeria.repository.PizzaRepo;

@Controller
@RequestMapping("/pizze")
public class PizzaController {
	@Autowired
	PizzaRepo pizzaRepo;

	@GetMapping
	public String index(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
		List<Pizza> elencoPizze;
		if (keyword == null) {
			elencoPizze = pizzaRepo.findAll();
		} else {
			elencoPizze = pizzaRepo.findByNomeLike("%" + keyword + "%");
		}

		model.addAttribute("elencoPizze", elencoPizze);
		return "index";
	}

	@GetMapping("/{id}")
	public String dettaglioPizza(@PathVariable("id") Integer id, Model model) {
		Pizza singolaPizza = pizzaRepo.getReferenceById(id);
		model.addAttribute("pizza", singolaPizza);
		return "details";
	}
}
