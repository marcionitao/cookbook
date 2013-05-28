package pt.ulht.es.cookbook.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pt.ulht.es.cookbook.model.Receita;
import pt.ulht.es.cookbook.model.Tag;
import pt.ulht.es.cookbook.service.ReceitaService;
import pt.ulht.es.cookbook.service.TagService;

@Controller
public class RecipeController {
     
    @Autowired
    private ReceitaService receitaService;  
    
    @Autowired
    private TagService tagService;
    
    //metodo para listar as receitas
    @RequestMapping(method=RequestMethod.GET, value="/listarReceita")
    public String listRecipes(Map<String, Object> map) {

        map.put("receitaList", receitaService.getAllReceita());        
        return "listRecipes";
    }
    
    //metodo que cria o fomulario para criar as receitas
    @RequestMapping("/novaReceita")
    public String form(ModelMap map) {
        
        Receita receita = new Receita();
        Tag tag = new Tag();
        
        map.addAttribute("receita", receita);
        map.addAttribute("tag",tag);
        map.addAttribute("receitaList", receitaService.getAllReceita());
               
        return "createRecipes";
    }
    
    //metodo para inserir a receita, ou seja, cria-las no BD
    @RequestMapping(value = "/novaReceita.do", method = RequestMethod.POST)
    public String createRecipes(@ModelAttribute("Receita") Receita receita, BindingResult resultReceita, 
                                @ModelAttribute("Tag") Tag tag, BindingResult resultTag, @RequestParam String action, Map<String, Object> map) {

              
        
        receita.getTag().add(tag);    
        receitaService.addReceita(receita);
        //tagService.addTag(tag);

        map.put("receita", receita);
        map.put("tag",tag);
        map.put("receitaList", receitaService.getAllReceita());

        return "listRecipes";

    }
    //metodo para criar o form editar receita   
    @RequestMapping(value = "/receita/{id}/form")
    public String editForm(@PathVariable("id") int id, ModelMap map) {
   
    
        map.addAttribute("receita", receitaService.getReceita(id));
        map.addAttribute("tag", tagService.getTag(id+1));
        return "updateRecipes";

    }   
    //acção de editar as receitas
 /*
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@ModelAttribute("receita") Receita receita, @RequestParam String action) {

        if (action.equals("add")) {

            receitaService.editReceita(receita);
        }

       return "redirect:/listarReceita";

    }
*/
    //metodo para eliminar a receita
     @RequestMapping("/delete/{id}")
    public String deleteContact(@PathVariable("id")int  receitaId) 
    {
        //chama o metodo e passa o valor do id do registo a ser eliminado
        receitaService.deleteReceita(receitaId);
 
        //após eliminar ele redireciona para o listarReceita
      return "redirect:/listarReceita";
    }
   
}
