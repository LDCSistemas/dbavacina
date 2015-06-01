/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristiano Seixas
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByCodigoUsuario", query = "SELECT u FROM Usuario u WHERE u.codigoUsuario = :codigoUsuario"),
    @NamedQuery(name = "Usuario.findByDataCadastro", query = "SELECT u FROM Usuario u WHERE u.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "Usuario.findByNAlteraSenhaProximoLogin", query = "SELECT u FROM Usuario u WHERE u.nAlteraSenhaProximoLogin = :nAlteraSenhaProximoLogin"),
    @NamedQuery(name = "Usuario.findByNivelAcesso", query = "SELECT u FROM Usuario u WHERE u.nivelAcesso = :nivelAcesso"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha"),
    @NamedQuery(name = "Usuario.findByStatusUsuario", query = "SELECT u FROM Usuario u WHERE u.statusUsuario = :statusUsuario")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CODIGO_USUARIO")
    private String codigoUsuario;
    @Column(name = "DATA_CADASTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Size(max = 255)
    @Column(name = "N_ALTERA_SENHA_PROXIMO_LOGIN")
    private String nAlteraSenhaProximoLogin;
    @Size(max = 255)
    @Column(name = "NIVEL_ACESSO")
    private String nivelAcesso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SENHA")
    private String senha;
    @Size(max = 8)
    @Column(name = "STATUS_USUARIO")
    private String statusUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoUsuarioCadastro")
    private List<Pessoa> pessoaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoUsuarioCadastro")
    private List<Atendimento> atendimentoList;
    @JoinColumn(name = "CODIGO_PESSOA", referencedColumnName = "CODIGO_PESSOA")
    @ManyToOne(optional = false)
    private Pessoa codigoPessoa;
    @JoinColumn(name = "CODIGO_FUNCIONARIO", referencedColumnName = "CODIGO_FUNCIONARIO")
    @ManyToOne(optional = false)
    private Funcionario codigoFuncionario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoUsuarioCadastro")
    private List<Funcionario> funcionarioList;

    public Usuario() {
    }

    public Usuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Usuario(String codigoUsuario, String senha) {
        this.codigoUsuario = codigoUsuario;
        this.senha = senha;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getNAlteraSenhaProximoLogin() {
        return nAlteraSenhaProximoLogin;
    }

    public void setNAlteraSenhaProximoLogin(String nAlteraSenhaProximoLogin) {
        this.nAlteraSenhaProximoLogin = nAlteraSenhaProximoLogin;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(String statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    @XmlTransient
    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    @XmlTransient
    public List<Atendimento> getAtendimentoList() {
        return atendimentoList;
    }

    public void setAtendimentoList(List<Atendimento> atendimentoList) {
        this.atendimentoList = atendimentoList;
    }

    public Pessoa getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(Pessoa codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public Funcionario getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(Funcionario codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
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
        hash += (codigoUsuario != null ? codigoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codigoUsuario == null && other.codigoUsuario != null) || (this.codigoUsuario != null && !this.codigoUsuario.equals(other.codigoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.Model.Usuario[ codigoUsuario=" + codigoUsuario + " ]";
    }
    
}
