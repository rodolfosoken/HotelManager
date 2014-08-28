/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Rodolfo
 */
@Embeddable
public class AcompanhantePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cpf_cliente")
    private String cpfCliente;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;

    public AcompanhantePK() {
    }

    public AcompanhantePK(String cpfCliente, String nome) {
        this.cpfCliente = cpfCliente;
        this.nome = nome;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpfCliente != null ? cpfCliente.hashCode() : 0);
        hash += (nome != null ? nome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcompanhantePK)) {
            return false;
        }
        AcompanhantePK other = (AcompanhantePK) object;
        if ((this.cpfCliente == null && other.cpfCliente != null) || (this.cpfCliente != null && !this.cpfCliente.equals(other.cpfCliente))) {
            return false;
        }
        if ((this.nome == null && other.nome != null) || (this.nome != null && !this.nome.equals(other.nome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.AcompanhantePK[ cpfCliente=" + cpfCliente + ", nome=" + nome + " ]";
    }
    
}
