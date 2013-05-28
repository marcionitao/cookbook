/*
 * Esta classe é responsavel por classificar as receitas
 * 
 */
package pt.ulht.es.cookbook.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;


@Entity //informa ao Hibernate que esta classe representa um objeto que pode persistir.
@Table(name="TAG")
public class Tag implements Serializable{
    
    @Id
    @Column//anotação é usada para mapear essa propriedade para a coluna nome na tabela de Studants.
    @GeneratedValue(strategy = GenerationType.AUTO) //for autonumber
    private int id_tag;
    @Column
    private String tag;
    
    @ManyToMany(fetch=FetchType.LAZY, mappedBy = "tag")
    @JoinTable(name="receita_tag", joinColumns={@JoinColumn(name="idTag")}, 
                                   inverseJoinColumns={@JoinColumn(name="idReceita")})
    @Cascade(org.hibernate.annotations.CascadeType.ALL) 
    private Collection<Receita> receita = new ArrayList<Receita>();   
   
    public int getId_tag() {
        return id_tag;
    }

    public Collection<Receita> getReceita() {
        return receita;
    }

    public void setReceita(Collection<Receita> receita) {
        this.receita = receita;
    }

    public void setId_tag(int id_tag) {
        this.id_tag = id_tag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    
    
}