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
import modelo.Acompanhante;
import modelo.Cliente;
import modelo.TelefoneCliente;
import visao.ViewAcompanhante;
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

        this.view.addCadastraBotaoListener(new cadastraListener());
        this.view.addAlteraBotaoListener(new actionAltera());
        this.view.addConcluidoBotaoListener(new actionConcluido());
        this.view.addExcluiBotaoListener(new actionExclui());
        this.view.addAcompanhanteListener(new actionAcompanhante());
        this.view.getConcluido().setEnabled(false);
        atualizaTabela();
    }

    class actionAcompanhante implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (recuperaClienteSelecionando()) {
                ViewAcompanhante viewAcompanhante = new ViewAcompanhante();
                Acompanhante acompanhante = new Acompanhante();
                AcompanhanteDAO dao = new AcompanhanteDAO(emf, acompanhante, model, viewAcompanhante);
            }
        }

    }

    public ClienteDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    class cadastraListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

             model.setTelefoneClienteCollection(new ArrayList<>());
            model.setCep(Integer.parseInt(view.getCep().getText()));
            model.setComplementoEnd(view.getComplemento().getText());
            model.setNome(view.getNome().getText());
            model.setCpf(view.getCpf().getText());
            model.setEmail(view.getEmail().getText());
            model.setRua(view.getRua().getText());
            if (!view.getTelefone().getText().equals("")) {
                model.getTelefoneClienteCollection().add(new TelefoneCliente(Integer.parseInt(view.getTelefone().getText()), model));
            }
            if (!view.getCelular().getText().equals("")) {
                model.getTelefoneClienteCollection().add(new TelefoneCliente(Integer.parseInt(view.getCelular().getText()), model));
            }
            if (!view.getComercial().getText().equals("")) {
                model.getTelefoneClienteCollection().add(new TelefoneCliente(Integer.parseInt(view.getComercial().getText()), model));
            }

            cadastraCliente();
            atualizaTabela();
            view.limpaCampos();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        }

    }

    public void atualizaTabela() {
        view.getModelo().setNumRows(0);
        for (Cliente c : getClientes()) {
            view.getModelo().addRow(new Object[]{c.getCpf(), c.getNome(), c.getRua(), c.getCep(), c.getComplementoEnd(), c.getEmail()}
            );
        }
    }

    class actionExclui implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int linhaSelecionada = -1;
            linhaSelecionada = view.getTabela().getSelectedRow();
            if (linhaSelecionada >= 0) {
                String cpf = (String) view.getTabela().getValueAt(linhaSelecionada, 0);
                exclui(cpf);
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
                String cpf = (String) view.getTabela().getValueAt(linhaSelecionada, 0);
                model = busca(cpf);
                view.getNome().setText(model.getNome());
                view.getCpf().setText(String.valueOf(model.getCpf()));
                view.getRua().setText(model.getRua());
                view.getCep().setText(String.valueOf(model.getCep()));
                view.getComplemento().setText(model.getComplementoEnd());
                view.getEmail().setText(model.getEmail());
                int i = 0;
                for (TelefoneCliente c : model.getTelefoneClienteCollection()) {
                    switch (i) {
                        case 0:
                            view.getTelefone().setText(c.getTelefone().toString());
                            break;

                        case 1:
                            view.getCelular().setText(c.getTelefone().toString());
                            break;

                        case 2:
                            view.getComercial().setText(c.getTelefone().toString());
                            break;
                    }
                    i++;
                }

            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }

        }

    }

    class actionConcluido implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            model.setCep(Integer.parseInt(view.getCep().getText()));
            model.setComplementoEnd(view.getComplemento().getText());
            model.setNome(view.getNome().getText());
            model.setCpf(view.getCpf().getText());
            model.setEmail(view.getEmail().getText());
            model.setRua(view.getRua().getText());
            if (!view.getTelefone().getText().equals("")) {
                model.setTelefoneClienteCollection(new ArrayList<>());
                model.getTelefoneClienteCollection().add(new TelefoneCliente(Integer.parseInt(view.getTelefone().getText()), model));
            }
            if (!view.getCelular().getText().equals("")) {
                model.getTelefoneClienteCollection().add(new TelefoneCliente(Integer.parseInt(view.getCelular().getText()), model));
            }
            if (!view.getComercial().getText().equals("")) {
                model.getTelefoneClienteCollection().add(new TelefoneCliente(Integer.parseInt(view.getComercial().getText()), model));
            }
            atualiza();
            atualizaTabela();
            view.limpaCampos();
            view.getConcluido().setEnabled(false);
        }

    }

    public void exclui(String id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Cliente quarto = em.getReference(Cliente.class, id);
            em.remove(quarto);
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

    public Cliente busca(String id) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery("select * from cliente c where c.CPF = '" + id + "';", Cliente.class);
            return (Cliente) q.getSingleResult();
        } finally {
            em.close();
        }
    }

    public List<Cliente> getClientes() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery("select * from cliente;", Cliente.class);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Cliente> getClientesPorNome(String nome) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery("select * from cliente c where c.nome LIKE '%" + nome + "%';", Cliente.class);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public void cadastraCliente() {
        if (model.getAcompanhanteCollection() == null) {
            model.setAcompanhanteCollection(new ArrayList<>());
        }
        if (model.getReservaCollection() == null) {
            model.setReservaCollection(new ArrayList<>());
        }
        if (model.getTelefoneClienteCollection() == null) {
            model.setTelefoneClienteCollection(new ArrayList<>());
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

    public boolean existe(String cpf) {
        boolean existe = false;
        EntityManager em = getEntityManager();
        try {
            if (em.find(Cliente.class, cpf) != null) {
                existe = true;
            }
        } finally {
            em.close();
        }

        return existe;

    }

    public boolean recuperaClienteSelecionando() {
        boolean selecionado = false;
        view.getConcluido().setEnabled(true);
        int linhaSelecionada = -1;
        linhaSelecionada = view.getTabela().getSelectedRow();
        if (linhaSelecionada >= 0) {
            String cpf = (String) view.getTabela().getValueAt(linhaSelecionada, 0);
            model = busca(cpf);
            view.getNome().setText(model.getNome());
            view.getCpf().setText(String.valueOf(model.getCpf()));
            view.getRua().setText(model.getRua());
            view.getCep().setText(String.valueOf(model.getCep()));
            view.getComplemento().setText(model.getComplementoEnd());
            view.getEmail().setText(model.getEmail());
            int i = 0;
            for (TelefoneCliente c : model.getTelefoneClienteCollection()) {
                switch (i) {
                    case 0:
                        view.getTelefone().setText(c.getTelefone().toString());
                        break;

                    case 1:
                        view.getCelular().setText(c.getTelefone().toString());
                        break;

                    case 2:
                        view.getComercial().setText(c.getTelefone().toString());
                        break;
                }
                i++;
            }

            selecionado = true;

        } else {
            JOptionPane.showMessageDialog(null, "É necesário selecionar um cliente já cadastrado.");
            selecionado = false;
        }

        return selecionado;
    }

}
