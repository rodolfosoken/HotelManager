/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import modelo.Acompanhante;
import modelo.AcompanhantePK;
import modelo.Cliente;
import visao.ViewAcompanhante;

/**
 *
 * @author Rodolfo
 */
public class AcompanhanteDAO {

    private EntityManagerFactory emf = null;
    private Acompanhante model = null;
    private ViewAcompanhante view = null;
    private Cliente cliente = null;

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public AcompanhanteDAO(EntityManagerFactory emf, Acompanhante model, Cliente cliente, ViewAcompanhante view) {
        this.emf = emf;
        this.view = view;
        this.model = model;
        this.cliente = cliente;

        this.view.addCadastraBotaoListener(new cadastraListener());
        this.view.addAlteraBotaoListener(new actionAltera());
        this.view.addConcluidoBotaoListener(new actionConcluido());
        this.view.addExcluiBotaoListener(new actionExclui());
        this.view.getConcluido().setEnabled(false);
        this.view.getCliente().setText(cliente.getNome());
        atualizaTabela();
    }

    public void atualizaTabela() {
        view.getModelo().setNumRows(0);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for (Acompanhante a : cliente.getAcompanhanteCollection()) {
            view.getModelo().addRow(new Object[]{a.getAcompanhantePK().getNome(),
                a.getAcompanhantePK().getCpfCliente(), a.getCliente().getNome(), df.format(a.getDtNascimento())}
            );
        }
    }

    public List<Acompanhante> getAcompanhantes() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery("select * from acompanhante;", Acompanhante.class);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    class cadastraListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if ((!view.getNome().getText().isEmpty()) && (!view.getDataNascimento().getText().isEmpty())) {
                model = new Acompanhante(cliente.getCpf(), view.getNome().getText());
                model.setCliente(cliente);
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = null;
                try {
                    data = new java.sql.Date(format.parse(view.getDataNascimento().getText()).getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(AcompanhanteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                model.setDtNascimento(data);
                cliente.getAcompanhanteCollection().add(model);
                cadastraAcompanhante();
                atualizaTabela();
                JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Preencha corretamente os campos.");
            }
        }

    }

    class actionExclui implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int linhaSelecionada = -1;
            linhaSelecionada = view.getTabela().getSelectedRow();
            if (linhaSelecionada >= 0) {
                String cpf = (String) view.getTabela().getValueAt(linhaSelecionada, 1);
                String nome = (String) view.getTabela().getValueAt(linhaSelecionada, 0);
                exclui(cpf, nome);
                atualizaTabela();
            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }

        }

    }

    class actionAltera implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            view.getConcluido().setEnabled(true);
            int linhaSelecionada = -1;
            linhaSelecionada = view.getTabela().getSelectedRow();
            if (linhaSelecionada >= 0) {
                String cpf = (String) view.getTabela().getValueAt(linhaSelecionada, 1);
                String nome = (String) view.getTabela().getValueAt(linhaSelecionada, 0);
                model = busca(cpf, nome);
                view.getNome().setText(model.getAcompanhantePK().getNome());
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                view.getDataNascimento().setText(df.format(model.getDtNascimento()));
                view.getCliente().setText(model.getCliente().getNome());
            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }

        }

    }

    class actionConcluido implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if ((!view.getNome().getText().isEmpty()) && (!view.getDataNascimento().getText().isEmpty())) {
                model = new Acompanhante(cliente.getCpf(), view.getNome().getText());
                model.setCliente(cliente);
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = null;
                try {
                    data = new java.sql.Date(format.parse(view.getDataNascimento().getText()).getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(AcompanhanteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                model.setDtNascimento(data);
                cliente.getAcompanhanteCollection().add(model);
                atualiza();
                atualizaTabela();
                view.limpaCampos();
                view.getConcluido().setEnabled(false);
                atualizaTabela();
                JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Preencha corretamente os campos.");
            }
        }

    }

    public void exclui(String cpf, String nome) {
        EntityManager em = getEntityManager();
        AcompanhantePK chave = new AcompanhantePK(cpf, nome);
        try {
            em.getTransaction().begin();
            Acompanhante acompanhante = em.getReference(Acompanhante.class, chave);
            cliente.getAcompanhanteCollection().remove(acompanhante);
            em.remove(acompanhante);
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
            cliente.getAcompanhanteCollection().remove(model);
        } finally {
            em.close();
        }

    }

    public Acompanhante busca(String cpf, String nome) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery("select * from acompanhante a where a.cpf_cliente = '" + cpf + "' AND a.nome = '" + nome + "';", Acompanhante.class);
            return (Acompanhante) q.getSingleResult();
        } finally {
            em.close();
        }
    }

    public void cadastraAcompanhante() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(model);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public boolean existe(String cpf, String nome) {
        boolean existe = false;
        EntityManager em = getEntityManager();
        AcompanhantePK chave = new AcompanhantePK(cpf, nome);
        try {
            if (em.find(Acompanhante.class, chave) != null) {
                existe = true;
            }
        } finally {
            em.close();
        }

        return existe;

    }

}
