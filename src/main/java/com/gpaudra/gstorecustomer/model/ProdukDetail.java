/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gpaudra.gstorecustomer.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gesang Paudra Jaya
 */
@Entity
@Table(name = "produk_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdukDetail.findAll", query = "SELECT p FROM ProdukDetail p"),
    @NamedQuery(name = "ProdukDetail.findByIdDetailproduk", query = "SELECT p FROM ProdukDetail p WHERE p.idDetailproduk = :idDetailproduk"),
    @NamedQuery(name = "ProdukDetail.findByIdProduk", query = "SELECT p FROM ProdukDetail p WHERE p.idProduk = :idProduk"),
    @NamedQuery(name = "ProdukDetail.findByIdPelanggan", query = "SELECT p FROM ProdukDetail p WHERE p.idPelanggan = :idPelanggan"),
    @NamedQuery(name = "ProdukDetail.findByQty", query = "SELECT p FROM ProdukDetail p WHERE p.qty = :qty"),
    @NamedQuery(name = "ProdukDetail.findByJumlah", query = "SELECT p FROM ProdukDetail p WHERE p.jumlah = :jumlah")})
public class ProdukDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_detailproduk")
    private String idDetailproduk;
    @Basic(optional = false)
    @Column(name = "id_produk")
    private String idProduk;
    @Basic(optional = false)
    @Column(name = "id_pelanggan")
    private int idPelanggan;
    @Basic(optional = false)
    @Column(name = "qty")
    private int qty;
    @Basic(optional = false)
    @Column(name = "jumlah")
    private int jumlah;

    public ProdukDetail() {
    }

    public ProdukDetail(String idDetailproduk) {
        this.idDetailproduk = idDetailproduk;
    }

    public ProdukDetail(String idDetailproduk, String idProduk, int idPelanggan, int qty, int jumlah) {
        this.idDetailproduk = idDetailproduk;
        this.idProduk = idProduk;
        this.idPelanggan = idPelanggan;
        this.qty = qty;
        this.jumlah = jumlah;
    }

    public String getIdDetailproduk() {
        return idDetailproduk;
    }

    public void setIdDetailproduk(String idDetailproduk) {
        this.idDetailproduk = idDetailproduk;
    }

    public String getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(String idProduk) {
        this.idProduk = idProduk;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetailproduk != null ? idDetailproduk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdukDetail)) {
            return false;
        }
        ProdukDetail other = (ProdukDetail) object;
        if ((this.idDetailproduk == null && other.idDetailproduk != null) || (this.idDetailproduk != null && !this.idDetailproduk.equals(other.idDetailproduk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gpaudra.gstorecustomer.model.ProdukDetail[ idDetailproduk=" + idDetailproduk + " ]";
    }
    
}
