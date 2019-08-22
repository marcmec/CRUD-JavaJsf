package br.com.ramaiscompany.util;
/*Emitir mensagem para o usuario,
com erro do banco, se necessario!
*/
public class BancoUtil extends  Exception {

    public BancoUtil(String s) {
        super(s);
    }

    public BancoUtil(String s, Throwable throwable) {
        super(s, throwable);
    }

}
