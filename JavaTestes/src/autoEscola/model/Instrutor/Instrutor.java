
package autoEscola.model.Instrutor;
public class Instrutor {

    
    private String nome;
    private String cpf;

    public Instrutor(String nome, String cpf){
        this.nome = nome;
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
