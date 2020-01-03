package autoEscola.Main;

import autoEscola.controller.Menu;
import autoEscola.util.validacoes.validaCPF.ValidaCPF;
import autoEscola.util.validacoes.validacoesDataBase.ValidacoesBancoDeDados;

public class TheApp {

    public static void main(String[] args) {

        //System.out.println(ValidaCPF.imprimeCPF("399.13862086"));
        Menu.menu();
        
//        if(ValidaCPF.isCPF("101.189.169-71") == true){
//            System.out.println("CPF VALIDO");
//                    
//        }
       
       //System.out.println(ValidacoesBancoDeDados.cpfExistenteDataBaseAluno("101.189.169-71"));
       //System.out.println(ValidacoesBancoDeDados.cpfExistenteDataBaseInstrutor("399.393.409-15"));
    }
}
