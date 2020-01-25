/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoEscola.util.MetodosUteis;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author duduf
 */
public class MetodosUteis {
    
    public static LocalDateTime getLocalDateTimeString(String data){
        //se algum analista olhar esse codigo, ou eu no futuro, fui obrigado a usar uma solução de contorno aqui violenta (lê-se gambiarra)
        // tentei o maximo possivel nao usar, mas aqui eu fui obrigado, foi mal, nao sei a solucao ideal
        LocalDateTime dateTime = null;
        if(data.contains("/")){
            data.replace("/", "-");
        }
        if(data.length() > 19){
         data = data.substring(0, data.length() - 2);   
         /*aqui vou explicar a gambiarra, por algum motivo quando vem do banco a string, o horario vem: 13:00:00.0 , no sql nao existe esse .0, o metodo original veio para auxiliar no GUI
          aqui eu transformo a string que vem com o tamanho maior que 19, quando tem 19 eu sei que ela possui tem o .0
          se ela possui esse numero extra eu apenas altero o valor da data para o formatter receber o valor real, 
         entretanto: na view ela me retorna uma string com dd/mm/yyyy pois é mais bonito para o usuario o nosso padrão, mas aqui eu quero usar o mesmo meotodo para sql e a view
         entao tenho que fazer um formatter APENAS para esse extra, pois nele eu sei que vem o padrao yyyy-mm-dd
         
         */
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
         dateTime = LocalDateTime.parse(data, formatter);
        }else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            dateTime = LocalDateTime.parse(data, formatter);
        }      
               
        
        
        return dateTime;
        //return dateTime;
        
        
    }
    
}
