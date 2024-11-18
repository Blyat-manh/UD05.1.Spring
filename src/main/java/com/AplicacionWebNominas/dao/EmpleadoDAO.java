package com.AplicacionWebNominas.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AplicacionWebNominas.model.Empleado;

import java.util.List;
import java.util.Optional;

@Repository
public class EmpleadoDAO {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    // Método para obtener todos los empleados
    public List<Empleado> obtenerEmpleado() {
        return empleadoRepository.findAll();  // Spring Data JPA proporciona el método findAll() por defecto
    }

    // Método para obtener un empleado por DNI
    public Optional<Empleado> obtenerEmpleado(String dni) {
        return empleadoRepository.findById(dni); // Encuentra un empleado por su ID (en este caso DNI)
    }

    // Método para buscar empleados por parte de su DNI
    public List<Empleado> buscarEmpleadosPorDNI(String dni) {
        return empleadoRepository.findByDniContaining(dni); // Busca empleados que contengan el DNI en su campo
    }

    // Método para buscar empleados por cualquier criterio
    public List<Empleado> buscarEmpleadosPorCriterios(String criterio) {
        return empleadoRepository.findByCriterio(criterio);  // Si defines una consulta personalizada en el repositorio
    }

    // Método para actualizar la información de un empleado
    public boolean actualizarEmpleado(Empleado empleado) {
        if (empleadoRepository.existsById(empleado.getDni())) {
            empleadoRepository.save(empleado);  // Spring Data JPA se encarga de la actualización si el DNI ya existe
            return true;
        }
        return false;
    }
}

