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
import wts.dev.entity.Patients;
import wts.dev.interfaceService.IDoctorsService;

@Controller
@RequestMapping
public class DoctorsController {

	@Autowired
	private IDoctorsService s;
	
	@GetMapping("/doctores")
	public String listDoctors(Model model) {
		List<Doctors> doctoresAct = s.listDoctors();
		List<Doctors> doctoresIna = s.listDoctorsInac();
		
		model.addAttribute("doctores", doctoresAct);
		model.addAttribute("doctoresInac", doctoresIna);
		
		return "pages/doctores";
	};
	
	@GetMapping("/newdoctor")
	public String frmDoctors(Model model) {
		model.addAttribute("doctor", new Doctors());
		return "forms/formDoctores";
	};
	
	@PostMapping("/saveDoctor")
	public String saveDoctor(@Validated Doctors d, Model model) {
		s.saveDoc(d);
		return "redirect:/doctores";
	}
	
	@GetMapping("/editDoctor/{id}")
	public String editDoctor(@PathVariable int id, Model model) {
		Optional<Doctors> doctor = s.listIdDoc(id);
		model.addAttribute("doctor", doctor);
		return "forms/formDoctoresE";
	}
	
	@GetMapping("/deleteDoctor/{id}")
	public String delteDoctor(@PathVariable int id, Model model) {
		Optional<Doctors> optDoc = s.listIdDoc(id);
	    if (optDoc.isPresent()) {
	    	Doctors doc = optDoc.get();
	    	doc.setEstDoc(Doctors.EstDoc.inactivo);
	        s.saveDoc(doc);
	    }
		return "redirect:/doctores";
	}
}
