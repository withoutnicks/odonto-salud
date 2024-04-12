package wts.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		model.addAttribute("recepcionistas", recepcionistas);
		return "pages/recepcionistas";
	};
}
