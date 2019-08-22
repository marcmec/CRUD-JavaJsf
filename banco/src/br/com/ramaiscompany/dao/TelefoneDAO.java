package br.com.ramaiscompany.dao;

import br.com.ramaiscompany.factory.ConexaoFactory;
import br.com.ramaiscompany.model.Telefone;
import br.com.ramaiscompany.util.BancoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelefoneDAO {


    public void inserirTelefone(Telefone telefone) throws BancoUtil {
        Connection conexao=null;
        conexao = ConexaoFactory.getConexao();
        PreparedStatement preparedStatement;
        String sqlInserir = "INSERT INTO public.ramais(orgao,setor,responsavel,ramal) VALUES (?,?,?,?)";

        try {
            preparedStatement = conexao.prepareStatement(sqlInserir);

            preparedStatement.setString(1, telefone.getOrgao().toUpperCase());
            preparedStatement.setString(2, telefone.getSetor().toUpperCase());
            preparedStatement.setString(3, telefone.getResponsavel());
            preparedStatement.setString(4, telefone.getRamal());
            preparedStatement.executeUpdate();
            conexao.commit();
        } catch (SQLException E) {
            throw new BancoUtil("Erro ao tentar salvar contato", E);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public List<Telefone> consultarTelefone() throws BancoUtil {
        Connection conexao=null;
        conexao = ConexaoFactory.getConexao();
        Telefone telefone;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sqlSelecionar = "SELECT id,orgao,setor,responsavel,ramal FROM public.ramais";
        List<Telefone> listaTelefones = new ArrayList<>();
        try {
            preparedStatement = conexao.prepareStatement(sqlSelecionar);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                telefone = new Telefone();
                telefone.setId(resultSet.getInt("id"));
                telefone.setOrgao(resultSet.getString("orgao"));
                telefone.setSetor(resultSet.getString("setor"));
                telefone.setResponsavel(resultSet.getString("responsavel"));
                telefone.setRamal(resultSet.getString("ramal"));

                listaTelefones.add(telefone);
            }
            return listaTelefones;
        } catch (SQLException e) {
            throw new BancoUtil("Erro ao tentar consultar tabela", e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void editarTelefone(Telefone telefone) throws BancoUtil {
        Connection conexao=null;

        String editSql = "UPDATE public.ramais SET orgao=?, setor=?, responsavel=?, ramal=? WHERE id=?";
        PreparedStatement preparedStatement;
        conexao = ConexaoFactory.getConexao();

        try {
            preparedStatement = conexao.prepareStatement(editSql);
            preparedStatement.setString(1, telefone.getOrgao().toUpperCase());
            preparedStatement.setString(2, telefone.getSetor().toUpperCase());
            preparedStatement.setString(3, telefone.getResponsavel());
            preparedStatement.setString(4, telefone.getRamal());
            preparedStatement.setInt(5, telefone.getId());
            preparedStatement.executeUpdate();
            conexao.commit();

        } catch (SQLException e) {
            throw new BancoUtil("Erro ao tentar editarTelefone contato", e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void excluirTelefone(Telefone telefone) throws BancoUtil {
        Connection conexao=null;

        conexao = ConexaoFactory.getConexao();
        String excluirSql = "DELETE FROM public.ramais where id=?";
        PreparedStatement preparedStatement;
        try {

            preparedStatement = conexao.prepareStatement(excluirSql);
            preparedStatement.setInt(1, telefone.getId());
            preparedStatement.execute();
            conexao.commit();
        } catch (SQLException e) {
            throw new BancoUtil("Erro ao tentar deletar contato", e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
