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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author juan
 */
@Stateless
public class TblVehiculoFacade extends AbstractFacade<TblVehiculo> implements TblVehiculoFacadeLocal {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblVehiculoFacade() {
        super(TblVehiculo.class);
    }
    
    @Override
    public boolean registrarVehiculo(TblVehiculo vehIn, Short estadoIn, int fk_categoria, TblDatospersonales fk_datospersonales) {
        try {
            Query qr = em.createNativeQuery("INSERT INTO tbl_vehiculo (vehPlaca, vehModelo, vehMarca, vehEstado, vehPrecio, catId, datId) VALUES (?, ?, ?, ?, ?, ?, ?)");
            qr.setParameter(1, vehIn.getVehPlaca());
            qr.setParameter(2, vehIn.getVehModelo());
            qr.setParameter(3, vehIn.getVehMarca());
            qr.setParameter(4, estadoIn);
            qr.setParameter(5, vehIn.getVehPrecio());
            qr.setParameter(6, fk_categoria);
            qr.setParameter(7, fk_datospersonales.getDatId());
            qr.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public List<TblVehiculo> filtrarVehiculosCategoria(TblCategoria catIn) {
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            Query qt = em.createQuery("SELECT u FROM TblVehiculo u WHERE u.catId = :c");
            qt.setParameter("c", catIn);
            return qt.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
/*
    @Override
    public boolean actualizarReserva(Reserva resIn,int fk_estado) {
        try {
            Query qr = em.createNativeQuery("UPDATE reserva SET fk_estado = ? WHERE (id_reserva = ?)");
            qr.setParameter(1, fk_estado);
            qr.setParameter(2, resIn.getIdReserva());
            qr.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }*/
    
}
