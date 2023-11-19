package dev.rafael.springbootdatajpa.controllers;

import dev.rafael.springbootdatajpa.models.Cliente;
import dev.rafael.springbootdatajpa.models.Factura;
import dev.rafael.springbootdatajpa.models.ItemFactura;
import dev.rafael.springbootdatajpa.models.Producto;
import dev.rafael.springbootdatajpa.service.IClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/factura")
@SessionAttributes("factura")
public class FacturaController {
    IClienteService clienteService;

    public FacturaController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/form/{clienteId}")
    public String crear(@PathVariable("clienteId") Long clienteId, Model model,
                        RedirectAttributes flash, SessionStatus sessionStatus){
        Cliente cliente = clienteService.findOne(clienteId);

        if(cliente == null){
            flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
            return "redirect:/listar";
        }

        Factura factura = new Factura();

        factura.setCliente(cliente);

        model.addAttribute("factura", factura);
        model.addAttribute("titulo", "Crear factura");
        sessionStatus.setComplete();
        return "factura/form";
    }

    @GetMapping(value = "/cargar-productos/{term}", produces = {"application/json"})
    public @ResponseBody List<Producto> cargarproducto(@PathVariable String term){
        return clienteService.findByName(term);
    }

    @PostMapping("/form")
    public String saveFactura(Factura factura,
                              @RequestParam(name = "item_id[]", required = false) Long[] itemId,
                              @RequestParam(name = "cantidad[]", required = false) Integer[] cantidad,
                              RedirectAttributes flash, SessionStatus sessionStatus){
        for (int i = 0; i < itemId.length; i++) {
            Producto producto = clienteService.findProductById(itemId[i]);
            ItemFactura itemFactura = new ItemFactura();

            itemFactura.setCantidad(cantidad[i]);
            itemFactura.setProducto(producto);

            factura.addItem(itemFactura);
        }

        clienteService.saveFactura(factura);

        sessionStatus.setComplete();

        flash.addFlashAttribute("success", "Factura creada con exito");

        return "redirect:/ver/" + factura.getCliente().getId();
    }
}