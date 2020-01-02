package autoEscola.util.validacoes.validacoesDataBase;

import autoEscola.database.FabricaConexao;
import autoEscola.util.validacoes.validaCPF.ValidaCPF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidacoesBancoDeDados {

    public static boolean cpfExistenteDataBaseAluno(String CPF) {
        PreparedStatement stmt = null;
        Connection conexao = conexao = FabricaConexao.getConnection();
        if (ValidaCPF.isCPF(CPF) == true) {
            String SQL = "SELECT cpf FROM aluno WHERE cpf = ?";
            try {                
                stmt = conexao.prepareStatement(SQL);
                stmt.setString(1, CPF);               
                ResultSet resultado = stmt.executeQuery(SQL);
                int contador = 0;
                while (resultado.next()) {
                    contador++;
                }
                stmt.close();
                conexao.close();
               
                if (contador > 1) {
                    return true;
                } else {
                    return false;
                }
                
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return false;
        } else {
            return false;
        }
    }

}
