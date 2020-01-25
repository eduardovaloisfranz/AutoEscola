package autoEscola.model.Aula;

import autoEscola.model.Aluno.Aluno;
import autoEscola.model.Instrutor.Instrutor;
import java.time.LocalDateTime;

public class Aula {

    private Instrutor instrutor;   
    private LocalDateTime dataAulaInicio;
    private LocalDateTime dataAulaTermino;
    private short quantidadeAulas;
    private Aluno aluno;
    private static TipoSolicitacao tp;

    public Aluno getAluno() {
        return aluno;
    }

    public static TipoSolicitacao getTp() {
        return tp;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public LocalDateTime getDataAulaInicio() {
        return dataAulaInicio;
    }

    public ModalidadeAula getModalidadeAula() {
        return modalidadeAula;
    }
    private ModalidadeAula modalidadeAula;

    public Aula(Instrutor instrutor, LocalDateTime dataInicio, ModalidadeAula md, Aluno aluno, short quantidadeAulas) {
        this.instrutor = instrutor;        
        this.dataAulaInicio = dataAulaInicio;
        this.modalidadeAula = md;
        this.aluno = aluno;
        this.quantidadeAulas = quantidadeAulas;
        if(!(quantidadeAulas < 0 || quantidadeAulas > 2)){
            if(quantidadeAulas == 1){
                this.dataAulaTermino = this.dataAulaInicio.plusMinutes(50);
            }else {
                this.dataAulaTermino = this.dataAulaInicio.plusMinutes(100);
            }
        }
        
    }
    public Aula(LocalDateTime dataAulaInicio, ModalidadeAula md, short quantidadeAulas) {
        this.dataAulaInicio = dataAulaInicio;
        this.modalidadeAula = md;       
        this.quantidadeAulas = quantidadeAulas;
        if(!(quantidadeAulas < 0 || quantidadeAulas > 2)){
            if(quantidadeAulas == 1){
                this.dataAulaTermino = this.dataAulaInicio.plusMinutes(50);
            }else {
                this.dataAulaTermino = this.dataAulaInicio.plusMinutes(100);
            }
        }
        
    }
    
    public Aula(LocalDateTime dataAulaInicio, LocalDateTime dataAulaTermino, String modalidadeAula, short quantidadeAulas){
        this.dataAulaInicio = dataAulaInicio;
        this.dataAulaTermino = dataAulaTermino;
        if(modalidadeAula.equals("Carro")){
            this.modalidadeAula = ModalidadeAula.CARRO;
        }else if(modalidadeAula.equals("Moto")){
            this.modalidadeAula = ModalidadeAula.MOTO;
        }
        this.quantidadeAulas = quantidadeAulas;
    }

    public void setInstrutor(Instrutor instrutor){
        this.instrutor = instrutor;
    }
    
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
            
    @Override
    public String toString() {
        return "Aula{" + "instrutor=" + instrutor + ", dataAulaInicio=" + dataAulaInicio + ", dataAulaTermino=" + dataAulaTermino + ", quantidadeAulas=" + quantidadeAulas + ", aluno=" + aluno + ", modalidadeAula=" + modalidadeAula + '}';
    }

    public LocalDateTime getDataAulaTermino() {
        return dataAulaTermino;
    }

    public short getQuantidadeAulas() {
        return quantidadeAulas;
    }

   

  

}
