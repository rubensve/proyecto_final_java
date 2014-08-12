/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ruben.controller;

import com.ruben.model.DAOUsuarioImpl;
import com.ruben.model.Usuario;
import java.io.IOException;
import java.util.Date;
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

public class ControladorUsuario {

    @RequestMapping(value = "/usuario/{nombre}/{apellidop}/{apellidom}/{rol}", method = RequestMethod.GET , headers = {"Accept=text/html"})
public @ResponseBody String insertar(@PathVariable String nombre,@PathVariable String apellidop, 
        @PathVariable String apellidom, @PathVariable String rol ){
DAOUsuarioImpl.insertar(new Usuario(nombre,apellidop,apellidom,rol));
return "El usuario se ha ingresado correctamente";
}
 @RequestMapping(value = "/usuario", method = RequestMethod.GET, headers = {"Accept=Application/json"})
public @ResponseBody String buscarTodos() throws IOException{
ObjectMapper mapper = new ObjectMapper();
return mapper.writeValueAsString(DAOUsuarioImpl.buscarTodos());
}

@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET, headers = {"Accept=text/html"})
public @ResponseBody String buscarPorId(@PathVariable int id){
return DAOUsuarioImpl.buscarId(id).toString();
}

@RequestMapping(value = "/usuario/{nombre}/{apellidop}/{apellidom}/{rol}/{id}",method = RequestMethod.PUT, headers = {"Accept=text/html"})
public @ResponseBody String actualizar(@PathVariable String nombre,@PathVariable String apellidop, 
        @PathVariable String apellidom, @PathVariable String rol, @PathVariable int id ){
DAOUsuarioImpl.actualizar(new Usuario(id, nombre, apellidop, apellidom, rol));
return "EL usuario se ha actualizado correctamente";
}

@RequestMapping(value = "/usuario/{nombre}/{apellidop}/{apellidom}/{rol}/{id}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
public @ResponseBody String eliminar(@PathVariable String nombre,@PathVariable String apellidop, 
        @PathVariable String apellidom, @PathVariable String rol, @PathVariable int id ){
try {
DAOUsuarioImpl.borrar(new Usuario(id, nombre, apellidop, apellidom, rol));
return "Usuario eliminado correctamente";
} catch (Exception e) {
return "Usuario no encontrado";
}
    }
}

