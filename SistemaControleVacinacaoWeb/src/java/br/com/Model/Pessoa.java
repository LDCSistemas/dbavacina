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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristiano Seixas
 */
@Entity
@Table(name = "pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByCodigoPessoa", query = "SELECT p FROM Pessoa p WHERE p.codigoPessoa = :codigoPessoa"),
    @NamedQuery(name = "Pessoa.findByCep", query = "SELECT p FROM Pessoa p WHERE p.cep = :cep"),
    @NamedQuery(name = "Pessoa.findByCns", query = "SELECT p FROM Pessoa p WHERE p.cns = :cns"),
    @NamedQuery(name = "Pessoa.findByCodigoCertidao", query = "SELECT p FROM Pessoa p WHERE p.codigoCertidao = :codigoCertidao"),
    @NamedQuery(name = "Pessoa.findByCor", query = "SELECT p FROM Pessoa p WHERE p.cor = :cor"),
    @NamedQuery(name = "Pessoa.findByCpf", query = "SELECT p FROM Pessoa p WHERE p.cpf = :cpf"),
    @NamedQuery(name = "Pessoa.findByDataCadastro", query = "SELECT p FROM Pessoa p WHERE p.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "Pessoa.findByDateExpedicao", query = "SELECT p FROM Pessoa p WHERE p.dateExpedicao = :dateExpedicao"),
    @NamedQuery(name = "Pessoa.findByDataNascimento", query = "SELECT p FROM Pessoa p WHERE p.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Pessoa.findByDescricaoLogradouro", query = "SELECT p FROM Pessoa p WHERE p.descricaoLogradouro = :descricaoLogradouro"),
    @NamedQuery(name = "Pessoa.findByEmail", query = "SELECT p FROM Pessoa p WHERE p.email = :email"),
    @NamedQuery(name = "Pessoa.findByEstadoCivil", query = "SELECT p FROM Pessoa p WHERE p.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "Pessoa.findByIdentidade", query = "SELECT p FROM Pessoa p WHERE p.identidade = :identidade"),
    @NamedQuery(name = "Pessoa.findByNomeMae", query = "SELECT p FROM Pessoa p WHERE p.nomeMae = :nomeMae"),
    @NamedQuery(name = "Pessoa.findByNomePai", query = "SELECT p FROM Pessoa p WHERE p.nomePai = :nomePai"),
    @NamedQuery(name = "Pessoa.findByNomePessoa", query = "SELECT p FROM Pessoa p WHERE p.nomePessoa = :nomePessoa"),
    @NamedQuery(name = "Pessoa.findByNumeroLogradouro", query = "SELECT p FROM Pessoa p WHERE p.numeroLogradouro = :numeroLogradouro"),
    @NamedQuery(name = "Pessoa.findByOrgaoEmissor", query = "SELECT p FROM Pessoa p WHERE p.orgaoEmissor = :orgaoEmissor"),
    @NamedQuery(name = "Pessoa.findBySexo", query = "SELECT p FROM Pessoa p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Pessoa.findByTelefoneCelular", query = "SELECT p FROM Pessoa p WHERE p.telefoneCelular = :telefoneCelular"),
    @NamedQuery(name = "Pessoa.findByTelefoneResidencial", query = "SELECT p FROM Pessoa p WHERE p.telefoneResidencial = :telefoneResidencial"),
    @NamedQuery(name = "Pessoa.findByComplemento", query = "SELECT p FROM Pessoa p WHERE p.complemento = :complemento")})
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO_PESSOA")
    private Long codigoPessoa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "CEP")
    private String cep;
    @Size(max = 20)
    @Column(name = "CNS")
    private String cns;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODIGO_CERTIDAO")
    private String codigoCertidao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "COR")
    private String cor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CPF")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_CADASTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Column(name = "DATE_EXPEDICAO")
    @Temporal(TemporalType.DATE)
    private Date dateExpedicao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_NASCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "DESCRICAO_LOGRADOURO")
    private String descricaoLogradouro;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "ESTADO_CIVIL")
    private String estadoCivil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "IDENTIDADE")
    private String identidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "NOME_MAE")
    private String nomeMae;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "NOME_PAI")
    private String nomePai;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "NOME_PESSOA")
    private String nomePessoa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_LOGRADOURO")
    private int numeroLogradouro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "ORGAO_EMISSOR")
    private String orgaoEmissor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SEXO")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "TELEFONE_CELULAR")
    private String telefoneCelular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "TELEFONE_RESIDENCIAL")
    private String telefoneResidencial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @JoinColumn(name = "CODIGO_PROFISSAO", referencedColumnName = "CODIGO_PROFISSAO")
    @ManyToOne(optional = false)
    private Profissao codigoProfissao;
    @JoinColumn(name = "CODIGO_CIDADE", referencedColumnName = "CODIGO_CIDADE")
    @ManyToOne(optional = false)
    private Cidade codigoCidade;
    @JoinColumn(name = "CODIGO_ESTADO", referencedColumnName = "CODIGO_ESTADO")
    @ManyToOne(optional = false)
    private Estado codigoEstado;
    @JoinColumn(name = "CODIGO_ESCOLARIDADE", referencedColumnName = "CODIGO_ESCOLARIDADE")
    @ManyToOne(optional = false)
    private Escolaridade codigoEscolaridade;
    @JoinColumn(name = "CODIGO_BAIRRO", referencedColumnName = "CODIGO_BAIRRO")
    @ManyToOne(optional = false)
    private Bairro codigoBairro;
    @JoinColumn(name = "CODIGO_USUARIO_CADASTRO", referencedColumnName = "CODIGO_USUARIO")
    @ManyToOne(optional = false)
    private Usuario codigoUsuarioCadastro;
    @JoinColumn(name = "CODIGO_NATURALIDADE", referencedColumnName = "CODIGO_CIDADE")
    @ManyToOne(optional = false)
    private Cidade codigoNaturalidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoPessoa")
    private List<Atendimento> atendimentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoPessoa")
    private List<Usuario> usuarioList;

    public Pessoa() {
    }

    public Pessoa(Long codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public Pessoa(Long codigoPessoa, String cep, String codigoCertidao, String cor, String cpf, Date dataCadastro, Date dataNascimento, String descricaoLogradouro, String estadoCivil, String identidade, String nomeMae, String nomePai, String nomePessoa, int numeroLogradouro, String orgaoEmissor, String sexo, String telefoneCelular, String telefoneResidencial, String complemento) {
        this.codigoPessoa = codigoPessoa;
        this.cep = cep;
        this.codigoCertidao = codigoCertidao;
        this.cor = cor;
        this.cpf = cpf;
        this.dataCadastro = dataCadastro;
        this.dataNascimento = dataNascimento;
        this.descricaoLogradouro = descricaoLogradouro;
        this.estadoCivil = estadoCivil;
        this.identidade = identidade;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.nomePessoa = nomePessoa;
        this.numeroLogradouro = numeroLogradouro;
        this.orgaoEmissor = orgaoEmissor;
        this.sexo = sexo;
        this.telefoneCelular = telefoneCelular;
        this.telefoneResidencial = telefoneResidencial;
        this.complemento = complemento;
    }

    public Long getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(Long codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCns() {
        return cns;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

    public String getCodigoCertidao() {
        return codigoCertidao;
    }

    public void setCodigoCertidao(String codigoCertidao) {
        this.codigoCertidao = codigoCertidao;
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

    public Date getDateExpedicao() {
        return dateExpedicao;
    }

    public void setDateExpedicao(Date dateExpedicao) {
        this.dateExpedicao = dateExpedicao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDescricaoLogradouro() {
        return descricaoLogradouro;
    }

    public void setDescricaoLogradouro(String descricaoLogradouro) {
        this.descricaoLogradouro = descricaoLogradouro;
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

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public int getNumeroLogradouro() {
        return numeroLogradouro;
    }

    public void setNumeroLogradouro(int numeroLogradouro) {
        this.numeroLogradouro = numeroLogradouro;
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

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Profissao getCodigoProfissao() {
        return codigoProfissao;
    }

    public void setCodigoProfissao(Profissao codigoProfissao) {
        this.codigoProfissao = codigoProfissao;
    }

    public Cidade getCodigoCidade() {
        return codigoCidade;
    }

    public void setCodigoCidade(Cidade codigoCidade) {
        this.codigoCidade = codigoCidade;
    }

    public Estado getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Estado codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public Escolaridade getCodigoEscolaridade() {
        return codigoEscolaridade;
    }

    public void setCodigoEscolaridade(Escolaridade codigoEscolaridade) {
        this.codigoEscolaridade = codigoEscolaridade;
    }

    public Bairro getCodigoBairro() {
        return codigoBairro;
    }

    public void setCodigoBairro(Bairro codigoBairro) {
        this.codigoBairro = codigoBairro;
    }

    public Usuario getCodigoUsuarioCadastro() {
        return codigoUsuarioCadastro;
    }

    public void setCodigoUsuarioCadastro(Usuario codigoUsuarioCadastro) {
        this.codigoUsuarioCadastro = codigoUsuarioCadastro;
    }

    public Cidade getCodigoNaturalidade() {
        return codigoNaturalidade;
    }

    public void setCodigoNaturalidade(Cidade codigoNaturalidade) {
        this.codigoNaturalidade = codigoNaturalidade;
    }

    @XmlTransient
    public List<Atendimento> getAtendimentoList() {
        return atendimentoList;
    }

    public void setAtendimentoList(List<Atendimento> atendimentoList) {
        this.atendimentoList = atendimentoList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPessoa != null ? codigoPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.codigoPessoa == null && other.codigoPessoa != null) || (this.codigoPessoa != null && !this.codigoPessoa.equals(other.codigoPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.Model.Pessoa[ codigoPessoa=" + codigoPessoa + " ]";
    }
    
}
