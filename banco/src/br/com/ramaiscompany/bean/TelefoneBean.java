package br.com.ramaiscompany.bean;

import br.com.ramaiscompany.dao.TelefoneDAO;
import br.com.ramaiscompany.model.Telefone;
import br.com.ramaiscompany.util.BancoUtil;
import br.com.ramaiscompany.util.MensagemUtil;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "telbean")
@SessionScoped
public class TelefoneBean {

    private Telefone telefone;
    private TelefoneDAO telefoneDAO = new TelefoneDAO();
    private List<Telefone> listaTelefonica = new ArrayList<>();

    public void inserirTelefone() {
        try {
            listaTelefonica.add(telefone);
            telefoneDAO.inserirTelefone(telefone);
            telefone = new Telefone();
            MensagemUtil.notificarUsuario("Salvo!", "Contato salvo com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (BancoUtil s) {
            MensagemUtil.notificarUsuario(s.getMessage(), s.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void atualizarLista() {
        try {
            listaTelefonica = telefoneDAO.consultarTelefone();

            if (listaTelefonica.size() == 0 || listaTelefonica == null) {
                MensagemUtil.notificarUsuario("Lista Vazia", "Não foi retornado nenhum contato.", FacesMessage.SEVERITY_INFO);
            }
        } catch (BancoUtil s) {
            MensagemUtil.notificarUsuario(s.getMessage(), s.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void editarTelefone() {
        try {
            telefoneDAO.editarTelefone(telefone);
            MensagemUtil.notificarUsuario("Editado", "Contato editado com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (BancoUtil s) {
            MensagemUtil.notificarUsuario(s.getMessage(), s.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void excluirTelefone() {
        try {
            telefoneDAO.excluirTelefone(telefone);
            MensagemUtil.notificarUsuario("Excluído", "Contato excluido com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (BancoUtil s) {
            MensagemUtil.notificarUsuario(s.getMessage(), s.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void selecionarTelefone(Telefone t) {
        telefone = t;

    }


    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public List<Telefone> getListaTelefonica() {

        return listaTelefonica;
    }

    public void setListaTelefonica(List<Telefone> listaTelefonica) {
        this.listaTelefonica = listaTelefonica;
    }
}
