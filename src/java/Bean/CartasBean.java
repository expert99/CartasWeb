/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.CartasDAO;
import Entidade.Cartas;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo
 */
@Named(value = "cartasBean")
@SessionScoped
public class CartasBean implements Serializable {

    /**
     * Creates a new instance of CartasBean
     */
    private Cartas cartas = new Cartas();
    private CartasDAO cartasdao = new CartasDAO();
    private List<Cartas> list = new ArrayList<Cartas>();
    private boolean sedex;
    private boolean registrada;
    
    public CartasBean() {
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
    
   
    
    
}
