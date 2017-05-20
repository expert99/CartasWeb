/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.CartasDAO;
import Entidade.Cartas;
import Report.Relatorio;
import com.sun.xml.registry.common.ConnectionFactoryFactory;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.xml.registry.ConnectionFactory;
import org.primefaces.context.RequestContext;


/**
 *
 * @author Ricardo
 */
@Named(value = "cartasBean")
@SessionScoped
@ManagedBean
public class CartasBean implements Serializable {

    /**
     * Creates a new instance of CartasBean
     */
    private Cartas cartas = new Cartas();
    private CartasDAO cartasdao = new CartasDAO();
    private boolean sedex;
    private boolean registrada;
    private String usuario, senha;
    
    
    
    public CartasBean() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String login(){
            
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean login = false;
        
        if(senha.equals("cartas") && usuario.equals("prefeitura") && senha != null && usuario !=null){
            
            login = true;
            
            this.setUsuario(null);
            this.setSenha(null);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro de Login", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("login", login);
            return "bemvindo";
            
            
        }else{
            
            login = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro de Login", "");
            return null;
        }
            
            
    }
        
    
    public boolean isSedex() {
        return sedex;
    }

    public void setSedex(boolean sedex) {
        this.sedex = sedex;
        if(this.sedex == true){
            cartas.setCarta("Sedex");
        }
    }

    public boolean isRegistrada() {
        return registrada;
    }

    public void setRegistrada(boolean registrada) {
        this.registrada = registrada;
        if(this.registrada == true){
            cartas.setCarta("Registrada");
        }
    }
    
    public String atualizar(){
        
        cartasdao.update(cartas);
        cartas = new Cartas();
        return "tabela";
      }
    
    public String carregar(Cartas c){
        
        cartas = c;
        return "alterarrastreio";
    }
    
    
    public String addCarta(){
        
        cartas.setCarta("Simples");
        cartasdao.getData(cartas);
        cartas = new Cartas();
        return "simples";
        
    }
    
    public String addCartaComposta(){
        
        cartasdao.getData(cartas);
        cartas = new Cartas();
        return "registrada-sedex";
    }
    
    public Cartas getCartas() {
        return cartas;
    }

    public void setCartas(Cartas cartas) {
        this.cartas = cartas;
    }

    public CartasDAO getCartasdao() {
        return cartasdao;
    }

    public void setCartasdao(CartasDAO cartasdao) {
        this.cartasdao = cartasdao;
    }
    
    public String pegarID(){
        
        cartas.getId();
        return "procurar";
    }
    
    
    //Relatorio
    
    public void gerarRelatorio(){
        
        Relatorio r = new Relatorio();
        r.getRelatorio();
    }
    
    
}
