package autoEscola.controller;

import autoEscola.model.Aluno.Aluno;
import autoEscola.model.Aula.Aula;
import autoEscola.model.Aula.ModalidadeAula;
import autoEscola.model.Instrutor.Instrutor;
import autoEscola.util.utilitarios.LeituraInformacoes;
import autoEscola.util.validacoes.validaCPF.ValidaCPF;
import autoEscola.util.validacoes.validacoesDataBase.ValidacoesBancoDeDados;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static Scanner input = new Scanner(System.in);

    public static void menu() {
        short opcaoDesejada = 0;
        do {
            System.out.println("Ola, bem vindo a autoescola, o que deseja fazer?\nAqui estao algumas opções\n"
                    + "1- Cadastrar Aluno\n"
                    + "2 - Cadastrar Aula a algum aluno\n"
                    + "3 - Cadastrar Instrutor");
            opcaoDesejada = input.nextShort();
            if (opcaoDesejada == 1) {
                cadastrarAluno();
            } else if (opcaoDesejada == 2) {
                cadastrarAulaAluno();
            } else if (opcaoDesejada == 3) {
                cadastrarInstrutor();
            }
        } while ((opcaoDesejada != 1) || (opcaoDesejada != 2) || (opcaoDesejada != 3));
    }

    private static void cadastrarAluno() {
        input.nextLine();
        String cpf = LeituraInformacoes.lerCpfAluno(true);
        input.nextLine();
        String nome = LeituraInformacoes.lerString("Informe o nome Completo do Aluno: ");
        short idade = LeituraInformacoes.lerInteiro("Informe a idade do Aluno: ");
        input.nextLine();
        short opcao = LeituraInformacoes.lerInteiro("Este aluno, aceita trocar a aula ?\n1- Sim \n2- Não: ");
        input.nextLine();
        boolean aceitaTroca = true;
        if (opcao == 1) {
            aceitaTroca = true;
        } else if (opcao == 2) {
            aceitaTroca = false;
        }
        AlunoController.addAluno(new Aluno(nome, idade, ValidaCPF.imprimeCPF(cpf), aceitaTroca));
    }

    private static void cadastrarAulaAluno() {
        input.nextLine();
        String cpfAluno = LeituraInformacoes.lerCpfAluno(false);
        input.nextLine();
        String cpfInstrutor = LeituraInformacoes.lerCpfInstrutor(false);
        input.nextLine();
        short quantidadeAulas = LeituraInformacoes.lerInteiro("Informe a quantidade de Aulas: ");
        input.nextLine();
        short opcaoAula = LeituraInformacoes.lerInteiro("Informe a categoria desta Aula\n1- Carro \n2- Moto");
        input.nextLine();
        LocalDateTime dataAula = LeituraInformacoes.gerarDataAula();
        if (opcaoAula == 1) {
            AulaController.addAula((new Aula(dataAula, ModalidadeAula.MOTO, quantidadeAulas)), ValidaCPF.imprimeCPF(cpfInstrutor), ValidaCPF.imprimeCPF(cpfAluno));

        } else if (opcaoAula == 2) {
            AulaController.addAula((new Aula(dataAula, ModalidadeAula.MOTO, quantidadeAulas)), ValidaCPF.imprimeCPF(cpfInstrutor), ValidaCPF.imprimeCPF(cpfAluno));
        }

        //LocalDateTime dataInicio, ModalidadeAula md, short quantidadeAulas
        //Instrutor instrutor, LocalDateTime dataInicio, ModalidadeAula md, Aluno aluno, short quantidadeAulas
    }

    private static void cadastrarInstrutor() {
        input.nextLine();
        String cpfInstrutor = LeituraInformacoes.lerCpfInstrutor(true);
        String nomeCompleto = LeituraInformacoes.lerString("Informe o nome completo do Instrutor(a): ");

        InstrutorController.addInstrutor(new Instrutor(nomeCompleto, ValidaCPF.imprimeCPF(cpfInstrutor)));
    }

}
