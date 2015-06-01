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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristiano Seixas
 */
@Entity
@Table(name = "fornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.findByCodigoFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.codigoFornecedor = :codigoFornecedor"),
    @NamedQuery(name = "Fornecedor.findByDescricaoFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.descricaoFornecedor = :descricaoFornecedor")})
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO_FORNECEDOR")
    private Integer codigoFornecedor;
    @Size(max = 255)
    @Column(name = "DESCRICAO_FORNECEDOR")
    private String descricaoFornecedor;

    public Fornecedor() {
    }

    public Fornecedor(Integer codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    public Integer getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public void setCodigoFornecedor(Integer codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    public String getDescricaoFornecedor() {
        return descricaoFornecedor;
    }

    public void setDescricaoFornecedor(String descricaoFornecedor) {
        this.descricaoFornecedor = descricaoFornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoFornecedor != null ? codigoFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.codigoFornecedor == null && other.codigoFornecedor != null) || (this.codigoFornecedor != null && !this.codigoFornecedor.equals(other.codigoFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.Model.Fornecedor[ codigoFornecedor=" + codigoFornecedor + " ]";
    }
    
}
