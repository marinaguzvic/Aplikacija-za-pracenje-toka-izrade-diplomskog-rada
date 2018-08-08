/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marina Guzvic
 */
@Entity
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
    @Column(name = "broj_telefona",length = 15)
    private String brojTelefona;
    @Column(name = "ime",length = 20)
    private String ime;
    @Column(name = "prezime",length = 20)
    private String prezime;
    @Column(name = "jmbg",length = 13)
    private String jmbg;
    @Column(name = "broj_radne_knjizice",length = 10)
    private String brojRadneKnjizice;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "clanSistema")
    @JsonBackReference(value = "nastavnik")
    private Nastavnik nastavnik;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "clanSistema")
    @JsonBackReference(value = "radnik")
    private RadnikUStudentskojSluzbi radnikUStudentskojSluzbi;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "clanSistema")
    @JsonBackReference(value = "student")
    private Student student;
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

    public Nastavnik getNastavnik() {
        return nastavnik;
    }

    public void setNastavnik(Nastavnik nastavnik) {
        this.nastavnik = nastavnik;
    }

    public RadnikUStudentskojSluzbi getRadnikUStudentskojSluzbi() {
        return radnikUStudentskojSluzbi;
    }

    public void setRadnikUStudentskojSluzbi(RadnikUStudentskojSluzbi radnikUStudentskojSluzbi) {
        this.radnikUStudentskojSluzbi = radnikUStudentskojSluzbi;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
    
}
