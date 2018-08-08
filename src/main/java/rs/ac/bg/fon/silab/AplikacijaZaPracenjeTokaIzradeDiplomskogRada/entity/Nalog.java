/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marina Guzvic
 */
@Entity
@Table(name = "nalog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nalog.findAll", query = "SELECT n FROM Nalog n")
    , @NamedQuery(name = "Nalog.findByClanSistemaIdFk", query = "SELECT n FROM Nalog n WHERE n.clanSistemaIdFk = :clanSistemaIdFk")
    , @NamedQuery(name = "Nalog.findByKorisnickoIme", query = "SELECT n FROM Nalog n WHERE n.korisnickoIme = :korisnickoIme")
    , @NamedQuery(name = "Nalog.findBySifra", query = "SELECT n FROM Nalog n WHERE n.sifra = :sifra")})
public class Nalog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "clan_sistema_id_fk",nullable = false)
    private Long clanSistemaIdFk;
    @Column(name = "korisnicko_ime",length = 50)
    private String korisnickoIme;
    @Column(name = "sifra",length = 50)
    private String sifra;
    @JoinColumn(name = "clan_sistema_id_fk", referencedColumnName = "clan_sistema_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ClanSistema clanSistema;

    public Nalog() {
    }

    public Nalog(Long clanSistemaIdFk) {
        this.clanSistemaIdFk = clanSistemaIdFk;
    }

    public Long getClanSistemaIdFk() {
        return clanSistemaIdFk;
    }

    public void setClanSistemaIdFk(Long clanSistemaIdFk) {
        this.clanSistemaIdFk = clanSistemaIdFk;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public ClanSistema getClanSistema() {
        return clanSistema;
    }

    public void setClanSistema(ClanSistema clanSistema) {
        this.clanSistema = clanSistema;
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
        if (!(object instanceof Nalog)) {
            return false;
        }
        Nalog other = (Nalog) object;
        if ((this.clanSistemaIdFk == null && other.clanSistemaIdFk != null) || (this.clanSistemaIdFk != null && !this.clanSistemaIdFk.equals(other.clanSistemaIdFk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Nalog[ clanSistemaIdFk=" + clanSistemaIdFk + " ]";
    }
    
}
