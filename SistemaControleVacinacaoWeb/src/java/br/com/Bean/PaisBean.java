/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Bean;

import br.com.Dao.HibernateDao;
import br.com.Dao.InterfaceDao;
import br.com.Model.Pais;
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
@ManagedBean(name = "paisBean")
@SessionScoped
public class PaisBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Pais pais = new Pais();
    private List<Pais> paises;

    public PaisBean() {

    }

    private InterfaceDao<Pais> paisDao() {
        InterfaceDao<Pais> paisDao = new HibernateDao<Pais>(Pais.class, FacesContextUtil.getRequestSession());
        return paisDao;
    }

    public String editPais() {

        return "/restrict/Paises.jsf";
    }

    public void insertPais() {
        paisDao().save(pais);
        Mensagens.MensagemSucesso("Cadastro atualizado com sucesso");
        limpaPais();
    }

    public void updatePais() {
        paisDao().update(pais);
        Mensagens.MensagemSucesso("Atualização efetuada com sucesso");
        limpaPais();
    }

    private void deletePais() {
        paisDao().remove(pais);
        Mensagens.MensagemSucesso("Pais excluída com sucesso");
        limpaPais();
    }

    private String limpaPais() {
        pais = new Pais();
        return "/restrict/Paises.jsf";
    }

    public List<Pais> getPaises() {
        paises = paisDao().getEntities();
        return paises;
    }

    public void setPaises(List<Pais> paises) {
        this.paises = paises;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

}
