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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
               
        LocalDateTime dateTime = LocalDateTime.parse(data, formatter);
        
        return dateTime;
        //return dateTime;
        
        
    }
    
}
