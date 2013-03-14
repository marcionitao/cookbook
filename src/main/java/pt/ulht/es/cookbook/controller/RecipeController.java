package pt.ulht.es.cookbook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RecipeController {
  
    @RequestMapping(method=RequestMethod.GET, value="/recipes")
    public String listRecipes(Model model) {

        List<String> values = new ArrayList<String>();
        values.add("1º item");
        values.add("2º item");   
        values.add("3º item");
        values.add("4º item");  
        model.addAttribute("items", values);
        
        return "listRecipes";
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/recipes/{id}")
    public String showRecipe(Model model, @PathVariable String id) {

        List<String> values = new ArrayList<String>();
        
         id = "4";
        values.add("1º item"+id);
        values.add("2º item"+id);   
        values.add("3º item"+id);
        values.add("4º item"+id);  
        
     
            
        model.addAttribute("items", values);
        
        if(id.equals("4")) {
        	return "detailedRecipe";
		} else {
			return "recipeNotFound";
		}
    }
        
    
    
}