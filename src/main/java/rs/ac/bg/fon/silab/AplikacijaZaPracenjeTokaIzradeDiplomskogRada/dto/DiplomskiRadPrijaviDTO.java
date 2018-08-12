/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dto;

import java.util.Date;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.EnumStatus;

/**
 *
 * @author Marina Guzvic
 */
public class DiplomskiRadPrijaviDTO {
    private Long studentIdFk;
    private Long temaIdFk;

    public DiplomskiRadPrijaviDTO() {
    }

    public DiplomskiRadPrijaviDTO(Long diplomskiRadId, Long studentIdFk, Long temaIdFk) {
        this.studentIdFk = studentIdFk;
        this.temaIdFk = temaIdFk;
    }



    

    public Long getStudentIdFk() {
        return studentIdFk;
    }

    public void setStudentIdFk(Long studentIdFk) {
        this.studentIdFk = studentIdFk;
    }

    public Long getTemaIdFk() {
        return temaIdFk;
    }

    public void setTemaIdFk(Long temaIdFk) {
        this.temaIdFk = temaIdFk;
    }
    
    
}
