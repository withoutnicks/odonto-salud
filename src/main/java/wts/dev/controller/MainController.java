package wts.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import wts.dev.entity.User;

@Controller
public class MainController {

	/* LOGIN */
	@GetMapping("/")
	public String IndexPage() {
		return "index.html";
	};
	
	@PostMapping("/login")
    public String login(User u, HttpSession session) {
		if ("admin".equals(u.getUsername()) && "12345".equals(u.getPassword())) {
            session.setAttribute("user", u);
            return "redirect:/home";
        }
        return "redirect:/";
    }
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
	    return "redirect:/";
	}
	

	/* FORMS */

	@GetMapping("/newcitas")
	public String FrmCitas() {
		return "forms/formCitas.html";
	};

	@GetMapping("/newclientes")
	public String FrmClientes() {
		return "forms/formClientes.html";
	};

	@GetMapping("/newdoctores")
	public String FrmDoctores() {
		return "forms/formDoctores.html";
	};

	@GetMapping("/newrecep")
	public String FrmRecep() {
		return "forms/formRecep.html";
	};
}
