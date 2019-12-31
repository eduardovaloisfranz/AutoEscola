
package autoEscola.controller;

import autoEscola.database.FabricaConexao;
import autoEscola.model.Aluno.Aluno;
import autoEscola.model.Aula.Aula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;

public class AulaController {
    public static Integer addAula(Aula aula, Integer fkInstrutor, Integer fkAluno){
        Integer idAula = null;
        String SQL = "INSERT INTO aula (dataAulaInicio, dataAulaTermino, quantidadeAula, modalidadeAula, fk_instrutor, fk_aluno) VALUES(?, ?, ? ,? , ?, ?)";
        Connection conexao = FabricaConexao.getConnection();
        PreparedStatement stmt = null;
        try{
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
            while(resultado.next()){
                idAula = resultado.getInt(1);
            }
            stmt.close();
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        
        return idAula;
    }
    
    public static void addAula(Aula aula, String cpfInstrutor, String cpfAluno){
        String SQL = "INSERT INTO aula (dataAulaInicio, dataAulaTermino, quantidadeAula, modalidadeAula, fk_instrutor, fk_aluno)" +
"SELECT ? ,?, ?, ?, a.id, b.id" +
"FROM instrutor a, aluno b WHERE a.cpf = ? AND b.cpf = ?";
        Connection conexao = FabricaConexao.getConnection();
        PreparedStatement stmt = null;
        try{
            stmt = conexao.prepareStatement(SQL);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");            
            String dataFormatada = aula.getDataAulaInicio().format(formatter);
            stmt.setString(1, dataFormatada);
            dataFormatada = aula.getDataAulaTermino().format(formatter);
            stmt.setString(2, dataFormatada);
            stmt.setShort(3, aula.getQuantidadeAulas());                                
            stmt.setString(4, aula.getModalidadeAula().getModalidade());
            stmt.setString(5, cpfInstrutor);
            stmt.setString(6, cpfAluno);
            stmt.execute();
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
                
    }       
    
    
}
