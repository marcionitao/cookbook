/* 
 * Vamos criar uma classe POJO para armazenar informações das Receitas. 
 * Também esta classe será uma classe de entidade e será vinculada com a tabela Receitas
 * no banco de dados. 
 */
package pt.ulht.es.cookbook.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity //informa ao Hibernate que esta classe representa um objeto que pode persistir.
@Table(name="RECEITA")
public class Receita implements Serializable {

    @Id
    @Column//anotação é usada para mapear essa propriedade para a coluna nome na tabela de Studants.
    @GeneratedValue(strategy = GenerationType.AUTO) //for autonumber
    private int id;
    @Column
    private String titulo;
    @Column
    private String desc_prob;
    @Column
    private String desc_soluc;
    @Column
    private String autor;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date rec_criada;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="receita_tag", joinColumns={@JoinColumn(name="idReceita")}, 
                                   inverseJoinColumns={@JoinColumn(name="idTag")})
    @Cascade(org.hibernate.annotations.CascadeType.ALL) 
    private Collection<Tag> tag = new ArrayList<Tag>();
    
    @ManyToOne
    @JoinColumn(name="my")
    private MyReceitas my;

    public MyReceitas getMy() {
        return my;
    }

    public void setMy(MyReceitas my) {
        this.my = my;
    }
    
    public Receita(){}
    
    public Receita(int id, String titulo, String desc_prob, String desc_soluc, 
            String autor, Date rec_criada, Collection<Tag> tag) { 
		super();
		this.id = id;
		this.titulo = titulo;
		this.desc_prob = desc_prob;
		this.desc_soluc = desc_soluc;
                this.autor = autor;
                this.rec_criada = rec_criada;
                this.tag = tag;
                
	}
    
    public Collection<Tag> getTag() {
        return tag;
    }

    public void setTag(Collection<Tag> tag) {
        this.tag = tag;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDesc_prob() {
        return desc_prob;
    }

    public void setDesc_prob(String desc_prob) {
        this.desc_prob = desc_prob;
    }

    public String getDesc_soluc() {
        return desc_soluc;
    }

    public void setDesc_soluc(String desc_soluc) {
        this.desc_soluc = desc_soluc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRec_criada() {
        return rec_criada;
    }

    public void setRec_criada(Date rec_criada) {
        this.rec_criada = rec_criada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
}
