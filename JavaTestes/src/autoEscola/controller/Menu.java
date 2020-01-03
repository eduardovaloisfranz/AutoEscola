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
        System.out.println("Informe o nome completo do aluno: ");
        String nome = input.nextLine();
        System.out.println("Informe a idade do Aluno: ");
        short idade = input.nextShort();
        input.nextLine();
        System.out.println("Este aluno, aceita trocar a aula ?\n1- Sim \n2- Não: ");
        short opcao = input.nextShort();
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
        System.out.println("Informe a quantidade de aulas: ");
        byte quantidadeAulas = input.nextByte();
        input.nextLine();
        System.out.println("Informe a categoria desta Aula\n1- Carro \n2- Moto");
        byte opcaoAula = input.nextByte();
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
        System.out.println("Informe o nome completo do Instrutor(a): ");
        input.nextLine();
        String nomeCompleto = input.nextLine();
        InstrutorController.addInstrutor(new Instrutor(nomeCompleto, ValidaCPF.imprimeCPF(cpfInstrutor)));
    }
    
}
