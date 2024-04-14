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
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/newcliente")
	public String frmPatients(Model model) {
		model.addAttribute("cliente", new Patients());
		return "forms/formClientes";
	};
	
	@PostMapping("/saveClient")
	public String savePatients(@Validated Patients p, Model model) {
		s.saveCli(p);
		return "redirect:/clientes";
	}

	@GetMapping("/editClient/{dni}")
	public String editPatients(@PathVariable String dni, Model model) {
		Optional<Patients> cliente = s.listIdCli(dni);
		model.addAttribute("cliente",cliente);
		return "forms/formClientesE";
	}
	
	@GetMapping("/deleteClient/{dni}")
	public String deltePatients(@PathVariable String dni, Model model) {
		Optional<Patients> optCli = s.listIdCli(dni);
	    if (optCli.isPresent()) {
	        Patients cli = optCli.get();
	        cli.setEstUsu(Patients.EstUsu.inactivo);
	        s.saveCli(cli);
	    }
		return "redirect:/clientes";
	}
	
	@GetMapping("/searchClient")
	public String searchClient(@RequestParam String dni, Model model) {
	    Optional<Patients> cliente = s.listIdCli(dni);
	    if (cliente.isPresent()) {
	        model.addAttribute("cliente", cliente.get());
	        return "forms/formClientesE";
	    } else {
	        return "redirect:/clientes";
	    }
	}
}
