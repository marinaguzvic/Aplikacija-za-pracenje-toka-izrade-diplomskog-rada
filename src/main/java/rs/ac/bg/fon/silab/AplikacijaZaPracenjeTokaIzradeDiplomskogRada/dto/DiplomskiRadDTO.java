/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Marina Guzvic
 */
public class DiplomskiRadDTO {
    private Long diplomskiRadId;
    private Date datumPrijave;
    private Date datumOdobravanja;
    private Date datumOdbrane;
    private Date datumPredaje;
    private Integer ocena;
    private String status;
    private List<ClanKaKlijentuDTO> clans;
    private StudentDTO studentIdFk;
    private TemaDiplomskogRadaDTO temaIdFk;
    private List<String> dokuments;

    public DiplomskiRadDTO() {
    }

    public DiplomskiRadDTO(Long diplomskiRadId, Date datumPrijave, Date datumOdobravanja, Date datumOdbrane, Date datumPredaje, Integer ocena, String status, List<ClanKaKlijentuDTO> clans, StudentDTO studentIdFk, TemaDiplomskogRadaDTO temaIdFk, List<String> dokuments) {
        this.diplomskiRadId = diplomskiRadId;
        this.datumPrijave = datumPrijave;
        this.datumOdobravanja = datumOdobravanja;
        this.datumOdbrane = datumOdbrane;
        this.datumPredaje = datumPredaje;
        this.ocena = ocena;
        this.status = status;
        this.clans = clans;
        this.studentIdFk = studentIdFk;
        this.temaIdFk = temaIdFk;
        this.dokuments = dokuments;
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

    public Date getDatumPredaje() {
        return datumPredaje;
    }

    public void setDatumPredaje(Date datumPredaje) {
        this.datumPredaje = datumPredaje;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ClanKaKlijentuDTO> getClans() {
        return clans;
    }

    public void setClans(List<ClanKaKlijentuDTO> clans) {
        this.clans = clans;
    }

    public StudentDTO getStudentIdFk() {
        return studentIdFk;
    }

    public void setStudentIdFk(StudentDTO studentIdFk) {
        this.studentIdFk = studentIdFk;
    }

    public TemaDiplomskogRadaDTO getTemaIdFk() {
        return temaIdFk;
    }

    public void setTemaIdFk(TemaDiplomskogRadaDTO temaIdFk) {
        this.temaIdFk = temaIdFk;
    }

    public List<String> getDokuments() {
        return dokuments;
    }

    public void setDokuments(List<String> dokuments) {
        this.dokuments = dokuments;
    }
    
    
}
