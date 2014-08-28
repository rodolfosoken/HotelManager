/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rodolfo
 */
@Entity
@Table(name = "acompanhante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acompanhante.findAll", query = "SELECT a FROM Acompanhante a"),
    @NamedQuery(name = "Acompanhante.findByCpfCliente", query = "SELECT a FROM Acompanhante a WHERE a.acompanhantePK.cpfCliente = :cpfCliente"),
    @NamedQuery(name = "Acompanhante.findByDtNascimento", query = "SELECT a FROM Acompanhante a WHERE a.dtNascimento = :dtNascimento"),
    @NamedQuery(name = "Acompanhante.findByNome", query = "SELECT a FROM Acompanhante a WHERE a.acompanhantePK.nome = :nome")})
public class Acompanhante implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AcompanhantePK acompanhantePK;
    @Column(name = "dt_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;
    @JoinColumn(name = "cpf_cliente", referencedColumnName = "CPF", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;

    public Acompanhante() {
    }

    public Acompanhante(AcompanhantePK acompanhantePK) {
        this.acompanhantePK = acompanhantePK;
    }

    public Acompanhante(String cpfCliente, String nome) {
        this.acompanhantePK = new AcompanhantePK(cpfCliente, nome);
    }

    public AcompanhantePK getAcompanhantePK() {
        return acompanhantePK;
    }

    public void setAcompanhantePK(AcompanhantePK acompanhantePK) {
        this.acompanhantePK = acompanhantePK;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acompanhantePK != null ? acompanhantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acompanhante)) {
            return false;
        }
        Acompanhante other = (Acompanhante) object;
        if ((this.acompanhantePK == null && other.acompanhantePK != null) || (this.acompanhantePK != null && !this.acompanhantePK.equals(other.acompanhantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Acompanhante[ acompanhantePK=" + acompanhantePK + " ]";
    }
    
}
