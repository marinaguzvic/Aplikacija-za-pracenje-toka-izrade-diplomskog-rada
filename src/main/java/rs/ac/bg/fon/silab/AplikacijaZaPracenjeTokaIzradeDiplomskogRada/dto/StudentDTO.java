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
public class StudentDTO extends ClanSistemaDTO{

    private String brojIndeksa;
    private Integer godinaStudija;

    public StudentDTO() {
    }

    public StudentDTO(Long clanSistemaId, String brojTelefona, String ime, String prezime, String jmbg, Date datumRodjenja, String brojIndeksa, Integer godinaStudija) {
        this.clanSistemaId = clanSistemaId;
        this.brojTelefona = brojTelefona;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.datumRodjenja = datumRodjenja;
        this.brojIndeksa = brojIndeksa;
        this.godinaStudija = godinaStudija;
    }

    

 

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public Integer getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(Integer godinaStudija) {
        this.godinaStudija = godinaStudija;
    }
    
    
}
