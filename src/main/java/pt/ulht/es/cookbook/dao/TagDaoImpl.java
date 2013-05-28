/*
 * A classe TagDaoImpl implementa a interface de acesso a dados ReceitaDAO 
 * que define métodos como list() , Add() , Delete(), Edit(), etc, para acessar 
 * os dados do banco de dados.
 */
package pt.ulht.es.cookbook.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pt.ulht.es.cookbook.model.Receita;
import pt.ulht.es.cookbook.model.Tag;

@Repository
public class TagDaoImpl implements TagDao{
    
    @Autowired // Isto é usado para que haja um fio automatico de dependência do ReceitaDaoImpl na SessionFactory.
    private SessionFactory session;

    public void addTag(Tag tag) {
        session.getCurrentSession().save(tag);
    }
    

    public void editTag(Tag tag) {
        session.getCurrentSession().update(tag);//mudar de futuro mudar para salve nova versão
    }

    public void deleteTag(int id_tag) {
         session.getCurrentSession().delete(getTag(id_tag));
    }

    public Tag getTag(int id_tag) {
         return (Tag)session.getCurrentSession().get(Tag.class, id_tag);
    }

    public List getAllTag() {
       //faz uma query a tabela Tag e ordena por ordem alfabetica o titulo da tag
        return session.getCurrentSession().createQuery("from Tag").list();
    }
    
}
