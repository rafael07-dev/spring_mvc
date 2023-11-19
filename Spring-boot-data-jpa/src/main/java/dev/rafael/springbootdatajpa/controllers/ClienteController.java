package dev.rafael.springbootdatajpa.controllers;

import dev.rafael.springbootdatajpa.models.Cliente;
import dev.rafael.springbootdatajpa.paginator.PageRender;
import dev.rafael.springbootdatajpa.service.IClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@SessionAttributes("cliente")
public class ClienteController {
    @Value("${rutaArchivos}")
    private String rutaCarga;
    //@Qualifier
    private final IClienteService iClienteService;

    public ClienteController(IClienteService iClienteService) {
        this.iClienteService = iClienteService;
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable("id") Long id, Model model, RedirectAttributes flash){
        Cliente cliente = iClienteService.findOne(id);

        if(cliente == null){
            flash.addFlashAttribute ("error", "El cliente no existe en la base de datos");
            return "redirect:/listar";
        }

        model.addAttribute("titulo", "Detalle del cliente: " + cliente.getNombre());

        model.addAttribute("cliente", cliente);

        return "ver";
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listarClientes(@RequestParam(name = "page", defaultValue = "0") int page, Model model){

        Pageable pageable = PageRequest.of(page, 5);

        Page<Cliente> clientes = iClienteService.findAll(pageable);

        PageRender<Cliente> pageRender = new PageRender<>("/listar", clientes);

        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clientes);
        model.addAttribute("page", pageRender);
        return "listar";
    }
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String crear(Model model, RedirectAttributes flash){
        Cliente cliente = new Cliente();
        model.addAttribute("titulo", "Formulario de clientes");
        model.addAttribute("cliente", cliente);
        flash.addFlashAttribute("succes", "Cliente creado con exito");
        return "form";
    }

    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash){
        Cliente cliente = new Cliente();

        if(id > 0){
            cliente = iClienteService.findOne(id);
            if (cliente == null){
                flash.addFlashAttribute("error", "El id del cliente no existe en la BBDD");
                return "redirect:/listar";
            }
        }else {
            flash.addFlashAttribute("error", "El id del cliente no puede ser cero");
            return "redirect:/listar";
        }

        model.addAttribute("titulo", "Editar cliente");
        model.addAttribute("cliente", cliente);

        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Cliente cliente, Model model, @RequestParam("file") MultipartFile foto, RedirectAttributes flash,
                          BindingResult result, SessionStatus sessionStatus)
    {

        if(result.hasErrors()){
            model.addAttribute("titulo", "Fomulario de clientes");
            return "form";
        }
        //verificamos el campo viene vacio desde el front
        if(foto.isEmpty()){
            flash.addFlashAttribute("mensaje", "Es necesario cargar una foto");
            return "redirect:/form";
        }

        try{
            byte[] bytes = foto.getBytes();
            //guardamos la ruta absoluta del archivo con el nombre
            Path rutaName = Paths.get(rutaCarga+"//" + foto.getOriginalFilename());

            Files.write(rutaName, bytes);

            flash.addFlashAttribute("mensaje", "Archivo cargado con exito: " + foto.getOriginalFilename());
            cliente.setFoto(foto.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String mensajeFlash = (cliente.getId() != null) ? "Cliente editado con exito": "Cliente creado con exito";
        iClienteService.save(cliente);
        sessionStatus.setComplete();
        flash.addFlashAttribute("success", mensajeFlash);
        return "redirect:/listar";
    }
    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes flash)
    {
        if(id > 0){
            iClienteService.delete(id);
            flash.addFlashAttribute("success", "Cliente eliminado con existo");
        }
        return "redirect:/listar";
    }
}
