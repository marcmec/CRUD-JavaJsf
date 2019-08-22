package br.com.ramaiscompany.dao;

import br.com.ramaiscompany.factory.ConexaoFactory;
import br.com.ramaiscompany.model.Usuario;
import br.com.ramaiscompany.util.BancoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {


    public Usuario verificarUsuarioExistente(Usuario usuario) {
        Connection conexao=null;
        String sqlConsulta = "SELECT id,usuario,senha FROM public.usuarios WHERE usuario=? AND senha=?";
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Usuario usuarioValido = null;
        try {
            conexao = ConexaoFactory.getConexao();
            preparedStatement = conexao.prepareStatement(sqlConsulta);
            preparedStatement.setString(1, usuario.getUsuario().toLowerCase());
            preparedStatement.setString(2, usuario.getSenha());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                usuarioValido = new Usuario();
                usuarioValido.setId(resultSet.getInt("id"));
                usuarioValido.setUsuario(resultSet.getString("usuario"));
                usuarioValido.setSenha(resultSet.getString("senha"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (BancoUtil e) {
            e.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return usuarioValido;

    }


}
