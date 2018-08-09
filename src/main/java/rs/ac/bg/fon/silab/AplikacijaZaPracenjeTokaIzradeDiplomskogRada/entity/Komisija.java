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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marina Guzvic
 */
@Entity
@Table(name = "komisija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Komisija.findAll", query = "SELECT k FROM Komisija k")
    , @NamedQuery(name = "Komisija.findByKomisijaId", query = "SELECT k FROM Komisija k WHERE k.komisijaId = :komisijaId")})
public class Komisija implements Serializable {

    private static final long serialVersionUID = 1L;
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "komisija_id")
    private Long komisijaId;
    @OneToMany(mappedBy = "komisijaIdFk")
    @JsonBackReference(value = "dipColl")
    private Collection<DiplomskiRad> diplomskiRadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "komisija")
    @JsonBackReference(value = "clanKomisijeColl")
    private Collection<ClanKomisije> clanKomisijeCollection;

    public Komisija() {
    }

    public Komisija(Long komisijaId) {
        this.komisijaId = komisijaId;
    }

    public Long getKomisijaId() {
        return komisijaId;
    }

    public void setKomisijaId(Long komisijaId) {
        this.komisijaId = komisijaId;
    }

    @XmlTransient
    public Collection<DiplomskiRad> getDiplomskiRadCollection() {
        return diplomskiRadCollection;
    }

    public void setDiplomskiRadCollection(Collection<DiplomskiRad> diplomskiRadCollection) {
        this.diplomskiRadCollection = diplomskiRadCollection;
    }

    @XmlTransient
    public Collection<ClanKomisije> getClanKomisijeCollection() {
        return clanKomisijeCollection;
    }

    public void setClanKomisijeCollection(Collection<ClanKomisije> clanKomisijeCollection) {
        this.clanKomisijeCollection = clanKomisijeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (komisijaId != null ? komisijaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Komisija)) {
            return false;
        }
        Komisija other = (Komisija) object;
        if ((this.komisijaId == null && other.komisijaId != null) || (this.komisijaId != null && !this.komisijaId.equals(other.komisijaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Komisija[ komisijaId=" + komisijaId + " ]";
    }
    
}
