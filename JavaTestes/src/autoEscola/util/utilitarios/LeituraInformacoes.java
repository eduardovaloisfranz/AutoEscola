package autoEscola.util.utilitarios;

import static autoEscola.controller.Menu.input;
import autoEscola.util.validacoes.validaCPF.ValidaCPF;
import autoEscola.util.validacoes.validacoesDataBase.ValidacoesBancoDeDados;
import java.time.LocalDateTime;

public class LeituraInformacoes {

    public static LocalDateTime gerarDataAula() {

        System.out.println("Informe o ano da aula: ");
        int anoAula = input.nextInt();
        input.nextLine();
        System.out.println("Informe o mês da Aula: ");
        byte mesAula = input.nextByte();
        input.nextLine();
        System.out.println("Informe o dia da Aula: ");
        byte diaAula = input.nextByte();
        input.nextLine();
        System.out.println("Sera informado o horario da aula, primeiro sera solicitado a HORA e apos isso sera informado os MINUTOS\nInforme apenas a HORA da aula: ");
        byte horaAula = input.nextByte();
        input.nextLine();
        System.out.println("Informe apenas o MINUTO da aula:  ");
        byte minutoAula = input.nextByte();
        return LocalDateTime.of(anoAula, mesAula, diaAula, horaAula, minutoAula, 0);
    }

    public static String lerCpfAluno(boolean proibirAlunoRepetido) {
        //boolean representa se permite ou nao nome repetido(util para cadastrar aluno novo não repetido e aula para apenas alunos existentes)
        String cpf = "";
        do {
            System.out.println("Informe o CPF do Aluno: ");
            cpf = input.next();
            if (ValidacoesBancoDeDados.cpfExistenteDataBaseAluno(cpf) == proibirAlunoRepetido) {
                System.out.println("Aluno JÁ ENCONTRA-SE CADASTRADO!\nCPF Existente no Banco de Dados: " + ValidaCPF.imprimeCPF(cpf));
            }
            if (ValidaCPF.isCPF(cpf) == false) {
                System.out.println("\nCPF Inválido!\nInforme um CPF válido! ");
            }

        } while (ValidaCPF.isCPF(cpf) == false || ValidacoesBancoDeDados.cpfExistenteDataBaseAluno(cpf) == proibirAlunoRepetido);
        return cpf;
    }

    public static String lerCpfInstrutor(boolean proibirInstrutorRepetido) {
        String cpfInstrutor = "";
        do {
            System.out.println("Informe o CPF do Instrutor: ");
            cpfInstrutor = input.next();
            if (ValidacoesBancoDeDados.cpfExistenteDataBaseInstrutor(cpfInstrutor) == proibirInstrutorRepetido) {
                System.out.println("Instrutor NÃO ENCONTRA-SE CADASTRADO!\nCPF Existente no Banco de Dados: " + ValidaCPF.imprimeCPF(cpfInstrutor));

            }
            if (ValidaCPF.isCPF(cpfInstrutor) == false) {
                System.out.println("\nCPF Inválido!\nInforme um CPF válido!");
            }

        } while (ValidaCPF.isCPF(cpfInstrutor) == false || ValidacoesBancoDeDados.cpfExistenteDataBaseInstrutor(cpfInstrutor) == proibirInstrutorRepetido);
        return cpfInstrutor;
    }
}
