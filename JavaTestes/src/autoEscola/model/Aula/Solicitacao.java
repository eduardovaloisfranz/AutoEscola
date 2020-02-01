/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoEscola.model.Aula;

/**
 *
 * @author duduf
 */
public class Solicitacao {
    private TipoSolicitacao tipoSolicitacao;
    private Aula aulaOrigem;
    private Aula aulaDestino;
    
    
    public Solicitacao(TipoSolicitacao tp, Aula aulaOrigem, Aula aulaDestino){
        this.tipoSolicitacao = tp;
        this.aulaOrigem = aulaOrigem;
        this.aulaDestino = aulaDestino;
    }
    
    private void alterarAula(){
        tipoSolicitacao = TipoSolicitacao.APROVADO;
        this.aulaOrigem = this.aulaDestino;
        this.aulaDestino = this.aulaOrigem;
    }

    public TipoSolicitacao getTipoSolicitacao() {
        return tipoSolicitacao;
    }

    public Aula getAulaOrigem() {
        return aulaOrigem;
    }

    public Aula getAulaDestino() {
        return aulaDestino;
    }
}
