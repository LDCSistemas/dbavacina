/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Bean;

import br.com.Dao.HibernateDao;
import br.com.Dao.InterfaceDao;
import br.com.Model.Pessoa;
import br.com.Utilitarios.FacesContextUtil;
import br.com.Utilitarios.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Cristiano Seixas
 */
@ManagedBean(name = "pessoaBean")
@SessionScoped
public class PessoaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Pessoa pessoa = new Pessoa();
    private List<Pessoa> pessoas;

    public PessoaBean() {

    }

    private InterfaceDao<Pessoa> pessoaDao() {
        InterfaceDao<Pessoa> pessoaDao = new HibernateDao<Pessoa>(Pessoa.class, FacesContextUtil.getRequestSession());
        return pessoaDao;
    }

    public String editPessoa() {

        return "/restrict/Pessoas.jsf";
    }

    public void insertPessoa() {
        pessoaDao().save(pessoa);
        Mensagens.MensagemSucesso("Cadastro atualizado com sucesso");
        LimpaCidade();
    }

    public void updatePessoa() {
        pessoaDao().update(pessoa);
        Mensagens.MensagemSucesso("Atualização efetuada com sucesso");
        LimpaCidade();
    }

    private void deletePessoa() {
        pessoaDao().remove(pessoa);
        Mensagens.MensagemSucesso("Pessoa excluída com sucesso");
        LimpaCidade();
    }

    private String LimpaCidade() {
        pessoa = new Pessoa();
        return "/restrict/Pessoas.jsf";
    }

    public List<Pessoa> getPessoas() {
        pessoas = pessoaDao().getEntities();
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
