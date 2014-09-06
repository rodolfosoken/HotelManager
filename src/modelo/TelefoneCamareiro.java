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
@Table(name = "telefone_camareiro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelefoneCamareiro.findAll", query = "SELECT t FROM TelefoneCamareiro t"),
    @NamedQuery(name = "TelefoneCamareiro.findByTelefone", query = "SELECT t FROM TelefoneCamareiro t WHERE t.telefone = :telefone")})
public class TelefoneCamareiro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "telefone")
    private Integer telefone;
    @JoinColumn(name = "CPF", referencedColumnName = "CPF")
    @ManyToOne(optional = false)
    private Camareiro cpf;

    public TelefoneCamareiro() {
    }

    public TelefoneCamareiro(Integer telefone) {
        this.telefone = telefone;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Camareiro getCpf() {
        return cpf;
    }

    public void setCpf(Camareiro cpf) {
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
        if (!(object instanceof TelefoneCamareiro)) {
            return false;
        }
        TelefoneCamareiro other = (TelefoneCamareiro) object;
        if ((this.telefone == null && other.telefone != null) || (this.telefone != null && !this.telefone.equals(other.telefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TelefoneCamareiro[ telefone=" + telefone + " ]";
    }
    
}
