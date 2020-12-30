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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "pelanggan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pelanggan.findAll", query = "SELECT p FROM Pelanggan p"),
    @NamedQuery(name = "Pelanggan.findByIdPelanggan", query = "SELECT p FROM Pelanggan p WHERE p.idPelanggan = :idPelanggan"),
    @NamedQuery(name = "Pelanggan.findByUsername", query = "SELECT p FROM Pelanggan p WHERE p.username = :username"),
    @NamedQuery(name = "Pelanggan.findByKatasandi", query = "SELECT p FROM Pelanggan p WHERE p.katasandi = :katasandi"),
    @NamedQuery(name = "Pelanggan.findByEmailPelanggan", query = "SELECT p FROM Pelanggan p WHERE p.emailPelanggan = :emailPelanggan"),
    @NamedQuery(name = "Pelanggan.findByNotelpPelanggan", query = "SELECT p FROM Pelanggan p WHERE p.notelpPelanggan = :notelpPelanggan"),
    @NamedQuery(name = "Pelanggan.findByImage", query = "SELECT p FROM Pelanggan p WHERE p.image = :image"),
    @NamedQuery(name = "Pelanggan.findByLog", query = "SELECT p FROM Pelanggan p WHERE p.log = :log")})
public class Pelanggan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pelanggan")
    private Integer idPelanggan;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "katasandi")
    private String katasandi;
    @Basic(optional = false)
    @Column(name = "email_pelanggan")
    private String emailPelanggan;
    @Basic(optional = false)
    @Lob
    @Column(name = "nm_pelanggan")
    private String nmPelanggan;
    @Basic(optional = false)
    @Lob
    @Column(name = "almt_pelanggan")
    private String almtPelanggan;
    @Basic(optional = false)
    @Column(name = "notelp_pelanggan")
    private String notelpPelanggan;
    @Basic(optional = false)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @Column(name = "log")
    @Temporal(TemporalType.TIMESTAMP)
    private Date log;

    public Pelanggan() {
    }

    public Pelanggan(Integer idPelanggan) {
        this.idPelanggan = idPelanggan;
    }
    

    public Pelanggan(Integer idPelanggan, String username, String katasandi, String emailPelanggan, String nmPelanggan, String almtPelanggan, String notelpPelanggan, String image, Date log) {
        this.idPelanggan = idPelanggan;
        this.username = username;
        this.katasandi = katasandi;
        this.emailPelanggan = emailPelanggan;
        this.nmPelanggan = nmPelanggan;
        this.almtPelanggan = almtPelanggan;
        this.notelpPelanggan = notelpPelanggan;
        this.image = image;
        this.log = log;
    }
    
    

    public Integer getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(Integer idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKatasandi() {
        return katasandi;
    }

    public void setKatasandi(String katasandi) {
        this.katasandi = katasandi;
    }

    public String getEmailPelanggan() {
        return emailPelanggan;
    }

    public void setEmailPelanggan(String emailPelanggan) {
        this.emailPelanggan = emailPelanggan;
    }

    public String getNmPelanggan() {
        return nmPelanggan;
    }

    public void setNmPelanggan(String nmPelanggan) {
        this.nmPelanggan = nmPelanggan;
    }

    public String getAlmtPelanggan() {
        return almtPelanggan;
    }

    public void setAlmtPelanggan(String almtPelanggan) {
        this.almtPelanggan = almtPelanggan;
    }

    public String getNotelpPelanggan() {
        return notelpPelanggan;
    }

    public void setNotelpPelanggan(String notelpPelanggan) {
        this.notelpPelanggan = notelpPelanggan;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        hash += (idPelanggan != null ? idPelanggan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pelanggan)) {
            return false;
        }
        Pelanggan other = (Pelanggan) object;
        if ((this.idPelanggan == null && other.idPelanggan != null) || (this.idPelanggan != null && !this.idPelanggan.equals(other.idPelanggan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gpaudra.gstorecustomer.model.Pelanggan[ idPelanggan=" + idPelanggan + " ]";
    }
    
}
