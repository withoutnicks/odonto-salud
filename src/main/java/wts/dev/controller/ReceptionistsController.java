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

import wts.dev.entity.Doctors;
import wts.dev.entity.Receptionists;
import wts.dev.interfaceService.IReceptionistsService;

@Controller
@RequestMapping
public class ReceptionistsController {

	@Autowired
	private IReceptionistsService s;
	
	@GetMapping("/recepcionistas")
	public String RecepcionistasPage(Model model) {
		List<Receptionists> recepcionistas = s.listReceptionists();
		List<Receptionists> recepcionistasIna = s.listRecepIna();
		
		model.addAttribute("recepcionistas", recepcionistas);
		model.addAttribute("recepIna", recepcionistasIna);
		
		return "pages/recepcionistas";
	};
	
	@GetMapping("/newrecep")
	public String frmRecep(Model model) {
		model.addAttribute("recep", new Receptionists());
		return "forms/formRecep";
	};
	
	@PostMapping("/saveRecep")
	public String saveRecep(@Validated Receptionists r, Model model) {
		s.saveRec(r);
		return "redirect:/recepcionistas";
	}
	
	@GetMapping("/editRecep/{id}")
	public String editRecep(@PathVariable int id, Model model) {
		Optional<Receptionists> recep = s.listIdRec(id);
		model.addAttribute("recep", recep);
		return "forms/formRecepE";
	}
	
	@GetMapping("/deleteRecep/{id}")
	public String delteRecep(@PathVariable int id, Model model) {
		Optional<Receptionists> optRec = s.listIdRec(id);
	    if (optRec.isPresent()) {
	    	Receptionists rec = optRec.get();
	    	rec.setEstRec(Receptionists.EstRec.inactivo);
	        s.saveRec(rec);
	    }
		return "redirect:/doctores";
	}
}
