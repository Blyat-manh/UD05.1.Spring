package com.aplicacionnominas.empresa.repository;

import com.aplicacionnominas.empresa.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
}
