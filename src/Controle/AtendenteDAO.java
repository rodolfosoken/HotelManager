/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import modelo.Atendente;
import visao.ViewCadAtendente;

/**
 *
 * @author Rodolfo
 */
public class AtendenteDAO {

    private EntityManagerFactory emf = null;
    private Atendente model = null;
    private ViewCadAtendente view;

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public AtendenteDAO(EntityManagerFactory emf, Atendente cliente, ViewCadAtendente view) {
        this.emf = emf;
        this.model = cliente;
        this.view = view;

        this.view.addCadastraBotaoListener(new cadastraListener());
        this.view.addAlteraBotaoListener(new actionAltera());
        this.view.addConcluidoBotaoListener(new actionConcluido());
        this.view.addExcluiBotaoListener(new actionExclui());
        atualizaTabela();
    }
    
    public AtendenteDAO(EntityManagerFactory emf){
        this.emf = emf;
    }

    public AtendenteDAO(EntityManagerFactory emf, Atendente cliente) {
        this.emf = emf;
        this.model = cliente;
    }

    class cadastraListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            model.setCep(Integer.parseInt(view.getCep().getText()));
            model.setComplementoEnd(view.getComplemento().getText());
            model.setNome(view.getNome().getText());
            model.setCpf(view.getCpf().getText());
            model.setSalario(Double.parseDouble(view.getSalario().getText()));
            model.setRua(view.getRua().getText());
            model.setSenha(view.getSenha().getText());

            cadastraAtendente();
            atualizaTabela();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        }

    }

    public void atualizaTabela() {

        view.getModelo().setNumRows(0);
        for (Atendente c : getAtendentes()) {
            view.getModelo().addRow(new Object[]{c.getCpf(), c.getNome(), c.getRua(), c.getCep(), c.getComplementoEnd(), c.getSenha(), c.getSalario()}
            );
        }

    }

    class actionExclui implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int linhaSelecionada = -1;
            linhaSelecionada = view.getTabela().getSelectedRow();
            if (linhaSelecionada >= 0) {
                String cpf = (String) view.getTabela().getValueAt(linhaSelecionada, 0);
                exclui(cpf);
                atualizaTabela();
            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }

        }

    }

    class actionAltera implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int linhaSelecionada = -1;
            linhaSelecionada = view.getTabela().getSelectedRow();
            if (linhaSelecionada >= 0) {
                String cpf = (String) view.getTabela().getValueAt(linhaSelecionada, 0);
                model = busca(cpf);
                view.getNome().setText(model.getNome());
                view.getCpf().setText(String.valueOf(model.getCpf()));
                view.getRua().setText(model.getRua());
                view.getCep().setText(String.valueOf(model.getCep()));
                view.getComplemento().setText(model.getComplementoEnd());
                view.getSenha().setText(model.getSenha());
                view.getSalario().setText(String.valueOf(model.getSalario()));

            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }

        }

    }

    class actionConcluido implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            model.setCep(Integer.parseInt(view.getCep().getText()));
            model.setComplementoEnd(view.getComplemento().getText());
            model.setNome(view.getNome().getText());
            model.setCpf(view.getCpf().getText());
            model.setSalario(Double.parseDouble(view.getSalario().getText()));
            model.setRua(view.getRua().getText());
            model.setSenha(view.getSenha().getText());
            atualiza();
           atualizaTabela();
           view.limpaCampos();
        }

    }

    public void exclui(String id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Atendente quarto = em.getReference(Atendente.class, id);
            em.remove(quarto);
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

    public Atendente busca(String id) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery("select * from atendente c where c.CPF = '" + id + "'", Atendente.class);
            return (Atendente) q.getSingleResult();
        } finally {
            em.close();
        }
    }
        public Atendente buscaPorNome(String nome) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery("select * from atendente c where c.nome = '" + nome + "'", Atendente.class);
            return (Atendente) q.getSingleResult();
        } finally {
            em.close();
        }
    }

    public List<Atendente> getAtendentes() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery("select * from atendente", Atendente.class);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public void cadastraAtendente() {
        if (model.getReservaCollection() == null) {
            model.setReservaCollection(new ArrayList<>());
        }
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
