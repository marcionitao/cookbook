package pt.ulht.es.cookbook.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pt.ulht.es.cookbook.dao.ReceitaDao;

import pt.ulht.es.cookbook.model.Receita;
import pt.ulht.es.cookbook.service.ReceitaService;

@Controller
public class RecipeController {
  
   // @Autowired
    private ReceitaService receitaService;
    
  
   /* @RequestMapping(method=RequestMethod.GET, value="/recipes")
    public String listRecipes(Model model) {

        List<String> values = new ArrayList<String>();
      
        model.addAttribute("items", values);
        
        return "listRecipes";
    }*/
    
    @RequestMapping("novaReceita")
    public String form() {
       return "createRecipes";
}
    
    @RequestMapping(value = "adicionaReceita", method=RequestMethod.POST)
    public String createRecipes(@ModelAttribute Receita receita, BindingResult result, @RequestParam String action, Map<String, Object> map) {
   
          //Receita receitaResult = new Receita();
          //if (action.equals("add")) {
            receitaService.add(receita);
           // receitaResult = receita;
          //}
        
        /*Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm");  
  
        model.addAttribute("currentTime", sdf.format(date));*/
          
         //map.put("receita", receitaResult);
  
         return "adicionada";
    }
    
    /*@RequestMapping(method=RequestMethod.GET, value="/recipes/{id}")
    public String showRecipe(Model model, @PathVariable("id") String id) {

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
    }*/
        
    
    
}