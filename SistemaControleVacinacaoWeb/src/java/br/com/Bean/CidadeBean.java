/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Bean;

import br.com.Dao.HibernateDao;
import br.com.Dao.InterfaceDao;
import br.com.Model.Cidade;
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
@ManagedBean(name = "cidadeBean")
@SessionScoped
public class CidadeBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Cidade cidade = new Cidade();
    private List<Cidade> cidades;

    public CidadeBean() {

    }

    private InterfaceDao<Cidade> cidadeDao() {
        InterfaceDao<Cidade> cidadeDao = new HibernateDao<Cidade>(Cidade.class, FacesContextUtil.getRequestSession());
        return cidadeDao;
    }

    public String editCidade() {

        return "/restrict/Cidades.jsf";
    }

    public void insertCidade() {
        cidadeDao().save(cidade);
        Mensagens.MensagemSucesso("Cadastro atualizado com sucesso");
        limpaCidade();
    }

    public void updateCidade() {
        cidadeDao().update(cidade);
        Mensagens.MensagemSucesso("Atualização efetuada com sucesso");
        limpaCidade();
    }

    private void deleteCidade() {
        cidadeDao().remove(cidade);
        Mensagens.MensagemSucesso("Cidade excluída com sucesso");
        limpaCidade();
    }

    private String limpaCidade() {
        cidade = new Cidade();
        return "/restrict/Cidades.jsf";
    }

    public List<Cidade> getCidades() {
        cidades = cidadeDao().getEntities();
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}
