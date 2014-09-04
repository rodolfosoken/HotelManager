/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ReservaDAO(EntityManagerFactory emf, Reserva model, ViewReserva view) {
        this.emf = emf;
        this.model = model;
        this.view = view;

//        this.view.addCadastraBotaoListener(new cadastraListener());
//        this.view.addTabelaBotaoListener(new tabelaQuarto());
//        this.view.addAlteraBotaoListener(new actionAltera());
//        this.view.addConcluidoBotaoListener(new actionConcluido());
//        this.view.addExcluiBotaoListener(new actionExclui());
//        this.view.atualiza();
    }
}
