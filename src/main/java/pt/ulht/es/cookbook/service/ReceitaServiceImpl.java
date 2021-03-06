/*
 * As boas praticas recomendam que esta classe tenha a finalidade de executar e 
 * implementar os metodos definidos na classe abstrata ReceitaService, de forma 
 * a separar as aguas.
 */
package pt.ulht.es.cookbook.service;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//importar as classes das camadas inferiores
import pt.ulht.es.cookbook.model.Receita;
import pt.ulht.es.cookbook.dao.ReceitaDao;
import pt.ulht.es.cookbook.model.Tag;

@Service
public class ReceitaServiceImpl implements ReceitaService{
      
    @Autowired
    private ReceitaDao receitaDao;

    @Transactional
    public void addReceita(Receita receita) {
       receitaDao.addReceita(receita);
    }
       
    @Transactional
    public void editReceita(Receita receita) {
         receitaDao.editReceita(receita);
    }

    @Transactional
    public void deleteReceita(int id) {
         receitaDao.deleteReceita(id);
    }

    @Transactional
    public Receita getReceita(int id) {
         return receitaDao.getReceita(id);
    }

    @Transactional
    public List getAllReceita() {
        return receitaDao.getAllReceita();
        //   throw new UnsupportedOperationException("Not supported yet.");
    }
    
     @Transactional
    public List getControle() {
        return receitaDao.getControle();
        //   throw new UnsupportedOperationException("Not supported yet.");
    }
    
     
    @Transactional
    public List getAllControle() {
        return receitaDao.getAllControle();
        //   throw new UnsupportedOperationException("Not supported yet.");
    }
     @Transactional
    public List getControle_versao(int controle){
        return receitaDao.getControle_versao(controle);
        //   throw new UnsupportedOperationException("Not supported yet.");
    }
}
