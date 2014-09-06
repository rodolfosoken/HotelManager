/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import modelo.Atendente;
import modelo.Cliente;
import modelo.Reserva;
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

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ReservaDAO(EntityManagerFactory emf, Reserva model, ViewReserva view, JanelaPrincipalDAO win) {
        this.emf = emf;
        this.model = model;
        this.view = view;
        this.main = win;
        this.clienteDAO = new ClienteDAO(emf);
        iniciaListeners();
        atualizaTabela();

    }

    private void iniciaListeners() {
        view.addNovoListener(new AcaoNovo());
        this.view.addCadastraBotaoListener(new AcaoCadastra());
        this.view.addAlteraBotaoListener(new AcaoAltera());
        this.view.addConcluidoBotaoListener(new AcaoConcluido());
        this.view.addExcluiBotaoListener(new AcaoExclui());
        this.view.addPesquisaListener(new AcaoPesquisar());
    }

    //Recupera informações para preencher a tabela    
    public void atualizaTabela() {
        view.getModelo().setNumRows(0);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for (Reserva r : getReservas()) {
            view.getModelo().addRow(new Object[]{
                r.getCpfCliente().getNome(),
                r.getNumQuarto().getNumQuarto(),
                df.format(r.getDtIn()),
                df.format(r.getDtOut()),
                r.getValor()});

        }
    }

    class AcaoPesquisar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (!view.getCodigo().getText().equals("")) {
                if (clienteDAO.existe(view.getCodigo().getText())) {
                    cliente = clienteDAO.busca(view.getCodigo().getText());
                    view.getNome().setText(cliente.getNome());
                    view.getEndereco().setText(cliente.getRua());
                    
                }else{
                    //cliente não encontrado
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                }
            }else{
                //caixa de pesquisa
            }
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
            int linhaSelecionada = -1;
            linhaSelecionada = view.getTabela().getSelectedRow();
            if (linhaSelecionada >= 0) {
                // String numQuarto = (String) view.getTabela().getValueAt(linhaSelecionada, 0);
                //model = busca(numQuarto);
                //view.getNumero().setText(String.valueOf(model.getNumQuarto()));
                //view.getCategoria().setText(model.getCategoria());
            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }

        }

    }

    class AcaoCadastra implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            cadastraReserva();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        }

    }

    class AcaoConcluido implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            // model.setCategoria(view.getCategoria().getText());
            //model.setNumQuarto(Integer.parseInt(view.getNumero().getText()));
            atualiza();
            atualizaTabela();
        }

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
            Query q = em.createNativeQuery("select * from reserva r where r.id_reserva = '" + id + "'", Reserva.class);
            return (Reserva) q.getSingleResult();
        } finally {
            em.close();
        }
    }

    public List<String> getHistorico() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery("select * from reserva");
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Reserva> getReservaOf(String cpf_cliente) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery("select * from reserva r where r.cpf_cliente = '" + cpf_cliente + "'", Reserva.class);
            return q.getResultList();
        } finally {
            em.close();
        }

    }

    public List<Reserva> getReservas() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery("select * from reserva", Reserva.class);
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
