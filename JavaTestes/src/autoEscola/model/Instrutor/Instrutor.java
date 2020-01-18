
package autoEscola.model.Instrutor;

import autoEscola.util.validacoes.validaCPF.ValidaCPF;

public class Instrutor {

    
    private String nome;
    private String cpf;

    public Instrutor(String nome, String cpf) throws Exception{
        this.nome = nome;
        if(nome.isEmpty() || nome.length() > 50){
            throw new Exception("O nome é invalido");
        }
        if(!ValidaCPF.isCPF(cpf)){
            throw new Exception("CPF Inválido");
        }
        this.cpf = cpf;
    }
    
    
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
    
    
    @Override
    public String toString() {
        return "Nome: " + this.nome + "cpf: " + this.cpf;
    }
   
      
    
    
}
