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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "tema_diplomskog_rada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TemaDiplomskogRada.findAll", query = "SELECT t FROM TemaDiplomskogRada t")
    , @NamedQuery(name = "TemaDiplomskogRada.findByTemaId", query = "SELECT t FROM TemaDiplomskogRada t WHERE t.temaId = :temaId")
    , @NamedQuery(name = "TemaDiplomskogRada.findByNazivTeme", query = "SELECT t FROM TemaDiplomskogRada t WHERE t.nazivTeme = :nazivTeme")})
public class TemaDiplomskogRada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tema_id")
    private Long temaId;
    @Column(name = "naziv_teme",length = 500)
    private String nazivTeme;
    @Lob
    @Column(name = "opis_teme",length = 65535)
    private String opisTeme;
    @JoinColumn(name = "predmet_id_fk", referencedColumnName = "predmet_id")
    @ManyToOne
    private Predmet predmetIdFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "temaIdFk")
    @JsonBackReference(value = "diplrColl")
    private Collection<DiplomskiRad> diplomskiRadCollection;

    public TemaDiplomskogRada() {
    }

    public TemaDiplomskogRada(Long temaId) {
        this.temaId = temaId;
    }

    public Long getTemaId() {
        return temaId;
    }

    public void setTemaId(Long temaId) {
        this.temaId = temaId;
    }

    public String getNazivTeme() {
        return nazivTeme;
    }

    public void setNazivTeme(String nazivTeme) {
        this.nazivTeme = nazivTeme;
    }

    public String getOpisTeme() {
        return opisTeme;
    }

    public void setOpisTeme(String opisTeme) {
        this.opisTeme = opisTeme;
    }

    public Predmet getPredmetIdFk() {
        return predmetIdFk;
    }

    public void setPredmetIdFk(Predmet predmetIdFk) {
        this.predmetIdFk = predmetIdFk;
    }

    @XmlTransient
    public Collection<DiplomskiRad> getDiplomskiRadCollection() {
        return diplomskiRadCollection;
    }

    public void setDiplomskiRadCollection(Collection<DiplomskiRad> diplomskiRadCollection) {
        this.diplomskiRadCollection = diplomskiRadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (temaId != null ? temaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TemaDiplomskogRada)) {
            return false;
        }
        TemaDiplomskogRada other = (TemaDiplomskogRada) object;
        if ((this.temaId == null && other.temaId != null) || (this.temaId != null && !this.temaId.equals(other.temaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.TemaDiplomskogRada[ temaId=" + temaId + " ]";
    }
    
}
