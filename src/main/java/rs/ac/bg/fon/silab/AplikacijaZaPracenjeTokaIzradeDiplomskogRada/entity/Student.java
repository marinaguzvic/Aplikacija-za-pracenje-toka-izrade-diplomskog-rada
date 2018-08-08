/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marina Guzvic
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findByClanSistemaIdFk", query = "SELECT s FROM Student s WHERE s.clanSistemaIdFk = :clanSistemaIdFk")
    , @NamedQuery(name = "Student.findByBrojIndeksa", query = "SELECT s FROM Student s WHERE s.brojIndeksa = :brojIndeksa")
    , @NamedQuery(name = "Student.findByGodinaStudija", query = "SELECT s FROM Student s WHERE s.godinaStudija = :godinaStudija")
    , @NamedQuery(name = "Student.findByDatumRodjenja", query = "SELECT s FROM Student s WHERE s.datumRodjenja = :datumRodjenja")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "clan_sistema_id_fk",nullable = false)
    private Long clanSistemaIdFk;
    @Column(name = "broj_indeksa",length = 8)
    private String brojIndeksa;
    @Column(name = "godina_studija")
    private Integer godinaStudija;
    @Column(name = "datum_rodjenja")
    @Temporal(TemporalType.DATE)
    private Date datumRodjenja;
    @JoinColumn(name = "clan_sistema_id_fk", referencedColumnName = "clan_sistema_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ClanSistema clanSistema;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentIdFk")
    @JsonBackReference(value = "diplRadColl")
    private Collection<DiplomskiRad> diplomskiRadCollection;

    public Student() {
    }

    public Student(Long clanSistemaIdFk) {
        this.clanSistemaIdFk = clanSistemaIdFk;
    }

    public Long getClanSistemaIdFk() {
        return clanSistemaIdFk;
    }

    public void setClanSistemaIdFk(Long clanSistemaIdFk) {
        this.clanSistemaIdFk = clanSistemaIdFk;
    }

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

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public ClanSistema getClanSistema() {
        return clanSistema;
    }

    public void setClanSistema(ClanSistema clanSistema) {
        this.clanSistema = clanSistema;
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
        hash += (clanSistemaIdFk != null ? clanSistemaIdFk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.clanSistemaIdFk == null && other.clanSistemaIdFk != null) || (this.clanSistemaIdFk != null && !this.clanSistemaIdFk.equals(other.clanSistemaIdFk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Student[ clanSistemaIdFk=" + clanSistemaIdFk + " ]";
    }
    
}
