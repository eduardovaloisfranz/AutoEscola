package autoEscola.util.validacoes.validacoesGerais;

import autoEscola.model.Aula.Aula;
import autoEscola.util.validacoes.validacoesDataBase.ValidacoesBancoDeDados;

public class ValidacoesGerais {
    public static boolean validarAula(Aula aula, String cpfInstrutor){
        boolean aulaIsValida = ValidacoesBancoDeDados.validarAula(aula, cpfInstrutor);       
        return aulaIsValida;
    }    
}
