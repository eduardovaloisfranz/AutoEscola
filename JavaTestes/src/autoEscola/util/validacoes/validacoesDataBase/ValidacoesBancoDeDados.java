package autoEscola.util.validacoes.validacoesDataBase;

import autoEscola.database.FabricaConexao;
import autoEscola.model.Aula.Aula;
import autoEscola.model.Aula.ModalidadeAula;
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
        ResultSet resultado = null;
        if (ValidaCPF.isCPF(CPF) == true) {
            String SQL = "SELECT COUNT(cpf)'qtdCpf' FROM aluno WHERE cpf = ?;";
            try {
                stmt = conexao.prepareStatement(SQL);
                stmt.setString(1, ValidaCPF.imprimeCPF(CPF));
                resultado = stmt.executeQuery();
                short quantidadeCpf = 0;
                while (resultado.next()) {
                    quantidadeCpf = resultado.getShort("qtdCpf");
                }
                if (quantidadeCpf >= 1) {
                    return true;
                } else {
                    return false;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conexao.isClosed() == false || stmt.isClosed() == false) {
                        conexao.close();
                        stmt.close();
                        resultado.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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

            return false;
        } else {
            return false;
        }
    }

    public static boolean validarAula(Aula aula, String cpfInstrutor) {        //String SQL = "SELECT COUNT(a.dataAulaInicio)'qtdAulaInicio', COUNT(b.cpf)'qtdInstrutor', COUNT(a.dataAulaTermino)'qtdAulaTermino' FROM aula a"
        //      + " JOIN instrutor B ON a.fk_instrutor = b.id WHERE ((? BETWEEN a.dataAulaInicio AND a.dataAulaTermino) OR (?  BETWEEN a.dataAulaInicio AND a.dataAulaTermino)) AND (b.cpf = ?)";

        String SQL = "SELECT COUNT(a.dataAulaInicio)'qtdAulaInicio', COUNT(a.dataAulaTermino)'qtdAulaTermino', a.modalidadeAula'modalidadeAula' FROM aula a"
                + " JOIN instrutor B ON a.fk_instrutor = b.id WHERE ((? BETWEEN a.dataAulaInicio AND a.dataAulaTermino) "
                + " OR (? BETWEEN a.dataAulaInicio AND a.dataAulaTermino) AND b.cpf = ?);";

        Connection conexao = FabricaConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet resultado = null;
        try {
            stmt = conexao.prepareStatement(SQL);
            stmt.setString(1, getDataFormatadaBanco(aula.getDataAulaInicio()));
            stmt.setString(2, getDataFormatadaBanco(aula.getDataAulaTermino()));
            stmt.setString(3, ValidaCPF.imprimeCPF(cpfInstrutor));
            resultado = stmt.executeQuery();
            short qtdAulasPorDataInicioInformada = 0, qtdAulasPorDataTerminoInformada = 0;
            String modalidadeAula = "";
            while (resultado.next()) {
                qtdAulasPorDataInicioInformada = resultado.getShort("qtdAulaInicio");
                qtdAulasPorDataTerminoInformada = resultado.getShort("qtdAulaTermino");
                modalidadeAula = resultado.getString("modalidadeAula");
            }
            if (modalidadeAula != null) {
                if (modalidadeAula.equals(ModalidadeAula.CARRO.getModalidade())) {
                    if ((qtdAulasPorDataInicioInformada >= 1) && (qtdAulasPorDataTerminoInformada >= 1)) {
                        return false;
                    } else {
                        return true;
                    }
                } else if (modalidadeAula.equals(ModalidadeAula.MOTO.getModalidade())) {
                    if ((qtdAulasPorDataInicioInformada >= 2) && (qtdAulasPorDataTerminoInformada >= 2)) {
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    return false;
                }
            }else{
                return true;
            }
                   

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (conexao.isClosed() == false || stmt.isClosed() == false) {
                    conexao.close();
                    stmt.close();
                    resultado.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
    }

    public static String getDataFormatadaBanco(LocalDateTime data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return data.format(formatter);
    }

    public static boolean validarAulaMoto(Aula aula, String cpfInstrutor) {
        return false;
    }
}
