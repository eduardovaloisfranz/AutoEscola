package autoEscola.controller;

import autoEscola.database.FabricaConexao;
import autoEscola.model.Aluno.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
