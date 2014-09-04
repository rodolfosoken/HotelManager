/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanager;

import Controle.AtendenteDAO;
import Controle.ClienteDAO;
import Controle.QuartoDAO;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Atendente;
import modelo.Cliente;
import modelo.Quarto;
import visao.ViewCadAtendente;
import visao.ViewCadCliente;
import visao.ViewCadQuarto;

/**
 *
 * @author Rodolfo
 */
public class HotelManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HotelManagerPU");

        Atendente atendente = new Atendente();
        ViewCadAtendente view = new ViewCadAtendente();
        AtendenteDAO control = new AtendenteDAO(emf, atendente, view);
        
        
//        Cliente cliente = new Cliente();
//        ViewCadCliente view = new ViewCadCliente();
//        ClienteDAO control = new ClienteDAO(emf, cliente, view);
        
//        Quarto model = new Quarto();
//        ViewCadQuarto view = new ViewCadQuarto();
//        QuartoDAO control = new QuartoDAO(emf, model, view);

    }

}
