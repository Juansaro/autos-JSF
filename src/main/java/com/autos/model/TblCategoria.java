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
@Table(name = "tbl_categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCategoria.findAll", query = "SELECT t FROM TblCategoria t"),
    @NamedQuery(name = "TblCategoria.findByCatId", query = "SELECT t FROM TblCategoria t WHERE t.catId = :catId"),
    @NamedQuery(name = "TblCategoria.findByCatTipo", query = "SELECT t FROM TblCategoria t WHERE t.catTipo = :catTipo")})
public class TblCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "catId")
    private Integer catId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "catTipo")
    private String catTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catId")
    private List<TblVehiculo> tblVehiculoList;

    public TblCategoria() {
    }

    public TblCategoria(Integer catId) {
        this.catId = catId;
    }

    public TblCategoria(Integer catId, String catTipo) {
        this.catId = catId;
        this.catTipo = catTipo;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatTipo() {
        return catTipo;
    }

    public void setCatTipo(String catTipo) {
        this.catTipo = catTipo;
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
        hash += (catId != null ? catId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCategoria)) {
            return false;
        }
        TblCategoria other = (TblCategoria) object;
        if ((this.catId == null && other.catId != null) || (this.catId != null && !this.catId.equals(other.catId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.autos.model.TblCategoria[ catId=" + catId + " ]";
    }
    
}
