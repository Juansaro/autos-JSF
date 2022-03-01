/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autos.ejb;

import com.autos.model.TblCategoria;
import com.autos.model.TblDatospersonales;
import com.autos.model.TblVehiculo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author juan
 */
@Local
public interface TblVehiculoFacadeLocal {

    void create(TblVehiculo tblVehiculo);

    void edit(TblVehiculo tblVehiculo);

    void remove(TblVehiculo tblVehiculo);

    TblVehiculo find(Object id);

    List<TblVehiculo> findAll();

    List<TblVehiculo> findRange(int[] range);

    int count();

    public boolean registrarVehiculo(TblVehiculo vehIn, Short estadoIn, int fk_categoria, TblDatospersonales fk_datospersonales);

    public List<TblVehiculo> filtrarVehiculosCategoria(TblCategoria catIn);
    
}
