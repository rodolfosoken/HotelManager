/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Atendente;
import modelo.Cliente;
import modelo.Quarto;
import modelo.Reserva;
import visao.JanelaPrincipal;
import visao.ViewCadAtendente;
import visao.ViewCadCliente;
import visao.ViewCadQuarto;
import visao.ViewReserva;

/**
 *
 * @author Rodolfo
 */
public class JanelaPrincipalDAO {

    private EntityManagerFactory emf = null;
    private JanelaPrincipal view = null;

    public JanelaPrincipalDAO(EntityManagerFactory emf, JanelaPrincipal view) {
        this.emf = emf;
        this.view = view;
        this.view.addClienteListener(new actionBtCliente());
        this.view.addAtendenteListener(new actionBtAtendente());
        this.view.addQuartoListener(new actionBtQuarto());
        this.view.addReservaListener(new actionBtReserva());
    }

    class actionBtCliente implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            clienteWindow();
        }

    }

    class actionBtAtendente implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            atendenteWindow();
        }

    }

    class actionBtQuarto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            quartoWindow();
        }

    }
    
        class actionBtReserva implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            reservaWindow();
        }

    }

    public void reservaWindow() {
    Reserva model = new Reserva();
    ViewReserva view = new ViewReserva();
    ReservaDAO control = new ReservaDAO(emf, model, view);
    }

    public void clienteWindow() {
        Cliente cliente = new Cliente();
        ViewCadCliente view = new ViewCadCliente();
        ClienteDAO control = new ClienteDAO(emf, cliente, view);
    }

    public void atendenteWindow() {
        Atendente atendente = new Atendente();
        ViewCadAtendente view = new ViewCadAtendente();
        AtendenteDAO control = new AtendenteDAO(emf, atendente, view);
    }

    public void quartoWindow() {
        Quarto model = new Quarto();
        ViewCadQuarto view = new ViewCadQuarto();
        QuartoDAO control = new QuartoDAO(emf, model, view);
    }

}
