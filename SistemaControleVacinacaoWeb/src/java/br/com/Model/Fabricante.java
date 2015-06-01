/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristiano Seixas
 */
@Entity
@Table(name = "fabricante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fabricante.findAll", query = "SELECT f FROM Fabricante f"),
    @NamedQuery(name = "Fabricante.findByCodigoFabricante", query = "SELECT f FROM Fabricante f WHERE f.codigoFabricante = :codigoFabricante"),
    @NamedQuery(name = "Fabricante.findByDescricaoFabricante", query = "SELECT f FROM Fabricante f WHERE f.descricaoFabricante = :descricaoFabricante")})
public class Fabricante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Codigo_Fabricante")
    private Long codigoFabricante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Descricao_Fabricante")
    private String descricaoFabricante;

    public Fabricante() {
    }

    public Fabricante(Long codigoFabricante) {
        this.codigoFabricante = codigoFabricante;
    }

    public Fabricante(Long codigoFabricante, String descricaoFabricante) {
        this.codigoFabricante = codigoFabricante;
        this.descricaoFabricante = descricaoFabricante;
    }

    public Long getCodigoFabricante() {
        return codigoFabricante;
    }

    public void setCodigoFabricante(Long codigoFabricante) {
        this.codigoFabricante = codigoFabricante;
    }

    public String getDescricaoFabricante() {
        return descricaoFabricante;
    }

    public void setDescricaoFabricante(String descricaoFabricante) {
        this.descricaoFabricante = descricaoFabricante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoFabricante != null ? codigoFabricante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fabricante)) {
            return false;
        }
        Fabricante other = (Fabricante) object;
        if ((this.codigoFabricante == null && other.codigoFabricante != null) || (this.codigoFabricante != null && !this.codigoFabricante.equals(other.codigoFabricante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.Model.Fabricante[ codigoFabricante=" + codigoFabricante + " ]";
    }
    
}
