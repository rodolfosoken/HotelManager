/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;
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

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ReservaDAO(EntityManagerFactory emf, Reserva model, ViewReserva view) {
        this.emf = emf;
        this.model = model;
        this.view = view;
        
        this.view.addCadastraBotaoListener(new cadastraListener());
        this.view.addTabelaBotaoListener(new tabelaQuarto());
        this.view.addAlteraBotaoListener(new actionAltera());
        this.view.addConcluidoBotaoListener(new actionConcluido());
        this.view.addExcluiBotaoListener(new actionExclui());
        this.view.atualiza();
    }
    
    
    

    public ReservaDAO(EntityManagerFactory emf, Reserva model, ViewReserva view, JanelaPrincipalDAO win) {
        this.emf = emf;
        this.model = model;
        this.view = view;
        this.main = win;

        view.addNovoListener(new actBtNovo());

    }

    class actBtNovo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            main.clienteWindow();
        }

    }
    
       class tabelaQuarto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            view.getModelo().setNumRows(0);
            for (Reserva r :getReservas()) {
                //view.getModelo().addRow(new Object[]{r.get(), q.getCategoria()});
            }
        }

    }
    
    class actionExclui implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            int linhaSelecionada = -1;
            linhaSelecionada = view.getTabela().getSelectedRow();
            if (linhaSelecionada >= 0) {
                int num = (int) view.getTabela().getValueAt(linhaSelecionada, 0);
                exclui(num);
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
            linhaSelecionada = view.getTabela().getSelectedRow();
            if (linhaSelecionada >= 0) {
                int numQuarto = (int) view.getTabela().getValueAt(linhaSelecionada, 0);
                model = busca(numQuarto);
               // view.getNumero().setText(String.valueOf(model.getNumQuarto()));
                //view.getCategoria().setText(model.getCategoria());
            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }

        }

    }

    class cadastraListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
           // model.setNumQuarto(Integer.parseInt(view.getNumero().getText()));
           //model.setCategoria(view.getCategoria().getText());
            cadastraReserva();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        }

    }
    
    class actionConcluido implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
           // model.setCategoria(view.getCategoria().getText());
           // model.setNumQuarto(Integer.parseInt(view.getNumero().getText()));
            atualiza();
            view.atualiza();
        }
        
    }
    
    
    public void exclui(int id){
        EntityManager em = getEntityManager();
        try{
        em.getTransaction().begin();
        Reserva quarto = em.getReference(Reserva.class, id);
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
    
    
    public Reserva busca(int id){
        EntityManager em = getEntityManager();
        try{
            Query q = em.createNativeQuery("select * from reserva r where r.id_reserva = '"+ id +"'",Reserva.class);
        return (Reserva)q.getSingleResult();
        }finally{
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
