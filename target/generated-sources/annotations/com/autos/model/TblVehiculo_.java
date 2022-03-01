package com.autos.model;

import com.autos.model.TblCategoria;
import com.autos.model.TblDatospersonales;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-02-28T21:26:52")
@StaticMetamodel(TblVehiculo.class)
public class TblVehiculo_ { 

    public static volatile SingularAttribute<TblVehiculo, String> vehMarca;
    public static volatile SingularAttribute<TblVehiculo, TblCategoria> catId;
    public static volatile SingularAttribute<TblVehiculo, String> vehModelo;
    public static volatile SingularAttribute<TblVehiculo, String> vehPlaca;
    public static volatile SingularAttribute<TblVehiculo, Short> vehEstado;
    public static volatile SingularAttribute<TblVehiculo, Integer> vehPrecio;
    public static volatile SingularAttribute<TblVehiculo, TblDatospersonales> datId;

}