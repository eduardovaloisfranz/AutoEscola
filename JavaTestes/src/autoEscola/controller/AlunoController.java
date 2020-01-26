package autoEscola.controller;

import autoEscola.database.FabricaConexao;
import autoEscola.model.Aluno.Aluno;
import autoEscola.util.validacoes.validaCPF.ValidaCPF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    //exibir Todas AS AULAS dos alunos, exibir as aulas aluno Especifico, mostrar todos os alunos que Aceitam TROCA, mostrar todos os alunos que NAO ACEITAM TROCA
    public static void exibirTodasAulasAluno() {
        String sql = "SELECT a.nome'nomeAluno', a.idade'idadeAluno', a.cpf'cpfAluno', a.aceitaTroca'alunoAceitaTroca', "
                + "b.dataAulaInicio'dataAulaInicio', b.dataAulaTermino'dataAulaTermino', b.quantidadeAula'quantidadeAulas', b.modalidadeAula'modalidadeAula',"
                + "c.nome'nomeInstrutor', c.cpf'cpfInstrutor' FROM aluno a"
                + " JOIN aula b ON b.fk_aluno = a.id"
                + " JOIN instrutor c ON b.fk_instrutor = c.id;";
        Connection conexao = FabricaConexao.getConnection();
        Statement stmt = null;
        ResultSet resultado = null;
        try {
            stmt = conexao.createStatement();
            resultado = stmt.executeQuery(sql);
            while (resultado.next()) {
                if (resultado.isFirst()) {
                    System.out.println("Será mostrado os seguintes valores\nNome do Aluno\tIdade do aluno\tCpf do Aluno\tSe o aluno aceita troca\tData inicio da Aula"
                            + "\tData termino aula\tQuantidade de Aulas\tModalidade da Aula\tNome do Instrutor\tCPF do instrutor");
                }
                System.out.println("Nome do Aluno: " + resultado.getString("nomeAluno"));
                System.out.println("Idade Aluno: " + resultado.getShort("idadeAluno"));
                System.out.println("CPF do Aluno: " + resultado.getString("cpfAluno"));
                System.out.println("Se o aluno Aceita Troca: " + resultado.getBoolean("alunoAceitaTroca"));
                System.out.println("Data do Inicio da Aula: " + resultado.getString("dataAulaInicio"));
                System.out.println("Data do Término da Aula: " + resultado.getString("dataAulaTermino"));
                System.out.println("Quantidade de Aulas: " + resultado.getShort("quantidadeAulas"));
                System.out.println("Modalidade da Aula: " + resultado.getString("modalidadeAula"));
                System.out.println("CPF Instrutor: " + resultado.getString("cpfInstrutor"));
                System.out.println("Nome do Instrutor: " + resultado.getString("nomeInstrutor"));
                System.out.println("-----------------------------------------------------------------------------");

            }
        } catch (SQLException e) {
            System.out.println("Algo deu errado na inserção no Banco. Erro: " + e.getMessage());
        } finally {
            try {
                if (conexao.isClosed() == false || stmt.isClosed() == false) {
                    conexao.close();
                    stmt.close();
                    resultado.close();
                }
            } catch (SQLException e) {
                System.out.println("Problema database: " + e.getMessage());
            }
        }

    }

     public static void exibirTodasAulasAlunoAceitamTroca() {
        String sql = "SELECT a.nome'nomeAluno', a.idade'idadeAluno', a.cpf'cpfAluno', a.aceitaTroca'alunoAceitaTroca', "
                + "b.dataAulaInicio'dataAulaInicio', b.dataAulaTermino'dataAulaTermino', b.quantidadeAula'quantidadeAulas', b.modalidadeAula'modalidadeAula',"
                + "c.nome'nomeInstrutor', c.cpf'cpfInstrutor' FROM aluno a"
                + " JOIN aula b ON b.fk_aluno = a.id"
                + " JOIN instrutor c ON b.fk_instrutor = c.id"
                + " WHERE a.aceitaTroca IS TRUE;";
        Connection conexao = FabricaConexao.getConnection();
        Statement stmt = null;
        ResultSet resultado = null;
        try {
            stmt = conexao.createStatement();
            resultado = stmt.executeQuery(sql);
            while (resultado.next()) {
                if (resultado.isFirst()) {
                    System.out.println("Será mostrado os seguintes valores\nNome do Aluno\tIdade do aluno\tCpf do Aluno\tSe o aluno aceita troca\tData inicio da Aula"
                            + "\tData termino aula\tQuantidade de Aulas\tModalidade da Aula\tNome do Instrutor\tCPF do instrutor");
                }
                System.out.println("Nome do Aluno: " + resultado.getString("nomeAluno"));
                System.out.println("Idade Aluno: " + resultado.getShort("idadeAluno"));
                System.out.println("CPF do Aluno: " + resultado.getString("cpfAluno"));
                System.out.println("Se o aluno Aceita Troca: " + resultado.getBoolean("alunoAceitaTroca"));
                System.out.println("Data do Inicio da Aula: " + resultado.getString("dataAulaInicio"));
                System.out.println("Data do Término da Aula: " + resultado.getString("dataAulaTermino"));
                System.out.println("Quantidade de Aulas: " + resultado.getShort("quantidadeAulas"));
                System.out.println("Modalidade da Aula: " + resultado.getString("modalidadeAula"));
                System.out.println("CPF Instrutor: " + resultado.getString("cpfInstrutor"));
                System.out.println("Nome do Instrutor: " + resultado.getString("nomeInstrutor"));
                System.out.println("-----------------------------------------------------------------------------");

            }
        } catch (SQLException e) {
            System.out.println("Algo deu errado na inserção no Banco. Erro: " + e.getMessage());
        } finally {
            try {
                if (conexao.isClosed() == false || stmt.isClosed() == false) {
                    conexao.close();
                    stmt.close();
                    resultado.close();
                }
            } catch (SQLException e) {
                System.out.println("Problema database: " + e.getMessage());
            }
        }

    }
     
     public static ArrayList<Aluno> getAlunos(){
        ArrayList<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT nome'nomeAluno', idade'idadeAluno' ,cpf'cpfAluno', aceitaTroca'aceitaTroca' FROM aluno";
        Statement stmt = null;
        Connection conexao = null;
        ResultSet resultado = null;
        try {
            conexao = FabricaConexao.getConnection();
            stmt = conexao.createStatement();
            resultado = stmt.executeQuery(sql);
            while (resultado.next()) {   
                //String nome, int idade, String cpf, boolean aceitaTroca
               alunos.add(new Aluno(resultado.getString("nomeAluno"), resultado.getByte("idadeAluno"), resultado.getString("cpfAluno"), resultado.getBoolean("aceitaTroca")));
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
            } catch (SQLException e) {
                System.out.println("Erro em fechar a conexao: " + e.getMessage());
            }
        }
        return alunos;
     }
     
     
    public static ArrayList<Aluno> obterListaAlunosDataBase(){
        ArrayList<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT cpf FROM aluno";
        Statement stmt = null;
        Connection conexao = null;
        ResultSet resultado = null;
        try {
            conexao = FabricaConexao.getConnection();
            stmt = conexao.createStatement();
            resultado = stmt.executeQuery(sql);
            while (resultado.next()) {              
               alunos.add(new Aluno(resultado.getString(1)));
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
            } catch (SQLException e) {
                System.out.println("Erro em fechar a conexao: " + e.getMessage());
            }
        }
        return alunos;
    }
    
    public static String getNomeAlunoPorCpf(String cpf){
        String nome = "";
        String sql = "SELECT nome'nomeAluno' FROM aluno WHERE cpf = ?";
        PreparedStatement stmt = null;
        Connection conexao = null;
        ResultSet resultado = null;
        try {
            conexao = FabricaConexao.getConnection();
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cpf);
            resultado = stmt.executeQuery();
            while (resultado.next()) {              
               nome = resultado.getString("nomeAluno");
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
            } catch (SQLException e) {
                System.out.println("Erro em fechar a conexao: " + e.getMessage());
            }
        }
        return nome;
    }
    public static Aluno getAlunoByCPF(String cpf){
        Aluno aluno = null;
        String sql = "SELECT nome'nomeAluno', idade'idadeAluno', aceitaTroca'aceitaTroca' FROM aluno WHERE cpf = ?";
        PreparedStatement stmt = null;
        Connection conexao = null;
        ResultSet resultado = null;
        try {
            conexao = FabricaConexao.getConnection();
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cpf);
            resultado = stmt.executeQuery();
            while (resultado.next()) {              
               String nomeAluno = resultado.getString("nomeAluno");
               byte idadeAluno = resultado.getByte("idadeAluno");
               boolean aceitaTroca = resultado.getBoolean("aceitaTroca");
               aluno = new Aluno(nomeAluno, idadeAluno, cpf, aceitaTroca);
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
            } catch (SQLException e) {
                System.out.println("Erro em fechar a conexao: " + e.getMessage());
            }
        }
        return aluno;
    }
    
    public static void exibirTodosOsAlunosAceitamTroca() {
        String sql = "SELECT nome FROM aluno WHERE aceitaTroca IS TRUE";
        Statement stmt = null;
        Connection conexao = null;
        ResultSet resultado = null;
        try {
            conexao = FabricaConexao.getConnection();
            stmt = conexao.createStatement();
            resultado = stmt.executeQuery(sql);
            while (resultado.next()) {
                if (resultado.isFirst()) {
                    System.out.println("Alunos que Aceitam ter aulas Trocadas: ");
                }
                System.out.println("Aluno nome: " + resultado.getString(1));
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
            } catch (SQLException e) {
                System.out.println("Erro em fechar a conexao: " + e.getMessage());
            }
        }
    }

    public static void exibirTodosOsAlunosNaoAceitamTroca() {
        String sql = "SELECT nome FROM aluno WHERE aceitaTroca IS FALSE";
        Statement stmt = null;
        Connection conexao = null;
        ResultSet resultado = null;
        try {
            conexao = FabricaConexao.getConnection();
            stmt = conexao.createStatement();
            resultado = stmt.executeQuery(sql);
            while (resultado.next()) {
                if (resultado.isFirst()) {
                    System.out.println("Alunos que não Aceitam ter aulas Trocadas: ");
                }
                System.out.println("Aluno nome: " + resultado.getString(1));
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
            } catch (SQLException e) {
                System.out.println("Erro em fechar a conexao: " + e.getMessage());
            }
        }
    }
    
    public static void exibirAulasAluno(String cpfAluno){
        String sql = "SELECT a.nome'nomeAluno', a.idade'idadeAluno', a.cpf'cpfAluno', a.aceitaTroca'alunoAceitaTroca', "
                + "b.dataAulaInicio'dataAulaInicio', b.dataAulaTermino'dataAulaTermino', b.quantidadeAula'quantidadeAulas', b.modalidadeAula'modalidadeAula',"
                + "c.nome'nomeInstrutor', c.cpf'cpfInstrutor' FROM aluno a"
                + " JOIN aula b ON b.fk_aluno = a.id"
                + " JOIN instrutor c ON b.fk_instrutor = c.id"
                + " WHERE a.id = (SELECT id FROM aluno WHERE cpf = ?) ;";
        Connection conexao = FabricaConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet resultado = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, ValidaCPF.imprimeCPF(cpfAluno));
            resultado = stmt.executeQuery();            
            while (resultado.next()) {
                if (resultado.isFirst()) {
                    System.out.println("Aulas do aluno");
                    System.out.println("Nome do Aluno: " + resultado.getString("nomeAluno"));
                    System.out.println("Idade Aluno: " + resultado.getShort("idadeAluno"));
                    System.out.println("CPF do Aluno: " + resultado.getString("cpfAluno"));
                    System.out.println("Se o aluno Aceita Troca: " + resultado.getBoolean("alunoAceitaTroca"));
                }                                                        
                System.out.println("\nData do Inicio da Aula: " + resultado.getString("dataAulaInicio"));
                System.out.println("Data do Término da Aula: " + resultado.getString("dataAulaTermino"));
                System.out.println("Quantidade de Aulas: " + resultado.getShort("quantidadeAulas"));
                System.out.println("Modalidade da Aula: " + resultado.getString("modalidadeAula"));
                System.out.println("CPF Instrutor: " + resultado.getString("cpfInstrutor"));
                System.out.println("Nome do Instrutor: " + resultado.getString("nomeInstrutor"));
                System.out.println("-----------------------------------------------------------------------------");

            }
        } catch (SQLException e) {
            System.out.println("Algo deu errado na inserção no Banco. Erro: " + e.getMessage());
        } finally {
            try {
                if (conexao.isClosed() == false || stmt.isClosed() == false) {
                    conexao.close();
                    stmt.close();
                    resultado.close();
                }
            } catch (SQLException e) {
                System.out.println("Problema database: " + e.getMessage());
            }
        }
    }
    
    

}
