package de.mxro.commissioncalculator.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import de.mxro.commissioncalculator.model.domain.Request;
import de.mxro.commissioncalculator.model.view.ErrorView;
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

	private final String showError(Model model, String message) {
		ErrorView error = new ErrorView();
		error.setMessage(message);
		model.addAttribute("error", error);
		return "error";
	}

	@PostMapping("/calculate")
	public String calculate(@Valid RequestView requestView, BindingResult result, Model model) {

		if (requestView.getActual() <= 0 || requestView.getTarget() <= 0
				|| requestView.getTarget() < requestView.getActual()
				|| (double) requestView.getActual() / (double) requestView.getTarget() > 99.99) {
			return showError(model, "Invalid values provided.");
		}

		Request request = new Request();
		request.setActual(requestView.getActual());
		request.setTarget(requestView.getTarget());
		request.setMotc(requestView.getMotc());

		model.addAttribute(service.calculateCommission(request));

		return "result";
	}

}
