package com.example.empresa2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empresa2.model.Empleado;
import com.example.empresa2.repository.EmpleadoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

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
    	EmpleadoService.calcularSalario(empleado);
        empleadoRepository.save(empleado);
    }

    // Eliminar un empleado
    public void eliminarEmpleado(String dni) {
        empleadoRepository.deleteById(dni);
    }
    
    
    @PersistenceContext
    private static EntityManager entityManager;
    
    public static int calcularSalario(Empleado empleado) {
        // Consulta SQL para obtener el salario base desde la tabla `nomina`
        String query = "SELECT n.sueldo FROM Nomina n WHERE n.categoria = :categoria";

        // Crear una consulta tipada
        TypedQuery<Integer> salarioBaseQuery = entityManager.createQuery(query, Integer.class);
        salarioBaseQuery.setParameter("categoria", empleado.getCategoria());

        Integer sueldoBase = salarioBaseQuery.getSingleResult();

        if (sueldoBase == null) {
            throw new IllegalArgumentException("No se encontró salario base para la categoría: " + empleado.getCategoria());
        }

        // Calcular el salario final
        int salarioFinal = sueldoBase + (5000 * empleado.getAniosTrabajados());
        return salarioFinal;
    }
}
