/*
 * As boas praticas recomendam que esta classe tenha a finalidade de executar e 
 * implementar os metodos definidos na classe abstrata TagService, de forma 
 * a separar as aguas.
 */

package pt.ulht.es.cookbook.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pt.ulht.es.cookbook.dao.TagDao;
import pt.ulht.es.cookbook.model.Tag;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Transactional
    public void addTag(Tag tag) {
        tagDao.addTag(tag);
    }

    @Transactional
    public void editTag(Tag tag) {
        tagDao.editTag(tag);
    }

    @Transactional
    public void deleteTag(int id_tag) {
        tagDao.deleteTag(id_tag);
    }

    @Transactional
    public Tag getTag(int id_tag) {
        return tagDao.getTag(id_tag);
    }

    @Transactional
    public List getAllTag() {
        return tagDao.getAllTag();
    }
}
