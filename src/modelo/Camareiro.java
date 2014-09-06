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
@Table(name = "camareiro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camareiro.findAll", query = "SELECT c FROM Camareiro c"),
    @NamedQuery(name = "Camareiro.findByCpf", query = "SELECT c FROM Camareiro c WHERE c.cpf = :cpf"),
    @NamedQuery(name = "Camareiro.findByNome", query = "SELECT c FROM Camareiro c WHERE c.nome = :nome"),
    @NamedQuery(name = "Camareiro.findByRua", query = "SELECT c FROM Camareiro c WHERE c.rua = :rua"),
    @NamedQuery(name = "Camareiro.findByCep", query = "SELECT c FROM Camareiro c WHERE c.cep = :cep"),
    @NamedQuery(name = "Camareiro.findByComplementoEnd", query = "SELECT c FROM Camareiro c WHERE c.complementoEnd = :complementoEnd"),
    @NamedQuery(name = "Camareiro.findBySalario", query = "SELECT c FROM Camareiro c WHERE c.salario = :salario"),
    @NamedQuery(name = "Camareiro.findByTurno", query = "SELECT c FROM Camareiro c WHERE c.turno = :turno")})
public class Camareiro implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cpf")
    private Collection<TelefoneCamareiro> telefoneCamareiroCollection;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salario")
    private Double salario;
    @Column(name = "turno")
    private String turno;

    public Camareiro() {
    }

    public Camareiro(String cpf) {
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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
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
        if (!(object instanceof Camareiro)) {
            return false;
        }
        Camareiro other = (Camareiro) object;
        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Camareiro[ cpf=" + cpf + " ]";
    }

    @XmlTransient
    public Collection<TelefoneCamareiro> getTelefoneCamareiroCollection() {
        return telefoneCamareiroCollection;
    }

    public void setTelefoneCamareiroCollection(Collection<TelefoneCamareiro> telefoneCamareiroCollection) {
        this.telefoneCamareiroCollection = telefoneCamareiroCollection;
    }
    
}
