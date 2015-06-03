/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Bean;

import br.com.Dao.HibernateDao;
import br.com.Dao.InterfaceDao;
import br.com.Model.Logradouro;
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
@ManagedBean(name = "logradouroBean")
@SessionScoped
public class LogradouroBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Logradouro logradouro = new Logradouro();
    private List<Logradouro> logradouros;

    public LogradouroBean() {

    }

    private InterfaceDao<Logradouro> logradouroDao() {
        InterfaceDao<Logradouro> logradouroDao = new HibernateDao<Logradouro>(Logradouro.class, FacesContextUtil.getRequestSession());
        return logradouroDao;
    }

    public String editLogradouro() {

        return "/restrict/Logradouros.jsf";
    }

    public void insertLogradouro() {
        logradouroDao().save(logradouro);
        Mensagens.MensagemSucesso("Cadastro atualizado com sucesso");
        limpaLogradouro();
    }

    public void updateLogradouro() {
        logradouroDao().update(logradouro);
        Mensagens.MensagemSucesso("Atualização efetuada com sucesso");
        limpaLogradouro();
    }

    private void deleteLogradouro() {
        logradouroDao().remove(logradouro);
        Mensagens.MensagemSucesso("Logradouro excluída com sucesso");
        limpaLogradouro();
    }

    private String limpaLogradouro() {
        logradouro = new Logradouro();
        return "/restrict/Logradouros.jsf";
    }

    public List<Logradouro> getLogradouros() {
        logradouros = logradouroDao().getEntities();
        return logradouros;
    }

    public void setLogradouros(List<Logradouro> logradouros) {
        this.logradouros = logradouros;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

}
