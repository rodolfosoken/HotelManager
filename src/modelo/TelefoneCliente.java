/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rodolfo
 */
@Entity
@Table(name = "telefone_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelefoneCliente.findAll", query = "SELECT t FROM TelefoneCliente t"),
    @NamedQuery(name = "TelefoneCliente.findByTelefone", query = "SELECT t FROM TelefoneCliente t WHERE t.telefone = :telefone")})
public class TelefoneCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "telefone")
    private Integer telefone;
    @JoinColumn(name = "CPF", referencedColumnName = "CPF")
    @ManyToOne(optional = false)
    private Cliente cpf;

    public TelefoneCliente() {
    }

    public TelefoneCliente(Integer telefone) {
        this.telefone = telefone;
    }
    
        public TelefoneCliente(Integer telefone, Cliente cpf) {
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Cliente getCpf() {
        return cpf;
    }

    public void setCpf(Cliente cpf) {
        this.cpf = cpf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telefone != null ? telefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefoneCliente)) {
            return false;
        }
        TelefoneCliente other = (TelefoneCliente) object;
        if ((this.telefone == null && other.telefone != null) || (this.telefone != null && !this.telefone.equals(other.telefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TelefoneCliente[ telefone=" + telefone + " ]";
    }
    
}
