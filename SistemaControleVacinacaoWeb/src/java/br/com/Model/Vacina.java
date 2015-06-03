/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "vacina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacina.findAll", query = "SELECT v FROM Vacina v"),
    @NamedQuery(name = "Vacina.findByCodigoVacina", query = "SELECT v FROM Vacina v WHERE v.codigoVacina = :codigoVacina"),
    @NamedQuery(name = "Vacina.findByNomeVacina", query = "SELECT v FROM Vacina v WHERE v.nomeVacina = :nomeVacina")})
public class Vacina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO_VACINA")
    private Integer codigoVacina;
    @Basic(optional = false)
    @NotNull(message = "A descrição da vacina deve ser informada")
    @Column(name = "NOME_VACINA")
    private String nomeVacina;
    @OneToMany(mappedBy = "codigoVacina")
    private List<Atendimento> atendimentoList;

    public Vacina() {
    }

    public Vacina(Integer codigoVacina) {
        this.codigoVacina = codigoVacina;
    }

    public Vacina(Integer codigoVacina, String nomeVacina) {
        this.codigoVacina = codigoVacina;
        this.nomeVacina = nomeVacina;
    }

    public Integer getCodigoVacina() {
        return codigoVacina;
    }

    public void setCodigoVacina(Integer codigoVacina) {
        this.codigoVacina = codigoVacina;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
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
        hash += (codigoVacina != null ? codigoVacina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacina)) {
            return false;
        }
        Vacina other = (Vacina) object;
        if ((this.codigoVacina == null && other.codigoVacina != null) || (this.codigoVacina != null && !this.codigoVacina.equals(other.codigoVacina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.Model.Vacina[ codigoVacina=" + codigoVacina + " ]";
    }
    
}
