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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristiano Seixas
 */
@Entity
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByCodigoFuncionario", query = "SELECT f FROM Funcionario f WHERE f.codigoFuncionario = :codigoFuncionario"),
    @NamedQuery(name = "Funcionario.findByCep", query = "SELECT f FROM Funcionario f WHERE f.cep = :cep"),
    @NamedQuery(name = "Funcionario.findByCodigoConselho", query = "SELECT f FROM Funcionario f WHERE f.codigoConselho = :codigoConselho"),
    @NamedQuery(name = "Funcionario.findByComplemento", query = "SELECT f FROM Funcionario f WHERE f.complemento = :complemento"),
    @NamedQuery(name = "Funcionario.findByCor", query = "SELECT f FROM Funcionario f WHERE f.cor = :cor"),
    @NamedQuery(name = "Funcionario.findByCpf", query = "SELECT f FROM Funcionario f WHERE f.cpf = :cpf"),
    @NamedQuery(name = "Funcionario.findByDataCadastro", query = "SELECT f FROM Funcionario f WHERE f.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "Funcionario.findByDataExpedicao", query = "SELECT f FROM Funcionario f WHERE f.dataExpedicao = :dataExpedicao"),
    @NamedQuery(name = "Funcionario.findByDataNascimento", query = "SELECT f FROM Funcionario f WHERE f.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Funcionario.findByEmail", query = "SELECT f FROM Funcionario f WHERE f.email = :email"),
    @NamedQuery(name = "Funcionario.findByEstadoCivil", query = "SELECT f FROM Funcionario f WHERE f.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "Funcionario.findByIdentidade", query = "SELECT f FROM Funcionario f WHERE f.identidade = :identidade"),
    @NamedQuery(name = "Funcionario.findByLogradouro", query = "SELECT f FROM Funcionario f WHERE f.logradouro = :logradouro"),
    @NamedQuery(name = "Funcionario.findByNome", query = "SELECT f FROM Funcionario f WHERE f.nome = :nome"),
    @NamedQuery(name = "Funcionario.findByNomeConjuge", query = "SELECT f FROM Funcionario f WHERE f.nomeConjuge = :nomeConjuge"),
    @NamedQuery(name = "Funcionario.findByNomeMae", query = "SELECT f FROM Funcionario f WHERE f.nomeMae = :nomeMae"),
    @NamedQuery(name = "Funcionario.findByNomePai", query = "SELECT f FROM Funcionario f WHERE f.nomePai = :nomePai"),
    @NamedQuery(name = "Funcionario.findByOrgaoEmissor", query = "SELECT f FROM Funcionario f WHERE f.orgaoEmissor = :orgaoEmissor"),
    @NamedQuery(name = "Funcionario.findBySexo", query = "SELECT f FROM Funcionario f WHERE f.sexo = :sexo")})
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO_FUNCIONARIO")
    private Long codigoFuncionario;
    @Size(max = 255)
    @Column(name = "CEP")
    private String cep;
    @Size(max = 255)
    @Column(name = "CODIGO_CONSELHO")
    private String codigoConselho;
    @Size(max = 255)
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Size(max = 255)
    @Column(name = "COR")
    private String cor;
    @Size(max = 255)
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "DATA_CADASTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Column(name = "DATA_EXPEDICAO")
    @Temporal(TemporalType.DATE)
    private Date dataExpedicao;
    @Column(name = "DATA_NASCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 255)
    @Column(name = "ESTADO_CIVIL")
    private String estadoCivil;
    @Size(max = 255)
    @Column(name = "IDENTIDADE")
    private String identidade;
    @Size(max = 255)
    @Column(name = "LOGRADOURO")
    private String logradouro;
    @Size(max = 255)
    @Column(name = "NOME")
    private String nome;
    @Size(max = 255)
    @Column(name = "NOME_CONJUGE")
    private String nomeConjuge;
    @Size(max = 255)
    @Column(name = "NOME_MAE")
    private String nomeMae;
    @Size(max = 255)
    @Column(name = "NOME_PAI")
    private String nomePai;
    @Size(max = 255)
    @Column(name = "ORGAO_EMISSOR")
    private String orgaoEmissor;
    @Size(max = 255)
    @Column(name = "SEXO")
    private String sexo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoFuncionario")
    private List<Usuario> usuarioList;
    @JoinColumn(name = "CODIGO_PROFISSAO", referencedColumnName = "CODIGO_PROFISSAO")
    @ManyToOne(optional = false)
    private Profissao codigoProfissao;
    @JoinColumn(name = "CODIGO_ESTADO", referencedColumnName = "CODIGO_ESTADO")
    @ManyToOne(optional = false)
    private Estado codigoEstado;
    @JoinColumn(name = "CODIGO_BAIRRO", referencedColumnName = "CODIGO_BAIRRO")
    @ManyToOne(optional = false)
    private Bairro codigoBairro;
    @JoinColumn(name = "CODIGO_ESCOLARIDADE", referencedColumnName = "CODIGO_ESCOLARIDADE")
    @ManyToOne(optional = false)
    private Escolaridade codigoEscolaridade;
    @JoinColumn(name = "CODIGO_USUARIO_CADASTRO", referencedColumnName = "CODIGO_USUARIO")
    @ManyToOne(optional = false)
    private Usuario codigoUsuarioCadastro;
    @JoinColumn(name = "CODIGO_CIDADE", referencedColumnName = "CODIGO_CIDADE")
    @ManyToOne(optional = false)
    private Cidade codigoCidade;
    @JoinColumn(name = "CODIGO_NATURALIDADE", referencedColumnName = "CODIGO_CIDADE")
    @ManyToOne(optional = false)
    private Cidade codigoNaturalidade;

    public Funcionario() {
    }

    public Funcionario(Long codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public Long getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(Long codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCodigoConselho() {
        return codigoConselho;
    }

    public void setCodigoConselho(String codigoConselho) {
        this.codigoConselho = codigoConselho;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataExpedicao() {
        return dataExpedicao;
    }

    public void setDataExpedicao(Date dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeConjuge() {
        return nomeConjuge;
    }

    public void setNomeConjuge(String nomeConjuge) {
        this.nomeConjuge = nomeConjuge;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Profissao getCodigoProfissao() {
        return codigoProfissao;
    }

    public void setCodigoProfissao(Profissao codigoProfissao) {
        this.codigoProfissao = codigoProfissao;
    }

    public Estado getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Estado codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public Bairro getCodigoBairro() {
        return codigoBairro;
    }

    public void setCodigoBairro(Bairro codigoBairro) {
        this.codigoBairro = codigoBairro;
    }

    public Escolaridade getCodigoEscolaridade() {
        return codigoEscolaridade;
    }

    public void setCodigoEscolaridade(Escolaridade codigoEscolaridade) {
        this.codigoEscolaridade = codigoEscolaridade;
    }

    public Usuario getCodigoUsuarioCadastro() {
        return codigoUsuarioCadastro;
    }

    public void setCodigoUsuarioCadastro(Usuario codigoUsuarioCadastro) {
        this.codigoUsuarioCadastro = codigoUsuarioCadastro;
    }

    public Cidade getCodigoCidade() {
        return codigoCidade;
    }

    public void setCodigoCidade(Cidade codigoCidade) {
        this.codigoCidade = codigoCidade;
    }

    public Cidade getCodigoNaturalidade() {
        return codigoNaturalidade;
    }

    public void setCodigoNaturalidade(Cidade codigoNaturalidade) {
        this.codigoNaturalidade = codigoNaturalidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoFuncionario != null ? codigoFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.codigoFuncionario == null && other.codigoFuncionario != null) || (this.codigoFuncionario != null && !this.codigoFuncionario.equals(other.codigoFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.Model.Funcionario[ codigoFuncionario=" + codigoFuncionario + " ]";
    }
    
}
