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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marina Guzvic
 */
@Entity
@Table(name = "radnik_u_studentskoj_sluzbi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RadnikUStudentskojSluzbi.findAll", query = "SELECT r FROM RadnikUStudentskojSluzbi r")
    , @NamedQuery(name = "RadnikUStudentskojSluzbi.findByClanSistemaIdFk", query = "SELECT r FROM RadnikUStudentskojSluzbi r WHERE r.clanSistemaIdFk = :clanSistemaIdFk")})
public class RadnikUStudentskojSluzbi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "clan_sistema_id_fk",nullable = false)
    private Long clanSistemaIdFk;
    @JoinColumn(name = "clan_sistema_id_fk", referencedColumnName = "clan_sistema_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ClanSistema clanSistema;

    public RadnikUStudentskojSluzbi() {
    }

    public RadnikUStudentskojSluzbi(Long clanSistemaIdFk) {
        this.clanSistemaIdFk = clanSistemaIdFk;
    }

    public Long getClanSistemaIdFk() {
        return clanSistemaIdFk;
    }

    public void setClanSistemaIdFk(Long clanSistemaIdFk) {
        this.clanSistemaIdFk = clanSistemaIdFk;
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
        if (!(object instanceof RadnikUStudentskojSluzbi)) {
            return false;
        }
        RadnikUStudentskojSluzbi other = (RadnikUStudentskojSluzbi) object;
        if ((this.clanSistemaIdFk == null && other.clanSistemaIdFk != null) || (this.clanSistemaIdFk != null && !this.clanSistemaIdFk.equals(other.clanSistemaIdFk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.RadnikUStudentskojSluzbi[ clanSistemaIdFk=" + clanSistemaIdFk + " ]";
    }
    
}
