/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ulht.es.cookbook.model;

import java.io.Serializable;
import java.util.List;
import org.hibernate.annotations.Entity;
import javax.persistence.*;


@Entity //informa ao Hibernate que esta classe representa um objeto que pode persistir.
@Table(name = "MyReceitas")
public class MyReceitas implements Serializable {

    @Id
    @Column//anotação é usada para mapear essa propriedade para a coluna nome na tabela de Studants.
    @GeneratedValue(strategy = GenerationType.AUTO) //for autonumber
    private int id_myreceitas;
    
    @OneToMany (cascade=CascadeType.ALL, mappedBy="my")
    private List receita;

    public MyReceitas() {}

    public List getReceita() {
        return receita;
    }

    public void setReceita(List receita) {
        this.receita = receita;
    }

    public MyReceitas(int id_myreceitas) {

        super();
        this.id_myreceitas = id_myreceitas;

    }

    public int getId_myreceitas() {
        return id_myreceitas;
    }

    public void setId_myreceitas(int id_myreceitas) {
        this.id_myreceitas = id_myreceitas;
    }
}
