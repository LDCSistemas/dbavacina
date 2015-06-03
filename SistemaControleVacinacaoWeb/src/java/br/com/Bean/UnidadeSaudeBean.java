/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Bean;

import br.com.Dao.HibernateDao;
import br.com.Dao.InterfaceDao;
import br.com.Model.UnidadeSaude;
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
@ManagedBean(name = "unidadeSaudeBean")
@SessionScoped
public class UnidadeSaudeBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private UnidadeSaude unidadeSaude = new UnidadeSaude();
    private List<UnidadeSaude> unidadesSaude;

    public UnidadeSaudeBean() {

    }

    private InterfaceDao<UnidadeSaude> unidadeSaudeDao() {
        InterfaceDao<UnidadeSaude> unidadeSaudeDao = new HibernateDao<UnidadeSaude>(UnidadeSaude.class, FacesContextUtil.getRequestSession());
        return unidadeSaudeDao;
    }

    public String editUnidadeSaude() {

        return "/restrict/UnidadesSaude.jsf";
    }

    public void insertUnidadeSaude() {
        unidadeSaudeDao().save(unidadeSaude);
        Mensagens.MensagemSucesso("Cadastro atualizado com sucesso");
        limpaUnidadeSaude();
    }

    public void updateUnidadeSaude() {
        unidadeSaudeDao().update(unidadeSaude);
        Mensagens.MensagemSucesso("Atualização efetuada com sucesso");
        limpaUnidadeSaude();
    }

    private void deleteUnidadeSaude() {
        unidadeSaudeDao().remove(unidadeSaude);
        Mensagens.MensagemSucesso("UnidadeSaude excluída com sucesso");
        limpaUnidadeSaude();
    }

    private String limpaUnidadeSaude() {
        unidadeSaude = new UnidadeSaude();
        return "/restrict/UnidadesSaude.jsf";
    }

    public List<UnidadeSaude> getUnidadesSaude() {
        unidadesSaude = unidadeSaudeDao().getEntities();
        return unidadesSaude;
    }

    public void setUnidadesSaude(List<UnidadeSaude> unidadesSaude) {
        this.unidadesSaude = unidadesSaude;
    }

    public UnidadeSaude getUnidadeSaude() {
        return unidadeSaude;
    }

    public void setUnidadeSaude(UnidadeSaude unidadeSaude) {
        this.unidadeSaude = unidadeSaude;
    }

}
