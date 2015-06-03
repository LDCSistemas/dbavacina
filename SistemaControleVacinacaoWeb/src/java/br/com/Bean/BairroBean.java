/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Bean;

import br.com.Dao.HibernateDao;
import br.com.Dao.InterfaceDao;
import br.com.Model.Bairro;
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
@ManagedBean(name = "bairroBean")
@SessionScoped
public class BairroBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Bairro bairro = new Bairro();
    private List<Bairro> bairros;

    public BairroBean() {

    }

    private InterfaceDao<Bairro> bairroDao() {
        InterfaceDao<Bairro> bairroDao = new HibernateDao<Bairro>(Bairro.class, FacesContextUtil.getRequestSession());
        return bairroDao;
    }

    public String editBairro() {

        return "/restrict/Bairros.jsf";
    }

    public void insertBairro() {
        bairroDao().save(bairro);
        Mensagens.MensagemSucesso("Cadastro atualizado com sucesso");
        limpaBairro();
    }

    public void updateBairro() {
        bairroDao().update(bairro);
        Mensagens.MensagemSucesso("Atualização efetuada com sucesso");
        limpaBairro();
    }

    private void deleteBairro() {
        bairroDao().remove(bairro);
        Mensagens.MensagemSucesso("Bairro excluída com sucesso");
        limpaBairro();
    }

    private String limpaBairro() {
        bairro = new Bairro();
        return "/restrict/Bairros.jsf";
    }

    public List<Bairro> getBairros() {
        bairros = bairroDao().getEntities();
        return bairros;
    }

    public void setBairros(List<Bairro> bairros) {
        this.bairros = bairros;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

}
