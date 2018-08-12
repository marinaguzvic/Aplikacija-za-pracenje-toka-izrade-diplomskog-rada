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
public class DiplomskiRadDatumOdbraneDTO {
    private Date datumOdbrane;

    public DiplomskiRadDatumOdbraneDTO() {
    }

    public DiplomskiRadDatumOdbraneDTO(Date datumOdbrane) {
        this.datumOdbrane = datumOdbrane;
    }
    
    public Date getDatumOdbrane() {
        return datumOdbrane;
    }

    public void setDatumOdbrane(Date datumOdbrane) {
        this.datumOdbrane = datumOdbrane;
    }
    
}
