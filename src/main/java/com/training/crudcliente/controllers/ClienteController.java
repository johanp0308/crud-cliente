package com.training.crudcliente.controllers;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.training.crudcliente.business.ClienteService;
import com.training.crudcliente.persistences.documents.ClienteDocument;

@Controller
@SessionAttributes("cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @RequestMapping(value = "/listar",method = RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo","Listado de clientes");
        model.addAttribute("clientes",clienteService.finAll());
        return "listar";
    }

    @RequestMapping(value="/form")
    public String crear(Map<String, Object> model){

        ClienteDocument cliente = new ClienteDocument();
        model.put("cliente",cliente);
        model.put("titulo", "Formulario de Cliente");
        return "form";

    }

    @RequestMapping(value="/form/{id}")
    public String editar(@PathVariable(value="id") String id, Map<String, Object> model){
        ClienteDocument cliente = null;

        if(id!=null){
            cliente = clienteService.findOne(id);
        }else{
            return "redirect:/listar";
        }
        model.put("cliente", cliente);
        model.put("titulo", "Editar Cliente");
        return "form";
    }

    @RequestMapping(value="/form", method=RequestMethod.POST)
    public String guardar(ClienteDocument cliente, Model model, SessionStatus status){
        clienteService.save(cliente);
        status.setComplete();
        return "redirect:listar";
    }

    @RequestMapping(value="/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") String id){
        if(id!=null){
            clienteService.delete(id);      
        }
        return "redirect:/listar";
    }
}
