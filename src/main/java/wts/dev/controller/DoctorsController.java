package wts.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import wts.dev.entity.Doctors;
import wts.dev.interfaceService.IDoctorsService;

@Controller
@RequestMapping
public class DoctorsController {

	@Autowired
	private IDoctorsService s;
	
	@GetMapping("/doctores")
	public String listDoctors(Model model) {
		List<Doctors> doctores = s.listDoctors();
		model.addAttribute("doctores", doctores);
		return "pages/doctores";
	};
}
