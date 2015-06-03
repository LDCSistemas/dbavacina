/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Bean;

import br.com.Dao.HibernateDao;
import br.com.Dao.InterfaceDao;
import br.com.Model.Profissao;
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
@ManagedBean(name = "profissaoBean")
@SessionScoped
public class ProfissaoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Profissao profissao = new Profissao();
    private List<Profissao> profissoes;

    public ProfissaoBean() {

    }

    private InterfaceDao<Profissao> profissaoDao() {
        InterfaceDao<Profissao> profissaoDao = new HibernateDao<Profissao>(Profissao.class, FacesContextUtil.getRequestSession());
        return profissaoDao;
    }

    public String editProfissao() {

        return "/restrict/Profissoes.jsf";
    }

    public void insertProfissao() {
        profissaoDao().save(profissao);
        Mensagens.MensagemSucesso("Cadastro atualizado com sucesso");
        limpaProfissao();
    }

    public void updateProfissao() {
        profissaoDao().update(profissao);
        Mensagens.MensagemSucesso("Atualização efetuada com sucesso");
        limpaProfissao();
    }

    private void deleteProfissao() {
        profissaoDao().remove(profissao);
        Mensagens.MensagemSucesso("Profissao excluída com sucesso");
        limpaProfissao();
    }

    private String limpaProfissao() {
        profissao = new Profissao();
        return "/restrict/Profissoes.jsf";
    }

    public List<Profissao> getProfissoes() {
        profissoes = profissaoDao().getEntities();
        return profissoes;
    }

    public void setProfissoes(List<Profissao> profissoes) {
        this.profissoes = profissoes;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

}
