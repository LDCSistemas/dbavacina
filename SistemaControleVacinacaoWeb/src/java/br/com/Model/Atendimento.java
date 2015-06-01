/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristiano Seixas
 */
@Entity
@Table(name = "atendimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atendimento.findAll", query = "SELECT a FROM Atendimento a"),
    @NamedQuery(name = "Atendimento.findByCodigoAtendimento", query = "SELECT a FROM Atendimento a WHERE a.codigoAtendimento = :codigoAtendimento"),
    @NamedQuery(name = "Atendimento.findByDataAtendimento", query = "SELECT a FROM Atendimento a WHERE a.dataAtendimento = :dataAtendimento"),
    @NamedQuery(name = "Atendimento.findByObservacaoAtendimento", query = "SELECT a FROM Atendimento a WHERE a.observacaoAtendimento = :observacaoAtendimento")})
public class Atendimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO_ATENDIMENTO")
    private Integer codigoAtendimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_ATENDIMENTO")
    @Temporal(TemporalType.DATE)
    private Date dataAtendimento;
    @Size(max = 255)
    @Column(name = "OBSERVACAO_ATENDIMENTO")
    private String observacaoAtendimento;
    @JoinColumn(name = "CODIGO_PESSOA", referencedColumnName = "CODIGO_PESSOA")
    @ManyToOne(optional = false)
    private Pessoa codigoPessoa;
    @JoinColumn(name = "CODIGO_USUARIO_CADASTRO", referencedColumnName = "CODIGO_USUARIO")
    @ManyToOne(optional = false)
    private Usuario codigoUsuarioCadastro;
    @JoinColumn(name = "CODIGO_VACINA", referencedColumnName = "CODIGO_VACINA")
    @ManyToOne
    private Vacina codigoVacina;
    @JoinColumn(name = "CODIGO_UNIDADE_SAUDE", referencedColumnName = "CODIGO_UNIDADE_SAUDE")
    @ManyToOne(optional = false)
    private UnidadeSaude codigoUnidadeSaude;

    public Atendimento() {
    }

    public Atendimento(Integer codigoAtendimento) {
        this.codigoAtendimento = codigoAtendimento;
    }

    public Atendimento(Integer codigoAtendimento, Date dataAtendimento) {
        this.codigoAtendimento = codigoAtendimento;
        this.dataAtendimento = dataAtendimento;
    }

    public Integer getCodigoAtendimento() {
        return codigoAtendimento;
    }

    public void setCodigoAtendimento(Integer codigoAtendimento) {
        this.codigoAtendimento = codigoAtendimento;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getObservacaoAtendimento() {
        return observacaoAtendimento;
    }

    public void setObservacaoAtendimento(String observacaoAtendimento) {
        this.observacaoAtendimento = observacaoAtendimento;
    }

    public Pessoa getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(Pessoa codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public Usuario getCodigoUsuarioCadastro() {
        return codigoUsuarioCadastro;
    }

    public void setCodigoUsuarioCadastro(Usuario codigoUsuarioCadastro) {
        this.codigoUsuarioCadastro = codigoUsuarioCadastro;
    }

    public Vacina getCodigoVacina() {
        return codigoVacina;
    }

    public void setCodigoVacina(Vacina codigoVacina) {
        this.codigoVacina = codigoVacina;
    }

    public UnidadeSaude getCodigoUnidadeSaude() {
        return codigoUnidadeSaude;
    }

    public void setCodigoUnidadeSaude(UnidadeSaude codigoUnidadeSaude) {
        this.codigoUnidadeSaude = codigoUnidadeSaude;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoAtendimento != null ? codigoAtendimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atendimento)) {
            return false;
        }
        Atendimento other = (Atendimento) object;
        if ((this.codigoAtendimento == null && other.codigoAtendimento != null) || (this.codigoAtendimento != null && !this.codigoAtendimento.equals(other.codigoAtendimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.Model.Atendimento[ codigoAtendimento=" + codigoAtendimento + " ]";
    }
    
}
