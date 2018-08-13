/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marina Guzvic
 */
@Entity
@DiscriminatorValue("S")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findByBrojIndeksa", query = "SELECT s FROM Student s WHERE s.brojIndeksa = :brojIndeksa")
    , @NamedQuery(name = "Student.findByGodinaStudija", query = "SELECT s FROM Student s WHERE s.godinaStudija = :godinaStudija")})
public class Student extends ClanSistema implements Serializable {

    
    @Column(name = "broj_indeksa",length = 8)
    private String brojIndeksa;
    @Column(name = "godina_studija")
    private Integer godinaStudija;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "studentIdFk")
    @JsonBackReference(value = "diplRadColl")
    private DiplomskiRad diplomskiRadCollection;

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public Integer getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(Integer godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    public DiplomskiRad getDiplomskiRadCollection() {
        return diplomskiRadCollection;
    }

    public void setDiplomskiRadCollection(DiplomskiRad diplomskiRadCollection) {
        this.diplomskiRadCollection = diplomskiRadCollection;
    }

    

}

