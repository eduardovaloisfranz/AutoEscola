package autoEscola.util.validacoes.validacoesGerais;

import autoEscola.model.Aula.Aula;
import autoEscola.util.validacoes.validacoesDataBase.ValidacoesBancoDeDados;

public class ValidacoesGerais {
    public static boolean validarAulaCarro(Aula aula, String cpfInstrutor){
        boolean aulaIsValida = ValidacoesBancoDeDados.validarAulaCarro(aula, cpfInstrutor);       
        return aulaIsValida;
    }
    public static boolean validarAulaMoto(Aula aula, String cpfInstrutor) {
        return false;
    }
}
