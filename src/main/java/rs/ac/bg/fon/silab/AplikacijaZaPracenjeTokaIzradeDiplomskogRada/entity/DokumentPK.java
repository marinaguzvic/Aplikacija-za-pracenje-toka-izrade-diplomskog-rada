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
public class DokumentPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "diplomski_rad_id_fk",nullable = false)
    private long diplomskiRadIdFk;
    @Basic(optional = false)
    @Column(name = "dokument_rb",nullable = false)
    private int dokumentRb;

    public DokumentPK() {
    }

    public DokumentPK(long diplomskiRadIdFk, int dokumentRb) {
        this.diplomskiRadIdFk = diplomskiRadIdFk;
        this.dokumentRb = dokumentRb;
    }


    public long getDiplomskiRadIdFk() {
        return diplomskiRadIdFk;
    }

    public void setDiplomskiRadIdFk(long diplomskiRadIdFk) {
        this.diplomskiRadIdFk = diplomskiRadIdFk;
    }

    public int getDokumentRb() {
        return dokumentRb;
    }

    public void setDokumentRb(int dokumentRb) {
        this.dokumentRb = dokumentRb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) diplomskiRadIdFk;
        hash += (int) dokumentRb;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DokumentPK)) {
            return false;
        }
        DokumentPK other = (DokumentPK) object;
        if (this.diplomskiRadIdFk != other.diplomskiRadIdFk) {
            return false;
        }
        if (this.dokumentRb != other.dokumentRb) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.DokumentPK[ diplomskiRadIdFk=" + diplomskiRadIdFk + ", dokumentRb=" + dokumentRb + " ]";
    }
    
}
