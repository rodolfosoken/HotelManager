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
        this.view.addTabelaBotaoListener(new actionAltera());
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

    class actionAltera implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int linhaSelecionada = -1;
            linhaSelecionada = view.getjTable1().getSelectedRow();
            if (linhaSelecionada >= 0) {
                int numQuarto = (int) view.getjTable1().getValueAt(linhaSelecionada, 0);
                
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
