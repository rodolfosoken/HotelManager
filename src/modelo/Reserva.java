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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r"),
    @NamedQuery(name = "Reserva.findByIdReserva", query = "SELECT r FROM Reserva r WHERE r.idReserva = :idReserva"),
    @NamedQuery(name = "Reserva.findByValor", query = "SELECT r FROM Reserva r WHERE r.valor = :valor"),
    @NamedQuery(name = "Reserva.findByDtOut", query = "SELECT r FROM Reserva r WHERE r.dtOut = :dtOut"),
    @NamedQuery(name = "Reserva.findByDtIn", query = "SELECT r FROM Reserva r WHERE r.dtIn = :dtIn")})
public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reserva")
    private Integer idReserva;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @Column(name = "dt_out")
    @Temporal(TemporalType.DATE)
    private Date dtOut;
    @Column(name = "dt_in")
    @Temporal(TemporalType.DATE)
    private Date dtIn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReserva")
    private Collection<Produto> produtoCollection;
    @JoinColumn(name = "cpf_cliente", referencedColumnName = "CPF")
    @ManyToOne(optional = false)
    private Cliente cpfCliente;
    @JoinColumn(name = "num_quarto", referencedColumnName = "num_quarto")
    @ManyToOne(optional = false)
    private Quarto numQuarto;
    @JoinColumn(name = "cpf_atend", referencedColumnName = "CPF")
    @ManyToOne
    private Atendente cpfAtend;
    @JoinColumn(name = "id_pgto", referencedColumnName = "id_pgto")
    @ManyToOne
    private Pagamento idPgto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReserva")
    private Collection<Servico> servicoCollection;

    public Reserva() {
    }

    public Reserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDtOut() {
        return dtOut;
    }

    public void setDtOut(Date dtOut) {
        this.dtOut = dtOut;
    }

    public Date getDtIn() {
        return dtIn;
    }

    public void setDtIn(Date dtIn) {
        this.dtIn = dtIn;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    public Cliente getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(Cliente cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public Quarto getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(Quarto numQuarto) {
        this.numQuarto = numQuarto;
    }

    public Atendente getCpfAtend() {
        return cpfAtend;
    }

    public void setCpfAtend(Atendente cpfAtend) {
        this.cpfAtend = cpfAtend;
    }

    public Pagamento getIdPgto() {
        return idPgto;
    }

    public void setIdPgto(Pagamento idPgto) {
        this.idPgto = idPgto;
    }

    @XmlTransient
    public Collection<Servico> getServicoCollection() {
        return servicoCollection;
    }

    public void setServicoCollection(Collection<Servico> servicoCollection) {
        this.servicoCollection = servicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReserva != null ? idReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.idReserva == null && other.idReserva != null) || (this.idReserva != null && !this.idReserva.equals(other.idReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Reserva[ idReserva=" + idReserva + " ]";
    }
    
}
