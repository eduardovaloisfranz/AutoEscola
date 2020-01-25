/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoEscola.util.utilitarios;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author duduf
 */
public class ModeloTabela extends AbstractTableModel{
    private ArrayList linhas = null;
    private String[] colunas = null;
    
    public ModeloTabela(ArrayList lin, String[] col){
        setLinhas(lin);
        setColunas(col);
                
    }

    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public String[] getColunas() {
        return colunas;
    }
    
    
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override 
    public String getColumnName(int numCol){
        return colunas[numCol];
    }

    @Override
    public Object getValueAt(int numLinha, int numCol) {
        Object[] linha = (Object[]) getLinhas().get(numLinha);
        return linha[numCol];
    }
    
}
