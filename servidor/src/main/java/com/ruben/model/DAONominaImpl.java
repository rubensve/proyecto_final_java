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
Criteria c = getSession().createCriteria(Usuario.class);
ArrayList<Nomina> nom = (ArrayList<Nomina>) c.list();
commit();
close();
return nom;
}

public static Usuario buscarId(int id){
begin();
Query q = getSession().createQuery("FROM Usuario WHERE id_usuario = :id");
q.setInteger("id", id);
Usuario usuario = (Usuario) q.uniqueResult();
commit();
close();
return usuario;
}
    
}
