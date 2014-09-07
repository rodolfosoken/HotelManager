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
@Table(name = "atendente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atendente.findAll", query = "SELECT a FROM Atendente a"),
    @NamedQuery(name = "Atendente.findByCpf", query = "SELECT a FROM Atendente a WHERE a.cpf = :cpf"),
    @NamedQuery(name = "Atendente.findByNome", query = "SELECT a FROM Atendente a WHERE a.nome = :nome"),
    @NamedQuery(name = "Atendente.findByRua", query = "SELECT a FROM Atendente a WHERE a.rua = :rua"),
    @NamedQuery(name = "Atendente.findByCep", query = "SELECT a FROM Atendente a WHERE a.cep = :cep"),
    @NamedQuery(name = "Atendente.findByComplementoEnd", query = "SELECT a FROM Atendente a WHERE a.complementoEnd = :complementoEnd"),
    @NamedQuery(name = "Atendente.findBySenha", query = "SELECT a FROM Atendente a WHERE a.senha = :senha"),
    @NamedQuery(name = "Atendente.findBySalario", query = "SELECT a FROM Atendente a WHERE a.salario = :salario")})
public class Atendente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "nome")
    private String nome;
    @Column(name = "rua")
    private String rua;
    @Column(name = "cep")
    private Integer cep;
    @Column(name = "complemento_end")
    private String complementoEnd;
    @Column(name = "senha")
    private String senha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salario")
    private Double salario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cpf")
    private Collection<TelefoneAtendente> telefoneAtendenteCollection;
    @OneToMany(mappedBy = "cpfAtend")
    private Collection<Reserva> reservaCollection;

    public Atendente() {
    }

    public Atendente(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getComplementoEnd() {
        return complementoEnd;
    }

    public void setComplementoEnd(String complementoEnd) {
        this.complementoEnd = complementoEnd;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @XmlTransient
    public Collection<TelefoneAtendente> getTelefoneAtendenteCollection() {
        return telefoneAtendenteCollection;
    }

    public void setTelefoneAtendenteCollection(Collection<TelefoneAtendente> telefoneAtendenteCollection) {
        this.telefoneAtendenteCollection = telefoneAtendenteCollection;
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
        hash += (cpf != null ? cpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atendente)) {
            return false;
        }
        Atendente other = (Atendente) object;
        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Atendente[ cpf=" + cpf + " ]";
    }
    
}
