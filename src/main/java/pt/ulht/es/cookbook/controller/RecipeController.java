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
    
    int resultado=0;
    
    //metodo para listar as versões de receitas
    @RequestMapping(method=RequestMethod.GET, value="/listarReceita/{controle}/versoes")
    public String listVersions(@PathVariable("controle") int controle, Map<String, Object> map) {
           
        map.put("versoesList", receitaService.getControle_versao(controle));  
      
        return "listVersions";
    }
    
      //metodo para listar as receitas
    @RequestMapping(method=RequestMethod.GET, value="/listarReceita")
    public String listRecipes(Map<String, Object> map) {
        
        map.put("receitaList", receitaService.getAllControle());        
       
        return "listRecipes";
    }
    
    //metodo que cria o fomulario para criar as receitas
    @RequestMapping("/novaReceita")
    public String form(ModelMap map) {
        
        Receita receita = new Receita();
      //  Tag tag = new Tag();
        
        map.addAttribute("receita", receita);
        //map.addAttribute("tag",tag);
        map.addAttribute("receitaList", receitaService.getAllReceita());
               
        return "createRecipes";
    }
    
    //metodo para inserir a receita, ou seja, cria-las no BD
    @RequestMapping(value = "/novaReceita.do", method = RequestMethod.POST)
    public String createRecipes(@ModelAttribute("Receita") Receita receita, BindingResult resultReceita, 
                                @ModelAttribute("Tag") Tag tag, BindingResult resultTag, @RequestParam String action, Map<String, Object> map) {

        
        //estas linhas irão a tabela Receita e itá devolver o valor do ultimo controle inserido, por fim acrescentará mais um
        List lista = new ArrayList();
        if (receitaService.getControle().size() == 0) {
            receita.setControle(1);
        } else {
            lista = receitaService.getControle();
            int contar = lista.size()-1;
            Object controle = lista.get(contar);
            int resultado = Integer.parseInt(controle.toString());
            //for(int i=0; i<=lista.size()-1;i++)
            resultado++;
            receita.setControle(resultado);

            System.out.print("Este é o valor do controle: " + resultado);
        }
        
        //aqui é definido que as tags serão recebidas e separadas por ,
        String[] tags = tag.getTag().split(",");       
        for(String tagString : tags) {
            Tag newTag = Tag.fromString(tagService.getAllTag(), tagString);
            newTag.getReceita().add(receita);
           // receita.getTag().add(newTag);    
        }
        
        receitaService.addReceita(receita);
        //tagService.addTag(tag);

       // map.put("tag",tag);
        //map.put("receitaList", receitaService.getAllReceita());

        return "redirect:/listarReceita";

    }
  
    //metodo para criar o form editar receita   
    @RequestMapping(value = "/receita/{id}/form", method = RequestMethod.GET)
    public String editForm(@PathVariable("id") int id, ModelMap map) {
                     
        map.addAttribute("receita", receitaService.getReceita(id));
        
       return "updateRecipes";       
    }  
    
    //acção de editar as receitas
    @RequestMapping("/receita/*")
    public String update(@ModelAttribute("receita") Receita receita) {   

            receitaService.addReceita(receita);
        
     return "redirect:/listarReceita";

    }

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
