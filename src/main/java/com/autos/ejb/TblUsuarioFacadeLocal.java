/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autos.ejb;

import com.autos.model.TblUsuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author juan
 */
@Local
public interface TblUsuarioFacadeLocal {

    void create(TblUsuario tblUsuario);

    void edit(TblUsuario tblUsuario);

    void remove(TblUsuario tblUsuario);

    TblUsuario find(Object id);

    List<TblUsuario> findAll();

    List<TblUsuario> findRange(int[] range);

    int count();

    public TblUsuario encontrarUsuarioDocumento(String login);
    
}
