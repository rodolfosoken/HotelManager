/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicos;

import Controle.ClienteDAO;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Cliente;
import visao.PesquisaCliente;

/**
 *
 * @author Rodolfo
 */
public class ControlePesquisaCliente {

    private EntityManagerFactory emf = null;
    PesquisaCliente view;

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ControlePesquisaCliente(EntityManagerFactory emf, PesquisaCliente view) {
        this.emf = emf;
        this.view = view;
        this.view.setVisible(true);
        iniciaListeners();
    }
    
    private void iniciaListeners(){
        this.view.addNomeListener(new NomeListener());
        this.view.addTabelaListener(new TabelaListener());
    }

    private void atualizaTabela() {
        view.getModelo().setNumRows(0);
        ClienteDAO dao = new ClienteDAO(emf);
        for (Cliente c : dao.getClientes()) {
            view.getModelo().addRow(new Object[]{c.getCpf(), c.getNome(), c.getRua(), c.getCep(), c.getComplementoEnd(), c.getEmail()}
            );
        }
    }

    private void tabelaComCriterio(String nome) {
        view.getModelo().setNumRows(0);
        ClienteDAO dao = new ClienteDAO(emf);
        for (Cliente c : dao.getClientesPorNome(nome)) {
            view.getModelo().addRow(new Object[]{c.getCpf(), c.getNome(), c.getRua(), c.getCep(), c.getComplementoEnd(), c.getEmail()}
            );
        }
    }
    
    class TabelaListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
          int linhaSelecionada = -1;
            linhaSelecionada = view.getTabela().getSelectedRow();
            if (linhaSelecionada >= 0) {
                String cpf = (String) view.getTabela().getValueAt(linhaSelecionada, 0);
                view.setSelecionado(cpf);
                System.out.println(cpf);
                view.dispose();
                } 
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
        
    }

    class NomeListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) {
        }

        @Override
        public void keyPressed(KeyEvent ke) {

        }

        @Override
        public void keyReleased(KeyEvent ke) {
            if (view.getNome().getText() != null) {
                String descricao = view.getNome().getText();
                tabelaComCriterio(descricao);

            }

        }

    }

}
