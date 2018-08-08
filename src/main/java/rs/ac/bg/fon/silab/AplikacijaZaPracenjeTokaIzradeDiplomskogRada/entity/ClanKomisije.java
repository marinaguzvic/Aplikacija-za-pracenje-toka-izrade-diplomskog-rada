/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marina Guzvic
 */
@Entity
@Table(name = "clan_komisije")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClanKomisije.findAll", query = "SELECT c FROM ClanKomisije c")
    , @NamedQuery(name = "ClanKomisije.findByKomisijaIdFk", query = "SELECT c FROM ClanKomisije c WHERE c.clanKomisijePK.komisijaIdFk = :komisijaIdFk")
    , @NamedQuery(name = "ClanKomisije.findByClanKomisijeRb", query = "SELECT c FROM ClanKomisije c WHERE c.clanKomisijePK.clanKomisijeRb = :clanKomisijeRb")
    , @NamedQuery(name = "ClanKomisije.findByUlogaClanaKomisije", query = "SELECT c FROM ClanKomisije c WHERE c.ulogaClanaKomisije = :ulogaClanaKomisije")})
public class ClanKomisije implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClanKomisijePK clanKomisijePK;
    @Column(name = "uloga_clana_komisije",length = 10)
    private String ulogaClanaKomisije;
    @JoinColumn(name = "nastavnik_id_fk", referencedColumnName = "korisnik_sistema_id_fk")
    @ManyToOne
    private Nastavnik nastavnikIdFk;
    @JoinColumn(name = "komisija_id_fk", referencedColumnName = "komisija_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Komisija komisija;

    public ClanKomisije() {
    }

    public ClanKomisije(ClanKomisijePK clanKomisijePK) {
        this.clanKomisijePK = clanKomisijePK;
    }

    public ClanKomisije(long komisijaIdFk, int clanKomisijeRb) {
        this.clanKomisijePK = new ClanKomisijePK(komisijaIdFk, clanKomisijeRb);
    }

    public ClanKomisijePK getClanKomisijePK() {
        return clanKomisijePK;
    }

    public void setClanKomisijePK(ClanKomisijePK clanKomisijePK) {
        this.clanKomisijePK = clanKomisijePK;
    }

    public String getUlogaClanaKomisije() {
        return ulogaClanaKomisije;
    }

    public void setUlogaClanaKomisije(String ulogaClanaKomisije) {
        this.ulogaClanaKomisije = ulogaClanaKomisije;
    }

    public Nastavnik getNastavnikIdFk() {
        return nastavnikIdFk;
    }

    public void setNastavnikIdFk(Nastavnik nastavnikIdFk) {
        this.nastavnikIdFk = nastavnikIdFk;
    }

    public Komisija getKomisija() {
        return komisija;
    }

    public void setKomisija(Komisija komisija) {
        this.komisija = komisija;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clanKomisijePK != null ? clanKomisijePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClanKomisije)) {
            return false;
        }
        ClanKomisije other = (ClanKomisije) object;
        if ((this.clanKomisijePK == null && other.clanKomisijePK != null) || (this.clanKomisijePK != null && !this.clanKomisijePK.equals(other.clanKomisijePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanKomisije[ clanKomisijePK=" + clanKomisijePK + " ]";
    }
    
}
