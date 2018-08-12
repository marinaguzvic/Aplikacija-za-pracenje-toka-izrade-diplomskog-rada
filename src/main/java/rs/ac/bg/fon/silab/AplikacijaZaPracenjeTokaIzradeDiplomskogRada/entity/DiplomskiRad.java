/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

/**
 *
 * @author Marina Guzvic
 */
@Entity
@Table(name = "diplomski_rad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiplomskiRad.findAll", query = "SELECT d FROM DiplomskiRad d")
    , @NamedQuery(name = "DiplomskiRad.findByDiplomskiRadId", query = "SELECT d FROM DiplomskiRad d WHERE d.diplomskiRadId = :diplomskiRadId")
    , @NamedQuery(name = "DiplomskiRad.findByDatumPrijave", query = "SELECT d FROM DiplomskiRad d WHERE d.datumPrijave = :datumPrijave")
    , @NamedQuery(name = "DiplomskiRad.findByDatumOdobravanja", query = "SELECT d FROM DiplomskiRad d WHERE d.datumOdobravanja = :datumOdobravanja")
    , @NamedQuery(name = "DiplomskiRad.findByDatumOdbrane", query = "SELECT d FROM DiplomskiRad d WHERE d.datumOdbrane = :datumOdbrane")
    , @NamedQuery(name = "DiplomskiRad.findByOcena", query = "SELECT d FROM DiplomskiRad d WHERE d.ocena = :ocena")
    , @NamedQuery(name = "DiplomskiRad.findByStatus", query = "SELECT d FROM DiplomskiRad d WHERE d.status = :status")})
public class DiplomskiRad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "diplomski_rad_id")
    private Long diplomskiRadId;
    @Column(name = "datum_prijave")
    @Temporal(TemporalType.DATE)
    private Date datumPrijave;
    @Column(name = "datum_odobravanja")
    @Temporal(TemporalType.DATE)
    private Date datumOdobravanja;
    @Column(name = "datum_odbrane")
    @Temporal(TemporalType.DATE)
    private Date datumOdbrane;
     @Column(name = "datum_predaje")
    @Temporal(TemporalType.DATE)
    private Date datumPredaje;
    @Column(name = "ocena")
    private Integer ocena;
    @Column(name = "status",length = 20)
    @Enumerated(EnumType.STRING)
    private EnumStatus status;
    @JoinColumn(name = "komisija_id_fk", referencedColumnName = "komisija_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Komisija komisijaIdFk;
    @JoinColumn(name = "student_id_fk", referencedColumnName = "clan_sistema_id")
    @OneToOne(optional = false)
    private Student studentIdFk;
    @JoinColumn(name = "tema_id_fk", referencedColumnName = "tema_id")
    @OneToOne(optional = false)
    private TemaDiplomskogRada temaIdFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diplomskiRad")
    @JsonBackReference(value = "dokumentCollection")
    private List<Dokument> dokumentCollection;

    public DiplomskiRad() {
    }

    public DiplomskiRad(Long diplomskiRadId) {
        this.diplomskiRadId = diplomskiRadId;
    }

    public Long getDiplomskiRadId() {
        return diplomskiRadId;
    }

    public void setDiplomskiRadId(Long diplomskiRadId) {
        this.diplomskiRadId = diplomskiRadId;
    }

    public Date getDatumPrijave() {
        return datumPrijave;
    }

    public void setDatumPrijave(Date datumPrijave) {
        this.datumPrijave = datumPrijave;
    }

    public Date getDatumOdobravanja() {
        return datumOdobravanja;
    }

    public void setDatumOdobravanja(Date datumOdobravanja) {
        this.datumOdobravanja = datumOdobravanja;
    }

    public Date getDatumOdbrane() {
        return datumOdbrane;
    }

    public void setDatumOdbrane(Date datumOdbrane) {
        this.datumOdbrane = datumOdbrane;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    public Komisija getKomisijaIdFk() {
        return komisijaIdFk;
    }

    public void setKomisijaIdFk(Komisija komisijaIdFk) {
        this.komisijaIdFk = komisijaIdFk;
    }

    public Student getStudentIdFk() {
        return studentIdFk;
    }

    public void setStudentIdFk(Student studentIdFk) {
        this.studentIdFk = studentIdFk;
    }

    public TemaDiplomskogRada getTemaIdFk() {
        return temaIdFk;
    }

    public void setTemaIdFk(TemaDiplomskogRada temaIdFk) {
        this.temaIdFk = temaIdFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diplomskiRadId != null ? diplomskiRadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiplomskiRad)) {
            return false;
        }
        DiplomskiRad other = (DiplomskiRad) object;
        if ((this.diplomskiRadId == null && other.diplomskiRadId != null) || (this.diplomskiRadId != null && !this.diplomskiRadId.equals(other.diplomskiRadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.DiplomskiRad[ diplomskiRadId=" + diplomskiRadId + " ]";
    }

    public Date getDatumPredaje() {
        return datumPredaje;
    }

    public void setDatumPredaje(Date datumPredaje) {
        this.datumPredaje = datumPredaje;
    }

    public List<Dokument> getDokumentCollection() {
        return dokumentCollection;
    }

    public void setDokumentCollection(List<Dokument> dokumentCollection) {
        this.dokumentCollection = dokumentCollection;
    }
    
}
