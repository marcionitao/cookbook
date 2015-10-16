package pt.ulht.es.cookbook.controller;

import java.util.*;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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
    int resultado = 0;
    private HashMap<Integer, Tag> tagCache;

    //metodo para listar as versões de receitas
    @RequestMapping(method = RequestMethod.GET, value = "/listarReceita/{controle}/versoes")
    public String listVersions(@PathVariable("controle") int controle, Map<String, Object> map) {

        map.put("versoesList", receitaService.getControle_versao(controle));

        return "listVersions";
    }

    //metodo para listar as receitas
    @RequestMapping(method = RequestMethod.GET, value = "/listarReceita")
    public String listRecipes(Map<String, Object> map) {

        map.put("receitaList", receitaService.getAllControle());

        return "listRecipes";
    }

    //metodo que cria o fomulario para criar as receitas
    @RequestMapping("/novaReceita")
    public String form(ModelMap map) {

        Receita receita = new Receita();

        map.addAttribute("receita", receita);
        //map.addAttribute("tag",tag);
        map.addAttribute("receitaList", receitaService.getAllReceita());

        return "createRecipes";
    }

    //metodo para inserir a receita, ou seja, cria-las no BD
    @RequestMapping(value = "/novaReceita.do", method = RequestMethod.POST)
    public String createRecipes(@ModelAttribute("Receita") Receita receita, @ModelAttribute("Tag") Tag tag) {

        //estas linhas irão a tabela Receita e itá devolver o valor do ultimo controle inserido, por fim acrescentará mais um
        List lista = new ArrayList();
        if (receitaService.getControle().size() == 0) {
            receita.setControle(1);
        } else {
            lista = receitaService.getControle();
            int contar = lista.size() - 1;
            Object controle = lista.get(contar);
            int resultado = Integer.parseInt(controle.toString());
            //for(int i=0; i<=lista.size()-1;i++)
            resultado++;
            receita.setControle(resultado);

            System.out.print("Este é o valor do controle: " + resultado);
        }

        Tag newTag = new Tag();
        newTag.getReceita().add(receita);
        receitaService.addReceita(receita);

        return "redirect:/listarReceita";

    }

    @RequestMapping(value = "/receita/{id}/form", method = RequestMethod.GET)
    public String editForm(@PathVariable("id") int id, ModelMap map) {

        Receita receita = receitaService.getReceita(id);
        map.addAttribute("receita", receita);
        Hibernate.initialize(receita.getTag());//força a inicialização

        Collection<Tag> tags = receita.getTag();//cria uma coleção local para obter o nome das tags
        String tagString = "";//variavel do tipo string de valor null
        for (Tag tag : tags) {
            tagString = tagString + tag.getTag() + (",");
        }
        tagString = tagString.trim();//remove os espaços em branco
        map.addAttribute("tagString", tagString);

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
    public String deleteReceita(@PathVariable("id") int receitaId) {
        //chama o metodo e passa o valor do id do registo a ser eliminado
        receitaService.deleteReceita(receitaId);

        //após eliminar ele redireciona para o listarReceita
        return "redirect:/listarReceita";
    }
}