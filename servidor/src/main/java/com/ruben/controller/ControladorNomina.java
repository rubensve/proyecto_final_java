/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ruben.controller;
import com.ruben.model.DAONominaImpl;
import com.ruben.model.Nomina;
import com.ruben.model.Usuario;
import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class ControladorNomina {
 
@RequestMapping (value = "/nomina/{sueldo}/{saldo}/{id_usuario}", method = RequestMethod.GET, headers = {"Accept=text/html"})
public @ResponseBody String insertar(@PathVariable float sueldo, @PathVariable float saldo, @PathVariable int id_usuario){
try {
DAONominaImpl.insertar(new Nomina(sueldo, saldo, new Usuario(id_usuario)));
return "Nomina insertada correctamente";
} catch (Exception e) {
return "El usuario de nomina no existe";
}
}

@RequestMapping (value = "/nomina/{id_nomina}/{sueldo}/{saldo}/{id_usuario}", method = RequestMethod.PUT, headers = {"Accept=text/html"})
public @ResponseBody String actualizar(@PathVariable int id_nomina, @PathVariable float sueldo, @PathVariable float saldo,
@PathVariable int id_usuario){
try {
DAONominaImpl.actualizar(new Nomina(id_nomina,sueldo, saldo, new Usuario(id_usuario)));
return "Nomina actualizada correctamente";
} catch (Exception e) {
return "Error al actualizar la nomina";
}
}
@RequestMapping (value = "/nomina/{id}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
public @ResponseBody String eliminar(@PathVariable int id_nomina){
try {
DAONominaImpl.borrar(new Nomina(id_nomina));
return "La nomina con id" + id_nomina + "se ha eliminado";
} catch (Exception e) {
return "Error al borrar la nomina buscada";
}
}
@RequestMapping (value = "/nomina", method = RequestMethod.GET, headers = {"Accept=Application/json"})
public @ResponseBody String buscarTodos () throws IOException{
ObjectMapper mapper1 = new ObjectMapper();
return mapper1.writeValueAsString(DAONominaImpl.buscarTodos());
}
@RequestMapping (value = "/nomina/{id}", method = RequestMethod.GET, headers = {"Accept=text/html"})
public @ResponseBody String buscarPorId (@PathVariable int id){
return DAONominaImpl.buscarId(id).toString();
}
    
    
    
}
