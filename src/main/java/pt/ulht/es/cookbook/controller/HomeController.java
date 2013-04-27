package pt.ulht.es.cookbook.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    
    
	@RequestMapping(method=RequestMethod.GET, value="/")
	public String showHome(Model model) {

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm");  
        //DateFormat df = DateFormat.getDateInstance();
        model.addAttribute("currentTime", sdf.format(date));
	    
		return "home";
	}

 
}