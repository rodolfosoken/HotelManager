/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rodolfo
 */
@Entity
@Table(name = "quarto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quarto.findAll", query = "SELECT q FROM Quarto q"),
    @NamedQuery(name = "Quarto.findByNumQuarto", query = "SELECT q FROM Quarto q WHERE q.numQuarto = :numQuarto"),
    @NamedQuery(name = "Quarto.findByValor", query = "SELECT q FROM Quarto q WHERE q.valor = :valor")})
public class Quarto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "num_quarto")
    private Integer numQuarto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @ManyToMany(mappedBy = "quartoCollection")
    private Collection<Camareiro> camareiroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numQuarto")
    private Collection<Reserva> reservaCollection;

    public Quarto() {
    }

    public Quarto(Integer numQuarto) {
        this.numQuarto = numQuarto;
    }

    public Integer getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(Integer numQuarto) {
        this.numQuarto = numQuarto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @XmlTransient
    public Collection<Camareiro> getCamareiroCollection() {
        return camareiroCollection;
    }

    public void setCamareiroCollection(Collection<Camareiro> camareiroCollection) {
        this.camareiroCollection = camareiroCollection;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numQuarto != null ? numQuarto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quarto)) {
            return false;
        }
        Quarto other = (Quarto) object;
        if ((this.numQuarto == null && other.numQuarto != null) || (this.numQuarto != null && !this.numQuarto.equals(other.numQuarto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Quarto[ numQuarto=" + numQuarto + " ]";
    }
    
}
