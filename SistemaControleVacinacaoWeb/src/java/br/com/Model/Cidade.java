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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristiano Seixas
 */
@Entity
@Table(name = "cidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c"),
    @NamedQuery(name = "Cidade.findByCodigoCidade", query = "SELECT c FROM Cidade c WHERE c.codigoCidade = :codigoCidade"),
    @NamedQuery(name = "Cidade.findByNomeCidade", query = "SELECT c FROM Cidade c WHERE c.nomeCidade = :nomeCidade")})
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO_CIDADE")
    private Integer codigoCidade;
    @Size(max = 255)
    @Column(name = "NOME_CIDADE")
    private String nomeCidade;
    @JoinColumn(name = "CODIGO_ESTADO", referencedColumnName = "CODIGO_ESTADO")
    @ManyToOne(optional = false)
    private Estado codigoEstado;
    @JoinColumn(name = "CODIGO_PAIS", referencedColumnName = "CODIGO_PAIS")
    @ManyToOne(optional = false)
    private Pais codigoPais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoCidade")
    private List<Pessoa> pessoaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoNaturalidade")
    private List<Pessoa> pessoaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoCidade")
    private List<Bairro> bairroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoCidade")
    private List<Funcionario> funcionarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoNaturalidade")
    private List<Funcionario> funcionarioList1;

    public Cidade() {
    }

    public Cidade(Integer codigoCidade) {
        this.codigoCidade = codigoCidade;
    }

    public Integer getCodigoCidade() {
        return codigoCidade;
    }

    public void setCodigoCidade(Integer codigoCidade) {
        this.codigoCidade = codigoCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public Estado getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Estado codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public Pais getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(Pais codigoPais) {
        this.codigoPais = codigoPais;
    }

    @XmlTransient
    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    @XmlTransient
    public List<Pessoa> getPessoaList1() {
        return pessoaList1;
    }

    public void setPessoaList1(List<Pessoa> pessoaList1) {
        this.pessoaList1 = pessoaList1;
    }

    @XmlTransient
    public List<Bairro> getBairroList() {
        return bairroList;
    }

    public void setBairroList(List<Bairro> bairroList) {
        this.bairroList = bairroList;
    }

    @XmlTransient
    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @XmlTransient
    public List<Funcionario> getFuncionarioList1() {
        return funcionarioList1;
    }

    public void setFuncionarioList1(List<Funcionario> funcionarioList1) {
        this.funcionarioList1 = funcionarioList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCidade != null ? codigoCidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.codigoCidade == null && other.codigoCidade != null) || (this.codigoCidade != null && !this.codigoCidade.equals(other.codigoCidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.Model.Cidade[ codigoCidade=" + codigoCidade + " ]";
    }
    
}
