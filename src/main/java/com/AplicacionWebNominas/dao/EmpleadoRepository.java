package com.AplicacionWebNominas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.AplicacionWebNominas.model.Empleado;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {

    List<Empleado> findByDniContaining(String dni);

    @Query("SELECT e FROM Empleado e WHERE " +
           "e.dni LIKE %:criterio% OR " +
           "e.nombre LIKE %:criterio% OR " +
           "e.sexo LIKE %:criterio% OR " +
           "e.categoria LIKE %:criterio% OR " +
           "e.anyos LIKE %:criterio%")
    List<Empleado> findByCriterio(String criterio);
}

