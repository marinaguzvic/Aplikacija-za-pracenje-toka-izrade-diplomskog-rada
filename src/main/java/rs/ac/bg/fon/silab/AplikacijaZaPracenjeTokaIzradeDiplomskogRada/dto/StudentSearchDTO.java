/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dto;

import java.util.Date;

/**
 *
 * @author Marina Guzvic
 */
public class StudentSearchDTO extends ClanSistemaDTO{
    private String brojIndeksa;
    private Integer [] godineStudija;

    public StudentSearchDTO() {
    }

    public StudentSearchDTO(String brojIndeksa, Integer[] godineStudija, Long clanSistemaId, String brojTelefona, String ime, String prezime, String jmbg, Date datumRodjenja, char tipClana) {
        super(clanSistemaId, brojTelefona, ime, prezime, jmbg, datumRodjenja, tipClana);
        this.brojIndeksa = brojIndeksa;
        this.godineStudija = godineStudija;
    }

    public Integer[] getGodineStudija() {
        return godineStudija;
    }

    public void setGodineStudija(Integer[] godineStudija) {
        this.godineStudija = godineStudija;
    }

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }
    
    
}
