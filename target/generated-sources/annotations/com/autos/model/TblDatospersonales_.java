package com.autos.model;

import com.autos.model.TblUsuario;
import com.autos.model.TblVehiculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-02-28T21:26:52")
@StaticMetamodel(TblDatospersonales.class)
public class TblDatospersonales_ { 

    public static volatile ListAttribute<TblDatospersonales, TblVehiculo> tblVehiculoList;
    public static volatile SingularAttribute<TblDatospersonales, TblUsuario> usuId;
    public static volatile SingularAttribute<TblDatospersonales, String> datApellido;
    public static volatile SingularAttribute<TblDatospersonales, String> datTipoId;
    public static volatile SingularAttribute<TblDatospersonales, String> datTelefono;
    public static volatile SingularAttribute<TblDatospersonales, String> datNombre;
    public static volatile SingularAttribute<TblDatospersonales, String> datNumeroId;
    public static volatile SingularAttribute<TblDatospersonales, String> datCorreo;
    public static volatile SingularAttribute<TblDatospersonales, Integer> datId;

}