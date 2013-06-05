/*
 * Esta classe é usada para armazenar as funções do projeto de negócios, 
 * as operações de base de dados reais (CRUD), não devem ser envolvidas nesta 
 * classe, ao vez disto, tem uma classe DAO(ReceitaDao) para fazê-lo.
 * 
 */
package pt.ulht.es.cookbook.service;

import java.util.List;
import pt.ulht.es.cookbook.model.Receita;
import pt.ulht.es.cookbook.model.Tag;

public interface ReceitaService {

    public void addReceita(Receita receita);

    public void editReceita(Receita receita);

    public void deleteReceita(int id);

    // public Receita getReceita(String titulo);//no futuro usar como pesquisa
    public Receita getReceita(int id);//no futuro usar como pesquisa

    public List getAllReceita();//lista as receitas
}