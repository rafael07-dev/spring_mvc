package dev.rafael.springbootdatajpa.dao;

import dev.rafael.springbootdatajpa.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacturaDao extends JpaRepository<Factura, Long> {

}
