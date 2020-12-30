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
@Table(name = "transaksi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaksi.findAll", query = "SELECT t FROM Transaksi t"),
    @NamedQuery(name = "Transaksi.findByIdTransaksi", query = "SELECT t FROM Transaksi t WHERE t.idTransaksi = :idTransaksi"),
    @NamedQuery(name = "Transaksi.findByIdDetailproduk", query = "SELECT t FROM Transaksi t WHERE t.idDetailproduk = :idDetailproduk"),
    @NamedQuery(name = "Transaksi.findByIdPelanggan", query = "SELECT t FROM Transaksi t WHERE t.idPelanggan = :idPelanggan"),
    @NamedQuery(name = "Transaksi.findByWaktuTrans", query = "SELECT t FROM Transaksi t WHERE t.waktuTrans = :waktuTrans"),
    @NamedQuery(name = "Transaksi.findByTotalHarga", query = "SELECT t FROM Transaksi t WHERE t.totalHarga = :totalHarga")})
public class Transaksi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_transaksi")
    private String idTransaksi;
    @Basic(optional = false)
    @Column(name = "id_detailproduk")
    private String idDetailproduk;
    @Basic(optional = false)
    @Column(name = "id_pelanggan")
    private int idPelanggan;
    @Basic(optional = false)
    @Column(name = "waktu_trans")
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuTrans;
    @Basic(optional = false)
    @Column(name = "total_harga")
    private int totalHarga;

    public Transaksi() {
    }

    public Transaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Transaksi(String idTransaksi, String idDetailproduk, int idPelanggan, Date waktuTrans, int totalHarga) {
        this.idTransaksi = idTransaksi;
        this.idDetailproduk = idDetailproduk;
        this.idPelanggan = idPelanggan;
        this.waktuTrans = waktuTrans;
        this.totalHarga = totalHarga;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getIdDetailproduk() {
        return idDetailproduk;
    }

    public void setIdDetailproduk(String idDetailproduk) {
        this.idDetailproduk = idDetailproduk;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public Date getWaktuTrans() {
        return waktuTrans;
    }

    public void setWaktuTrans(Date waktuTrans) {
        this.waktuTrans = waktuTrans;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransaksi != null ? idTransaksi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaksi)) {
            return false;
        }
        Transaksi other = (Transaksi) object;
        if ((this.idTransaksi == null && other.idTransaksi != null) || (this.idTransaksi != null && !this.idTransaksi.equals(other.idTransaksi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gpaudra.gstorecustomer.model.Transaksi[ idTransaksi=" + idTransaksi + " ]";
    }
    
}
