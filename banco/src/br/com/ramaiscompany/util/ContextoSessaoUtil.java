package br.com.ramaiscompany.util;



import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

public class ContextoSessaoUtil {

    private static String OBJETO_NA_SESSAO ="objetoNaSessao";


    public static ExternalContext externalContext(){
        if (FacesContext.getCurrentInstance() == null){
            throw new RuntimeException("Nao foi possivel acessar a aplicacao!");
        }else{
            return FacesContext.getCurrentInstance().getExternalContext();
        }
    }

    public static void adicionarObjetoNaSessao(Object objeto){

         externalContext().getSessionMap().put(OBJETO_NA_SESSAO,objeto);
    }

    public static void retornarObjetoNaSessao(Object objeto){
        externalContext().getSessionMap().get(objeto);
    }

    public static void encerrarSessao() throws IOException {
        externalContext().invalidateSession();
        PaginasUtil.irParaPaginadeLogin();
    }

}
