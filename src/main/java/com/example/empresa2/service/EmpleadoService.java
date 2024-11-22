package com.example.empresa2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empresa2.model.Empleado;
import com.example.empresa2.repository.EmpleadoRepository;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    // Obtener todos los empleados
    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoRepository.findAll();
    }

    // Obtener un empleado por DNI
    public Empleado obtenerEmpleadoPorDni(String dni) {
        return empleadoRepository.findByDni(dni);
    }

    // Guardar o actualizar un empleado
    public void guardarEmpleado(Empleado empleado) {
        empleado.calcularSalario();
        empleadoRepository.save(empleado);
    }

    // Eliminar un empleado
    public void eliminarEmpleado(String dni) {
        empleadoRepository.deleteById(dni);
    }
}
