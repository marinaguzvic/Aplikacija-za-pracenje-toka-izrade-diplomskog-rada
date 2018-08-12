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
public class PredmetDTO {
    private Long predmetId;
    private String nazivPredmeta;
    private String katedra;

    public PredmetDTO() {
    }

    public PredmetDTO(Long predmetId, String nazivPredmeta, String katedra) {
        this.predmetId = predmetId;
        this.nazivPredmeta = nazivPredmeta;
        this.katedra = katedra;
    }

    

    public Long getPredmetId() {
        return predmetId;
    }

    public void setPredmetId(Long predmetId) {
        this.predmetId = predmetId;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public String getKatedra() {
        return katedra;
    }

    public void setKatedra(String katedra) {
        this.katedra = katedra;
    }
    
    
}
