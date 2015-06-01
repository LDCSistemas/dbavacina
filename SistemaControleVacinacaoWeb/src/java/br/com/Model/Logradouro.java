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
 * @author Cristiano Seixas
 */
@Entity
@Table(name = "logradouro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logradouro.findAll", query = "SELECT l FROM Logradouro l"),
    @NamedQuery(name = "Logradouro.findByCodigoLogradouro", query = "SELECT l FROM Logradouro l WHERE l.codigoLogradouro = :codigoLogradouro"),
    @NamedQuery(name = "Logradouro.findByCep", query = "SELECT l FROM Logradouro l WHERE l.cep = :cep"),
    @NamedQuery(name = "Logradouro.findByCodigoTpoLogradouro", query = "SELECT l FROM Logradouro l WHERE l.codigoTpoLogradouro = :codigoTpoLogradouro"),
    @NamedQuery(name = "Logradouro.findByNomeLogradouro", query = "SELECT l FROM Logradouro l WHERE l.nomeLogradouro = :nomeLogradouro")})
public class Logradouro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_LOGRADOURO")
    private Integer codigoLogradouro;
    @Size(max = 255)
    @Column(name = "CEP")
    private String cep;
    @Column(name = "CODIGO_TPO_LOGRADOURO")
    private Integer codigoTpoLogradouro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NOME_LOGRADOURO")
    private String nomeLogradouro;
    @JoinColumn(name = "CODIGO_BAIRRO", referencedColumnName = "CODIGO_BAIRRO")
    @ManyToOne(optional = false)
    private Bairro codigoBairro;

    public Logradouro() {
    }

    public Logradouro(Integer codigoLogradouro) {
        this.codigoLogradouro = codigoLogradouro;
    }

    public Logradouro(Integer codigoLogradouro, String nomeLogradouro) {
        this.codigoLogradouro = codigoLogradouro;
        this.nomeLogradouro = nomeLogradouro;
    }

    public Integer getCodigoLogradouro() {
        return codigoLogradouro;
    }

    public void setCodigoLogradouro(Integer codigoLogradouro) {
        this.codigoLogradouro = codigoLogradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getCodigoTpoLogradouro() {
        return codigoTpoLogradouro;
    }

    public void setCodigoTpoLogradouro(Integer codigoTpoLogradouro) {
        this.codigoTpoLogradouro = codigoTpoLogradouro;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public Bairro getCodigoBairro() {
        return codigoBairro;
    }

    public void setCodigoBairro(Bairro codigoBairro) {
        this.codigoBairro = codigoBairro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoLogradouro != null ? codigoLogradouro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logradouro)) {
            return false;
        }
        Logradouro other = (Logradouro) object;
        if ((this.codigoLogradouro == null && other.codigoLogradouro != null) || (this.codigoLogradouro != null && !this.codigoLogradouro.equals(other.codigoLogradouro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.Model.Logradouro[ codigoLogradouro=" + codigoLogradouro + " ]";
    }
    
}
