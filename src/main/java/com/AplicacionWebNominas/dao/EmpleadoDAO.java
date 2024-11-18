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

    public List<Empleado> obtenerEmpleado() {
        return empleadoRepository.findAll();
    }

    public Optional<Empleado> obtenerEmpleado(String dni) {
        return empleadoRepository.findById(dni);
    }

    public List<Empleado> buscarEmpleadosPorDNI(String dni) {
        return empleadoRepository.findByDniContaining(dni); 
    }

    public List<Empleado> buscarEmpleadosPorCriterios(String criterio) {
        return empleadoRepository.findByCriterio(criterio);
    }

    public boolean actualizarEmpleado(Empleado empleado) {
        if (empleadoRepository.existsById(empleado.getDni())) {
            empleadoRepository.save(empleado);
            return true;
        }
        return false;
    }
}

