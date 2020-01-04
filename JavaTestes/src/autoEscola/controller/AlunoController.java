package autoEscola.controller;

import autoEscola.database.FabricaConexao;
import autoEscola.model.Aluno.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoController {

    public static void addAluno(Aluno aluno) {
        Connection conexao = FabricaConexao.getConnection();
        String sql = "INSERT INTO aluno (nome, idade, cpf, aceitaTroca) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getCpf());
            stmt.setBoolean(4, aluno.getAceitaTroca());
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
