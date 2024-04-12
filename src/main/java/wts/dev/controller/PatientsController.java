package wts.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import wts.dev.entity.Patients;
import wts.dev.interfaceService.IPatientsService;

@Controller
@RequestMapping
public class PatientsController {
	
	@Autowired
	private IPatientsService s;
	
	@GetMapping("/clientes")
	public String listPatients(Model model) {
		List<Patients> clientes = s.listPatients();
		model.addAttribute("clientes", clientes);
		return "pages/clientes";
	}

}
