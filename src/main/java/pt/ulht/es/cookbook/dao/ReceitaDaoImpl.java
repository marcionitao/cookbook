/*
 * A classe ReceitaDaoImpl implementa a interface de acesso a dados ReceitaDAO 
 * que define métodos como list() , Add() , Delete(), Edit(), etc, para acessar 
 * os dados do banco de dados.
 */
package pt.ulht.es.cookbook.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//importar as classes das camadas inferiores
import pt.ulht.es.cookbook.dao.ReceitaDao;
import pt.ulht.es.cookbook.model.Receita;

@Repository
public class ReceitaDaoImpl implements ReceitaDao {

    @Autowired // Isto é usado para que haja um fio automatico de dependência do ReceitaDaoImpl na SessionFactory.
    private SessionFactory session;
    @Override
    public void add(Receita receita) {
            session.getCurrentSession().save(receita);
    }

    @Override
    public void edit(Receita receita) {
          session.getCurrentSession().saveOrUpdate(receita);//mudar de futuro mudar para salve nova versão
    }

    @Override
    public void delete(int id) {
         session.getCurrentSession().delete(getReceita(id));
    }

    @Override
    public Receita getReceita(int id) {
        return (Receita)session.getCurrentSession().get(Receita.class, id);
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List getAllReceita() {
        return session.getCurrentSession().createQuery("from Receita").list();//faz uma query a DB
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
