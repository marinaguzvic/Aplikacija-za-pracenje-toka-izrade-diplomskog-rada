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
import javax.persistence.Lob;
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
@Table(name = "dokument")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dokument.findAll", query = "SELECT d FROM Dokument d")
    , @NamedQuery(name = "Dokument.findByDiplomskiRadIdFk", query = "SELECT d FROM Dokument d WHERE d.dokumentPK.diplomskiRadIdFk = :diplomskiRadIdFk")
    , @NamedQuery(name = "Dokument.findByDokumentRb", query = "SELECT d FROM Dokument d WHERE d.dokumentPK.dokumentRb = :dokumentRb")
    , @NamedQuery(name = "Dokument.findByNazivDokumenta", query = "SELECT d FROM Dokument d WHERE d.nazivDokumenta = :nazivDokumenta")})
public class Dokument implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DokumentPK dokumentPK;
    @Column(name = "naziv_dokumenta",length = 50)
    private String nazivDokumenta;
    @Lob
    @Column(name = "sadrzaj_dokumenta")
    private byte[] sadrzajDokumenta;

    public Dokument() {
    }

    public Dokument(DokumentPK dokumentPK) {
        this.dokumentPK = dokumentPK;
    }

    public Dokument(long diplomskiRadIdFk, int dokumentRb) {
        this.dokumentPK = new DokumentPK(diplomskiRadIdFk, dokumentRb);
    }

    public DokumentPK getDokumentPK() {
        return dokumentPK;
    }

    public void setDokumentPK(DokumentPK dokumentPK) {
        this.dokumentPK = dokumentPK;
    }

    public String getNazivDokumenta() {
        return nazivDokumenta;
    }

    public void setNazivDokumenta(String nazivDokumenta) {
        this.nazivDokumenta = nazivDokumenta;
    }

    public byte[] getSadrzajDokumenta() {
        return sadrzajDokumenta;
    }

    public void setSadrzajDokumenta(byte[] sadrzajDokumenta) {
        this.sadrzajDokumenta = sadrzajDokumenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dokumentPK != null ? dokumentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dokument)) {
            return false;
        }
        Dokument other = (Dokument) object;
        if ((this.dokumentPK == null && other.dokumentPK != null) || (this.dokumentPK != null && !this.dokumentPK.equals(other.dokumentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Dokument[ dokumentPK=" + dokumentPK + " ]";
    }
    
}
