/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ulht.es.cookbook.dao;

import java.util.List;
import pt.ulht.es.cookbook.model.Tag;

public interface TagDao {

    //public void addTag(Tag tag);
     public void addTag(Tag tag);

    public void editTag(Tag tag);

    public void deleteTag(int id_tag);
   
    public Tag getTag(int id_tag);

    public List getAllTag();
}
