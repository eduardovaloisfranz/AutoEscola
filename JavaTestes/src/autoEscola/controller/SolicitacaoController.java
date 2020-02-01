/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoEscola.controller;

import autoEscola.database.FabricaConexao;
import autoEscola.model.Aula.TipoSolicitacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author duduf
 */
public class SolicitacaoController {
    public static void addSolicitacao(int idAulaOrigem, int idAulaDestino){
        Connection conexao = FabricaConexao.getConnection();
        String sql = "INSERT INTO solicitacao (statusSolicitacao, fk_aulaOrigem, fk_aulaDestino) VALUES (?, ?, ?)";
        PreparedStatement stmt = null;
        try {
            //por padrao é pendente            
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, TipoSolicitacao.PENDENTE.getSolicitacao());
            stmt.setInt(2, idAulaOrigem);
            stmt.setInt(3, idAulaDestino);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conexao.isClosed() == false || stmt.isClosed() == false) {
                    conexao.close();
                    stmt.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
