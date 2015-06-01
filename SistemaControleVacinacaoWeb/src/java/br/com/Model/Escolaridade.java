/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Model;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristiano Seixas
 */
@Entity
@Table(name = "escolaridade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escolaridade.findAll", query = "SELECT e FROM Escolaridade e"),
    @NamedQuery(name = "Escolaridade.findByCodigoEscolaridade", query = "SELECT e FROM Escolaridade e WHERE e.codigoEscolaridade = :codigoEscolaridade"),
    @NamedQuery(name = "Escolaridade.findByDescricaoEscolaridade", query = "SELECT e FROM Escolaridade e WHERE e.descricaoEscolaridade = :descricaoEscolaridade")})
public class Escolaridade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO_ESCOLARIDADE")
    private Integer codigoEscolaridade;
    @Size(max = 255)
    @Column(name = "DESCRICAO_ESCOLARIDADE")
    private String descricaoEscolaridade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoEscolaridade")
    private List<Pessoa> pessoaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoEscolaridade")
    private List<Funcionario> funcionarioList;

    public Escolaridade() {
    }

    public Escolaridade(Integer codigoEscolaridade) {
        this.codigoEscolaridade = codigoEscolaridade;
    }

    public Integer getCodigoEscolaridade() {
        return codigoEscolaridade;
    }

    public void setCodigoEscolaridade(Integer codigoEscolaridade) {
        this.codigoEscolaridade = codigoEscolaridade;
    }

    public String getDescricaoEscolaridade() {
        return descricaoEscolaridade;
    }

    public void setDescricaoEscolaridade(String descricaoEscolaridade) {
        this.descricaoEscolaridade = descricaoEscolaridade;
    }

    @XmlTransient
    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    @XmlTransient
    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEscolaridade != null ? codigoEscolaridade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escolaridade)) {
            return false;
        }
        Escolaridade other = (Escolaridade) object;
        if ((this.codigoEscolaridade == null && other.codigoEscolaridade != null) || (this.codigoEscolaridade != null && !this.codigoEscolaridade.equals(other.codigoEscolaridade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.Model.Escolaridade[ codigoEscolaridade=" + codigoEscolaridade + " ]";
    }
    
}
