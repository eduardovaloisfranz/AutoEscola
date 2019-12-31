/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoEscola.model.Aula;

/**
 *
 * 9 * @author casa
 */
public enum ModalidadeAula {
    CARRO("Carro"),
    MOTO("Moto");

    private final String modalidadeAula;

    private ModalidadeAula(String modalidade) {
        this.modalidadeAula = modalidade;
    }
    
    public String getModalidade(){
        return modalidadeAula;
    }
}
