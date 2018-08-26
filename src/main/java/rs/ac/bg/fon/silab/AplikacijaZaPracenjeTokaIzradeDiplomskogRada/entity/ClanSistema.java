/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marina Guzvic
 */
@Entity
@Inheritance
@DiscriminatorColumn(name = "tip_clana")
@Table(name = "clan_sistema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClanSistema.findAll", query = "SELECT c FROM ClanSistema c")
    , @NamedQuery(name = "ClanSistema.findByClanSistemaId", query = "SELECT c FROM ClanSistema c WHERE c.clanSistemaId = :clanSistemaId")
    , @NamedQuery(name = "ClanSistema.findByBrojTelefona", query = "SELECT c FROM ClanSistema c WHERE c.brojTelefona = :brojTelefona")
    , @NamedQuery(name = "ClanSistema.findByIme", query = "SELECT c FROM ClanSistema c WHERE c.ime = :ime")
    , @NamedQuery(name = "ClanSistema.findByPrezime", query = "SELECT c FROM ClanSistema c WHERE c.prezime = :prezime")
    , @NamedQuery(name = "ClanSistema.findByJmbg", query = "SELECT c FROM ClanSistema c WHERE c.jmbg = :jmbg")
    , @NamedQuery(name = "ClanSistema.findByBrojRadneKnjizice", query = "SELECT c FROM ClanSistema c WHERE c.brojRadneKnjizice = :brojRadneKnjizice")})
public class ClanSistema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "clan_sistema_id")
    private Long clanSistemaId;
    @Column(name = "broj_telefona", length = 15)
    private String brojTelefona;
    @Column(name = "ime", length = 20)
    private String ime;
    @Column(name = "prezime", length = 20)
    private String prezime;
    @Column(name = "jmbg", length = 13)
    private String jmbg;
    @Column(name = "broj_radne_knjizice", length = 10)
    private String brojRadneKnjizice;
    @Column(name = "datum_rodjenja")
//    @Temporal(TemporalType.DATE)
    private LocalDate datumRodjenja;
    @Column(name = "tip_clana",insertable = false,updatable = false)
    private char tipClana;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "clanSistema")
    @JsonBackReference(value = "nalog")
    private Nalog nalog;

    public ClanSistema() {
    }

    public ClanSistema(Long clanSistemaId) {
        this.clanSistemaId = clanSistemaId;
    }

    public Long getClanSistemaId() {
        return clanSistemaId;
    }

    public void setClanSistemaId(Long clanSistemaId) {
        this.clanSistemaId = clanSistemaId;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getBrojRadneKnjizice() {
        return brojRadneKnjizice;
    }

    public void setBrojRadneKnjizice(String brojRadneKnjizice) {
        this.brojRadneKnjizice = brojRadneKnjizice;
    }

   

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    

    public Nalog getNalog() {
        return nalog;
    }

    public void setNalog(Nalog nalog) {
        this.nalog = nalog;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clanSistemaId != null ? clanSistemaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClanSistema)) {
            return false;
        }
        ClanSistema other = (ClanSistema) object;
        if ((this.clanSistemaId == null && other.clanSistemaId != null) || (this.clanSistemaId != null && !this.clanSistemaId.equals(other.clanSistemaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanSistema[ clanSistemaId=" + clanSistemaId + " ]";
    }

    public char getTipClana() {
        return tipClana;
    }

    public void setTipClana(char tipClana) {
        this.tipClana = tipClana;
    }

}
