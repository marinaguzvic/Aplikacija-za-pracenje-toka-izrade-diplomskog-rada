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
public class NastavnikDTO extends ClanSistemaDTO{
   
    private String zvanje;
    private String titula;
    private String katedra;

    public NastavnikDTO() {
    }

    public NastavnikDTO(Long clanSistemaId, String brojTelefona, String ime, String prezime, String jmbg, Date datumRodjenja, String zvanje, String titula, String katedra) {
        this.clanSistemaId = clanSistemaId;
        this.brojTelefona = brojTelefona;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.datumRodjenja = datumRodjenja;
        this.zvanje = zvanje;
        this.titula = titula;
        this.katedra = katedra;
    }

    

    

    

    public String getZvanje() {
        return zvanje;
    }

    public void setZvanje(String zvanje) {
        this.zvanje = zvanje;
    }

    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }

    public String getKatedra() {
        return katedra;
    }

    public void setKatedra(String katedra) {
        this.katedra = katedra;
    }
    
    
}
