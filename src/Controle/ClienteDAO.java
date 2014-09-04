/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import modelo.Cliente;
import visao.ViewCadCliente;

/**
 *
 * @author Rodolfo
 */
public class ClienteDAO {

    private EntityManagerFactory emf = null;
    private Cliente model = null;
    private ViewCadCliente view;

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ClienteDAO(EntityManagerFactory emf, Cliente cliente, ViewCadCliente view) {
        this.emf = emf;
        this.model = cliente;
        this.view = view;
        
        this.view.addCadastraBotaoLitener(new cadastraListener());
    }
    
    
    class cadastraListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            model.setCep(Integer.parseInt(view.getCep().getText()));
            model.setComplementoEnd(view.getComplemento().getText());
            model.setNome(view.getNome().getText());
            model.setCpf(view.getCpf().getText());
            model.setEmail(view.getEmail().getText());
            model.setRua(view.getRua().getText());
           
           cadastraCliente();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        }
        
    }
    

    public void cadastraCliente() {
        if (model.getAcompanhanteCollection() == null) {
            model.setAcompanhanteCollection(new ArrayList<>());
        }
        if (model.getReservaCollection() == null) {
            model.setReservaCollection(new ArrayList<>());
        }
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(model);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    
    public void removeCliente(){
        
    }
    

}
