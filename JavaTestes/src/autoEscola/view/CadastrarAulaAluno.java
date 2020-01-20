/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoEscola.view;

import autoEscola.controller.AlunoController;
import autoEscola.controller.InstrutorController;
import autoEscola.model.Aluno.Aluno;
import autoEscola.model.Instrutor.Instrutor;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;

/**
 *
 * @author duduf
 */
public class CadastrarAulaAluno extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarAulaAluno
     */
    public CadastrarAulaAluno() {
        initComponents();
        this.inserirAlunosComboBox();
        this.inserirInstrutoresComboBox();
        this.exibirNomeAlunoSelecionado();
        this.exibirNomeInstrutorSelecionado();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDataInicioAula = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        cbAlunosDB = new javax.swing.JComboBox<>();
        cbInstrutoresDB = new javax.swing.JComboBox<>();
        lblNomeAluno = new javax.swing.JLabel();
        lblNomeInstrutor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cadastrar Aula Aluno");

        jLabel2.setText("Informe CPF do Aluno");

        jLabel3.setText("Informe CPF do Instrutor");

        jLabel4.setText("Informe o Inicio da Aula");

        txtDataInicioAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataInicioAulaActionPerformed(evt);
            }
        });

        jLabel5.setText("Selecione a quantidade de Aulas");

        cbAlunosDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlunosDBActionPerformed(evt);
            }
        });

        cbInstrutoresDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbInstrutoresDBActionPerformed(evt);
            }
        });

        lblNomeAluno.setText("O nome do aluno Selecionado é: ");

        lblNomeInstrutor.setText("O nome do Instrutor Selecionado é: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(lblNomeInstrutor))
                                .addGap(18, 18, 18)
                                .addComponent(txtDataInicioAula, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(cbInstrutoresDB, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblNomeAluno)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbAlunosDB, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbAlunosDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(lblNomeAluno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbInstrutoresDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNomeInstrutor)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDataInicioAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDataInicioAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataInicioAulaActionPerformed
        // TODO add your handling code here:
        String date = new SimpleDateFormat("MM/dd/yy  HH:mm").format(new Date());

        txtDataInicioAula = new JFormattedTextField(date);
    }//GEN-LAST:event_txtDataInicioAulaActionPerformed
    private void inserirAlunosComboBox() {
        for (Aluno alunos : AlunoController.obterListaAlunosDataBase()) {
            cbAlunosDB.addItem(alunos.getCpf());
        }
    }
    private void cbAlunosDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlunosDBActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbAlunosDBActionPerformed

    private void inserirInstrutoresComboBox(){
        for(Instrutor instrutores : InstrutorController.obterListaInstrutorDataBase()){
            cbInstrutoresDB.addItem(instrutores.getCpf());
        }
    }
    
    private void exibirNomeAlunoSelecionado(){
        lblNomeAluno.setText(lblNomeAluno.getText() + AlunoController.getNomeAlunoPorCpf(cbAlunosDB.getSelectedItem().toString()));
    }
    private void exibirNomeInstrutorSelecionado(){
        lblNomeInstrutor.setText(lblNomeInstrutor.getText() + InstrutorController.getInstrutorPorCpf(cbInstrutoresDB.getSelectedItem().toString()));
    }
    
    private void cbInstrutoresDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbInstrutoresDBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbInstrutoresDBActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastrarAulaAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarAulaAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarAulaAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarAulaAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarAulaAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbAlunosDB;
    private javax.swing.JComboBox<String> cbInstrutoresDB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblNomeAluno;
    private javax.swing.JLabel lblNomeInstrutor;
    private javax.swing.JFormattedTextField txtDataInicioAula;
    // End of variables declaration//GEN-END:variables
}
