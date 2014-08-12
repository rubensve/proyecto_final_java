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
    
    
    public static void insertar(Nomina nomina){
begin();
getSession().save(nomina);
commit();
close();
}
public static void actualizar(Nomina nomina){
begin();
getSession().update(nomina);
commit();
close();
}
public static void borrar(Nomina nomina){
begin();
getSession().delete(nomina);
commit();
close();
}
public static ArrayList<Nomina> buscarTodos(){
begin();
Criteria c = getSession().createCriteria(Nomina.class);
ArrayList<Nomina> nom = (ArrayList<Nomina>) c.list();
commit();
close();
return nom;
}

public static Nomina buscarId(int id){
begin();
Query q = getSession().createQuery("FROM Nomina WHERE id_nomina = :id");
q.setInteger("id", id);
Nomina nomina = (Nomina) q.uniqueResult();
commit();
close();
return nomina;
}
    
}
