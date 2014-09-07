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
import modelo.Produto;
import modelo.Reserva;
import visao.ViewProduto;

/**
 *
 * @author Rodolfo
 */
public class ProdutoDAO {

    private EntityManagerFactory emf = null;
    private Produto model = null;
    private ViewProduto view = null;
    private Reserva reserva = null;

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ProdutoDAO(EntityManagerFactory emf, Produto model, ViewProduto view) {
        this.emf = emf;
        this.view = view;
        this.model = model;

        this.view.addCadastraBotaoListener(new cadastraListener());
        this.view.addAlteraBotaoListener(new actionAltera());
        this.view.addConcluidoBotaoListener(new actionConcluido());
        this.view.addExcluiBotaoListener(new actionExclui());
        this.view.getConcluido().setEnabled(false);
        atualizaTabela();
    }
    
    public ProdutoDAO(EntityManagerFactory emf){
        this.emf = emf;
    }

    public void atualizaTabela() {
        view.getModelo().setNumRows(0);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for (Produto p : getProdutos()) {
            view.getModelo().addRow(new Object[]{p.getIdProd(),
                p.getDescricao(), p.getValor()}
            );
        }
    }

    class actionExclui implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int linhaSelecionada = -1;
            linhaSelecionada = view.getTabela().getSelectedRow();
            if (linhaSelecionada >= 0) {
                int idProduto = (int) view.getTabela().getValueAt(linhaSelecionada, 0);
                exclui(idProduto);
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
                int idProduto = (int) view.getTabela().getValueAt(linhaSelecionada, 0);
                model = busca(idProduto);
                view.getDescricao().setText(String.valueOf(model.getDescricao()));
                view.getValor().setText(model.getValor().toString());
            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }

        }

    }

    class cadastraListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            model.setDescricao(view.getDescricao().getText());
            model.setValor(Double.parseDouble(view.getValor().getText()));
            cadastraProduto();
            atualizaTabela();
            view.limpaCampos();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        }

    }

    class actionConcluido implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            model.setValor(Double.parseDouble(view.getValor().getText()));
            model.setDescricao(view.getDescricao().getText());
            atualiza();
            atualizaTabela();
            view.getConcluido().setEnabled(false);
            view.limpaCampos();
        }

    }

    public void exclui(int id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Produto produto = em.getReference(Produto.class, id);
            em.remove(produto);
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

    public Produto busca(int id) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery("select * from produto p where p.id_prod = '" + id + "';", Produto.class);
            return (Produto) q.getSingleResult();
        } finally {
            em.close();
        }
    }

    public List<Produto> getProdutos() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery("select * from produto;", Produto.class);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public void cadastraProduto() {
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
