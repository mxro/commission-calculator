package de.mxro.commissioncalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.mxro.commissioncalculator.model.domain.Request;
import de.mxro.commissioncalculator.model.view.RequestView;
import de.mxro.commissioncalculator.service.CommissionCalculationService;

@Controller
public class CommissionController {

	@Autowired
	CommissionCalculationService service;

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("request", new RequestView());
		return "index";
	}

	@PostMapping("/calculate")
	public String calculate(@ModelAttribute RequestView requestView, BindingResult result, Model model) {

		Request request = new Request();
		request.setActual(requestView.getActual());
		request.setTarget(requestView.getTarget());
		request.setMotc(request.getMotc());
		
		model.addAttribute(service.calculateCommission(request));

		return "result";
	}

}
