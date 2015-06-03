/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Bean;

import br.com.Dao.HibernateDao;
import br.com.Dao.InterfaceDao;
import br.com.Model.Atendimento;
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
@ManagedBean(name = "atendimentoBean")
@SessionScoped
public class AtendimentoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Atendimento atendimento = new Atendimento();
    private List<Atendimento> atendimentos;

    public AtendimentoBean() {

    }

    private InterfaceDao<Atendimento> atendimentoDao() {
        InterfaceDao<Atendimento> atendimentoDao = new HibernateDao<Atendimento>(Atendimento.class, FacesContextUtil.getRequestSession());
        return atendimentoDao;
    }

    public String editAtendimento() {

        return "/restrict/Atendimentos.jsf";
    }

    public void insertAtendimento() {
        atendimentoDao().save(atendimento);
        Mensagens.MensagemSucesso("Cadastro atualizado com sucesso");
        limpaAtendimento();
    }

    public void updateAtendimento() {
        atendimentoDao().update(atendimento);
        Mensagens.MensagemSucesso("Atualização efetuada com sucesso");
        limpaAtendimento();
    }

    private void deleteAtendimento() {
        atendimentoDao().remove(atendimento);
        Mensagens.MensagemSucesso("Atendimento excluída com sucesso");
        limpaAtendimento();
    }

    private String limpaAtendimento() {
        atendimento = new Atendimento();
        return "/restrict/Atendimentos.jsf";
    }

    public List<Atendimento> getAtendimentos() {
        atendimentos = atendimentoDao().getEntities();
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

}
