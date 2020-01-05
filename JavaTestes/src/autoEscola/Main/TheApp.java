package autoEscola.Main;

import autoEscola.controller.AlunoController;
import autoEscola.controller.Menu;
import autoEscola.util.validacoes.validaCPF.ValidaCPF;
import autoEscola.util.validacoes.validacoesDataBase.ValidacoesBancoDeDados;

public class TheApp {

    public static void main(String[] args) {        
        //Menu.menu();        
        //AlunoController.exibirTodasAulasAluno();
        //AlunoController.exibirTodosOsAlunosAceitamTroca();
        AlunoController.exibirTodosOsAlunosNaoAceitamTroca();
    }
}
