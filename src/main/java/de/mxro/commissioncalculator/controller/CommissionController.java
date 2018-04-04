package de.mxro.commissioncalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.mxro.commissioncalculator.model.Request;
import de.mxro.commissioncalculator.service.CommissionCalculationService;

@Controller
public class CommissionController {

	@Autowired
	CommissionCalculationService service;

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("request", new Request());
		return "index";
	}

	@PostMapping("/calculate")
	public String calculate(@ModelAttribute Request request, BindingResult result, Model model) {

		model.addAttribute(service.calculateCommission(request));

		return "result";
	}

}
