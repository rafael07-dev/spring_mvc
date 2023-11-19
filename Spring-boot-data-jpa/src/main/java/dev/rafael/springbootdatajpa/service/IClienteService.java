package dev.rafael.springbootdatajpa.service;

import dev.rafael.springbootdatajpa.models.Cliente;
import dev.rafael.springbootdatajpa.models.Factura;
import dev.rafael.springbootdatajpa.models.Producto;
import org.apache.juli.logging.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClienteService {

    List<Cliente> findAll();
    Page<Cliente> findAll(Pageable pageable);

    void save(Cliente cliente);

    Cliente findOne(Long id);

    void delete(Long id);

    List<Producto> findByName(String term);

    void saveFactura(Factura factura);

    Producto findProductById(Long id);
}
