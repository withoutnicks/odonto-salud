package wts.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import wts.dev.entity.Quotes;
import wts.dev.interfaceService.IQuotesService;

@Controller
@RequestMapping
public class QuotesController {
	
	@Autowired
	private IQuotesService s;
	
	@GetMapping("/home")
	public String HomePage(Model model) {
		List<Quotes> citasActivas = s.listQuotesActives();
		List<Quotes> citasProgramadas = s.listQuotesScheduled();
		
		model.addAttribute("citasActivas", citasActivas);
		model.addAttribute("citasProgramadas", citasProgramadas);
		
		return "pages/citas";
	};
}
