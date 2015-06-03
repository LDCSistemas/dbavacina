/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Bean;

import br.com.Dao.HibernateDao;
import br.com.Dao.InterfaceDao;
import br.com.Model.Vacina;
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
@ManagedBean(name = "vacinaBean")
@SessionScoped
public class VacinaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Vacina vacina = new Vacina();
    private List<Vacina> vacinas;

    public VacinaBean() {

    }

    private InterfaceDao<Vacina> vacinaDao() {
        InterfaceDao<Vacina> vacinaDao = new HibernateDao<Vacina>(Vacina.class, FacesContextUtil.getRequestSession());
        return vacinaDao;
    }

    public String editVacina() {

        return "/restrict/Vacinas.jsf";
    }

    public String limpaVacina() {
        vacina = new Vacina();
        return "/restrict/Vacinas.jsf";
    }

    public void insertVacina() {
        vacinaDao().save(vacina);
        Mensagens.MensagemSucesso("Cadastro atualizado com sucesso");
        limpaVacina();
    }

    public void updateVacina() {
        vacinaDao().update(vacina);
        Mensagens.MensagemSucesso("Atualização efetuada com sucesso");
        limpaVacina();
    }

    private void deleteVacina() {
        vacinaDao().remove(vacina);
        Mensagens.MensagemSucesso("Vacina excluída com sucesso");
        limpaVacina();
    }

    public List<Vacina> getVacinas() {
        vacinas = vacinaDao().getEntities();
        return vacinas;
    }

    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

}
