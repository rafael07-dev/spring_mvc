package dev.rafael.springbootdatajpa.dao;

import dev.rafael.springbootdatajpa.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductDao extends JpaRepository<Producto, Long> {
    @Query("select p from Producto p where p.nombre like %?1%")
    List<Producto> findByName(String term);
}
