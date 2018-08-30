/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.service;

import java.util.List;
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;

/**
 *
 * @author Marina Guzvic
 */
public abstract class AbstractService {
    public abstract List<AbstractDTO> getAll(String [] ids) throws Exception;
    public abstract AbstractDTO get(String [] ids) throws Exception;
    public abstract AbstractDTO add(AbstractDTO dto,String [] ids) throws Exception;
    public abstract AbstractDTO update(AbstractDTO dto,String [] ids) throws Exception;
    public abstract AbstractDTO delete(String [] ids) throws Exception;
    public abstract List<AbstractDTO> search(AbstractDTO search) throws Exception;
}
