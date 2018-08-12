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
public class ClanDTO {
    private String ulogaClanaKomisije;
    private Long nastavnik;

    public ClanDTO() {
    }

    public ClanDTO(String ulogaClanaKomisije, Long nastavnik) {
        this.ulogaClanaKomisije = ulogaClanaKomisije;
        this.nastavnik = nastavnik;
    }



    public Long getNastavnik() {
        return nastavnik;
    }

    public void setNastavnik(Long nastavnik) {
        this.nastavnik = nastavnik;
    }

    public String getUlogaClanaKomisije() {
        return ulogaClanaKomisije;
    }

    public void setUlogaClanaKomisije(String ulogaClanaKomisije) {
        this.ulogaClanaKomisije = ulogaClanaKomisije;
    }
    
    
}
