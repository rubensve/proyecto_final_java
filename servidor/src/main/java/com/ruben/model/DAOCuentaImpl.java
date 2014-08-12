/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ruben.model;

import static com.ruben.model.DAO.close;
import static com.ruben.model.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;

/**
 *
 * @author rubens
 */
public class DAOCuentaImpl extends DAO{
    
    public void agregarCuenta(Cuenta cuenta) {
    begin();
    getSession().save(cuenta);
    commit();
    close();
    }
    
    public ArrayList<Cuenta> buscarTodasCuentas() {
        begin();
        Criteria c=getSession().createCriteria(Cuenta.class);
        ArrayList<Cuenta> cuentas = (ArrayList<Cuenta>)c.list();
        commit();
        close();
        return cuentas; 
    }
    
    public void borrarCuenta(Cuenta c){
            begin();
             getSession().delete(c);
            commit();
            close();
    }   
    
  public Cuenta buscarPorId(int id_cuenta){
     begin();
     Query q = getSession().createQuery("from Cuenta where id_cuenta = :id_cuenta");
        q.setInteger("id_cuenta",id_cuenta);
        Cuenta c = (Cuenta)q.uniqueResult();
        commit();
        close();
        return c;  
  } 
    
}
