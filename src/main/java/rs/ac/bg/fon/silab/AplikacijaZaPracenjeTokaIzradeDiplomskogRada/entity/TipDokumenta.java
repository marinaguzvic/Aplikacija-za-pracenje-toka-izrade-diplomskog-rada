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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tip_dokumenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipDokumenta.findAll", query = "SELECT t FROM TipDokumenta t")
    , @NamedQuery(name = "TipDokumenta.findByTipDokumentaId", query = "SELECT t FROM TipDokumenta t WHERE t.tipDokumentaId = :tipDokumentaId")
    , @NamedQuery(name = "TipDokumenta.findByNazivTipaDokumenta", query = "SELECT t FROM TipDokumenta t WHERE t.nazivTipaDokumenta = :nazivTipaDokumenta")})
public class TipDokumenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tip_dokumenta_id")
    private Long tipDokumentaId;
    @Column(name = "naziv_tipa_dokumenta",length = 20)
    private String nazivTipaDokumenta;

    public TipDokumenta() {
    }

    public TipDokumenta(Long tipDokumentaId) {
        this.tipDokumentaId = tipDokumentaId;
    }

    public Long getTipDokumentaId() {
        return tipDokumentaId;
    }

    public void setTipDokumentaId(Long tipDokumentaId) {
        this.tipDokumentaId = tipDokumentaId;
    }

    public String getNazivTipaDokumenta() {
        return nazivTipaDokumenta;
    }

    public void setNazivTipaDokumenta(String nazivTipaDokumenta) {
        this.nazivTipaDokumenta = nazivTipaDokumenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipDokumentaId != null ? tipDokumentaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipDokumenta)) {
            return false;
        }
        TipDokumenta other = (TipDokumenta) object;
        if ((this.tipDokumentaId == null && other.tipDokumentaId != null) || (this.tipDokumentaId != null && !this.tipDokumentaId.equals(other.tipDokumentaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.TipDokumenta[ tipDokumentaId=" + tipDokumentaId + " ]";
    }
    
}
