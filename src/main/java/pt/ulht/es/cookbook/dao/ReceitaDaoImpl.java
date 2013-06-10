/*
 * A classe ReceitaDaoImpl implementa a interface de acesso a dados ReceitaDAO 
 * que define métodos como list() , Add() , Delete(), Edit(), etc, para acessar 
 * os dados do banco de dados.
 */
package pt.ulht.es.cookbook.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//importar as classes das camadas inferiores
import pt.ulht.es.cookbook.model.Receita;
import pt.ulht.es.cookbook.model.Tag;

@Repository
public class ReceitaDaoImpl implements ReceitaDao {

    @Autowired // Isto é usado para que haja um fio automatico de dependência do ReceitaDaoImpl na SessionFactory.
    private SessionFactory session;
    
    @Override
    public void addReceita(Receita receita) {
           session.getCurrentSession().save(receita);         
    }
    
    @Override
    public void editReceita(Receita receita) {
          session.getCurrentSession().update(receita);//mudar de futuro mudar para salve nova versão
    }

    @Override
    public void deleteReceita(int id) {
         session.getCurrentSession().delete(getReceita(id));
    }

    @Override
    public Receita getReceita(int id) {
        return (Receita)session.getCurrentSession().get(Receita.class, id);
        //throw new UnsupportedOperationException("Not supported yet.");
    }
  
    @Override 
    public List getAllReceita() {
        //faz uma query a tabela Receita e ordena por ordem alfabetica o titulo da receita
        return session.getCurrentSession().createQuery("from Receita order by titulo").list();
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public List getControle(){
        
         return session.getCurrentSession().createQuery("select r.controle from Receita r order by r.controle").list();
    }
     
    public List getAllControle(){
        
         return session.getCurrentSession().createQuery("from Receita group by controle").list();
    }
    public List getControle_versao(int controle){
        
         return (List) session.getCurrentSession().createQuery("FROM Receita WHERE controle = "+controle+" ORDER BY titulo").list();
    }
     
}