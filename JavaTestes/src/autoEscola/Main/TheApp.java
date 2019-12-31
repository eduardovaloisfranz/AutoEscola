/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoEscola.Main;

import autoEscola.controller.AlunoController;
import autoEscola.controller.AulaController;
import autoEscola.controller.InstrutorController;
import autoEscola.controller.Menu;
import autoEscola.model.Aluno.Aluno;
import autoEscola.model.Aula.Aula;
import autoEscola.model.Aula.ModalidadeAula;
import autoEscola.model.Instrutor.Instrutor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author casa
 */
public class TheApp {

    public static void main(String[] args) {
       
       Menu.menu();
        //LocalDateTime dataDaora = LocalDateTime.of(2020, 10, 3, 10, 10, 0, 0);
        //System.out.println(dataDaora);
        //AulaController.addAula((new Aula((LocalDateTime.of(2020, 10, 3, 10, 10, 0, 0)), ModalidadeAula.CARRO, 1)), "666", "10118916971");
       
        /*
        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<Instrutor> instrutores = new ArrayList<>();
        ArrayList<Aula> aulas = new ArrayList<>();
        instrutores.add(new Instrutor("Joao", "meuCpf"));                        
              
        alunos.add(new Aluno("Eu", 19, "cpf1", true));
        alunos.add(new Aluno("Eu2", 26, "cpf2", false));

       // aulas.add(new Aula(instrutores.get(0), LocalDate.of(2019, 12, 12), ModalidadeAula.MOTO));
       // alunos.get(0).addAula(aulas.get(0));
       // alunos.get(1).addAula(aulas.get(0));
 

        System.out.println(InstrutorController.addInstrutor(instrutores.get(0)));
        //System.out.println(alunos.toString());   
 
        
    
      
       // System.out.println("\n" + aulas);
         */
    }

    private static void menu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
