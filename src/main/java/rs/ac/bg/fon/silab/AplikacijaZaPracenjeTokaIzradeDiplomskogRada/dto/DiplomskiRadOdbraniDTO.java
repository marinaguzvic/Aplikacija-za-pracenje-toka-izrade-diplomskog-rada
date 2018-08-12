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
public class DiplomskiRadOdbraniDTO {
    private Integer ocena;

    public DiplomskiRadOdbraniDTO() {
    }

    public DiplomskiRadOdbraniDTO( Integer ocena) {
        this.ocena = ocena;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }


    
    
}
