/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.CartasBean;
import Entidade.Cartas;
import Util.Util;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ricardo
 */
public class CartasDAO {
    
    
    private Session sessao;
    private Transaction trans;
    private List<Cartas> list = new ArrayList<>();
    
    //Tabela
    public List<Cartas> getList() {
            
            list = new ArrayList<Cartas>();
        
        try {
            
            sessao = Util.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            
            Query q = sessao.createQuery("from Cartas order by id desc");
            list = q.list();
            trans.commit();
            return list;
            
        } catch (Exception e) {
            
            return null;
        }
        
        
    }
    
    
    
    
    //Add usuário
    public void getData(Cartas c){
        
        try {
            sessao = Util.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            
            Criteria cri = sessao.createCriteria(Cartas.class);
            Cartas cartas = new Cartas();
            
            cartas.setCarta(c.getCarta());
            cartas.setCep(c.getCep());
            cartas.setCodigo(c.getCodigo());
            cartas.setCpf(c.getCpf());
            cartas.setData(c.getData());
            cartas.setDestinatario(c.getDestinatario());
            cartas.setId(c.getId());
            cartas.setNome(c.getNome());
            cartas.setRemetente(c.getRemetente());
            cartas.setSituação(c.getSituação());
            cartas.setDepartamento(c.getDepartamento());
            cartas.setPreco(c.getPreco());
            
            sessao.save(cartas);
            trans.commit();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sem conexão com o servidor");
        }
        sessao.close();
        
    }
    
    
    public void update(Cartas c){
        
        try {
            
            sessao = Util.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            
            sessao.update(c);
            trans.commit();
            sessao.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
}
