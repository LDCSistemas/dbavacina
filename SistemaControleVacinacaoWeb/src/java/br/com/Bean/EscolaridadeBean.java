/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Bean;

import br.com.Dao.HibernateDao;
import br.com.Dao.InterfaceDao;
import br.com.Model.Escolaridade;
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
@ManagedBean(name = "escolaridadeBean")
@SessionScoped
public class EscolaridadeBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Escolaridade escolaridade = new Escolaridade();
    private List<Escolaridade> escolaridades;

    public EscolaridadeBean() {

    }

    private InterfaceDao<Escolaridade> escolaridadeDao() {
        InterfaceDao<Escolaridade> escolaridadeDao = new HibernateDao<Escolaridade>(Escolaridade.class, FacesContextUtil.getRequestSession());
        return escolaridadeDao;
    }

    public String editEscolaridade() {

        return "/restrict/Escolaridades.jsf";
    }

    public void insertEscolaridade() {
        escolaridadeDao().save(escolaridade);
        Mensagens.MensagemSucesso("Cadastro atualizado com sucesso");
        limpaEscolaridade();
    }

    public void updateEscolaridade() {
        escolaridadeDao().update(escolaridade);
        Mensagens.MensagemSucesso("Atualização efetuada com sucesso");
        limpaEscolaridade();
    }

    private void deleteEscolaridade() {
        escolaridadeDao().remove(escolaridade);
        Mensagens.MensagemSucesso("Escolaridade excluída com sucesso");
        limpaEscolaridade();
    }

    private String limpaEscolaridade() {
        escolaridade = new Escolaridade();
        return "/restrict/Escolaridades.jsf";
    }

    public List<Escolaridade> getEscolaridades() {
        escolaridades = escolaridadeDao().getEntities();
        return escolaridades;
    }

    public void setEscolaridades(List<Escolaridade> escolaridades) {
        this.escolaridades = escolaridades;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

}
