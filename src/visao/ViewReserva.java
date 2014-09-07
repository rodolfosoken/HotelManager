/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Atendente;

/**
 *
 * @author Rodolfo
 */
public class ViewReserva extends javax.swing.JFrame {

    /**
     * Creates new form ViewReserva
     */
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
        private DefaultTableModel modeloProduto = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public DefaultTableModel getModeloProduto() {
        return modeloProduto;
    }

    public void setModeloProduto(DefaultTableModel modeloProduto) {
        this.modeloProduto = modeloProduto;
    }
        
    private List<String> atendentes = new ArrayList<>();

    public List<String> getAtendentes() {
        return atendentes;
    }

    public void setAtendentes(List<String> atendentes) {
        this.atendentes = atendentes;
    }

    public JTextField getValorProdutos() {
        return valorProdutos;
    }

    public void setValorProdutos(JTextField valorProdutos) {
        this.valorProdutos = valorProdutos;
    }
    

    public void atendentelist() {
        for (String a : atendentes) {
            atendente.addItem(a);
        }
    }

    private List<String> quartos = new ArrayList<>();

    public List<String> getQuartos() {
        return quartos;
    }

    private List<String> produtos = new ArrayList<>();

    public List<String> getProdutos() {
        return produtos;
    }
    
        public void produtoList() {
        for (String p : produtos) {
            comboProduto.addItem(p);
        }
    }
        
   public void addBtAddProdutoListener(ActionListener listener){
       addProduto.addActionListener(listener);
   }

    public void setProdutos(List<String> produtos) {
        this.produtos = produtos;
    }

    public void setQuartos(List<String> quartos) {
        this.quartos = quartos;
    }

    public void quartosList() {
        for (String r : quartos) {
            quarto.addItem(r);
        }
    }

    public ViewReserva() {
        initComponents();
        this.setVisible(true);
        criaJTable();
    }

    private void criaJTable() {
        getTabela().setModel(getModelo());
        getModelo().addColumn("ID");
        getModelo().addColumn("Nome");
        getModelo().addColumn("Quarto");
        getModelo().addColumn("Data Entrada");
        getModelo().addColumn("Data Saída");
        getModelo().addColumn("Valor");
        getTabela().getColumnModel().getColumn(0).setPreferredWidth(80);
        getTabela().getColumnModel().getColumn(1).setPreferredWidth(200);
        getTabela().getColumnModel().getColumn(2).setPreferredWidth(80);
        getTabela().getColumnModel().getColumn(3).setPreferredWidth(120);
        getTabela().getColumnModel().getColumn(4).setPreferredWidth(120);
        getTabela().getColumnModel().getColumn(5).setPreferredWidth(80);
        
        getTabelaProduto().setModel(modeloProduto);
        getModeloProduto().addColumn("Descrição");
        getModeloProduto().addColumn("Valor");
        getTabelaProduto().getColumnModel().getColumn(0).setPreferredWidth(100);
        getTabelaProduto().getColumnModel().getColumn(0).setPreferredWidth(80);
    }

    public void limpaCampos() {
        for (int i = 0; i < getContentPane().getComponentCount(); i++) {
            //varre todos os componentes  

            Component c = getContentPane().getComponent(i);

            if (c instanceof JTextField) {
                //apaga os valores  
                JTextField field = (JTextField) c;
                field.setText("");
            }
        }
    }

    public JButton getAddProduto() {
        return addProduto;
    }

    public void setAddProduto(JButton addProduto) {
        this.addProduto = addProduto;
    }

    public JButton getAddServico() {
        return addServico;
    }

    public void setAddServico(JButton addServico) {
        this.addServico = addServico;
    }

    public List<Atendente> getAtendenteList() {
        return atendenteList;
    }

    public void setAtendenteList(List<Atendente> atendenteList) {
        this.atendenteList = atendenteList;
    }

    public JComboBox getComboProduto() {
        return comboProduto;
    }

    public void setComboProduto(JComboBox comboProduto) {
        this.comboProduto = comboProduto;
    }

    public JComboBox getComboServico() {
        return comboServico;
    }

    public void setComboServico(JComboBox comboServico) {
        this.comboServico = comboServico;
    }

    public JList getListaPagamento() {
        return listaPagamento;
    }

    public void setListaPagamento(JList listaPagamento) {
        this.listaPagamento = listaPagamento;
    }

    public JButton getRemoveProduto() {
        return removeProduto;
    }

    public void setRemoveProduto(JButton removeProduto) {
        this.removeProduto = removeProduto;
    }

    public JButton getRemoveSevico() {
        return removeSevico;
    }

    public void setRemoveSevico(JButton removeSevico) {
        this.removeSevico = removeSevico;
    }

    public JTable getTabelaProduto() {
        return tabelaProduto;
    }

    public void setTabelaProduto(JTable tabelaProduto) {
        this.tabelaProduto = tabelaProduto;
    }

    public JTable getTabelaServico() {
        return tabelaServico;
    }

    public void setTabelaServico(JTable tabelaServico) {
        this.tabelaServico = tabelaServico;
    }

    public JTextField getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(JTextField valorTotal) {
        this.valorTotal = valorTotal;
    }

    public JTextField getCelular() {
        return celular;
    }

    public void setCelular(JTextField celular) {
        this.celular = celular;
    }

    public JTextField getComercial() {
        return comercial;
    }

    public void setComercial(JTextField comercial) {
        this.comercial = comercial;
    }

    public JTextField getTelefone() {
        return telefone;
    }

    public void setTelefone(JTextField telefone) {
        this.telefone = telefone;
    }

    public JTextField getValorQuarto() {
        return valorQuarto;
    }

    public void setValorQuarto(JTextField valorQuarto) {
        this.valorQuarto = valorQuarto;
    }

    public JTextField getEndereco() {
        return endereco;
    }

    public JButton getPesquisar() {
        return pesquisar;
    }

    public void addDtSaidaListener(FocusListener listener) {
        dtSaida.addFocusListener(listener);
    }

    public void addDtEntradaListener(FocusListener listener) {
        dtEntrada.addFocusListener(listener);
    }

    public void addQuarto2Listener(FocusListener listener) {
        quarto.addFocusListener(listener);
    }

    public void addQuartoListener(MouseListener listener) {
        quarto.addMouseListener(listener);
    }

    public void addPesquisaListener(ActionListener listener) {
        pesquisar.addActionListener(listener);
    }

    public void addNovoListener(ActionListener listener) {
        getNovo().addActionListener(listener);
    }

    public void addCadastraBotaoListener(ActionListener listener) {
        getCadastra().addActionListener(listener);
    }

    public void addAlteraBotaoListener(ActionListener listener) {
        getAltera().addActionListener(listener);
    }

    public void addConcluidoBotaoListener(ActionListener listener) {
        getConcluido().addActionListener(listener);
    }

    public void addExcluiBotaoListener(ActionListener listener) {
        getExclui().addActionListener(listener);
    }

    /**
     * @return the altera
     */
    public javax.swing.JButton getAltera() {
        return altera;
    }

    /**
     * @param altera the altera to set
     */
    public void setAltera(javax.swing.JButton altera) {
        this.altera = altera;
    }

    /**
     * @return the cadastra
     */
    public javax.swing.JButton getCadastra() {
        return cadastra;
    }

    /**
     * @param cadastra the cadastra to set
     */
    public void setCadastra(javax.swing.JButton cadastra) {
        this.cadastra = cadastra;
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
     * @return the exclui
     */
    public javax.swing.JButton getExclui() {
        return exclui;
    }

    /**
     * @param exclui the exclui to set
     */
    public void setExclui(javax.swing.JButton exclui) {
        this.exclui = exclui;
    }

    /**
     * @return the jButton1
     */
    public javax.swing.JButton getjButton1() {
        return pesquisar;
    }

    /**
     * @param jButton1 the jButton1 to set
     */
    public void setjButton1(javax.swing.JButton jButton1) {
        this.pesquisar = jButton1;
    }

    /**
     * @return the jButton2
     */
    public javax.swing.JButton getjButton2() {
        return addProduto;
    }

    /**
     * @param jButton2 the jButton2 to set
     */
    public void setjButton2(javax.swing.JButton jButton2) {
        this.addProduto = jButton2;
    }

    /**
     * @return the jButton7
     */
    public javax.swing.JButton getjButton7() {
        return addServico;
    }

    /**
     * @param jButton7 the jButton7 to set
     */
    public void setjButton7(javax.swing.JButton jButton7) {
        this.addServico = jButton7;
    }

    /**
     * @return the jButton8
     */
    public javax.swing.JButton getjButton8() {
        return removeProduto;
    }

    /**
     * @param jButton8 the jButton8 to set
     */
    public void setjButton8(javax.swing.JButton jButton8) {
        this.removeProduto = jButton8;
    }

    /**
     * @return the jButton9
     */
    public javax.swing.JButton getjButton9() {
        return removeSevico;
    }

    /**
     * @param jButton9 the jButton9 to set
     */
    public void setjButton9(javax.swing.JButton jButton9) {
        this.removeSevico = jButton9;
    }

    /**
     * @return the jComboBox1
     */
    public javax.swing.JComboBox getjComboBox1() {
        return comboProduto;
    }

    /**
     * @param jComboBox1 the jComboBox1 to set
     */
    public void setjComboBox1(javax.swing.JComboBox jComboBox1) {
        this.comboProduto = jComboBox1;
    }

    /**
     * @return the jComboBox2
     */
    public javax.swing.JComboBox getjComboBox2() {
        return comboServico;
    }

    /**
     * @param jComboBox2 the jComboBox2 to set
     */
    public void setjComboBox2(javax.swing.JComboBox jComboBox2) {
        this.comboServico = jComboBox2;
    }

    /**
     * @return the jLabel1
     */
    public javax.swing.JLabel getjLabel1() {
        return jLabel1;
    }

    /**
     * @param jLabel1 the jLabel1 to set
     */
    public void setjLabel1(javax.swing.JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    /**
     * @return the jLabel10
     */
    public javax.swing.JLabel getjLabel10() {
        return jLabel10;
    }

    /**
     * @param jLabel10 the jLabel10 to set
     */
    public void setjLabel10(javax.swing.JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    /**
     * @return the jLabel11
     */
    public javax.swing.JLabel getjLabel11() {
        return jLabel11;
    }

    /**
     * @param jLabel11 the jLabel11 to set
     */
    public void setjLabel11(javax.swing.JLabel jLabel11) {
        this.jLabel11 = jLabel11;
    }

    /**
     * @return the jLabel12
     */
    public javax.swing.JLabel getjLabel12() {
        return jLabel12;
    }

    /**
     * @param jLabel12 the jLabel12 to set
     */
    public void setjLabel12(javax.swing.JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }

    /**
     * @return the jLabel13
     */
    public javax.swing.JLabel getjLabel13() {
        return jLabel13;
    }

    /**
     * @param jLabel13 the jLabel13 to set
     */
    public void setjLabel13(javax.swing.JLabel jLabel13) {
        this.jLabel13 = jLabel13;
    }

    /**
     * @return the jLabel14
     */
    public javax.swing.JLabel getjLabel14() {
        return jLabel14;
    }

    /**
     * @param jLabel14 the jLabel14 to set
     */
    public void setjLabel14(javax.swing.JLabel jLabel14) {
        this.jLabel14 = jLabel14;
    }

    /**
     * @return the jLabel2
     */
    public javax.swing.JLabel getjLabel2() {
        return jLabel2;
    }

    /**
     * @param jLabel2 the jLabel2 to set
     */
    public void setjLabel2(javax.swing.JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    /**
     * @return the jLabel3
     */
    public javax.swing.JLabel getjLabel3() {
        return jLabel3;
    }

    /**
     * @param jLabel3 the jLabel3 to set
     */
    public void setjLabel3(javax.swing.JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    /**
     * @return the jLabel4
     */
    public javax.swing.JLabel getjLabel4() {
        return jLabel4;
    }

    /**
     * @param jLabel4 the jLabel4 to set
     */
    public void setjLabel4(javax.swing.JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    /**
     * @return the jLabel5
     */
    public javax.swing.JLabel getjLabel5() {
        return jLabel5;
    }

    /**
     * @param jLabel5 the jLabel5 to set
     */
    public void setjLabel5(javax.swing.JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    /**
     * @return the jLabel6
     */
    public javax.swing.JLabel getjLabel6() {
        return jLabel6;
    }

    /**
     * @param jLabel6 the jLabel6 to set
     */
    public void setjLabel6(javax.swing.JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    /**
     * @return the jLabel7
     */
    public javax.swing.JLabel getjLabel7() {
        return jLabel7;
    }

    /**
     * @param jLabel7 the jLabel7 to set
     */
    public void setjLabel7(javax.swing.JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    /**
     * @return the jLabel8
     */
    public javax.swing.JLabel getjLabel8() {
        return jLabel8;
    }

    /**
     * @param jLabel8 the jLabel8 to set
     */
    public void setjLabel8(javax.swing.JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    /**
     * @return the jLabel9
     */
    public javax.swing.JLabel getjLabel9() {
        return jLabel9;
    }

    /**
     * @param jLabel9 the jLabel9 to set
     */
    public void setjLabel9(javax.swing.JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    /**
     * @return the jList1
     */
    public javax.swing.JList getjList1() {
        return listaPagamento;
    }

    /**
     * @param jList1 the jList1 to set
     */
    public void setjList1(javax.swing.JList jList1) {
        this.listaPagamento = jList1;
    }

    /**
     * @return the jPanel1
     */
    public javax.swing.JPanel getjPanel1() {
        return jPanel1;
    }

    /**
     * @param jPanel1 the jPanel1 to set
     */
    public void setjPanel1(javax.swing.JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    /**
     * @return the jPanel2
     */
    public javax.swing.JPanel getjPanel2() {
        return jPanel2;
    }

    /**
     * @param jPanel2 the jPanel2 to set
     */
    public void setjPanel2(javax.swing.JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    /**
     * @return the jPanel3
     */
    public javax.swing.JPanel getjPanel3() {
        return jPanel3;
    }

    /**
     * @param jPanel3 the jPanel3 to set
     */
    public void setjPanel3(javax.swing.JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    /**
     * @return the jPanel4
     */
    public javax.swing.JPanel getjPanel4() {
        return jPanel4;
    }

    /**
     * @param jPanel4 the jPanel4 to set
     */
    public void setjPanel4(javax.swing.JPanel jPanel4) {
        this.jPanel4 = jPanel4;
    }

    /**
     * @return the jScrollPane1
     */
    public javax.swing.JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    /**
     * @param jScrollPane1 the jScrollPane1 to set
     */
    public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    /**
     * @return the jScrollPane2
     */
    public javax.swing.JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    /**
     * @param jScrollPane2 the jScrollPane2 to set
     */
    public void setjScrollPane2(javax.swing.JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    /**
     * @return the jScrollPane3
     */
    public javax.swing.JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    /**
     * @param jScrollPane3 the jScrollPane3 to set
     */
    public void setjScrollPane3(javax.swing.JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }

    /**
     * @return the jScrollPane4
     */
    public javax.swing.JScrollPane getjScrollPane4() {
        return jScrollPane4;
    }

    /**
     * @param jScrollPane4 the jScrollPane4 to set
     */
    public void setjScrollPane4(javax.swing.JScrollPane jScrollPane4) {
        this.jScrollPane4 = jScrollPane4;
    }

    /**
     * @return the jTable2
     */
    public javax.swing.JTable getjTable2() {
        return tabelaProduto;
    }

    /**
     * @param jTable2 the jTable2 to set
     */
    public void setjTable2(javax.swing.JTable jTable2) {
        this.tabelaProduto = jTable2;
    }

    /**
     * @return the jTable4
     */
    public javax.swing.JTable getjTable4() {
        return tabelaServico;
    }

    /**
     * @param jTable4 the jTable4 to set
     */
    public void setjTable4(javax.swing.JTable jTable4) {
        this.tabelaServico = jTable4;
    }

    /**
     * @return the jTextField1
     */
    public javax.swing.JTextField getjTextField1() {
        return getCodigo();
    }

    /**
     * @param jTextField1 the jTextField1 to set
     */
    public void setjTextField1(javax.swing.JTextField jTextField1) {
        this.setCodigo(jTextField1);
    }

    /**
     * @return the jTextField10
     */
    public javax.swing.JTextField getjTextField10() {
        return jTextField10;
    }

    /**
     * @param jTextField10 the jTextField10 to set
     */
    public void setjTextField10(javax.swing.JTextField jTextField10) {
        this.jTextField10 = jTextField10;
    }

    /**
     * @return the jTextField2
     */
    public javax.swing.JTextField getjTextField2() {
        return getNome();
    }

    /**
     * @param jTextField2 the jTextField2 to set
     */
    public void setjTextField2(javax.swing.JTextField jTextField2) {
        this.setNome(jTextField2);
    }

    /**
     * @return the jTextField3
     */
    public javax.swing.JTextField getjTextField3() {
        return endereco;
    }

    /**
     * @param jTextField3 the jTextField3 to set
     */
    public void setjTextField3(javax.swing.JTextField jTextField3) {
        this.endereco = jTextField3;
    }

    /**
     * @return the jTextField6
     */
    public javax.swing.JTextField getjTextField6() {
        return jTextField6;
    }

    /**
     * @param jTextField6 the jTextField6 to set
     */
    public void setjTextField6(javax.swing.JTextField jTextField6) {
        this.jTextField6 = jTextField6;
    }

    /**
     * @return the jTextField7
     */
    public javax.swing.JTextField getjTextField7() {
        return jTextField7;
    }

    /**
     * @param jTextField7 the jTextField7 to set
     */
    public void setjTextField7(javax.swing.JTextField jTextField7) {
        this.jTextField7 = jTextField7;
    }

    /**
     * @return the jTextField8
     */
    public javax.swing.JTextField getjTextField8() {
        return valorTotal;
    }

    /**
     * @param jTextField8 the jTextField8 to set
     */
    public void setjTextField8(javax.swing.JTextField jTextField8) {
        this.valorTotal = jTextField8;
    }

    /**
     * @return the jTextField9
     */
    public javax.swing.JTextField getjTextField9() {
        return valorProdutos;
    }

    /**
     * @param jTextField9 the jTextField9 to set
     */
    public void setjTextField9(javax.swing.JTextField jTextField9) {
        this.valorProdutos = jTextField9;
    }

    /**
     * @return the novo
     */
    public javax.swing.JButton getNovo() {
        return novo;
    }

    /**
     * @param novo the novo to set
     */
    public void setNovo(javax.swing.JButton novo) {
        this.novo = novo;
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
     * @return the codigo
     */
    public javax.swing.JTextField getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(javax.swing.JTextField codigo) {
        this.codigo = codigo;
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

    public JComboBox getQuarto() {
        return quarto;
    }

    public JFormattedTextField getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrada(JFormattedTextField dtEntrada) {
        this.dtEntrada = dtEntrada;
    }

    public JComboBox getAtendente() {
        return atendente;
    }

    public JFormattedTextField getDtSaida() {
        return dtSaida;
    }

    public void setDtSaida(JFormattedTextField dtSaida) {
        this.dtSaida = dtSaida;
    }

    public void setQuarto(JComboBox quarto) {
        this.quarto = quarto;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HotelManagerPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("HotelManagerPU").createEntityManager();
        atendenteQuery = java.beans.Beans.isDesignTime() ? null : HotelManagerPUEntityManager.createQuery("SELECT a FROM Atendente a");
        atendenteList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : atendenteQuery.getResultList();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        pesquisar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        endereco = new javax.swing.JTextField();
        novo = new javax.swing.JButton();
        cadastra = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        telefone = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        celular = new javax.swing.JTextField();
        comercial = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        valorQuarto = new javax.swing.JTextField();
        atendente = new javax.swing.JComboBox();
        quarto = new javax.swing.JComboBox();
        dtEntrada = new javax.swing.JFormattedTextField();
        dtSaida = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboProduto = new javax.swing.JComboBox();
        comboServico = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaServico = new javax.swing.JTable();
        addProduto = new javax.swing.JButton();
        addServico = new javax.swing.JButton();
        removeProduto = new javax.swing.JButton();
        removeSevico = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        altera = new javax.swing.JButton();
        exclui = new javax.swing.JButton();
        concluido = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        valorTotal = new javax.swing.JTextField();
        valorProdutos = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaPagamento = new javax.swing.JList();
        jLabel14 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel1.setText("Reservas");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Cliente");

        codigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigoFocusLost(evt);
            }
        });

        pesquisar.setText("Pesquisar");

        jLabel3.setText("Nome");

        jLabel4.setText("Endereço");

        jLabel5.setText("Quarto");

        jLabel6.setText("Atendente");

        nome.setEditable(false);

        endereco.setEditable(false);

        novo.setText("Novo");
        novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoActionPerformed(evt);
            }
        });

        cadastra.setText("Cadastra");

        jLabel15.setText("Telefone");

        telefone.setEditable(false);

        jLabel16.setText("Celular");

        jLabel17.setText("Comercial");

        celular.setEditable(false);

        comercial.setEditable(false);

        jLabel18.setText("Valor");

        quarto.setModel(new javax.swing.DefaultComboBoxModel(new String[] {""}));
        quarto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                quartoFocusLost(evt);
            }
        });

        dtEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        dtSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jLabel20.setText("Entrada");

        jLabel21.setText("Saida");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel15)
                    .addComponent(jLabel6)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtSaida)
                        .addGap(34, 34, 34)
                        .addComponent(cadastra, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(celular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comercial, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(atendente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quarto, 0, 196, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(pesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(novo, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(endereco))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisar)
                    .addComponent(novo)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(cadastra, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel18)
                            .addComponent(valorQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(atendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(31, 31, 31))))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("Produto");

        jLabel8.setText("Serviço");

        comboServico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaProduto);

        tabelaServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane4.setViewportView(tabelaServico);

        addProduto.setText("Add");

        addServico.setText("Add");

        removeProduto.setText("Remove");

        removeSevico.setText("Remove");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(comboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(removeProduto))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addServico, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboServico, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeSevico)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane2, jScrollPane4});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comboProduto, comboServico});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(addServico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(removeSevico)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addProduto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(removeProduto)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(comboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(84, 84, 84))))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
        jScrollPane1.setViewportView(tabela);

        altera.setText("Altera");
        altera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alteraActionPerformed(evt);
            }
        });

        exclui.setText("Exclui");

        concluido.setText("Concluido");

        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField6.setEditable(false);

        jLabel9.setText("Valor ");

        jLabel10.setText("Desconto");

        jTextField7.setEditable(false);

        jLabel11.setText("Valor Total");

        valorTotal.setEditable(false);
        valorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorTotalActionPerformed(evt);
            }
        });

        valorProdutos.setEditable(false);
        valorProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorProdutosActionPerformed(evt);
            }
        });

        jLabel12.setText("Valor dos Produtos");

        jLabel13.setText("Valor dos Serviços");

        jTextField10.setEditable(false);

        listaPagamento.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listaPagamento);

        jLabel14.setText("Forma de pagamento");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel19.setText("%");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorProdutos)
                            .addComponent(jTextField10))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jLabel11)))
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField6)
                    .addComponent(valorTotal)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(valorProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addComponent(jLabel14)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(altera)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exclui, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(concluido, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 418, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(altera)
                    .addComponent(exclui)
                    .addComponent(concluido))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alteraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alteraActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed

        dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoActionPerformed

    }//GEN-LAST:event_novoActionPerformed

    private void valorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorTotalActionPerformed

    private void valorProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorProdutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorProdutosActionPerformed

    private void codigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoFocusLost

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void quartoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quartoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_quartoFocusLost

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
            java.util.logging.Logger.getLogger(ViewReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager HotelManagerPUEntityManager;
    private javax.swing.JButton addProduto;
    private javax.swing.JButton addServico;
    private javax.swing.JButton altera;
    private javax.swing.JComboBox atendente;
    private java.util.List<modelo.Atendente> atendenteList;
    private javax.persistence.Query atendenteQuery;
    private javax.swing.JButton cadastra;
    private javax.swing.JTextField celular;
    private javax.swing.JTextField codigo;
    private javax.swing.JComboBox comboProduto;
    private javax.swing.JComboBox comboServico;
    private javax.swing.JTextField comercial;
    private javax.swing.JButton concluido;
    private javax.swing.JFormattedTextField dtEntrada;
    private javax.swing.JFormattedTextField dtSaida;
    private javax.swing.JTextField endereco;
    private javax.swing.JButton exclui;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JList listaPagamento;
    private javax.swing.JTextField nome;
    private javax.swing.JButton novo;
    private javax.swing.JButton pesquisar;
    private javax.swing.JComboBox quarto;
    private javax.swing.JButton removeProduto;
    private javax.swing.JButton removeSevico;
    private javax.swing.JButton sair;
    private javax.swing.JTable tabela;
    private javax.swing.JTable tabelaProduto;
    private javax.swing.JTable tabelaServico;
    private javax.swing.JTextField telefone;
    private javax.swing.JTextField valorProdutos;
    private javax.swing.JTextField valorQuarto;
    private javax.swing.JTextField valorTotal;
    // End of variables declaration//GEN-END:variables

}
