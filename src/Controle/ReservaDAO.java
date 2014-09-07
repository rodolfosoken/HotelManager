/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Servicos.ControlePesquisaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.Atendente;
import modelo.Cliente;
import modelo.Quarto;
import modelo.Reserva;
import modelo.TelefoneCliente;
import visao.PesquisaCliente;
import visao.ViewReserva;

/**
 *
 * @author Rodolfo
 */
public class ReservaDAO {

    private EntityManagerFactory emf = null;
    private Reserva model = null;
    private ViewReserva view = null;
    private JanelaPrincipalDAO main = null;
    private Cliente cliente = null;
    private ClienteDAO clienteDAO = null;
    private Atendente atendente = null;
    private AtendenteDAO atendenteDAO = null;
    private Quarto quarto = null;
    private QuartoDAO quartoDAO = null;

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ReservaDAO(EntityManagerFactory emf, Reserva model, ViewReserva view, JanelaPrincipalDAO win) {
        this.emf = emf;
        this.model = model;
        this.view = view;
        this.main = win;
        this.clienteDAO = new ClienteDAO(emf);
        this.atendenteDAO = new AtendenteDAO(emf);
        this.quartoDAO = new QuartoDAO(emf);
        this.view.getConcluido().setEnabled(false);
        iniciaListeners();
        setAtendentes();
        setQuartos();
        getDataHoje();
        atualizaTabela();
    }

    private void getDataHoje() {
        Date x = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = new GregorianCalendar();
        view.getDtEntrada().setText(sdf1.format(x));
        c.add(Calendar.DAY_OF_MONTH, 1);
        view.getDtSaida().setText(sdf1.format(c.getTime()));
    }

    private void iniciaListeners() {
        view.addNovoListener(new AcaoNovo());
        this.view.addCadastraBotaoListener(new AcaoCadastra());
        this.view.addAlteraBotaoListener(new AcaoAltera());
        this.view.addConcluidoBotaoListener(new AcaoConcluido());
        this.view.addExcluiBotaoListener(new AcaoExclui());
        this.view.addPesquisaListener(new AcaoPesquisar());
        this.view.addQuartoListener(new AcaoQuarto());
        this.view.addQuarto2Listener(new AcaoQuarto2());
        this.view.addDtSaidaListener(new AcaoDataFocusLost());
        this.view.addDtEntradaListener(new AcaoDataFocusLost());
    }

    class AcaoDataFocusLost implements FocusListener {

        @Override
        public void focusGained(FocusEvent fe) {
            atualizaTabelaComcriterios();
        }

        @Override
        public void focusLost(FocusEvent fe) {
            atualizaTabelaComcriterios();
        }

    }

    //Recupera informações para preencher a tabela    
    public void atualizaTabela() {
        view.getModelo().setNumRows(0);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for (Reserva r : getReservas()) {
            view.getModelo().addRow(new Object[]{
                r.getIdReserva(),
                r.getCpfCliente().getNome(),
                r.getNumQuarto().getNumQuarto(),
                df.format(r.getDtIn()),
                df.format(r.getDtOut()),
                r.getValor()});

        }
    }

    //Recupera informações para preencher a tabela    
    public void atualizaTabelaComcriterios() {
        view.getModelo().setNumRows(0);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for (Reserva r : getReservasComCriterios()) {
            view.getModelo().addRow(new Object[]{
                r.getIdReserva(),
                r.getCpfCliente().getNome(),
                r.getNumQuarto().getNumQuarto(),
                df.format(r.getDtIn()),
                df.format(r.getDtOut()),
                r.getValor()});

        }
    }

    public void setAtendentes() {
        List<String> atend = new ArrayList<>();
        for (Atendente a : atendenteDAO.getAtendentes()) {
            atend.add(a.getNome());
        }
        view.setAtendentes(atend);
        view.atendentelist();

    }

    public void setQuartos() {
        List<String> quar = new ArrayList<>();
        for (Quarto q : quartoDAO.getQuartos()) {
            quar.add(q.getNumQuarto().toString());
        }
        view.setQuartos(quar);
        view.quartosList();
    }

    public void setDadosCliente(Cliente cliente) {
        view.getNome().setText(cliente.getNome());
        view.getEndereco().setText(cliente.getRua());
        view.getCodigo().setText(cliente.getCpf());
        int i = 0;
        for (TelefoneCliente c : cliente.getTelefoneClienteCollection()) {
            switch (i) {
                case 0:
                    view.getTelefone().setText(c.getTelefone().toString());
                    break;

                case 1:
                    view.getCelular().setText(c.getTelefone().toString());
                    break;

                case 2:
                    view.getComercial().setText(c.getTelefone().toString());
                    break;
            }
            i++;
        }
    }

    private void calculaTotal() {
        atualizaValorQuarto();
        Double total = quarto.getValor();
        view.getValorTotal().setText(String.valueOf(total));
    }

    private void atualizaValorQuarto() {

        quarto = quartoDAO.busca(Integer.parseInt(view.getQuarto().getSelectedItem().toString()));
        view.getValorQuarto().setText(quarto.getValor().toString());
    }

    class AcaoQuarto2 implements FocusListener {

        @Override
        public void focusGained(FocusEvent fe) {
        }

        @Override
        public void focusLost(FocusEvent fe) {
            if (!view.getQuarto().getSelectedItem().equals("")) {
                quarto = quartoDAO.busca(Integer.parseInt(view.getQuarto().getSelectedItem().toString()));
                view.getValorQuarto().setText(quarto.getValor().toString());
                calculaTotal();
                atualizaTabelaComcriterios();
            }
        }

    }

    class AcaoQuarto implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            if (!view.getQuarto().getSelectedItem().equals("")) {
                quarto = quartoDAO.busca(Integer.parseInt(view.getQuarto().getSelectedItem().toString()));
                view.getValorQuarto().setText(quarto.getValor().toString());
                calculaTotal();
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {

        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }

    }

    class AcaoPesquisar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (!view.getCodigo().getText().equals("")) {
                if (clienteDAO.existe(view.getCodigo().getText())) {
                    cliente = clienteDAO.busca(view.getCodigo().getText());
                    setDadosCliente(cliente);
                } else {
                    //cliente não encontrado
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                    caixaDePesquisa();

                }
            } else {
                //caixa de pesquisa
                caixaDePesquisa();
            }
        }

    }

    private void caixaDePesquisa() {
        PesquisaCliente pesquisa = new PesquisaCliente();
        ControlePesquisaCliente controle = new ControlePesquisaCliente(emf, pesquisa);
        JDialog dia = new JDialog(pesquisa);
        dia.setModal(true);     //cria JDialog modal para travar foco
        dia.setContentPane(pesquisa.getContentPane());
        dia.setBounds(pesquisa.getBounds());
        dia.setVisible(true);
        if (pesquisa.getSelecionado() != null) {
            cliente = clienteDAO.busca(pesquisa.getSelecionado());
            setDadosCliente(cliente);
        }
    }

    class AcaoNovo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            main.clienteWindow();
        }

    }

    class AcaoExclui implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int linhaSelecionada = -1;
            linhaSelecionada = view.getTabela().getSelectedRow();
            if (linhaSelecionada >= 0) {
                // String num = (String)view.getTabela().getValueAt(linhaSelecionada, 0);
                //exclui(num);
                atualizaTabela();
            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }

        }

    }

    class AcaoAltera implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            view.getConcluido().setEnabled(false);
            view.getTelefone().setText("");
            view.getCelular().setText("");
            view.getComercial().setText("");
            int linhaSelecionada = -1;
            linhaSelecionada = view.getTabela().getSelectedRow();
            if (linhaSelecionada >= 0) {
                int id_reserva = (int) view.getTabela().getValueAt(linhaSelecionada, 0);
                model = busca(id_reserva);
                cliente = model.getCpfCliente();
                quarto = model.getNumQuarto();
                view.getCodigo().setText(String.valueOf(model.getCpfCliente().getCpf()));
                setDadosCliente(model.getCpfCliente());
                view.getQuarto().setSelectedIndex(model.getNumQuarto().getNumQuarto());
                view.getAtendente().setSelectedItem(model.getCpfAtend().getNome());
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                view.getDtEntrada().setText(format.format(model.getDtIn()));
                view.getDtSaida().setText(format.format(model.getDtOut()));
                view.getConcluido().setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }

        }

    }

    class AcaoCadastra implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (cliente != null) {
                model.setCpfAtend(atendenteDAO.buscaPorNome(view.getAtendente().getSelectedItem().toString()));
                model.setCpfCliente(cliente);
                if ((!view.getDtEntrada().getText().isEmpty()) && (!view.getDtSaida().getText().isEmpty())) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date data = null;
                    try {
                        data = new java.sql.Date(format.parse(view.getDtEntrada().getText()).getTime());
                    } catch (ParseException ex) {
                        Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    model.setDtIn(data);
                    try {
                        data = new java.sql.Date(format.parse(view.getDtSaida().getText()).getTime());
                    } catch (ParseException ex) {
                        Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    model.setDtOut(data);
                    if (quarto != null) {
                        model.setNumQuarto(quarto);
                        model.setValor(Double.parseDouble(view.getValorTotal().getText()));

                        if (verificaDisponibilidade(quarto, model.getDtIn(), model.getDtOut())) {
                            cadastraReserva();
                            atualizaTabela();
                            main.atualizaTabela();
                            JOptionPane.showMessageDialog(null, "Reserva Cadastrada com Sucesso!");
                            view.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Quarto já reservado para esta data.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecione um Quarto.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma Data.");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Selecione um Cliente");
            }
        }

    }

    class AcaoConcluido implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (cliente != null) {
                model.setCpfAtend(atendenteDAO.buscaPorNome(view.getAtendente().getSelectedItem().toString()));
                model.setCpfCliente(cliente);
                if ((!view.getDtEntrada().getText().isEmpty()) && (!view.getDtSaida().getText().isEmpty())) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date data = null;
                    try {
                        data = new java.sql.Date(format.parse(view.getDtEntrada().getText()).getTime());
                    } catch (ParseException ex) {
                        Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    model.setDtIn(data);
                    try {
                        data = new java.sql.Date(format.parse(view.getDtSaida().getText()).getTime());
                    } catch (ParseException ex) {
                        Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    model.setDtOut(data);
                    if (quarto != null) {
                        atualizaValorQuarto();
                        calculaTotal();
                        model.setNumQuarto(quarto);
                        model.setValor(Double.parseDouble(view.getValorTotal().getText()));

                        if (verificaDisponibilidade(quarto, model.getDtIn(), model.getDtOut(), model)) {
                            atualiza();
                            atualizaTabela();
                            main.atualizaTabela();
                            view.getConcluido().setEnabled(false);
                            JOptionPane.showMessageDialog(null, "Reserva Cadastrada com Sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Quarto já reservado para esta data.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecione um Quarto.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma Data.");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Selecione um Cliente");
            }
        }

    }

    public boolean verificaDisponibilidade(Quarto quarto, Date dataEntrada, Date dataSaida) {
        boolean disponivel = false;
        EntityManager em = getEntityManager();
        try {
            java.sql.Date data_in = null, data_out = null;
            data_in = new java.sql.Date(dataEntrada.getTime());
            data_out = new java.sql.Date(dataSaida.getTime());
            Query q = em.createNativeQuery("select * from reserva r where r.num_quarto = '" + quarto.getNumQuarto()
                    + "' AND '" + data_out + "' >= dt_in AND '" + data_in + "' <= dt_in OR '" + data_in + "' <= dt_out AND '" + data_out + "' > dt_out;");
            if (q.getResultList().isEmpty()) {
                disponivel = true;
            }

        } finally {
            em.close();
        }

        return disponivel;
    }

    public boolean verificaDisponibilidade(Quarto quarto, Date dataEntrada, Date dataSaida, Reserva reserva) {
        boolean disponivel = false;
        EntityManager em = getEntityManager();
        try {
            java.sql.Date data_in = null, data_out = null;
            data_in = new java.sql.Date(dataEntrada.getTime());
            data_out = new java.sql.Date(dataSaida.getTime());
            Query q = em.createNativeQuery("select * from reserva r where r.num_quarto = '" + quarto.getNumQuarto()
                    + "' AND '" + data_out + "' >= dt_in AND '" + data_in + "' <= dt_in OR '" + data_in + "' <= dt_out AND '" + data_out + "' > dt_out AND r.id_reserva <> '" + reserva.getIdReserva() + "';");
            if (q.getResultList().isEmpty()) {
                disponivel = true;
            }

        } finally {
            em.close();
        }

        return disponivel;
    }

    public void exclui(int id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Reserva reserva = em.getReference(Reserva.class, id);
            em.remove(reserva);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void atualiza() {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(model);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    public Reserva busca(int id) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery("select * from reserva r where r.id_reserva = '" + id + "';", Reserva.class);
            return (Reserva) q.getSingleResult();
        } finally {
            em.close();
        }
    }

    public List<String> getHistorico() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery("select * from reserva;");
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Reserva> getReservaOf(String cpf_cliente) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery("select * from reserva r where r.cpf_cliente = '" + cpf_cliente + "';", Reserva.class);
            return q.getResultList();
        } finally {
            em.close();
        }

    }

    public List<Reserva> getReservasComCriterios() {
        EntityManager em = getEntityManager();
        if ((!view.getDtEntrada().getText().isEmpty()) || (!view.getDtSaida().getText().isEmpty())) {
            if (!view.getQuarto().getSelectedItem().equals("")) {
                try {
                    java.sql.Date data_in = null, data_out = null;
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    data_in = new java.sql.Date(format.parse(view.getDtEntrada().getText()).getTime());
                    data_out = new java.sql.Date(format.parse(view.getDtSaida().getText()).getTime());
                    Query q = em.createNativeQuery("select * from reserva r where r.num_quarto = '" + view.getQuarto().getSelectedItem()
                            + "' AND '" + data_out + "' >= dt_in AND '" + data_in + "' <= dt_in OR '" + data_in + "' <= dt_out AND '" + data_out + "' > dt_out;", Reserva.class);
                    return q.getResultList();

                } catch (ParseException ex) {
                    Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    em.close();
                }
            } else {
                return getReservas();
            }

        } else {
            return getReservas();
        }
        return getReservas();

    }

    public List<Reserva> getReservas() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery("select * from reserva;", Reserva.class);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public void cadastraReserva() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(model);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
