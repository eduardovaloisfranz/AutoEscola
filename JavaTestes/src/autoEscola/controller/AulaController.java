package autoEscola.controller;

import autoEscola.database.FabricaConexao;
import autoEscola.model.Aluno.Aluno;
import autoEscola.model.Aula.Aula;
import autoEscola.model.Instrutor.Instrutor;
import autoEscola.util.MetodosUteis.MetodosUteis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AulaController {

    public static Integer addAula(Aula aula, Integer fkInstrutor, Integer fkAluno) {
        Integer idAula = null;
        String SQL = "INSERT INTO aula (dataAulaInicio, dataAulaTermino, quantidadeAula, modalidadeAula, fk_instrutor, fk_aluno) VALUES(?, ?, ? ,? , ?, ?)";
        Connection conexao = FabricaConexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            //stmt.setDate(1, java.sql.Date.valueOf(aula.getDataAulaInicio()));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String dataFormatada = aula.getDataAulaInicio().format(formatter);
            stmt.setString(1, dataFormatada);
            dataFormatada = aula.getDataAulaTermino().format(formatter);
            stmt.setString(2, dataFormatada);
            stmt.setShort(3, aula.getQuantidadeAulas());
            stmt.setString(4, aula.getModalidadeAula().getModalidade());
            stmt.setInt(5, fkInstrutor);
            stmt.setInt(6, fkAluno);
            stmt.executeUpdate();
            ResultSet resultado = stmt.getGeneratedKeys();
            while (resultado.next()) {
                idAula = resultado.getInt(1);
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

        return idAula;
    }

    public static void addAula(Aula aula, String cpfInstrutor, String cpfAluno) {
        String SQL = "INSERT INTO aula (dataAulaInicio, dataAulaTermino, quantidadeAula, modalidadeAula, fk_instrutor, fk_aluno)"
                + "SELECT ? ,?, ?, ?, a.id, b.id"
                + " FROM instrutor  a, aluno b WHERE a.cpf = ? AND b.cpf = ?";
        Connection conexao = FabricaConexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(SQL);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String dataFormatada = aula.getDataAulaInicio().format(formatter);
            stmt.setString(1, dataFormatada);
            dataFormatada = aula.getDataAulaTermino().format(formatter);
            stmt.setString(2, dataFormatada);
            stmt.setShort(3, aula.getQuantidadeAulas());
            stmt.setString(4, aula.getModalidadeAula().getModalidade());
            stmt.setString(5, cpfInstrutor);
            stmt.setString(6, cpfAluno);
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
    
    public static ArrayList<Aula> getAulasPorAluno(String nome, String cpf){
        ArrayList<Aula> aulas = new ArrayList<>();        
        for(Aula listaAulas : AulaController.getAulas()){
            if(listaAulas.getAluno().getCpf().equalsIgnoreCase(cpf) && listaAulas.getAluno().getNome().equalsIgnoreCase(nome)){
                aulas.add(listaAulas);
            }
        }                
        
        return aulas;
    }
    
    public static ArrayList<Aula> getAulasAceitamTroca(){
        ArrayList<Aula> aulas = new ArrayList<>();
        PreparedStatement stmt = null;
        Connection conexao = null;
        ResultSet resultado = null;
        try {
            conexao = FabricaConexao.getConnection();
            String sql = "SELECT a.id'idAula', a.dataAulaInicio'dataAulaInicio', a.dataAulaTermino'dataAulaTermino', a.quantidadeAula'quantidadeAula', a.modalidadeAula'modalidadeAula', b.cpf'cpfAluno', b.nome'nomeAluno', b.idade'idadeAluno', b.aceitaTroca'alunoAceitaTroca', c.nome'nomeInstrutor', c.cpf'cpfInstrutor' FROM aula AS a"
                    + " JOIN aluno b ON b.id = a.fk_aluno"
                    + " JOIN instrutor c ON a.fk_instrutor = c.id"
                    + " WHERE b.aceitaTroca IS TRUE AND a.dataAulaInicio > ?";
            //stmt = conexao.createStatement();
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, MetodosUteis.getDataFormatadaBanco(LocalDateTime.now().plusDays(1)));
            resultado = stmt.executeQuery();
            while (resultado.next()) {
                //LocalDateTime dataAulaInicio, LocalDateTime dataAulaTermino, String modalidadeAula, short quantidadeAulas)
                LocalDateTime dataAulaInicio = MetodosUteis.getLocalDateTimeString(resultado.getString("dataAulaInicio"));
                LocalDateTime dataAulaTermino = MetodosUteis.getLocalDateTimeString(resultado.getString("dataAulaTermino"));
                String modalidadeAula = resultado.getString("modalidadeAula");
                short quantidadeAula = resultado.getShort("quantidadeAula");
                long idAula = resultado.getLong("idAula");
                //String nome, int idade, String cpf, boolean aceitaTroca
                Aluno aluno = new Aluno(resultado.getString("nomeAluno"), resultado.getByte("idadeAluno"), resultado.getString("cpfAluno"), resultado.getBoolean("alunoAceitaTroca"));
                Instrutor instrutor = null;
                try {
                    instrutor = new Instrutor(resultado.getString("nomeInstrutor"), resultado.getString("cpfInstrutor"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                Aula aula = new Aula(dataAulaInicio, dataAulaTermino, modalidadeAula, quantidadeAula, idAula);
                aula.setAluno(aluno);
                aula.setInstrutor(instrutor);
                aulas.add(aula);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
            try {
                if (!(conexao.isClosed()) || !(stmt.isClosed())) {
                    conexao.close();
                    stmt.close();
                }

            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        return aulas;
    }

    public static ArrayList<Aula> getAulas() {        
        ArrayList<Aula> aulas = new ArrayList<>();
        Statement stmt = null;
        Connection conexao = null;
        ResultSet resultado = null;
        try {
            conexao = FabricaConexao.getConnection();
            String sql = "SELECT a.id'idAula', a.dataAulaInicio'dataAulaInicio', a.dataAulaTermino'dataAulaTermino', a.quantidadeAula'quantidadeAula', a.modalidadeAula'modalidadeAula', b.cpf'cpfAluno', b.nome'nomeAluno', b.idade'idadeAluno', b.aceitaTroca'alunoAceitaTroca', c.nome'nomeInstrutor', c.cpf'cpfInstrutor' FROM aula AS a"
                    + " JOIN aluno b ON b.id = a.fk_aluno"
                    + " JOIN instrutor c ON a.fk_instrutor = c.id;";
            stmt = conexao.createStatement();
            resultado = stmt.executeQuery(sql);
            while (resultado.next()) {
                //LocalDateTime dataAulaInicio, LocalDateTime dataAulaTermino, String modalidadeAula, short quantidadeAulas)
                LocalDateTime dataAulaInicio = MetodosUteis.getLocalDateTimeString(resultado.getString("dataAulaInicio"));
                LocalDateTime dataAulaTermino = MetodosUteis.getLocalDateTimeString(resultado.getString("dataAulaTermino"));
                String modalidadeAula = resultado.getString("modalidadeAula");
                short quantidadeAula = resultado.getShort("quantidadeAula");
                long idAula = resultado.getLong("idAula");
                //String nome, int idade, String cpf, boolean aceitaTroca
                Aluno aluno = new Aluno(resultado.getString("nomeAluno"), resultado.getByte("idadeAluno"), resultado.getString("cpfAluno"), resultado.getBoolean("alunoAceitaTroca"));
                Instrutor instrutor = null;
                try {
                    instrutor = new Instrutor(resultado.getString("nomeInstrutor"), resultado.getString("cpfInstrutor"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                Aula aula = new Aula(dataAulaInicio, dataAulaTermino, modalidadeAula, quantidadeAula, idAula);
                aula.setAluno(aluno);
                aula.setInstrutor(instrutor);
                aulas.add(aula);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
            try {
                if (!(conexao.isClosed()) || !(stmt.isClosed())) {
                    conexao.close();
                    stmt.close();
                }

            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        return aulas;
    }

}
