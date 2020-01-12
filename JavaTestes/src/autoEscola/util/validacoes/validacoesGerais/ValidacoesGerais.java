package autoEscola.util.validacoes.validacoesGerais;

import autoEscola.model.Aula.Aula;
import autoEscola.util.validacoes.validacoesDataBase.ValidacoesBancoDeDados;

public class ValidacoesGerais {

    public static boolean validarAula(Aula aula, String cpfInstrutor) {
        boolean aulaIsValida = ValidacoesBancoDeDados.validarAula(aula, cpfInstrutor);
        return aulaIsValida;
    }

    public static boolean instrutorIsValido(String cpfInstrutor, String nomeInstrutor) {
        boolean cpfExistente = ValidacoesBancoDeDados.cpfExistenteDataBaseInstrutor(cpfInstrutor);
        boolean nomeValido;
        if (nomeInstrutor.isEmpty()) {
            nomeValido = false;
        } else if (nomeInstrutor.length() > 40) {
            nomeValido = false;
        } else {
            nomeValido = true;
        }
        if (!(cpfExistente == true || nomeValido == true)) {
            return false;
        }else{
            return true;
        }   

    }
}
