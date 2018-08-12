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
public class ClanSistemaDTO {
     protected Long clanSistemaId;
    protected String brojTelefona;
    protected String ime;
    protected String prezime;
    protected String jmbg;
    protected Date datumRodjenja;
    protected char tipClana;

    public ClanSistemaDTO() {
    }

    public ClanSistemaDTO(Long clanSistemaId, String brojTelefona, String ime, String prezime, String jmbg, Date datumRodjenja, char tipClana) {
        this.clanSistemaId = clanSistemaId;
        this.brojTelefona = brojTelefona;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.datumRodjenja = datumRodjenja;
        this.tipClana = tipClana;
    }
    
    
    
    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Long getClanSistemaId() {
        return clanSistemaId;
    }

    public void setClanSistemaId(Long clanSistemaId) {
        this.clanSistemaId = clanSistemaId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public char getTipClana() {
        return tipClana;
    }

    public void setTipClana(char tipClana) {
        this.tipClana = tipClana;
    }
}
