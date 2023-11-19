package dev.rafael.springbootdatajpa.service;

import dev.rafael.springbootdatajpa.dao.IClienteDao;
import dev.rafael.springbootdatajpa.dao.IFacturaDao;
import dev.rafael.springbootdatajpa.dao.IProductDao;
import dev.rafael.springbootdatajpa.models.Cliente;
import dev.rafael.springbootdatajpa.models.Factura;
import dev.rafael.springbootdatajpa.models.Producto;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService{

    private final IClienteDao iClienteDao;
    private final IProductDao iProductDao;
    private final IFacturaDao iFacturaDao;

    public ClienteServiceImpl(IClienteDao iClienteDao, IProductDao iProductDao, IFacturaDao iFacturaDao) {
        this.iClienteDao = iClienteDao;
        this.iProductDao = iProductDao;
        this.iFacturaDao = iFacturaDao;
    }

    @Override
    @Transactional
    public List<Cliente> findAll() {
        return (List<Cliente>) iClienteDao.findAll();
    }

    @Override
    @Transactional
    public Page<Cliente> findAll(Pageable pageable) {
        return iClienteDao.findAll(pageable);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        iClienteDao.save(cliente);
    }

    @Override
    @Transactional
    public Cliente findOne(Long id) {
        return iClienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        iClienteDao.deleteById(id);
    }

    @Override
    public List<Producto> findByName(String term) {
        return iProductDao.findByName(term);
    }

    @Override
    @Transactional
    public void saveFactura(Factura factura) {
        iFacturaDao.save(factura);
    }

    @Override
    @Transactional
    public Producto findProductById(Long id) {
        return iProductDao.findById(id).orElse(null);
    }
}
