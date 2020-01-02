package autoEscola.Main;
import autoEscola.controller.Menu;
import autoEscola.util.validacoes.validaCPF.ValidaCPF;
import autoEscola.util.validacoes.validacoesDataBase.ValidacoesBancoDeDados;

public class TheApp {

    public static void main(String[] args) {

       // Menu.menu();
        
        if(ValidaCPF.isCPF("101.189.169-71") == true){
            System.out.println("CPF VALIDO");
                    
        }
        System.out.println(ValidacoesBancoDeDados.cpfExistenteDataBaseAluno("101.189.169-71"));
        
    }
}
