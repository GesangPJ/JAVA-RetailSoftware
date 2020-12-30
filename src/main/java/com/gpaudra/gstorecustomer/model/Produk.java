/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gpaudra.gstorecustomer.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gesang Paudra Jaya
 */
@Entity
@Table(name = "produk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produk.findAll", query = "SELECT p FROM Produk p"),
    @NamedQuery(name = "Produk.findByIdProduk", query = "SELECT p FROM Produk p WHERE p.idProduk = :idProduk"),
    @NamedQuery(name = "Produk.findByNmProduk", query = "SELECT p FROM Produk p WHERE p.nmProduk = :nmProduk"),
    @NamedQuery(name = "Produk.findByHargaJual", query = "SELECT p FROM Produk p WHERE p.hargaJual = :hargaJual"),
    @NamedQuery(name = "Produk.findByKategori", query = "SELECT p FROM Produk p WHERE p.kategori = :kategori"),
    @NamedQuery(name = "Produk.findByStokProduk", query = "SELECT p FROM Produk p WHERE p.stokProduk = :stokProduk"),
    @NamedQuery(name = "Produk.findByLog", query = "SELECT p FROM Produk p WHERE p.log = :log")})
public class Produk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_produk")
    private String idProduk;
    @Basic(optional = false)
    @Column(name = "nm_produk")
    private String nmProduk;
    @Basic(optional = false)
    @Column(name = "harga_jual")
    private int hargaJual;
    @Basic(optional = false)
    @Column(name = "kategori")
    private int kategori;
    @Basic(optional = false)
    @Column(name = "stok_produk")
    private int stokProduk;
    @Basic(optional = false)
    @Column(name = "log")
    @Temporal(TemporalType.TIMESTAMP)
    private Date log;

    public Produk() {
    }

    public Produk(String idProduk) {
        this.idProduk = idProduk;
    }

    public Produk(String idProduk, String nmProduk, int hargaJual, int kategori, int stokProduk, Date log) {
        this.idProduk = idProduk;
        this.nmProduk = nmProduk;
        this.hargaJual = hargaJual;
        this.kategori = kategori;
        this.stokProduk = stokProduk;
        this.log = log;
    }

    public String getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(String idProduk) {
        this.idProduk = idProduk;
    }

    public String getNmProduk() {
        return nmProduk;
    }

    public void setNmProduk(String nmProduk) {
        this.nmProduk = nmProduk;
    }

    public int getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(int hargaJual) {
        this.hargaJual = hargaJual;
    }

    public int getKategori() {
        return kategori;
    }

    public void setKategori(int kategori) {
        this.kategori = kategori;
    }

    public int getStokProduk() {
        return stokProduk;
    }

    public void setStokProduk(int stokProduk) {
        this.stokProduk = stokProduk;
    }

    public Date getLog() {
        return log;
    }

    public void setLog(Date log) {
        this.log = log;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduk != null ? idProduk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produk)) {
            return false;
        }
        Produk other = (Produk) object;
        if ((this.idProduk == null && other.idProduk != null) || (this.idProduk != null && !this.idProduk.equals(other.idProduk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gpaudra.gstorecustomer.model.Produk[ idProduk=" + idProduk + " ]";
    }
    
}
