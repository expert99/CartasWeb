/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "cartas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartas.findAll", query = "SELECT c FROM Cartas c")
    , @NamedQuery(name = "Cartas.findById", query = "SELECT c FROM Cartas c WHERE c.id = :id")
    , @NamedQuery(name = "Cartas.findByNome", query = "SELECT c FROM Cartas c WHERE c.nome = :nome")
    , @NamedQuery(name = "Cartas.findByCpf", query = "SELECT c FROM Cartas c WHERE c.cpf = :cpf")
    , @NamedQuery(name = "Cartas.findByDepartamento", query = "SELECT c FROM Cartas c WHERE c.departamento = :departamento")
    , @NamedQuery(name = "Cartas.findByDestinatario", query = "SELECT c FROM Cartas c WHERE c.destinatario = :destinatario")
    , @NamedQuery(name = "Cartas.findByCarta", query = "SELECT c FROM Cartas c WHERE c.carta = :carta")
    , @NamedQuery(name = "Cartas.findByCodigo", query = "SELECT c FROM Cartas c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Cartas.findByData", query = "SELECT c FROM Cartas c WHERE c.data = :data")
    , @NamedQuery(name = "Cartas.findBySitua\u00e7\u00e3o", query = "SELECT c FROM Cartas c WHERE c.situa\u00e7\u00e3o = :situa\u00e7\u00e3o")
    , @NamedQuery(name = "Cartas.findByCep", query = "SELECT c FROM Cartas c WHERE c.cep = :cep")
    , @NamedQuery(name = "Cartas.findByRemetente", query = "SELECT c FROM Cartas c WHERE c.remetente = :remetente")
    , @NamedQuery(name = "Cartas.findByPreco", query = "SELECT c FROM Cartas c WHERE c.preco = :preco")})
public class Cartas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private BigInteger cpf;
    @Size(max = 100)
    @Column(name = "departamento")
    private String departamento;
    @Size(max = 100)
    @Column(name = "destinatario")
    private String destinatario;
    @Size(max = 100)
    @Column(name = "carta")
    private String carta;
    @Size(max = 50)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Size(max = 20)
    @Column(name = "situa\u00e7\u00e3o")
    private String situação;
    @Column(name = "CEP")
    private BigInteger cep;
    @Size(max = 100)
    @Column(name = "remetente")
    private String remetente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private Float preco;

    public Cartas() {
    }

    public Cartas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigInteger getCpf() {
        return cpf;
    }

    public void setCpf(BigInteger cpf) {
        this.cpf = cpf;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getCarta() {
        return carta;
    }

    public void setCarta(String carta) {
        this.carta = carta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getSituação() {
        return situação;
    }

    public void setSituação(String situação) {
        this.situação = situação;
    }

    public BigInteger getCep() {
        return cep;
    }

    public void setCep(BigInteger cep) {
        this.cep = cep;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartas)) {
            return false;
        }
        Cartas other = (Cartas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.Cartas[ id=" + id + " ]";
    }
    
}
