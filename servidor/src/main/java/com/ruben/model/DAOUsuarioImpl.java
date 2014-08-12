/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ruben.model;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;

/**
 *
 * @author rubens
 */
public class DAOUsuarioImpl extends DAO {
   
    public static void insertar(Usuario usuario){
begin();
getSession().save(usuario);
commit();
close();
}
public static void actualizar(Usuario usuario){
begin();
getSession().update(usuario);
commit();
close();
}
public static void borrar(Usuario usuario){
begin();
getSession().delete(usuario);
commit();
close();
}
public static ArrayList<Usuario> buscarTodos(){
begin();
Criteria c = getSession().createCriteria(Usuario.class);
ArrayList<Usuario> usu = (ArrayList<Usuario>) c.list();
commit();
close();
return usu;
}
public static Usuario buscarId(int id){
begin();
Query q = getSession().createQuery("FROM usuario WHERE id_usuario = :id");
q.setInteger("id", id);
Usuario usu = (Usuario) q.uniqueResult();
commit();
close();
return usu;
}
    
}
