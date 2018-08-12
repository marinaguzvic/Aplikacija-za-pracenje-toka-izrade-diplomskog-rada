/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marina Guzvic
 */
 @Entity
    @DiscriminatorValue("R")
@XmlRootElement
public class Radnik extends ClanSistema{
      @Column(name = "radno_mesto",length = 20)
    private String radnoMesto;

    public Radnik() {
    }

    public Radnik(String radnoMesto) {
        this.radnoMesto = radnoMesto;
    }

    public Radnik(String radnoMesto, Long clanSistemaId) {
        super(clanSistemaId);
        this.radnoMesto = radnoMesto;
    }

    public String getRadnoMesto() {
        return radnoMesto;
    }

    public void setRadnoMesto(String radnoMesto) {
        this.radnoMesto = radnoMesto;
    }
      
      
}
