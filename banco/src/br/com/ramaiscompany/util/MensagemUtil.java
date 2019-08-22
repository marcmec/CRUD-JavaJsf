package br.com.ramaiscompany.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensagemUtil {

    public static void notificarUsuario(String s, String mensagem, FacesMessage.Severity tipoDeMensagem){
        FacesContext context= FacesContext.getCurrentInstance();
        FacesMessage msg= new FacesMessage(tipoDeMensagem,s,mensagem);
        context.addMessage(null,msg);
    }
}
