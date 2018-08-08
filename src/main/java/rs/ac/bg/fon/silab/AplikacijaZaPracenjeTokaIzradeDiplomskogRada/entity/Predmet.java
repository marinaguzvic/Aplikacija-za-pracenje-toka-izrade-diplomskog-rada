/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marina Guzvic
 */
@Entity
@Table(name = "predmet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Predmet.findAll", query = "SELECT p FROM Predmet p")
    , @NamedQuery(name = "Predmet.findByPredmetId", query = "SELECT p FROM Predmet p WHERE p.predmetId = :predmetId")
    , @NamedQuery(name = "Predmet.findByNazivPredmeta", query = "SELECT p FROM Predmet p WHERE p.nazivPredmeta = :nazivPredmeta")})
public class Predmet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "predmet_id")
    private Long predmetId;
    @Column(name = "naziv_predmeta",length = 100)
    private String nazivPredmeta;
    @OneToMany(mappedBy = "predmetIdFk")
    @JsonBackReference(value = "teme")
    private Collection<TemaDiplomskogRada> temaDiplomskogRadaCollection;
    @JoinColumn(name = "katedra_id_fk", referencedColumnName = "katedra_id")
    @ManyToOne(optional = false)
    private Katedra katedraIdFk;

    public Predmet() {
    }

    public Predmet(Long predmetId) {
        this.predmetId = predmetId;
    }

    public Long getPredmetId() {
        return predmetId;
    }

    public void setPredmetId(Long predmetId) {
        this.predmetId = predmetId;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    @XmlTransient
    public Collection<TemaDiplomskogRada> getTemaDiplomskogRadaCollection() {
        return temaDiplomskogRadaCollection;
    }

    public void setTemaDiplomskogRadaCollection(Collection<TemaDiplomskogRada> temaDiplomskogRadaCollection) {
        this.temaDiplomskogRadaCollection = temaDiplomskogRadaCollection;
    }

    public Katedra getKatedraIdFk() {
        return katedraIdFk;
    }

    public void setKatedraIdFk(Katedra katedraIdFk) {
        this.katedraIdFk = katedraIdFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (predmetId != null ? predmetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Predmet)) {
            return false;
        }
        Predmet other = (Predmet) object;
        if ((this.predmetId == null && other.predmetId != null) || (this.predmetId != null && !this.predmetId.equals(other.predmetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Predmet[ predmetId=" + predmetId + " ]";
    }
    
}
