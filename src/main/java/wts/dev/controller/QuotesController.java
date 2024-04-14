package wts.dev.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/newcitas")
	public String frmCitas(Model model) {
		model.addAttribute("cita", new Quotes());
		return "forms/formCitas";
	};
	
	@PostMapping("/saveQuotes")
	public String saveQuotes(@Validated Quotes q, Model model) {
		s.saveCit(q);
		return "redirect:/home";
	}
	
	@GetMapping("/editQuotes/{id}")
	public String editQuotes(@PathVariable int id, Model model) {
		Optional<Quotes> citas = s.listIdCit(id);
		model.addAttribute("citas", citas);
		return "forms/formCitasE";
	}
}
