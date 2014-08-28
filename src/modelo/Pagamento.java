/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rodolfo
 */
@Entity
@Table(name = "pagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagamento.findAll", query = "SELECT p FROM Pagamento p"),
    @NamedQuery(name = "Pagamento.findByIdPgto", query = "SELECT p FROM Pagamento p WHERE p.idPgto = :idPgto"),
    @NamedQuery(name = "Pagamento.findByForma", query = "SELECT p FROM Pagamento p WHERE p.forma = :forma"),
    @NamedQuery(name = "Pagamento.findByValor", query = "SELECT p FROM Pagamento p WHERE p.valor = :valor"),
    @NamedQuery(name = "Pagamento.findByStatus", query = "SELECT p FROM Pagamento p WHERE p.status = :status"),
    @NamedQuery(name = "Pagamento.findByDtPg", query = "SELECT p FROM Pagamento p WHERE p.dtPg = :dtPg")})
public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pgto")
    private Integer idPgto;
    @Column(name = "forma")
    private String forma;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @Column(name = "status")
    private String status;
    @Column(name = "dt_pg")
    @Temporal(TemporalType.DATE)
    private Date dtPg;
    @OneToMany(mappedBy = "idPgto")
    private Collection<Reserva> reservaCollection;

    public Pagamento() {
    }

    public Pagamento(Integer idPgto) {
        this.idPgto = idPgto;
    }

    public Integer getIdPgto() {
        return idPgto;
    }

    public void setIdPgto(Integer idPgto) {
        this.idPgto = idPgto;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDtPg() {
        return dtPg;
    }

    public void setDtPg(Date dtPg) {
        this.dtPg = dtPg;
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
        hash += (idPgto != null ? idPgto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagamento)) {
            return false;
        }
        Pagamento other = (Pagamento) object;
        if ((this.idPgto == null && other.idPgto != null) || (this.idPgto != null && !this.idPgto.equals(other.idPgto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Pagamento[ idPgto=" + idPgto + " ]";
    }
    
}
