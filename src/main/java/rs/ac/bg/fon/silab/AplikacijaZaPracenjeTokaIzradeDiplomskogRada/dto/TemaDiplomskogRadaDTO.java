/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dto;

/**
 *
 * @author Marina Guzvic
 */
public class TemaDiplomskogRadaDTO {
    private Long temaId;
    private String nazivTeme;
    private String opisTeme;
    private PredmetDTO predmetIdFk;

    public TemaDiplomskogRadaDTO() {
    }

    public TemaDiplomskogRadaDTO(Long temaId, String nazivTeme, String opisTeme, PredmetDTO predmet) {
        this.temaId = temaId;
        this.nazivTeme = nazivTeme;
        this.opisTeme = opisTeme;
        this.predmetIdFk = predmet;
    }
    
    

    public Long getTemaId() {
        return temaId;
    }

    public void setTemaId(Long temaId) {
        this.temaId = temaId;
    }

    public String getNazivTeme() {
        return nazivTeme;
    }

    public void setNazivTeme(String nazivTeme) {
        this.nazivTeme = nazivTeme;
    }

    public String getOpisTeme() {
        return opisTeme;
    }

    public void setOpisTeme(String opisTeme) {
        this.opisTeme = opisTeme;
    }

    public PredmetDTO getPredmetIdFk() {
        return predmetIdFk;
    }

    public void setPredmetIdFk(PredmetDTO predmetIdFk) {
        this.predmetIdFk = predmetIdFk;
    }
    
    
}
