/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marina Guzvic
 */

    @Entity
    @DiscriminatorValue("N")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nastavnik.findAll", query = "SELECT n FROM Nastavnik n")
    , @NamedQuery(name = "Nastavnik.findByZvanje", query = "SELECT n FROM Nastavnik n WHERE n.zvanje = :zvanje")
    , @NamedQuery(name = "Nastavnik.findByTitula", query = "SELECT n FROM Nastavnik n WHERE n.titula = :titula")})
public class Nastavnik extends ClanSistema implements Serializable {


    @Column(name = "zvanje",length = 20)
    @Enumerated(EnumType.STRING)
    private EnumZvanje zvanje;
    @Column(name = "titula",length = 20)
    @Enumerated(EnumType.STRING)
    private EnumTitula titula;
    @JoinColumn(name = "katedra_id_fk", referencedColumnName = "katedra_id")
    @ManyToOne
    private Katedra katedraIdFk;
    @OneToMany(mappedBy = "nastavnikIdFk")
    @JsonBackReference(value = "clanColl")
    private Collection<ClanKomisije> clanKomisijeCollection;

    public EnumZvanje getZvanje() {
        return zvanje;
    }

    public void setZvanje(EnumZvanje zvanje) {
        this.zvanje = zvanje;
    }

    public EnumTitula getTitula() {
        return titula;
    }

    public void setTitula(EnumTitula titula) {
        this.titula = titula;
    }

    public Katedra getKatedraIdFk() {
        return katedraIdFk;
    }

    public void setKatedraIdFk(Katedra katedraIdFk) {
        this.katedraIdFk = katedraIdFk;
    }

    public Collection<ClanKomisije> getClanKomisijeCollection() {
        return clanKomisijeCollection;
    }

    public void setClanKomisijeCollection(Collection<ClanKomisije> clanKomisijeCollection) {
        this.clanKomisijeCollection = clanKomisijeCollection;
    }
    
    
}
