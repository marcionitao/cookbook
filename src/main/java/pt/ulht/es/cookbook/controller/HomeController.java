package pt.ulht.es.cookbook.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(method=RequestMethod.GET, value="/cookbook/")
	//@RequestMapping(method=RequestMethod.GET, value="/")
	public String showHome(Model model) {

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        model.addAttribute("currentTime", sdf.format(date));
	    
		return "home";
	}

 
}