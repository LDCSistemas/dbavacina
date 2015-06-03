/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Bean;

import br.com.Dao.HibernateDao;
import br.com.Dao.InterfaceDao;
import br.com.Model.Funcionario;
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
@ManagedBean(name = "funcionarioBean")
@SessionScoped
public class FuncionarioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Funcionario funcionario = new Funcionario();
    private List<Funcionario> funcionarios;

    public FuncionarioBean() {

    }

    private InterfaceDao<Funcionario> funcionarioDao() {
        InterfaceDao<Funcionario> funcionarioDao = new HibernateDao<Funcionario>(Funcionario.class, FacesContextUtil.getRequestSession());
        return funcionarioDao;
    }

    public String editFuncionario() {

        return "/restrict/Funcionarios.jsf";
    }

    public void insertFuncionario() {
        funcionarioDao().save(funcionario);
        Mensagens.MensagemSucesso("Cadastro atualizado com sucesso");
        limpaFuncionario();
    }

    public void updateFuncionario() {
        funcionarioDao().update(funcionario);
        Mensagens.MensagemSucesso("Atualização efetuada com sucesso");
        limpaFuncionario();
    }

    private void deleteFuncionario() {
        funcionarioDao().remove(funcionario);
        Mensagens.MensagemSucesso("Funcionario excluída com sucesso");
        limpaFuncionario();
    }

    private String limpaFuncionario() {
        funcionario = new Funcionario();
        return "/restrict/Funcionarios.jsf";
    }

    public List<Funcionario> getFuncionarios() {
        funcionarios = funcionarioDao().getEntities();
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
