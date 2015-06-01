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
@Table(name = "unidade_saude")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadeSaude.findAll", query = "SELECT u FROM UnidadeSaude u"),
    @NamedQuery(name = "UnidadeSaude.findByCodigoUnidadeSaude", query = "SELECT u FROM UnidadeSaude u WHERE u.codigoUnidadeSaude = :codigoUnidadeSaude"),
    @NamedQuery(name = "UnidadeSaude.findByNomeUnidadeSaude", query = "SELECT u FROM UnidadeSaude u WHERE u.nomeUnidadeSaude = :nomeUnidadeSaude")})
public class UnidadeSaude implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO_UNIDADE_SAUDE")
    private Long codigoUnidadeSaude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "NOME_UNIDADE_SAUDE")
    private String nomeUnidadeSaude;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoUnidadeSaude")
    private List<Atendimento> atendimentoList;

    public UnidadeSaude() {
    }

    public UnidadeSaude(Long codigoUnidadeSaude) {
        this.codigoUnidadeSaude = codigoUnidadeSaude;
    }

    public UnidadeSaude(Long codigoUnidadeSaude, String nomeUnidadeSaude) {
        this.codigoUnidadeSaude = codigoUnidadeSaude;
        this.nomeUnidadeSaude = nomeUnidadeSaude;
    }

    public Long getCodigoUnidadeSaude() {
        return codigoUnidadeSaude;
    }

    public void setCodigoUnidadeSaude(Long codigoUnidadeSaude) {
        this.codigoUnidadeSaude = codigoUnidadeSaude;
    }

    public String getNomeUnidadeSaude() {
        return nomeUnidadeSaude;
    }

    public void setNomeUnidadeSaude(String nomeUnidadeSaude) {
        this.nomeUnidadeSaude = nomeUnidadeSaude;
    }

    @XmlTransient
    public List<Atendimento> getAtendimentoList() {
        return atendimentoList;
    }

    public void setAtendimentoList(List<Atendimento> atendimentoList) {
        this.atendimentoList = atendimentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoUnidadeSaude != null ? codigoUnidadeSaude.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadeSaude)) {
            return false;
        }
        UnidadeSaude other = (UnidadeSaude) object;
        if ((this.codigoUnidadeSaude == null && other.codigoUnidadeSaude != null) || (this.codigoUnidadeSaude != null && !this.codigoUnidadeSaude.equals(other.codigoUnidadeSaude))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.Model.UnidadeSaude[ codigoUnidadeSaude=" + codigoUnidadeSaude + " ]";
    }
    
}
