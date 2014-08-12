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
public class DAONominaImpl extends DAO {
    
    public void agregarNomina(Nomina empleado) {
    begin();
    getSession().save(empleado);
    commit();
    close();
    }
    
    public ArrayList<Nomina> buscarTodasNominas() {
        begin();
        Criteria c=getSession().createCriteria(Nomina.class);
        ArrayList<Nomina> empleados = (ArrayList<Nomina>)c.list();
        commit();
        close();
        return empleados; 
    }
    
    public void borrarNomina(Nomina n){
            begin();
             getSession().delete(n);
            commit();
            close();
    }   
    
  public Nomina buscarPorId(int id_nomina){
     begin();
     Query q = getSession().createQuery("from Nomina where id_nomina = :id_nomina");
        q.setInteger("id_nomina",id_nomina);
        Nomina n = (Nomina)q.uniqueResult();
        commit();
        close();
        return n;  
  } 
}
