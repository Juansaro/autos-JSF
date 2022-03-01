/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autos.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juan
 */
@Entity
@Table(name = "tbl_datospersonales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDatospersonales.findAll", query = "SELECT t FROM TblDatospersonales t"),
    @NamedQuery(name = "TblDatospersonales.findByDatId", query = "SELECT t FROM TblDatospersonales t WHERE t.datId = :datId"),
    @NamedQuery(name = "TblDatospersonales.findByDatNombre", query = "SELECT t FROM TblDatospersonales t WHERE t.datNombre = :datNombre"),
    @NamedQuery(name = "TblDatospersonales.findByDatApellido", query = "SELECT t FROM TblDatospersonales t WHERE t.datApellido = :datApellido"),
    @NamedQuery(name = "TblDatospersonales.findByDatTipoId", query = "SELECT t FROM TblDatospersonales t WHERE t.datTipoId = :datTipoId"),
    @NamedQuery(name = "TblDatospersonales.findByDatNumeroId", query = "SELECT t FROM TblDatospersonales t WHERE t.datNumeroId = :datNumeroId"),
    @NamedQuery(name = "TblDatospersonales.findByDatTelefono", query = "SELECT t FROM TblDatospersonales t WHERE t.datTelefono = :datTelefono"),
    @NamedQuery(name = "TblDatospersonales.findByDatCorreo", query = "SELECT t FROM TblDatospersonales t WHERE t.datCorreo = :datCorreo")})
public class TblDatospersonales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "datId")
    private Integer datId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "datNombre")
    private String datNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "datApellido")
    private String datApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "datTipoId")
    private String datTipoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "datNumeroId")
    private String datNumeroId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "datTelefono")
    private String datTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "datCorreo")
    private String datCorreo;
    @JoinColumn(name = "usuId", referencedColumnName = "usuId")
    @ManyToOne(optional = false)
    private TblUsuario usuId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datId")
    private List<TblVehiculo> tblVehiculoList;

    public TblDatospersonales() {
    }

    public TblDatospersonales(Integer datId) {
        this.datId = datId;
    }

    public TblDatospersonales(Integer datId, String datNombre, String datApellido, String datTipoId, String datNumeroId, String datTelefono, String datCorreo) {
        this.datId = datId;
        this.datNombre = datNombre;
        this.datApellido = datApellido;
        this.datTipoId = datTipoId;
        this.datNumeroId = datNumeroId;
        this.datTelefono = datTelefono;
        this.datCorreo = datCorreo;
    }

    public Integer getDatId() {
        return datId;
    }

    public void setDatId(Integer datId) {
        this.datId = datId;
    }

    public String getDatNombre() {
        return datNombre;
    }

    public void setDatNombre(String datNombre) {
        this.datNombre = datNombre;
    }

    public String getDatApellido() {
        return datApellido;
    }

    public void setDatApellido(String datApellido) {
        this.datApellido = datApellido;
    }

    public String getDatTipoId() {
        return datTipoId;
    }

    public void setDatTipoId(String datTipoId) {
        this.datTipoId = datTipoId;
    }

    public String getDatNumeroId() {
        return datNumeroId;
    }

    public void setDatNumeroId(String datNumeroId) {
        this.datNumeroId = datNumeroId;
    }

    public String getDatTelefono() {
        return datTelefono;
    }

    public void setDatTelefono(String datTelefono) {
        this.datTelefono = datTelefono;
    }

    public String getDatCorreo() {
        return datCorreo;
    }

    public void setDatCorreo(String datCorreo) {
        this.datCorreo = datCorreo;
    }

    public TblUsuario getUsuId() {
        return usuId;
    }

    public void setUsuId(TblUsuario usuId) {
        this.usuId = usuId;
    }

    @XmlTransient
    public List<TblVehiculo> getTblVehiculoList() {
        return tblVehiculoList;
    }

    public void setTblVehiculoList(List<TblVehiculo> tblVehiculoList) {
        this.tblVehiculoList = tblVehiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datId != null ? datId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDatospersonales)) {
            return false;
        }
        TblDatospersonales other = (TblDatospersonales) object;
        if ((this.datId == null && other.datId != null) || (this.datId != null && !this.datId.equals(other.datId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.autos.model.TblDatospersonales[ datId=" + datId + " ]";
    }
    
}
