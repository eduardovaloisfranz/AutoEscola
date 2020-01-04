package autoEscola.controller;

import autoEscola.model.Aluno.Aluno;
import autoEscola.model.Aula.Aula;
import autoEscola.model.Aula.ModalidadeAula;
import autoEscola.model.Instrutor.Instrutor;
import autoEscola.util.utilitarios.LeituraInformacoes;
import autoEscola.util.validacoes.validaCPF.ValidaCPF;
import autoEscola.util.validacoes.validacoesGerais.ValidacoesGerais;
import java.time.LocalDateTime;

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
        String nome = LeituraInformacoes.lerString("Informe o nome Completo do Aluno: ");
        short idade = LeituraInformacoes.lerInteiro("Informe a idade do Aluno: ");

        short opcao = LeituraInformacoes.lerInteiro("Este aluno, aceita trocar a aula ?\n1- Sim \n2- Não: ");

        boolean aceitaTroca = true;
        if (opcao == 1) {
            aceitaTroca = true;
        } else if (opcao == 2) {
            aceitaTroca = false;
        }
        AlunoController.addAluno(new Aluno(nome, idade, ValidaCPF.imprimeCPF(cpf), aceitaTroca));
    }

    private static void cadastrarAulaAluno() {
        String cpfAluno = LeituraInformacoes.lerCpfAluno(false);
        String cpfInstrutor = "";
        LocalDateTime dataAula = null;
        short opcaoAula = LeituraInformacoes.lerInteiro("Informe a categoria desta Aula\n1- Carro \n2- Moto");
        short quantidadeAulas = 0;
        Aula aula = null;
        if (opcaoAula == 1) {
            boolean aulaIsValida = true;
            do {
                cpfInstrutor = LeituraInformacoes.lerCpfInstrutor(false);
                quantidadeAulas = LeituraInformacoes.lerInteiro("Informe a quantidade de Aulas: ");
                dataAula = LeituraInformacoes.gerarDataAula(cpfInstrutor);
                aula = new Aula(dataAula, ModalidadeAula.CARRO, quantidadeAulas);                
                aulaIsValida = ValidacoesGerais.validarAulaCarro(aula, cpfInstrutor);
            } while (aulaIsValida == false);
            AulaController.addAula((new Aula(dataAula, ModalidadeAula.CARRO, quantidadeAulas)), ValidaCPF.imprimeCPF(cpfInstrutor), ValidaCPF.imprimeCPF(cpfAluno));

        } else if (opcaoAula == 2) {
            do {
                aula = new Aula(dataAula, ModalidadeAula.MOTO, quantidadeAulas);
                ValidacoesGerais.validarAulaCarro(aula, cpfInstrutor);
            } while (ValidacoesGerais.validarAulaMoto(aula, cpfInstrutor) == false);
            AulaController.addAula((new Aula(dataAula, ModalidadeAula.MOTO, quantidadeAulas)), ValidaCPF.imprimeCPF(cpfInstrutor), ValidaCPF.imprimeCPF(cpfAluno));        
        }

        //LocalDateTime dataInicio, ModalidadeAula md, short quantidadeAulas
        //Instrutor instrutor, LocalDateTime dataInicio, ModalidadeAula md, Aluno aluno, short quantidadeAulas
    }

    private static void cadastrarInstrutor() {        
        String cpfInstrutor = LeituraInformacoes.lerCpfInstrutor(true);
        String nomeCompleto = LeituraInformacoes.lerString("Informe o nome completo do Instrutor(a): ");

        InstrutorController.addInstrutor(new Instrutor(nomeCompleto, ValidaCPF.imprimeCPF(cpfInstrutor)));
    }

}
