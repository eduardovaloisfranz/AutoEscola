package autoEscola.model.Aluno;

import autoEscola.model.Aula.Aula;
import java.util.ArrayList;

public class Aluno {
 
    private String nome;
    private int idade;
    private String cpf;

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }   
    public Aluno(String cpf){
        this.cpf = cpf;
    }
    

    public boolean getAceitaTroca() {
        return aceitaTroca;
    }
   
    private boolean aceitaTroca;
    
    public Aluno(String nome, int idade, String cpf, boolean aceitaTroca){
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;       
        this.aceitaTroca = aceitaTroca;
       
    }
   

    
    @Override
    public String toString() {
        return "Aluno nome: " +this.nome + "Idade: " + this.idade + " CPF: " + this.cpf + "Aceita Troca: " + this.aceitaTroca + "\n"; 
    }
    
    
   
    
}
