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
    
    
public static void insertar(Cuenta cuenta){
begin();
getSession().save(cuenta);
commit();
close();
}
public static void actualizar(Cuenta cuenta){
begin();
getSession().update(cuenta);
commit();
close();
}
public static void borrar(Cuenta cuenta){
begin();
getSession().delete(cuenta);
commit();
close();
}
public static ArrayList<Cuenta> buscarTodos(){
begin();
Criteria c = getSession().createCriteria(Cuenta.class);
ArrayList<Cuenta> cue = (ArrayList<Cuenta>) c.list();
commit();
close();
return cue;
}

public static Cuenta buscarId(int id){
begin();
Query q = getSession().createQuery("FROM Cuenta WHERE id_cuenta = :id");
q.setInteger("id", id);
Cuenta cuenta = (Cuenta) q.uniqueResult();
commit();
close();
return cuenta;
}
    
}
