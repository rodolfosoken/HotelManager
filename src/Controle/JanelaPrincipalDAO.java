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

    public EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }

    public JanelaPrincipalDAO(EntityManagerFactory emf, JanelaPrincipal view) {
        this.emf = emf;
        this.view = view;
        this.view.addClienteListener(new actionBtCliente());
        this.view.addAtendenteListener(new actionBtAtendente());
        this.view.addQuartoListener(new actionBtQuarto());
        this.view.addReservaListener(new actionBtReserva());
        atualizaTabela();
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

    //Recupera informações para preencher a tabela    
    public void atualizaTabela() {
        view.getModelo().setNumRows(0);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for (Reserva r : getReservas()) {
            view.getModelo().addRow(new Object[]{r.getCpfCliente().getNome(), r.getNumQuarto().getNumQuarto(), df.format(r.getDtIn()),df.format(r.getDtOut()), r.getValor()});
 
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

    public void reservaWindow() {
        Reserva model = new Reserva();
        ViewReserva view = new ViewReserva();
        ReservaDAO control = new ReservaDAO(emf, model, view, this);
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
