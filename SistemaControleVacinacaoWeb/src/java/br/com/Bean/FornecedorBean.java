/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Bean;

import br.com.Dao.HibernateDao;
import br.com.Dao.InterfaceDao;
import br.com.Model.Fornecedor;
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
@ManagedBean(name = "fornecedorBean")
@SessionScoped
public class FornecedorBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Fornecedor fornecedor = new Fornecedor();
    private List<Fornecedor> fornecedores;

    public FornecedorBean() {

    }

    private InterfaceDao<Fornecedor> fornecedorDao() {
        InterfaceDao<Fornecedor> fornecedorDao = new HibernateDao<Fornecedor>(Fornecedor.class, FacesContextUtil.getRequestSession());
        return fornecedorDao;
    }

    public String editFornecedor() {

        return "/restrict/Fornecedores.jsf";
    }

    public void insertFornecedor() {
        fornecedorDao().save(fornecedor);
        Mensagens.MensagemSucesso("Cadastro atualizado com sucesso");
        limpaFornecedor();
    }

    public void updateFornecedor() {
        fornecedorDao().update(fornecedor);
        Mensagens.MensagemSucesso("Atualização efetuada com sucesso");
        limpaFornecedor();
    }

    private void deleteFornecedor() {
        fornecedorDao().remove(fornecedor);
        Mensagens.MensagemSucesso("Fornecedor excluída com sucesso");
        limpaFornecedor();
    }

    private String limpaFornecedor() {
        fornecedor = new Fornecedor();
        return "/restrict/Fornecedores.jsf";
    }

    public List<Fornecedor> getFornecedores() {
        fornecedores = fornecedorDao().getEntities();
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

}
