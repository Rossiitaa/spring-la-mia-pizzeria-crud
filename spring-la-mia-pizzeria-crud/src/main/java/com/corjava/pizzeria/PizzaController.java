package com.corjava.pizzeria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.corjava.pizzeria.model.Pizza;
import com.corjava.pizzeria.repository.PizzaRepo;

@Controller
@RequestMapping("/pizza")
public class PizzaController {

	@Autowired
	private PizzaRepo pizzaRepo;

	@GetMapping
	public String index(Model model) {
		List <Pizza> elencoPizze = pizzaRepo.findAll();
		model.addAttribute("elencoPizze", elencoPizze);
		return "index";
	}
}