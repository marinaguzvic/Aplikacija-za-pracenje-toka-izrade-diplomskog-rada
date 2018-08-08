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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marina Guzvic
 */
@Entity
@Table(name = "nastavnik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nastavnik.findAll", query = "SELECT n FROM Nastavnik n")
    , @NamedQuery(name = "Nastavnik.findByKorisnikSistemaIdFk", query = "SELECT n FROM Nastavnik n WHERE n.korisnikSistemaIdFk = :korisnikSistemaIdFk")
    , @NamedQuery(name = "Nastavnik.findByZvanje", query = "SELECT n FROM Nastavnik n WHERE n.zvanje = :zvanje")
    , @NamedQuery(name = "Nastavnik.findByTitula", query = "SELECT n FROM Nastavnik n WHERE n.titula = :titula")})
public class Nastavnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "korisnik_sistema_id_fk",nullable = false)
    private Long korisnikSistemaIdFk;
    @Column(name = "zvanje",length = 20)
    private String zvanje;
    @Column(name = "titula",length = 20)
    private String titula;
    @JoinColumn(name = "katedra_id_fk", referencedColumnName = "katedra_id")
    @ManyToOne
    private Katedra katedraIdFk;
    @JoinColumn(name = "korisnik_sistema_id_fk", referencedColumnName = "clan_sistema_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ClanSistema clanSistema;
    @OneToMany(mappedBy = "nastavnikIdFk")
    @JsonBackReference(value = "clanColl")
    private Collection<ClanKomisije> clanKomisijeCollection;

    public Nastavnik() {
    }

    public Nastavnik(Long korisnikSistemaIdFk) {
        this.korisnikSistemaIdFk = korisnikSistemaIdFk;
    }

    public Long getKorisnikSistemaIdFk() {
        return korisnikSistemaIdFk;
    }

    public void setKorisnikSistemaIdFk(Long korisnikSistemaIdFk) {
        this.korisnikSistemaIdFk = korisnikSistemaIdFk;
    }

    public String getZvanje() {
        return zvanje;
    }

    public void setZvanje(String zvanje) {
        this.zvanje = zvanje;
    }

    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }

    public Katedra getKatedraIdFk() {
        return katedraIdFk;
    }

    public void setKatedraIdFk(Katedra katedraIdFk) {
        this.katedraIdFk = katedraIdFk;
    }

    public ClanSistema getClanSistema() {
        return clanSistema;
    }

    public void setClanSistema(ClanSistema clanSistema) {
        this.clanSistema = clanSistema;
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
        hash += (korisnikSistemaIdFk != null ? korisnikSistemaIdFk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nastavnik)) {
            return false;
        }
        Nastavnik other = (Nastavnik) object;
        if ((this.korisnikSistemaIdFk == null && other.korisnikSistemaIdFk != null) || (this.korisnikSistemaIdFk != null && !this.korisnikSistemaIdFk.equals(other.korisnikSistemaIdFk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Nastavnik[ korisnikSistemaIdFk=" + korisnikSistemaIdFk + " ]";
    }
    
}
