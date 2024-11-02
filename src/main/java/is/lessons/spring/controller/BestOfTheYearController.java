package is.lessons.spring.controller;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class BestOfTheYearController {

	
	@GetMapping("/welcome")
	public String saluto(@RequestParam ("nome") String nome, Model model) {
		model.addAttribute("nome", nome);
		model.addAttribute("time", LocalTime.now());
		
		return "welcome";
	}
}
