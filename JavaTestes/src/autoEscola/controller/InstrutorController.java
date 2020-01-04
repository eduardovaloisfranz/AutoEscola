
package autoEscola.controller;

import autoEscola.database.FabricaConexao;
import autoEscola.model.Instrutor.Instrutor;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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
}
