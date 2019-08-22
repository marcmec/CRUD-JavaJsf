package br.com.ramaiscompany.bean;


import br.com.ramaiscompany.dao.UsuarioDAO;
import br.com.ramaiscompany.model.Usuario;
import br.com.ramaiscompany.util.ContextoSessaoUtil;
import br.com.ramaiscompany.util.MensagemUtil;
import br.com.ramaiscompany.util.PaginasUtil;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.IOException;

@ManagedBean (name = "loginBean")
@SessionScoped
public class UsuarioBean {

    private Usuario logarUsuario = new Usuario();
    private UsuarioDAO usuarioDAO= new UsuarioDAO();
    private Usuario usuarioNaSessao;
    private Boolean usuarioLogadoNaSessao =false;



    public Usuario getLogarUsuario() {
        return logarUsuario;
    }

    public void setLogarUsuario(Usuario logarUsuario) {
        this.logarUsuario = logarUsuario;
    }


    public void realizarLoginDoUsuario() throws IOException {

        usuarioNaSessao = usuarioDAO.verificarUsuarioExistente(logarUsuario);

            if(usuarioNaSessao !=null) {
                usuarioLogadoNaSessao =true;
                PaginasUtil.irParaPaginaDeEditarTelefones();
                ContextoSessaoUtil.adicionarObjetoNaSessao(usuarioNaSessao);
            } else {
                MensagemUtil.notificarUsuario("Erro!", "usuario ou senha invalidos!", FacesMessage.SEVERITY_ERROR);
        }
    }
    public String verificarUsuarioLogado() throws IOException {

        if(usuarioLogadoNaSessao){

            ContextoSessaoUtil.retornarObjetoNaSessao(usuarioNaSessao);
            return usuarioNaSessao.getUsuario();
        }
            PaginasUtil.irParaPaginadeLogin();
        return "";
    }

    public void finalizarSessao() throws IOException{
        ContextoSessaoUtil.encerrarSessao();
    }

}
