package autoEscola.controller;

import autoEscola.model.Aluno.Aluno;
import autoEscola.model.Aula.Aula;
import autoEscola.model.Aula.ModalidadeAula;
import autoEscola.model.Instrutor.Instrutor;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
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
        System.out.println("Informe o nome completo do aluno: ");
        String nome = input.nextLine();
        System.out.println("Informe a idade do Aluno: ");
        short idade = input.nextShort();
        input.nextLine();
        System.out.println("Informe o cpf Aluno: ");
        String cpf = input.nextLine();
        System.out.println("Este aluno, aceita trocar a aula ?\n1- Sim \n2- Não: ");
        short opcao = input.nextShort();
        input.nextLine();
        boolean aceitaTroca = true;
        if (opcao == 1) {
            aceitaTroca = true;
        } else if (opcao == 2) {
            aceitaTroca = false;
        }
        AlunoController.addAluno(new Aluno(nome, idade, cpf, aceitaTroca));
    }

  private static void cadastrarAulaAluno() {
        input.nextLine();
        System.out.println("Informe o CPF do Aluno: ");
        String cpfAluno = input.next();
        System.out.println("Informe o CPF do Instrutor: ");
        String cpfInstrutor = input.next();
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
        input.nextLine();
        System.out.println("Informe a quantidade de aulas: ");
        byte quantidadeAulas = input.nextByte();
        input.nextLine();
        System.out.println("Informe a categoria desta Aula\n1- Carro \n2- Moto");
        byte opcaoAula = input.nextByte();
        input.nextLine();        
        LocalDateTime dataAula = LocalDateTime.of(anoAula, mesAula, diaAula, horaAula, minutoAula, 0);      
        if (opcaoAula == 1) {
            AulaController.addAula((new Aula (dataAula, ModalidadeAula.CARRO, quantidadeAulas)), cpfInstrutor, cpfAluno);
        } else if (opcaoAula == 2) {
            AulaController.addAula((new Aula(dataAula, ModalidadeAula.MOTO, quantidadeAulas)), cpfInstrutor, cpfAluno);
        }

        //LocalDateTime dataInicio, ModalidadeAula md, short quantidadeAulas
        //Instrutor instrutor, LocalDateTime dataInicio, ModalidadeAula md, Aluno aluno, short quantidadeAulas
    }

    private static void cadastrarInstrutor() {
        input.nextLine();
        System.out.println("Informe o nome completo do Instrutor(a): ");
        String nomeCompleto = input.nextLine();
        System.out.println("\nInforme o CPF do Instrutor(a): ");
        String cpf = input.nextLine();
        InstrutorController.addInstrutor(new Instrutor(nomeCompleto, cpf));
    }

}
