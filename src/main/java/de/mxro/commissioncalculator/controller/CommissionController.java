package de.mxro.commissioncalculator.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import de.mxro.commissioncalculator.model.domain.CalculationParameters;
import de.mxro.commissioncalculator.model.view.ErrorView;
import de.mxro.commissioncalculator.model.view.CalculationParametersView;
import de.mxro.commissioncalculator.service.CommissionCalculationService;

/**
 * <p>
 * The Controller for the commission calculation.
 * 
 * @author Max
 *
 */
@Controller
public class CommissionController {
	
	/**
	 * Service used to calculate the commission
	 */
	@Autowired
	CommissionCalculationService service;
	
	/**
	 * Shows the index page for this application.
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("request", new CalculationParametersView());
		return "index";
	}
	
	/**
	 * <p>Populates the model for showing an error page 
	 * @param model
	 * @param message
	 * @return
	 */
	private final String showError(Model model, String message) {
		ErrorView error = new ErrorView();
		error.setMessage(message);
		model.addAttribute("error", error);
		return "error";
	}
	
	/**
	 * <p>Provides the REST endpoint for calculating commission
	 * @param parametersView
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/calculate")
	public String calculate(@Valid CalculationParametersView parametersView, BindingResult result, Model model) {

		// doing a very simple validation of input parameters
		if (parametersView.getActual() < 0 || parametersView.getTarget() <= 0
				|| parametersView.getTarget() < parametersView.getActual()
				|| parametersView.getMotc().doubleValue() < 0
				|| parametersView.getMotc().doubleValue() >= 10000
				|| (double) parametersView.getActual() / (double) parametersView.getTarget() > 99.99) {
			return showError(model, "Invalid values provided.");
		}
		
		// mapping view to domain model
		CalculationParameters parameters = new CalculationParameters();
		parameters.setActual(parametersView.getActual());
		parameters.setTarget(parametersView.getTarget());
		parameters.setMotc(parametersView.getMotc());

		model.addAttribute(service.calculateCommission(parameters));

		return "result";
	}

}
