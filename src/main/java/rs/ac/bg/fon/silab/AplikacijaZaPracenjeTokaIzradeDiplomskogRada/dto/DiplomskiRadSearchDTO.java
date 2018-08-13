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
public class DiplomskiRadSearchDTO {
    private String [] statuses;
    private String [] ulogaClanaKomisijes;
    private String imeStudenta;
    private String prezimeStudenta;
    private String brojIndeksa;
    private Long nastavnikId;
            

    public DiplomskiRadSearchDTO() {
    }

    public DiplomskiRadSearchDTO(String[] statuses, String[] ulogaClanaKomisijes, String imeStudenta, String prezimeStudenta, String brojIndeksa, Long nastavnikId) {
        this.statuses = statuses;
        this.ulogaClanaKomisijes = ulogaClanaKomisijes;
        this.imeStudenta = imeStudenta;
        this.prezimeStudenta = prezimeStudenta;
        this.brojIndeksa = brojIndeksa;
        this.nastavnikId = nastavnikId;
    }

    

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public String [] getStatuses() {
        return statuses;
    }

    public void setStatuses(String [] status) {
        this.statuses = status;
    }

    public String [] getUlogaClanaKomisijes() {
        return ulogaClanaKomisijes;
    }

    public void setUlogaClanaKomisijes(String [] ulogaClanaKomisije) {
        this.ulogaClanaKomisijes = ulogaClanaKomisije;
    }

    public String getImeStudenta() {
        return imeStudenta;
    }

    public void setImeStudenta(String imeStudenta) {
        this.imeStudenta = imeStudenta;
    }

    public String getPrezimeStudenta() {
        return prezimeStudenta;
    }

    public void setPrezimeStudenta(String prezimeStudenta) {
        this.prezimeStudenta = prezimeStudenta;
    }

    public Long getNastavnikId() {
        return nastavnikId;
    }

    public void setNastavnikId(Long nastavnikId) {
        this.nastavnikId = nastavnikId;
    }
    
    
}
