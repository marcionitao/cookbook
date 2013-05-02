package pt.ulht.es.cookbook.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pt.ulht.es.cookbook.model.Receita;
import pt.ulht.es.cookbook.service.ReceitaService;

@Controller
public class RecipeController {
   
    @Autowired
    private ReceitaService receitaService;    
  
    //metodo para listar as receitas
    @RequestMapping(method=RequestMethod.GET, value="/listarReceita")
    public String listRecipes(Map<String, Object> map) {

        map.put("receitaList", receitaService.getAllReceita());        
        return "listRecipes";
    }
    
    //metodo que cria o fomulario para criar as receitas
    @RequestMapping("/novaReceita")
    public String form(Map<String, Object> map) {
        
        Receita receita = new Receita();
        map.put("receita", receita);
        map.put("receitaList", receitaService.getAllReceita());
               
        return "createRecipes";
    }
    
    //metodo para inserir a recita, ou seja, cria-las no BD
    @RequestMapping(value = "/novaReceita.do", method = RequestMethod.POST)
    public String createRecipes(@ModelAttribute Receita receita, BindingResult result, @RequestParam String action, Map<String, Object> map) {

        Receita receitaResult = new Receita();

        if (action.equals("add")) {

            receitaService.addReceita(receita);
            receitaResult = receita;

        } else if (action.equals("cancel")) {

            return "createRecipes";
        }

        map.put("receita", receitaResult);
        map.put("receitaList", receitaService.getAllReceita());

        return "listRecipes";

    }
    //metodo para criar o form editar receita
  
    @RequestMapping(value = "/receita/{id}/form")
    public String editForm(@PathVariable("id") int id, Map<String, Object> map) {
   
        map.put("receita", receitaService.getReceita(id));

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
 
        receitaService.deleteReceita(receitaId);
 
        //após eliminar ele redireciona para o listarReceita
      return "redirect:/listarReceita";
    }
   
}
