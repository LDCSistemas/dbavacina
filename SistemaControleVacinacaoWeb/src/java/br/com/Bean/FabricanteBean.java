/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Bean;

import br.com.Dao.HibernateDao;
import br.com.Dao.InterfaceDao;
import br.com.Model.Fabricante;
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
@ManagedBean(name = "fabricanteBean")
@SessionScoped
public class FabricanteBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Fabricante fabricante = new Fabricante();
    private List<Fabricante> fabricantes;

    public FabricanteBean() {

    }

    private InterfaceDao<Fabricante> fabricanteDao() {
        InterfaceDao<Fabricante> fabricanteDao = new HibernateDao<Fabricante>(Fabricante.class, FacesContextUtil.getRequestSession());
        return fabricanteDao;
    }

    public String editFabricante() {

        return "/restrict/Fabricantes.jsf";
    }

    public void insertFabricante() {
        fabricanteDao().save(fabricante);
        Mensagens.MensagemSucesso("Cadastro atualizado com sucesso");
        limpaFabricante();
    }

    public void updateFabricante() {
        fabricanteDao().update(fabricante);
        Mensagens.MensagemSucesso("Atualização efetuada com sucesso");
        limpaFabricante();
    }

    private void deleteFabricante() {
        fabricanteDao().remove(fabricante);
        Mensagens.MensagemSucesso("Fabricante excluída com sucesso");
        limpaFabricante();
    }

    private String limpaFabricante() {
        fabricante = new Fabricante();
        return "/restrict/Fabricantes.jsf";
    }

    public List<Fabricante> getFabricantes() {
        fabricantes = fabricanteDao().getEntities();
        return fabricantes;
    }

    public void setFabricantes(List<Fabricante> fabricantes) {
        this.fabricantes = fabricantes;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

}
