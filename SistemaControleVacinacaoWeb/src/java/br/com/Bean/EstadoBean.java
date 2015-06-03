/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Bean;

import br.com.Dao.HibernateDao;
import br.com.Dao.InterfaceDao;
import br.com.Model.Estado;
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
@ManagedBean(name = "estadoBean")
@SessionScoped
public class EstadoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Estado estado = new Estado();
    private List<Estado> estados;

    public EstadoBean() {

    }

    private InterfaceDao<Estado> estadoDao() {
        InterfaceDao<Estado> estadoDao = new HibernateDao<Estado>(Estado.class, FacesContextUtil.getRequestSession());
        return estadoDao;
    }

    public String editEstado() {

        return "/restrict/Estados.jsf";
    }

    public void insertEstado() {
        estadoDao().save(estado);
        Mensagens.MensagemSucesso("Cadastro atualizado com sucesso");
        limpaEstado();
    }

    public void updateEstado() {
        estadoDao().update(estado);
        Mensagens.MensagemSucesso("Atualização efetuada com sucesso");
        limpaEstado();
    }

    private void deleteEstado() {
        estadoDao().remove(estado);
        Mensagens.MensagemSucesso("Estado excluída com sucesso");
        limpaEstado();
    }

    private String limpaEstado() {
        estado = new Estado();
        return "/restrict/Estados.jsf";
    }

    public List<Estado> getEstados() {
        estados = estadoDao().getEntities();
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
