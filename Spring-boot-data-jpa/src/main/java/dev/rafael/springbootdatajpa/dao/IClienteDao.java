package dev.rafael.springbootdatajpa.dao;

import dev.rafael.springbootdatajpa.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IClienteDao extends JpaRepository<Cliente, Long> {

}
