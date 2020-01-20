
package autoEscola.controller;

import autoEscola.database.FabricaConexao;
import autoEscola.model.Aluno.Aluno;
import autoEscola.model.Instrutor.Instrutor;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class InstrutorController {
    public static Integer addInstrutor(Instrutor instrutor){
        Integer idInstrutor = null;
        Connection conexao = FabricaConexao.getConnection();
        String SQL = "INSERT INTO instrutor (nome, cpf) VALUES (?, ?)";
        PreparedStatement stmt = null;
        ResultSet resultado = null;
        try{
            stmt = conexao.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, instrutor.getNome());
            stmt.setString(2, instrutor.getCpf());
            stmt.executeUpdate();
            resultado = stmt.getGeneratedKeys();
            while(resultado.next()){
                idInstrutor = resultado.getInt(1);
            }            
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
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
        return idInstrutor;
    }
    
    public static ArrayList<Instrutor> obterListaInstrutorDataBase(){
        ArrayList<Instrutor> instrutores = new ArrayList<>();
        String sql = "SELECT cpf'cpfInstrutor' FROM instrutor";
        java.sql.Statement stmt = null;
        Connection conexao = null;
        ResultSet resultado = null;
        try {
            conexao = FabricaConexao.getConnection();
            stmt = conexao.createStatement();
            resultado = stmt.executeQuery(sql);
            while (resultado.next()) {              
               instrutores.add(new Instrutor(resultado.getString("cpfInstrutor")));
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
        return instrutores;
    }
    
    public static String getInstrutorPorCpf(String cpf){
        String nome = "";
        String sql = "SELECT nome'nomeInstrutor' FROM instrutor WHERE cpf = ?";
        PreparedStatement stmt = null;
        Connection conexao = null;
        ResultSet resultado = null;
        try {
            conexao = FabricaConexao.getConnection();
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cpf);
            resultado = stmt.executeQuery();
            while (resultado.next()) {              
               nome = resultado.getString("nomeInstrutor");
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
}
