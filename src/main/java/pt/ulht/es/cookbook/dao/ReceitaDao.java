/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ulht.es.cookbook.dao;

import java.util.List;
import pt.ulht.es.cookbook.model.Receita;

public interface ReceitaDao {

    public void add(Receita receita);

    public void edit(Receita receita);

    public void delete(int id);

   // public Receita getReceita(String titulo);//no futuro usar como pesquisa
    
    public Receita getReceita(int id);//no futuro usar como pesquisa

    public List getAllReceita();//lista as receitas
}
