/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ruben.controller;

import com.ruben.model.Cuenta;
import com.ruben.model.DAOCuentaImpl;
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

/**
 *
 * @author rubens
 */
@Controller
@RequestMapping("/")

public class ControladorCuenta {
@RequestMapping (value = "/cuenta/{total_venta}/{id_usuario}", method = RequestMethod.GET, headers = {"Accept=text/html"})
public @ResponseBody String insertar(@PathVariable float total_venta, @PathVariable int id_usuario){
try {
DAOCuentaImpl.insertar(new Cuenta(total_venta, new Usuario(id_usuario)));
return "Cuenta insertada correctamente";
} catch (Exception e) {
return "El usuario no existe";
}
}

@RequestMapping (value = "/cuenta/{id_cuenta}/{total_venta}/{id_usuario}", method = RequestMethod.PUT, headers = {"Accept=text/html"})
public @ResponseBody String actualizar(@PathVariable int id_cuenta, @PathVariable float total_venta, @PathVariable int id_usuario){
try {
DAOCuentaImpl.actualizar(new Cuenta(id_cuenta,total_venta, new Usuario(id_usuario)));
return "Cuenta actualizada correctamente";
} catch (Exception e) {
return "Error al actualizar la cuenta";
}
}
@RequestMapping (value = "/cuenta/{id}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
public @ResponseBody String eliminar(@PathVariable int id_cuenta){
try {
DAOCuentaImpl.borrar(new Cuenta(id_cuenta));
return "La cuenta con id" + id_cuenta + "se ha eliminado";
} catch (Exception e) {
return "Error al borrar la cuenta buscada";
}
}
@RequestMapping (value = "/cuenta", method = RequestMethod.GET, headers = {"Accept=Application/json"})
public @ResponseBody String buscarTodos () throws IOException{
ObjectMapper mapper1 = new ObjectMapper();
return mapper1.writeValueAsString(DAOCuentaImpl.buscarTodos());
}
@RequestMapping (value = "/cuenta/{id}", method = RequestMethod.GET, headers = {"Accept=text/html"})
public @ResponseBody String buscarPorId (@PathVariable int id){
return DAOCuentaImpl.buscarId(id).toString();
}
        
}
