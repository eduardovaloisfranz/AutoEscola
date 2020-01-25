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
public enum TipoSolicitacao {
    PENDENTE("Pendente"),
    APROVADO("Aprovado");

    private final String statusSolicitacao;

    private TipoSolicitacao(String solicitacao) {
        this.statusSolicitacao = solicitacao;
    }
    
    public String getModalidade(){
        return statusSolicitacao;
    }
}
