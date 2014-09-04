/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodolfo
 */
public class ViewCadAtendente extends javax.swing.JFrame {

    /**
     * Creates new form viewAtendente
     */
    private DefaultTableModel modelo = new DefaultTableModel();

    public ViewCadAtendente() {
        initComponents();
        this.setVisible(true);
        criaJTable();
    }

    public void addCadastraBotaoListener(ActionListener listener) {
        getCadastra().addActionListener(listener);
    }

    public void addTabelaBotaoListener(ActionListener listener) {
        atuaTab.addActionListener(listener);
    }

    public void addAlteraBotaoListener(ActionListener listener) {
        altera.addActionListener(listener);
    }

    public void addConcluidoBotaoListener(ActionListener listener) {
        getConcluido().addActionListener(listener);
    }

    public void addExcluiBotaoListener(ActionListener listener) {
        exclui.addActionListener(listener);
    }

    private void criaJTable() {
        getTabela().setModel(getModelo());
        getModelo().addColumn("CPF");
        getModelo().addColumn("Nome");
        getModelo().addColumn("Rua");
        getModelo().addColumn("CEP");
        getModelo().addColumn("Complem.");
        getModelo().addColumn("Senha");
        getModelo().addColumn("Salário");
        getTabela().getColumnModel().getColumn(0).setPreferredWidth(80);
        getTabela().getColumnModel().getColumn(1).setPreferredWidth(200);
        getTabela().getColumnModel().getColumn(2).setPreferredWidth(120);
        getTabela().getColumnModel().getColumn(3).setPreferredWidth(80);
        getTabela().getColumnModel().getColumn(4).setPreferredWidth(80);
        getTabela().getColumnModel().getColumn(5).setPreferredWidth(80);
        getTabela().getColumnModel().getColumn(6).setPreferredWidth(80);
    }

    public void atualiza() {
        atuaTab.doClick();
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cpf = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        rua = new javax.swing.JTextField();
        cep = new javax.swing.JTextField();
        complemento = new javax.swing.JTextField();
        senha = new javax.swing.JTextField();
        salario = new javax.swing.JTextField();
        cadastra = new javax.swing.JToggleButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        exclui = new javax.swing.JButton();
        altera = new javax.swing.JButton();
        concluido = new javax.swing.JButton();
        atuaTab = new javax.swing.JButton();
        sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel1.setText("Cadastro de Atendente");

        jLabel2.setText("CPF");

        jLabel3.setText("Nome");

        jLabel4.setText("Rua");

        jLabel5.setText("Cep");

        jLabel6.setText("Complemento");

        jLabel7.setText("Senha");

        jLabel8.setText("Salário");

        cadastra.setText("Cadastrar");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabela);

        jScrollPane3.setViewportView(jScrollPane2);

        exclui.setText("Exclui");

        altera.setText("Altera");

        concluido.setText("Concluido");
        concluido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                concluidoActionPerformed(evt);
            }
        });

        atuaTab.setText("Atualiza Tabela");
        atuaTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atuaTabActionPerformed(evt);
            }
        });

        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(complemento, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(salario, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                                    .addComponent(senha)
                                    .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rua)
                                    .addComponent(nome, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cadastra)))
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(exclui)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(altera)
                                .addGap(18, 18, 18)
                                .addComponent(concluido)
                                .addGap(204, 204, 204)
                                .addComponent(atuaTab))
                            .addComponent(sair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(complemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(salario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(cadastra, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(exclui)
                            .addComponent(altera)
                            .addComponent(concluido)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(atuaTab)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void concluidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_concluidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_concluidoActionPerformed

    private void atuaTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atuaTabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_atuaTabActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        dispose();
    }//GEN-LAST:event_sairActionPerformed

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
            java.util.logging.Logger.getLogger(ViewCadAtendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCadAtendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCadAtendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCadAtendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCadAtendente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton altera;
    private javax.swing.JButton atuaTab;
    private javax.swing.JToggleButton cadastra;
    private javax.swing.JTextField cep;
    private javax.swing.JTextField complemento;
    private javax.swing.JButton concluido;
    private javax.swing.JTextField cpf;
    private javax.swing.JButton exclui;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField rua;
    private javax.swing.JButton sair;
    private javax.swing.JTextField salario;
    private javax.swing.JTextField senha;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the modelo
     */
    public DefaultTableModel getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the Altera
     */
    public javax.swing.JButton getAltera() {
        return altera;
    }

    /**
     * @param Altera the Altera to set
     */
    public void setAltera(javax.swing.JButton Altera) {
        this.altera = Altera;
    }

    /**
     * @return the Exclui
     */
    public javax.swing.JButton getExclui() {
        return exclui;
    }

    /**
     * @param Exclui the Exclui to set
     */
    public void setExclui(javax.swing.JButton Exclui) {
        this.exclui = Exclui;
    }

    /**
     * @return the cadastra
     */
    public javax.swing.JToggleButton getCadastra() {
        return cadastra;
    }

    /**
     * @param cadastra the cadastra to set
     */
    public void setCadastra(javax.swing.JToggleButton cadastra) {
        this.cadastra = cadastra;
    }

    /**
     * @return the cep
     */
    public javax.swing.JTextField getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(javax.swing.JTextField cep) {
        this.cep = cep;
    }

    /**
     * @return the complemento
     */
    public javax.swing.JTextField getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(javax.swing.JTextField complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the concluido
     */
    public javax.swing.JButton getConcluido() {
        return concluido;
    }

    /**
     * @param concluido the concluido to set
     */
    public void setConcluido(javax.swing.JButton concluido) {
        this.concluido = concluido;
    }

    /**
     * @return the cpf
     */
    public javax.swing.JTextField getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(javax.swing.JTextField cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the jButton4
     */
    public javax.swing.JButton getjButton4() {
        return atuaTab;
    }

    /**
     * @param jButton4 the jButton4 to set
     */
    public void setjButton4(javax.swing.JButton jButton4) {
        this.atuaTab = jButton4;
    }

    /**
     * @return the nome
     */
    public javax.swing.JTextField getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(javax.swing.JTextField nome) {
        this.nome = nome;
    }

    /**
     * @return the rua
     */
    public javax.swing.JTextField getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(javax.swing.JTextField rua) {
        this.rua = rua;
    }

    /**
     * @return the sair
     */
    public javax.swing.JButton getSair() {
        return sair;
    }

    /**
     * @param sair the sair to set
     */
    public void setSair(javax.swing.JButton sair) {
        this.sair = sair;
    }

    /**
     * @return the salario
     */
    public javax.swing.JTextField getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(javax.swing.JTextField salario) {
        this.salario = salario;
    }

    /**
     * @return the senha
     */
    public javax.swing.JTextField getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(javax.swing.JTextField senha) {
        this.senha = senha;
    }

    /**
     * @return the tabela
     */
    public javax.swing.JTable getTabela() {
        return tabela;
    }

    /**
     * @param tabela the tabela to set
     */
    public void setTabela(javax.swing.JTable tabela) {
        this.tabela = tabela;
    }
}
