package br.com.ramaiscompany.util;

import java.io.IOException;
public class PaginasUtil {


    public static void irParaPaginaDeEditarTelefones() throws IOException {
        String url = ContextoSessaoUtil.externalContext().getRequestContextPath();
       ContextoSessaoUtil.externalContext().redirect(url+"/faces/telefones.xhtml");
    }

    public static void irParaPaginadeLogin() throws IOException {
        String url = ContextoSessaoUtil.externalContext().getRequestContextPath();
        ContextoSessaoUtil.externalContext().redirect(url + "/faces/login.xhtml");
    }

}
