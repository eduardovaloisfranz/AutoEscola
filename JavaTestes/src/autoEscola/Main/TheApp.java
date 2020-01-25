package autoEscola.Main;

import autoEscola.controller.AlunoController;
import autoEscola.controller.AulaController;
import autoEscola.controller.Menu;
import autoEscola.util.validacoes.validaCPF.ValidaCPF;
import autoEscola.util.validacoes.validacoesDataBase.ValidacoesBancoDeDados;
import autoEscola.view.CadastroInstrutor;
import autoEscola.view.HomeAutoEscola;

public class TheApp {

    public static void main(String[] args) {        
        //Menu.menu();        
        
        //System.out.println(AlunoController.getAlunos().toString());
        System.out.println(AulaController.getAulasPorAluno("Eduardo Valois Franz", "101.189.169-71"));
        

        //CadastroInstrutor tela = new CadastroInstrutor
        //AlunoController.exibirTodasAulasAluno();
       //AlunoController.exibirTodosOsAlunosAceitamTroca();
        //AlunoController.exibirTodosOsAlunosNaoAceitamTroca();
       // AlunoController.exibirAulasAluno("10118916971");
       //AlunoController.exibirTodasAulasAlunoAceitamTroca();
    }
}
