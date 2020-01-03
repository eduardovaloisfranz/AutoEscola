package autoEscola.util.validacoes.validacoesDataBase;

import autoEscola.database.FabricaConexao;
import autoEscola.model.Aula.Aula;
import autoEscola.util.validacoes.validaCPF.ValidaCPF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ValidacoesBancoDeDados {

    public static boolean cpfExistenteDataBaseAluno(String CPF) {
        PreparedStatement stmt = null;
        Connection conexao = conexao = FabricaConexao.getConnection();
        if (ValidaCPF.isCPF(CPF) == true) {
            String SQL = "SELECT COUNT(cpf)'qtdCpf' FROM aluno WHERE cpf = ?;";
            try {
                stmt = conexao.prepareStatement(SQL);
                stmt.setString(1, ValidaCPF.imprimeCPF(CPF));
                ResultSet resultado = stmt.executeQuery();
                short quantidadeCpf = 0;
                while (resultado.next()) {
                    quantidadeCpf = resultado.getShort("qtdCpf");
                }                
                stmt.close();
                conexao.close();
                if(quantidadeCpf >= 1){
                    return true;
                }else{
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

    public static boolean cpfExistenteDataBaseInstrutor(String CPF) {
        PreparedStatement stmt = null;
        Connection conexao = conexao = FabricaConexao.getConnection();
        if (ValidaCPF.isCPF(CPF) == true) {
            String SQL = "SELECT COUNT(cpf) FROM instrutor WHERE cpf = ?";
            try {
                stmt = conexao.prepareStatement(SQL);
                stmt.setString(1, ValidaCPF.imprimeCPF(CPF));                
                ResultSet resultado = stmt.executeQuery();
                while (resultado.next()) {
                    if (resultado.getInt(1) >= 1) {
                        return true;
                    } else {
                        return false;
                    }
                }
                stmt.close();
                conexao.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return false;
        } else {
            return false;
        }
    }

    public static boolean validarAulaCarro(Aula aula, String cpfInstrutor) {
        String SQL = "SELECT COUNT(a.dataAulaInicio)'qtdAulas', COUNT(b.cpf)'qtdInstrutor' FROM aula a"
                + " JOIN instrutor B ON a.fk_instrutor = b.id WHERE (? BETWEEN a.dataAulaInicio AND a.dataAulaTermino) AND (a.modalidadeAula = 'Carro') AND (b.cpf = ?)";
        Connection conexao = FabricaConexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(SQL);
            stmt.setString(1, getDataFormatadaBanco(aula.getDataAulaInicio()));
            stmt.setString(2, cpfInstrutor);
            ResultSet resultado = stmt.executeQuery();
            short qtdAulasPorDataInformada = 0, qtdAulasPorInstrutorInformado = 0;
            while(resultado.next()){
                qtdAulasPorDataInformada = resultado.getShort("qtdAulas");
                qtdAulasPorInstrutorInformado = resultado.getShort("qtdInstrutor");
            }
            resultado.close();
            conexao.close();
            stmt.close();
            if((qtdAulasPorDataInformada >= 1) || (qtdAulasPorInstrutorInformado >= 1)){
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getDataFormatadaBanco(LocalDateTime data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return data.format(formatter);
    }
}
