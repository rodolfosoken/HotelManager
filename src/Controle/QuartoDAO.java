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
import modelo.Quarto;
import visao.ViewCadQuarto;

/**
 *
 * @author Rodolfo
 */
public class QuartoDAO {

    private EntityManagerFactory emf = null;
    private Quarto model = null;
    private ViewCadQuarto view = null;

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public QuartoDAO(EntityManagerFactory emf, Quarto quarto, ViewCadQuarto view) {
        this.emf = emf;
        this.model = quarto;
        this.view = view;

        this.view.addCadastraBotaoListener(new cadastraListener());
        this.view.addTabelaBotaoListener(new tabelaQuarto());
        this.view.addAlteraBotaoListener(new actionAltera());
        this.view.addConcluidoBotaoListener(new actionConcluido());
        this.view.addExcluiBotaoListener(new actionExclui());
        this.view.atualiza();
    }

    class tabelaQuarto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            view.getModelo().setNumRows(0);
            for (Quarto q : getQuartos()) {
                view.getModelo().addRow(new Object[]{q.getNumQuarto(), q.getCategoria()});
            }
        }

    }
    
    class actionExclui implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            int linhaSelecionada = -1;
            linhaSelecionada = view.getjTable1().getSelectedRow();
            if (linhaSelecionada >= 0) {
                int numQuarto = (int) view.getjTable1().getValueAt(linhaSelecionada, 0);
                exclui(numQuarto);
                view.atualiza();
            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }
            
        }
        
    }

    class actionAltera implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int linhaSelecionada = -1;
            linhaSelecionada = view.getjTable1().getSelectedRow();
            if (linhaSelecionada >= 0) {
                int numQuarto = (int) view.getjTable1().getValueAt(linhaSelecionada, 0);
                model = busca(numQuarto);
                view.getNumero().setText(String.valueOf(model.getNumQuarto()));
                view.getCategoria().setText(model.getCategoria());
            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }

        }

    }

    class cadastraListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            model.setNumQuarto(Integer.parseInt(view.getNumero().getText()));
            model.setCategoria(view.getCategoria().getText());
            cadastraQuarto();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        }

    }
    
    class actionConcluido implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            model.setCategoria(view.getCategoria().getText());
            model.setNumQuarto(Integer.parseInt(view.getNumero().getText()));
            atualiza();
            view.atualiza();
        }
        
    }
    
    
    public void exclui(int id){
        EntityManager em = getEntityManager();
        try{
        em.getTransaction().begin();
        Quarto quarto = em.getReference(Quarto.class, id);
        em.remove(quarto);
        em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
    
    public void atualiza(){
        EntityManager em = getEntityManager();
        
        try{
            em.getTransaction().begin();
            em.merge(model);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        
    }
    
    
    public Quarto busca(int id){
        EntityManager em = getEntityManager();
        try{
            Query q = em.createNativeQuery("select * from quarto q where q.num_quarto = '"+ id +"'",Quarto.class);
        return (Quarto)q.getSingleResult();
        }finally{
            em.close();
        }
    }

    public List<Quarto> getQuartos() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery("select * from quarto", Quarto.class);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public void cadastraQuarto() {
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