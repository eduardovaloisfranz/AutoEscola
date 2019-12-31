
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
        try{
            stmt = conexao.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, instrutor.getNome());
            stmt.setString(2, instrutor.getCpf());
            stmt.executeUpdate();
            ResultSet resultado = stmt.getGeneratedKeys();
            while(resultado.next()){
                idInstrutor = resultado.getInt(1);
            }  
            stmt.close();
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return idInstrutor;
    }
}
