package com.aplicacionnominas.empresa.repository;

import org.springframework.stereotype.Service;

import com.aplicacionnominas.empresa.model.Empleado;

import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> obtenerTodos() {
        return empleadoRepository.findAll();
    }

    public Empleado obtenerPorDni(String dni) {
        return empleadoRepository.findById(dni).orElse(null);
    }

    public void guardarEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    public void eliminarEmpleado(String dni) {
        empleadoRepository.deleteById(dni);
    }

    public int calcularSalario(Empleado empleado) {
        final int[] SUELDO_BASE = {50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000, 230000};
        return SUELDO_BASE[empleado.getCategoria()] + 5000 * empleado.getAnyos();
    }
}