/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autos.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juan
 */
@Entity
@Table(name = "tbl_vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblVehiculo.findAll", query = "SELECT t FROM TblVehiculo t"),
    @NamedQuery(name = "TblVehiculo.findByVehPlaca", query = "SELECT t FROM TblVehiculo t WHERE t.vehPlaca = :vehPlaca"),
    @NamedQuery(name = "TblVehiculo.findByVehModelo", query = "SELECT t FROM TblVehiculo t WHERE t.vehModelo = :vehModelo"),
    @NamedQuery(name = "TblVehiculo.findByVehMarca", query = "SELECT t FROM TblVehiculo t WHERE t.vehMarca = :vehMarca"),
    @NamedQuery(name = "TblVehiculo.findByVehEstado", query = "SELECT t FROM TblVehiculo t WHERE t.vehEstado = :vehEstado"),
    @NamedQuery(name = "TblVehiculo.findByVehPrecio", query = "SELECT t FROM TblVehiculo t WHERE t.vehPrecio = :vehPrecio")})
public class TblVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "vehPlaca")
    private String vehPlaca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "vehModelo")
    private String vehModelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "vehMarca")
    private String vehMarca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vehEstado")
    private short vehEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vehPrecio")
    private int vehPrecio;
    @JoinColumn(name = "catId", referencedColumnName = "catId")
    @ManyToOne(optional = false)
    private TblCategoria catId;
    @JoinColumn(name = "datId", referencedColumnName = "datId")
    @ManyToOne(optional = false)
    private TblDatospersonales datId;

    public TblVehiculo() {
    }

    public TblVehiculo(String vehPlaca) {
        this.vehPlaca = vehPlaca;
    }

    public TblVehiculo(String vehPlaca, String vehModelo, String vehMarca, short vehEstado, int vehPrecio) {
        this.vehPlaca = vehPlaca;
        this.vehModelo = vehModelo;
        this.vehMarca = vehMarca;
        this.vehEstado = vehEstado;
        this.vehPrecio = vehPrecio;
    }

    public String getVehPlaca() {
        return vehPlaca;
    }

    public void setVehPlaca(String vehPlaca) {
        this.vehPlaca = vehPlaca;
    }

    public String getVehModelo() {
        return vehModelo;
    }

    public void setVehModelo(String vehModelo) {
        this.vehModelo = vehModelo;
    }

    public String getVehMarca() {
        return vehMarca;
    }

    public void setVehMarca(String vehMarca) {
        this.vehMarca = vehMarca;
    }

    public short getVehEstado() {
        return vehEstado;
    }

    public void setVehEstado(short vehEstado) {
        this.vehEstado = vehEstado;
    }

    public int getVehPrecio() {
        return vehPrecio;
    }

    public void setVehPrecio(int vehPrecio) {
        this.vehPrecio = vehPrecio;
    }

    public TblCategoria getCatId() {
        return catId;
    }

    public void setCatId(TblCategoria catId) {
        this.catId = catId;
    }

    public TblDatospersonales getDatId() {
        return datId;
    }

    public void setDatId(TblDatospersonales datId) {
        this.datId = datId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehPlaca != null ? vehPlaca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblVehiculo)) {
            return false;
        }
        TblVehiculo other = (TblVehiculo) object;
        if ((this.vehPlaca == null && other.vehPlaca != null) || (this.vehPlaca != null && !this.vehPlaca.equals(other.vehPlaca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.autos.model.TblVehiculo[ vehPlaca=" + vehPlaca + " ]";
    }
    
}
