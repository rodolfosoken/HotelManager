/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanager;

import Controle.AtendenteDAO;
import Controle.ClienteDAO;
import Controle.JanelaPrincipalDAO;
import Controle.QuartoDAO;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.Atendente;
import modelo.Cliente;
import modelo.Quarto;
import visao.JanelaPrincipal;
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
        //tenta ativar o nimbus como tema
        String laf = "";

        try {

            try {
                //TENTA USAR O NIMBUS  
                UIManager.LookAndFeelInfo[] info = UIManager.getInstalledLookAndFeels();

                if (laf.length() == 0) {
                    laf = "NimbusLookAndFeel";
                }

                for (UIManager.LookAndFeelInfo lookAndFeelInfo : info) {
                    if (lookAndFeelInfo.getClassName().contains(laf)) {
                        UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                        break;
                    }
                }

            } catch (Exception ex) {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }

        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }

//   ---------------------main ----------------
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HotelManagerPU");
        
        JanelaPrincipal janela = new JanelaPrincipal();
        JanelaPrincipalDAO control = new JanelaPrincipalDAO(emf, janela);

    }

}
