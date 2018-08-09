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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "katedra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Katedra.findAll", query = "SELECT k FROM Katedra k")
    , @NamedQuery(name = "Katedra.findByKatedraId", query = "SELECT k FROM Katedra k WHERE k.katedraId = :katedraId")
    , @NamedQuery(name = "Katedra.findByNazivKatedre", query = "SELECT k FROM Katedra k WHERE k.nazivKatedre = :nazivKatedre")})
public class Katedra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "katedra_id")
    private Long katedraId;
    @Column(name = "naziv_katedre",length = 100)
    private String nazivKatedre;
    @OneToMany(mappedBy = "katedraIdFk")
     @JsonBackReference(value = "nastavnikColl")
    private Collection<Nastavnik> nastavnikCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "katedraIdFk")
    @JsonBackReference(value = "predmetColl")
    private Collection<Predmet> predmetCollection;

    public Katedra() {
    }

    public Katedra(Long katedraId) {
        this.katedraId = katedraId;
    }

    public Long getKatedraId() {
        return katedraId;
    }

    public void setKatedraId(Long katedraId) {
        this.katedraId = katedraId;
    }

    public String getNazivKatedre() {
        return nazivKatedre;
    }

    public void setNazivKatedre(String nazivKatedre) {
        this.nazivKatedre = nazivKatedre;
    }

    @XmlTransient
    public Collection<Nastavnik> getClanSistemaCollection() {
        return nastavnikCollection;
    }

    public void setClanSistemaCollection(Collection<Nastavnik> nastavnikCollection) {
        this.nastavnikCollection = nastavnikCollection;
    }

    @XmlTransient
    public Collection<Predmet> getPredmetCollection() {
        return predmetCollection;
    }

    public void setPredmetCollection(Collection<Predmet> predmetCollection) {
        this.predmetCollection = predmetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (katedraId != null ? katedraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Katedra)) {
            return false;
        }
        Katedra other = (Katedra) object;
        if ((this.katedraId == null && other.katedraId != null) || (this.katedraId != null && !this.katedraId.equals(other.katedraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Katedra[ katedraId=" + katedraId + " ]";
    }
    
}
