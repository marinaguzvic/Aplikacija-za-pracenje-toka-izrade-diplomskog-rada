/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Marina Guzvic
 */
@Embeddable
public class ClanKomisijePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "komisija_id_fk",nullable = false)
    private Long komisijaIdFk;
    @Basic(optional = false)
    @Column(name = "clan_komisije_rb",nullable = false)
    private int clanKomisijeRb;

    public ClanKomisijePK() {
    }

    public ClanKomisijePK(Long komisijaIdFk, int clanKomisijeRb) {
        this.komisijaIdFk = komisijaIdFk;
        this.clanKomisijeRb = clanKomisijeRb;
    }

    public Long getKomisijaIdFk() {
        return komisijaIdFk;
    }

    public void setKomisijaIdFk(Long komisijaIdFk) {
        this.komisijaIdFk = komisijaIdFk;
    }

    public int getClanKomisijeRb() {
        return clanKomisijeRb;
    }

    public void setClanKomisijeRb(int clanKomisijeRb) {
        this.clanKomisijeRb = clanKomisijeRb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (long) komisijaIdFk;
        hash += (int) clanKomisijeRb;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClanKomisijePK)) {
            return false;
        }
        ClanKomisijePK other = (ClanKomisijePK) object;
        if (this.komisijaIdFk != other.komisijaIdFk) {
            return false;
        }
        if (this.clanKomisijeRb != other.clanKomisijeRb) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanKomisijePK[ komisijaIdFk=" + komisijaIdFk + ", clanKomisijeRb=" + clanKomisijeRb + " ]";
    }
    
}
