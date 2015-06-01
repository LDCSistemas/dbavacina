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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristiano Seixas
 */
@Entity
@Table(name = "profissao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profissao.findAll", query = "SELECT p FROM Profissao p"),
    @NamedQuery(name = "Profissao.findByCodigoProfissao", query = "SELECT p FROM Profissao p WHERE p.codigoProfissao = :codigoProfissao"),
    @NamedQuery(name = "Profissao.findByNomeProfissao", query = "SELECT p FROM Profissao p WHERE p.nomeProfissao = :nomeProfissao")})
public class Profissao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO_PROFISSAO")
    private Integer codigoProfissao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NOME_PROFISSAO")
    private String nomeProfissao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoProfissao")
    private List<Pessoa> pessoaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoProfissao")
    private List<Funcionario> funcionarioList;

    public Profissao() {
    }

    public Profissao(Integer codigoProfissao) {
        this.codigoProfissao = codigoProfissao;
    }

    public Profissao(Integer codigoProfissao, String nomeProfissao) {
        this.codigoProfissao = codigoProfissao;
        this.nomeProfissao = nomeProfissao;
    }

    public Integer getCodigoProfissao() {
        return codigoProfissao;
    }

    public void setCodigoProfissao(Integer codigoProfissao) {
        this.codigoProfissao = codigoProfissao;
    }

    public String getNomeProfissao() {
        return nomeProfissao;
    }

    public void setNomeProfissao(String nomeProfissao) {
        this.nomeProfissao = nomeProfissao;
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
        hash += (codigoProfissao != null ? codigoProfissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profissao)) {
            return false;
        }
        Profissao other = (Profissao) object;
        if ((this.codigoProfissao == null && other.codigoProfissao != null) || (this.codigoProfissao != null && !this.codigoProfissao.equals(other.codigoProfissao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.Model.Profissao[ codigoProfissao=" + codigoProfissao + " ]";
    }
    
}
