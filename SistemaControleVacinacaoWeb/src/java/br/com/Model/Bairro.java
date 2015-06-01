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
 * @author Cristiano Seixas
 */
@Entity
@Table(name = "bairro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bairro.findAll", query = "SELECT b FROM Bairro b"),
    @NamedQuery(name = "Bairro.findByCodigoBairro", query = "SELECT b FROM Bairro b WHERE b.codigoBairro = :codigoBairro"),
    @NamedQuery(name = "Bairro.findByNomeBairro", query = "SELECT b FROM Bairro b WHERE b.nomeBairro = :nomeBairro")})
public class Bairro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO_BAIRRO")
    private Integer codigoBairro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "NOME_BAIRRO")
    private String nomeBairro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoBairro")
    private List<Pessoa> pessoaList;
    @JoinColumn(name = "CODIGO_CIDADE", referencedColumnName = "CODIGO_CIDADE")
    @ManyToOne(optional = false)
    private Cidade codigoCidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoBairro")
    private List<Logradouro> logradouroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoBairro")
    private List<Funcionario> funcionarioList;

    public Bairro() {
    }

    public Bairro(Integer codigoBairro) {
        this.codigoBairro = codigoBairro;
    }

    public Bairro(Integer codigoBairro, String nomeBairro) {
        this.codigoBairro = codigoBairro;
        this.nomeBairro = nomeBairro;
    }

    public Integer getCodigoBairro() {
        return codigoBairro;
    }

    public void setCodigoBairro(Integer codigoBairro) {
        this.codigoBairro = codigoBairro;
    }

    public String getNomeBairro() {
        return nomeBairro;
    }

    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }

    @XmlTransient
    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    public Cidade getCodigoCidade() {
        return codigoCidade;
    }

    public void setCodigoCidade(Cidade codigoCidade) {
        this.codigoCidade = codigoCidade;
    }

    @XmlTransient
    public List<Logradouro> getLogradouroList() {
        return logradouroList;
    }

    public void setLogradouroList(List<Logradouro> logradouroList) {
        this.logradouroList = logradouroList;
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
        hash += (codigoBairro != null ? codigoBairro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bairro)) {
            return false;
        }
        Bairro other = (Bairro) object;
        if ((this.codigoBairro == null && other.codigoBairro != null) || (this.codigoBairro != null && !this.codigoBairro.equals(other.codigoBairro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.Model.Bairro[ codigoBairro=" + codigoBairro + " ]";
    }
    
}
